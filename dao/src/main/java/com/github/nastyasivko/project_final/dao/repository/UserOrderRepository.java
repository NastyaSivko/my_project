package com.github.nastyasivko.project_final.dao.repository;

import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.UserEntity;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrderEntity, Long> {
    UserOrderEntity findByUserloginAndNameRoomAndNumberOfBeds(String userLogin, String numberRoom, String numberOfBeds);
}
