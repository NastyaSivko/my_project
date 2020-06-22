package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.CostsDao;
import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.entity.CostRoomsEntity;
import com.github.nastyasivko.project_final.model.Costs;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDefaultCostsDao {
    final String name="project_test";
    final CostsDao costsDao = DefaultCostsDao.getInstance();

    @BeforeEach
    public void init(){
        Session session = EMUtil.getSession(name);
        session.getTransaction().begin();
        session.persist(new CostRoomsEntity(null, 15));
        session.persist(new CostRoomsEntity(null, 20));
        session.persist(new CostRoomsEntity(null, 3));
        session.getTransaction().commit();
    }

    @Test
    void testGetListCosts(){
        List<Costs> listCost = costsDao.getListCosts(name);

        assertNotNull(listCost);
    }
}
