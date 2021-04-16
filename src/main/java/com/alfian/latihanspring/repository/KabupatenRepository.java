package com.alfian.latihanspring.repository;

import java.util.List;

import com.alfian.latihanspring.models.entity.Kabupaten;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KabupatenRepository extends JpaRepository<Kabupaten, Integer> {
    @Query(value = "select * from kabupaten where is_active = '1'", nativeQuery = true)
    public List<Kabupaten> findActive();

    @Query(value = "select * from kabupaten where kode_kabupaten = ? AND is_active = '1'", nativeQuery = true)
    public Kabupaten findKode(String kode);

    @Query(value = "select * from kabupaten where kode_provinsi = ? AND is_active = '1'", nativeQuery = true)
    public List<Kabupaten> findFromProvinsi(String kode);
}
