package com.alfian.latihanspring.repository;

import com.alfian.latihanspring.models.entity.Mahasiswa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {

}
