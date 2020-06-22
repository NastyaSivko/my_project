package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.dao.entity.CostRoomsEntity;
import com.github.nastyasivko.project_final.model.Costs;

import java.util.List;

public interface CostsDao {
     List<Costs> getListCosts(String nameDb);
     CostRoomsEntity getCost(String nameDb, Costs cost);
}
