package com.example.mf2.repositories;

import com.example.mf2.entities.Intern;
import com.example.mf2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from users u where u.email = ?1")
    User getByEmail(String email);
}
