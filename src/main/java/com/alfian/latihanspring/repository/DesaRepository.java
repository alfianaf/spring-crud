package com.alfian.latihanspring.repository;

import java.util.List;

import com.alfian.latihanspring.models.entity.Desa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DesaRepository extends JpaRepository<Desa, Integer> {
    @Query(value = "select * from desa where is_active = '1' ", nativeQuery = true)
    public List<Desa> findActive();

    @Query(value = "select * from desa where kode_desa = ? AND is_active = '1'", nativeQuery = true)
    public Desa findKode(String kode);

    @Query(value = "select * from desa where kode_kecamatan = ? AND is_active = '1'", nativeQuery = true)
    public List<Desa> findFromKecamatan(String kode);

    @Query(value = "select * from desa where kode_kabupaten = ? AND is_active = '1'", nativeQuery = true)
    public List<Desa> findFromKabupaten(String kode);

    @Query(value = "select * from desa where kode_provinsi = ? AND is_active = '1'", nativeQuery = true)
    public List<Desa> findFromProvinsi(String kode);
}
