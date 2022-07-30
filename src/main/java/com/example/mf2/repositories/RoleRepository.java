package com.example.mf2.repositories;

import com.example.mf2.entities.Intern;
import com.example.mf2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
