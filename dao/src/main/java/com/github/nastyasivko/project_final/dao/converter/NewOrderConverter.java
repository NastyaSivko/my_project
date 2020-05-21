package com.github.nastyasivko.project_final.dao.converter;

import com.github.nastyasivko.project_final.dao.entity.NewOrdersEntity;
import com.github.nastyasivko.project_final.model.UserOrder;

public class NewOrderConverter {
    public static NewOrdersEntity toEntity(UserOrder userOrder) {
        if (userOrder == null) {
            return null;
        }
        final NewOrdersEntity userOrderEntity = new NewOrdersEntity();
        userOrderEntity.setId(userOrder.getId());
        userOrderEntity.setUserlogin(userOrder.getUserLogin());
        userOrderEntity.setNameRoom(userOrder.getNameRoom());
        userOrderEntity.setNumberOfBeds(userOrder.getBeds());
        return userOrderEntity;
    }

    public static UserOrder fromEntity(NewOrdersEntity userOrderEntity) {
        if (userOrderEntity == null) {
            return null;
        }
        return new UserOrder(
                userOrderEntity.getId(),
                userOrderEntity.getUserlogin(),
                userOrderEntity.getNameRoom(),
                userOrderEntity.getNumberOfBeds());
    }
}
