package com.github.nastyasivko.project_final.dao.repository;

import com.github.nastyasivko.project_final.dao.entity.ApprovedOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedOrderRepository extends JpaRepository<ApprovedOrderEntity, Long> {
}
