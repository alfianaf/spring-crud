package com.alfian.latihanspring.repository;

import com.alfian.latihanspring.models.entity.Provinsi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer> {
    @Query(value = "select * from provinsi where is_active = '1'", nativeQuery = true)
    public Provinsi findActive();

    @Query(value = "select * from provinsi where kode_provinsi = ? AND is_active = '1'", nativeQuery = true)
    public Provinsi findKode(String kode);

    // @Query(value = "select * from provinsi where is_active = '1'", nativeQuery =
    // true)
    // public Provinsi findProvinsi();
}
