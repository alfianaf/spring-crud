package com.alfian.latihanspring.repository;

import com.alfian.latihanspring.models.entity.Pendidikan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendidikanRepository extends JpaRepository<Pendidikan, Integer> {

}
