package com.github.nastyasivko.project_final.dao.converter;

import com.github.nastyasivko.project_final.dao.entity.NewOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;

public class NewOrderConverter {
    public static NewOrderEntity toEntity(UserOrder userOrder) {
        if (userOrder == null) {
            return null;
        }
        final NewOrderEntity userOrderEntity = new NewOrderEntity();
        userOrderEntity.setId(userOrder.getId());
        userOrderEntity.setUserlogin(userOrder.getUserLogin());
        userOrderEntity.setNameRoom(userOrder.getNameRoom());
        userOrderEntity.setNumberOfBeds(userOrder.getBeds());
        userOrderEntity.setDateStart(userOrder.getDateStart());
        userOrderEntity.setDateEnd(userOrder.getDateEnd());
        return userOrderEntity;
    }

    public static UserOrder fromEntity(NewOrderEntity userOrderEntity) {
        if (userOrderEntity == null) {
            return null;
        }
        return new UserOrder(
                userOrderEntity.getId(),
                userOrderEntity.getUserlogin(),
                userOrderEntity.getNameRoom(),
                userOrderEntity.getNumberOfBeds(),
                userOrderEntity.getDateStart(),
                userOrderEntity.getDateEnd());
    }
}
