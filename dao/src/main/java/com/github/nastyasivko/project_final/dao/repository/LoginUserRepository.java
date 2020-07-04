package com.github.nastyasivko.project_final.dao.repository;

import com.github.nastyasivko.project_final.dao.entity.LoginUserEntity;
import com.github.nastyasivko.project_final.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUserEntity, Long> {
    Optional<LoginUserEntity> findByLogin(String login);

    @Modifying(clearAutomatically = true)
    @Query("update LoginUserEntity set password= :password where id = :loginUserId")
    void updatePassword(@Param("loginUserId") Long loginUserId, @Param("password") String password);

    Optional<LoginUserEntity> findByUserId(Long userId);
}
