package com.github.nastyasivko.project_final.dao.repository;

import com.github.nastyasivko.project_final.dao.entity.NewOrderEntity;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface NewOrderRepository extends JpaRepository<NewOrderEntity, Long> {

    List<NewOrderEntity> findByUserloginAndNameRoomAndNumberOfBeds(String userLogin, String numberRoom, String numberOfBeds);
}
