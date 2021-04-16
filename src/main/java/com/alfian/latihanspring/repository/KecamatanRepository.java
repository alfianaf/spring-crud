package com.alfian.latihanspring.repository;

import java.util.List;

import com.alfian.latihanspring.models.entity.Kecamatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanRepository extends JpaRepository<Kecamatan, Integer> {
    @Query(value = "select * from kecamatan where is_active = '1'", nativeQuery = true)
    public List<Kecamatan> findActive();

    @Query(value = "select * from kecamatan where kode_kecamatan = ? AND is_active = '1'", nativeQuery = true)
    public Kecamatan findKode(String kode);

    @Query(value = "select * from kecamatan where kode_kabupaten = ? AND is_active = '1'", nativeQuery = true)
    public List<Kecamatan> findFromKabupaten(String kode);

    @Query(value = "select * from kecamatan where kode_provinsi = ? AND is_active = '1'", nativeQuery = true)
    public List<Kecamatan> findFromProvinsi(String kode);
}
