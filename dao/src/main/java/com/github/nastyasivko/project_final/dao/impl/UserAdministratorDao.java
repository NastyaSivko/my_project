package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.AdministratorDao;
import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.converter.NewOrderConverter;
import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.NewOrdersEntity;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
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
    public boolean deleteNewOrders(String nameDb){
        Session session = EMUtil.getSession(nameDb);
        session.getTransaction().begin();
        session.createQuery("delete from NewOrdersEntity ").executeUpdate();
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
}
