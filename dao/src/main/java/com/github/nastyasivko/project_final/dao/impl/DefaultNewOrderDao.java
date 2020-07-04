package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.NewOrderDao;
import com.github.nastyasivko.project_final.dao.converter.HotelRoomConverter;
import com.github.nastyasivko.project_final.dao.converter.NewOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.NewOrderEntity;
import com.github.nastyasivko.project_final.dao.repository.NewOrderRepository;
import com.github.nastyasivko.project_final.model.UserOrder;

import java.util.List;

public class DefaultNewOrderDao implements NewOrderDao {
    private final NewOrderRepository repository;

    public DefaultNewOrderDao(NewOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveNewOrder(UserOrder userOrder) {
        NewOrderEntity newOrderEntity = NewOrderConverter.toEntity(userOrder);

        repository.save(newOrderEntity);

        return newOrderEntity.getId();
    }

    @Override
    public UserOrder get(Long id){
        NewOrderEntity newOrderEntity = repository.getOne(id);
        return NewOrderConverter.fromEntity(newOrderEntity);
    }
}
