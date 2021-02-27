package com.myproject.authentic.repository;

import com.myproject.data.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberAccountRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByEmail(String username);

    Boolean existsByEmail(String email);
}
