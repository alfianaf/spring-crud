package com.alfian.latihanspring.repository;

import com.alfian.latihanspring.models.entity.Domisili;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomisiliRepository extends JpaRepository<Domisili, Integer> {

}
