package com.alfian.latihanspring.repository;

import com.alfian.latihanspring.models.entity.DetailUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailUserRepository extends JpaRepository<DetailUser, Integer> {

}
