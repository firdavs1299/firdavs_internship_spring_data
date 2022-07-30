package com.example.mf2.repositories;

import com.example.mf2.entities.UserWithRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWithRoleRepository extends JpaRepository<UserWithRole, Long> {
}
