package com.alfian.latihanspring.repository;

import com.alfian.latihanspring.models.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);

    @Query(value = "select username from user where username = ?", nativeQuery = true)
    public String findUsernameByUsername(String username);
}
