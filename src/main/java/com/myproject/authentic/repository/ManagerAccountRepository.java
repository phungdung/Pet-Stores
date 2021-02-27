package com.myproject.authentic.repository;

import com.myproject.data.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerAccountRepository extends JpaRepository<ManagerEntity, Long> {

    Optional<ManagerEntity> findByEmail(String username);

    Boolean existsByEmail(String email);
}
