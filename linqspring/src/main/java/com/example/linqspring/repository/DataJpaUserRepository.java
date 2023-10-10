package com.example.linqspring.repository;

import com.example.linqspring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJpaUserRepository extends JpaRepository<UserEntity,String> {
    public boolean existsByUserIdAndUserPassword(String userId,String userPassword);
}
