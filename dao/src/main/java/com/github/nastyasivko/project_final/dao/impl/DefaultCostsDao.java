package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.CostsDao;
import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.converter.CostsConverter;
import com.github.nastyasivko.project_final.dao.entity.CostRoomsEntity;
import com.github.nastyasivko.project_final.model.Costs;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DefaultCostsDao implements CostsDao {
    private static class SingletonHolder {
        static final CostsDao HOLDER_INSTANCE = new DefaultCostsDao();
    }

    public static CostsDao getInstance() {
        return DefaultCostsDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public List<Costs> getListCosts(String nameDb){
        Session session = EMUtil.getSession(nameDb);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CostRoomsEntity> criteria = cb.createQuery(CostRoomsEntity.class);
        Root<CostRoomsEntity> costs = criteria.from(CostRoomsEntity.class);
        criteria.select(costs)
                .orderBy(cb.asc(costs.get("cost")));
        List<CostRoomsEntity> costsEntities = session.createQuery(criteria).getResultList();
        List<Costs> costsList = new ArrayList<>();
        for (int i = 0; i < costsEntities.size(); i++) {
            costsList.add(CostsConverter.fromEntity(costsEntities.get(i)));
        }
        return costsList;
    }

    @Override
    public CostRoomsEntity getCost(String nameDb, Costs cost){
        Session session = EMUtil.getSession(nameDb);
        List<CostRoomsEntity> costEntity = session.createQuery("from CostRoomsEntity c where c.cost = :cost ")
                .setParameter("cost", cost.getCost())
                .getResultList();
        return costEntity.get(0);
    }
}
