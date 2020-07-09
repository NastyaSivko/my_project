package com.github.nastyasivko.project_final.dao.repository;

import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.UserEntity;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrderEntity, Long> {
    List<UserOrderEntity> findByUserLoginAndNameRoomAndNumberOfBedsAndDateStartAndDateEnd(String userLogin, String numberRoom, String numberOfBeds, String dateStart, String dateEnd);

    List<UserOrderEntity> findByUserLogin(String userLogin);
}
