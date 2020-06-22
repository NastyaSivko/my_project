package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.AdministratorDao;
import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.converter.NewOrderConverter;
import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.*;
import com.github.nastyasivko.project_final.model.Answer;
import com.github.nastyasivko.project_final.model.Costs;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class UserAdministratorDao implements AdministratorDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultLoginUsersDao.class);

    private static class SingletonHolder {
        static final AdministratorDao HOLDER_INSTANCE = new UserAdministratorDao();
    }

    public static AdministratorDao getInstance() {
        return UserAdministratorDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public List<UserOrder> getUsersOrders(String nameDb) {
        Session session = EMUtil.getSession(nameDb);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<NewOrdersEntity> criteria = cb.createQuery(NewOrdersEntity.class);
        criteria.select(criteria.from(NewOrdersEntity.class));
        List<NewOrdersEntity> userOrderEntities = session.createQuery(criteria).getResultList();
        List<UserOrder> orderList = new ArrayList<>();
        for (int i = 0; i < userOrderEntities.size(); i++) {
            orderList.add(NewOrderConverter.fromEntity(userOrderEntities.get(i)));
        }
        return orderList;
    }

    @Override
    public boolean deleteNewOrders(String nameDb, UserOrder userOrder){
        Session session = EMUtil.getSession(nameDb);
        session.getTransaction().begin();
        List<NewOrdersEntity> order = session.createQuery("from NewOrdersEntity n where n.userlogin = :login and n.nameRoom = :room and n.numberOfBeds = :bed ")
                .setParameter("login", userOrder.getUserLogin())
                .setParameter("room", userOrder.getNameRoom())
                .setParameter("bed", userOrder.getBeds())
                .getResultList();
        session.delete(order.get(0));
        session.getTransaction().commit();
        return true;
    }

    @Override
    public List<UserOrder> getNewOrdersForPage(String nameDb, int page){
        final List<NewOrdersEntity> listNewOrder = getPage(nameDb, page);
        List<UserOrder> newOrderList = new ArrayList<>();
        try{
        for (int i = 0; i < listNewOrder.size(); i++) {
            newOrderList.add(NewOrderConverter.fromEntity(listNewOrder.get(i)));
        }
        } catch (NullPointerException e){
            log.info("no new order");
            newOrderList = null;
        }
        return newOrderList;

    }

    private List<NewOrdersEntity> getPage(String nameDb, int page) {
        int pageSize = 3;
        Session session = EMUtil.getSession(nameDb);
        Query query = session.createQuery("from NewOrdersEntity");
        return query.setMaxResults(pageSize)
                .setFirstResult((page - 1) * pageSize)
                .getResultList();
    }

    @Override
    public Long saveApprovedOrder(String nameDb, UserOrder userOrder, Integer numberRoom, Costs cost) {

        final Session session = EMUtil.getSession(nameDb);
        UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(userOrder);
        CostRoomsEntity costRoomsEntity = DefaultCostsDao.getInstance().getCost(nameDb, cost);
        ApprovedOrdersEntity approvedOrdersEntity = new ApprovedOrdersEntity(null, userOrderEntity.getId(), Answer.YES, numberRoom, costRoomsEntity);

        costRoomsEntity.getApprovedOrdersEntities().add(approvedOrdersEntity);

        session.beginTransaction();
        session.persist(approvedOrdersEntity);
        session.getTransaction().commit();

        return approvedOrdersEntity.getId();
    }

    @Override
    public Long saveDeniedOrder(String nameDb, UserOrder userOrder){
        final Session session = EMUtil.getSession(nameDb);
        UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(userOrder);
        DeniedOrdersEntity deniedOrdersEntity = new DeniedOrdersEntity(null, userOrderEntity.getId(), Answer.NO);

        session.beginTransaction();
        session.persist(deniedOrdersEntity);
        session.getTransaction().commit();

        return deniedOrdersEntity.getId();
    }
}
