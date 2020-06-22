package com.github.nastyasivko.project_final.dao.converter;

import com.github.nastyasivko.project_final.dao.entity.CostRoomsEntity;
import com.github.nastyasivko.project_final.model.Costs;

public class CostsConverter {
    public static CostRoomsEntity toEntity(Costs cost) {
        if (cost == null) {
            return null;
        }
        final CostRoomsEntity costRoomsEntity = new CostRoomsEntity();
        costRoomsEntity.setId(cost.getId());
        costRoomsEntity.setCost(cost.getCost());
        return costRoomsEntity;
    }

    public static Costs fromEntity(CostRoomsEntity costRoomsEntity) {
        if (costRoomsEntity == null) {
            return null;
        }
        return new Costs(
                costRoomsEntity.getId(),
                costRoomsEntity.getCost());
    }
}
