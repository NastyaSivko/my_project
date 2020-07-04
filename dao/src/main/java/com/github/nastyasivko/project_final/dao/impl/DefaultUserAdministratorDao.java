package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.UserAdministratorDao;
import com.github.nastyasivko.project_final.dao.converter.NewOrderConverter;
import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.*;
import com.github.nastyasivko.project_final.dao.repository.*;
import com.github.nastyasivko.project_final.model.Answer;
import com.github.nastyasivko.project_final.model.Cost;
import com.github.nastyasivko.project_final.model.UserOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserAdministratorDao implements UserAdministratorDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultLoginUserDao.class);

    private final CostRepository repositoryCost;
    private final NewOrderRepository repositoryNewOrder;
    private final ApprovedOrderRepository repositoryApprovedOrder;
    private final DeniedOrderRepository repositoryDeniedOrder;
    private final NewOrderPagingRepository pagingRepository;

    public DefaultUserAdministratorDao(CostRepository repositoryCost, NewOrderRepository repositoryNewOrder, ApprovedOrderRepository repositoryApprovedOrder, DeniedOrderRepository repositoryDeniedOrder, NewOrderPagingRepository pagingRepository) {
        this.repositoryCost = repositoryCost;
        this.repositoryNewOrder = repositoryNewOrder;
        this.repositoryApprovedOrder = repositoryApprovedOrder;
        this.repositoryDeniedOrder = repositoryDeniedOrder;
        this.pagingRepository = pagingRepository;
    }

    @Override
    public List<UserOrder> getUsersOrders() {
        List<NewOrderEntity> userOrderEntities = repositoryNewOrder.findAll();
        List<UserOrder> orderList = new ArrayList<>();
        try {
            for (int i = 0; i < userOrderEntities.size(); i++) {
                orderList.add(NewOrderConverter.fromEntity(userOrderEntities.get(i)));
            }
        } catch (NullPointerException e) {
            log.info("no new order");
            orderList = null;
        }
        return orderList;
    }

    @Override
    public boolean deleteNewOrders(UserOrder userOrder) {

        List<NewOrderEntity> order = repositoryNewOrder.findByUserloginAndNameRoomAndNumberOfBeds(userOrder.getUserLogin(), userOrder.getNameRoom(), userOrder.getBeds());
        repositoryNewOrder.delete(order.get(0));
        return true;
    }

    @Override
    public List<UserOrder> getNewOrdersForPage(int page) {
        int pageSize = 3;
        Page<NewOrderEntity> newOrderPages = pagingRepository.findAll(PageRequest.of((page - 1), pageSize));
        List<NewOrderEntity> newOrderEntityList = new ArrayList<>();
        newOrderPages.getContent().forEach(newOrderEntityList::add);
        List<UserOrder> newOrderList = new ArrayList<>();
        try {
            for (int i = 0; i < newOrderEntityList.size(); i++) {
                newOrderList.add(NewOrderConverter.fromEntity(newOrderEntityList.get(i)));
            }
        } catch (NullPointerException e) {
            log.info("no new order");
            newOrderList = null;
        }
        return newOrderList;
    }

    @Override
    public Long saveApprovedOrder(UserOrder userOrder, Integer numberRoom, Cost cost) {

        UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(userOrder);
        CostRoomEntity costRoomEntity = repositoryCost.findByCost(cost.getCost());
        ApprovedOrderEntity approvedOrderEntity = new ApprovedOrderEntity(null, userOrderEntity.getId(), userOrderEntity.getDateStart(), userOrderEntity.getDateEnd(), Answer.YES, numberRoom, costRoomEntity);

        costRoomEntity.getApprovedOrdersEntities().add(approvedOrderEntity);

        repositoryApprovedOrder.save(approvedOrderEntity);

        return approvedOrderEntity.getId();
    }

    @Override
    public Long saveDeniedOrder(UserOrder userOrder) {

        UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(userOrder);
        DeniedOrderEntity deniedOrderEntity = new DeniedOrderEntity(null, userOrderEntity.getId(), userOrderEntity.getDateStart(), userOrderEntity.getDateEnd(), Answer.NO);

        repositoryDeniedOrder.save(deniedOrderEntity);

        return deniedOrderEntity.getId();
    }
}
