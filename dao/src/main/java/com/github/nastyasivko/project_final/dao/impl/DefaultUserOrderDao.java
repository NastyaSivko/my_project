package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import com.github.nastyasivko.project_final.dao.repository.UserOrderRepository;
import com.github.nastyasivko.project_final.model.UserOrder;

public class DefaultUserOrderDao implements UserOrderDao {

    private final UserOrderRepository repository;

    public DefaultUserOrderDao(UserOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveUserOrder(UserOrder userOrder) {

        UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(userOrder);

        repository.save(userOrderEntity);

        return userOrderEntity.getId();
    }

    @Override
    public UserOrder get(Long id){
        UserOrderEntity userOrderEntity = repository.getOne(id);
        return UserOrderConverter.fromEntity(userOrderEntity);
    }

    @Override
    public UserOrder getUserOrder(UserOrder userOrder) {
        UserOrderEntity userOrderEntity = repository.findByUserloginAndNameRoomAndNumberOfBeds(userOrder.getUserLogin(), userOrder.getNameRoom(), userOrder.getBeds());
        return UserOrderConverter.fromEntity(userOrderEntity);
    }
}
