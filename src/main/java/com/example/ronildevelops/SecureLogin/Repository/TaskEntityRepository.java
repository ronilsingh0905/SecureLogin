package com.example.ronildevelops.SecureLogin.Repository;

import com.example.ronildevelops.SecureLogin.Entity.TaskEntity;
import com.example.ronildevelops.SecureLogin.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByCreatedBy(UserEntity user);
}