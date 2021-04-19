package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.dto.WilayahDto;
import com.alfian.latihanspring.models.entity.Provinsi;
import com.alfian.latihanspring.repository.ProvinsiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService {
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> add(WilayahDto wilayahDto) {
        StatusMessageDto<Provinsi> result = new StatusMessageDto<>();
        Provinsi provinsi = new Provinsi();

        provinsi.setNamaProvinsi(wilayahDto.getNamaProvinsi());
        provinsi.setIsActive(1);
        provinsiRepository.save(provinsi);
        provinsi.setKodeProvinsi("PRV" + provinsi.getId());

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil ditambahkan!");
        result.setData(provinsi);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> edit(Integer id, WilayahDto wilayahDto) {
        StatusMessageDto<Provinsi> result = new StatusMessageDto<>();
        Provinsi provinsi = provinsiRepository.findById(id).get();

        provinsi.setNamaProvinsi(wilayahDto.getNamaProvinsi());

        provinsiRepository.save(provinsi);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil diubah!");
        result.setData(provinsi);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        StatusMessageDto<Provinsi> result = new StatusMessageDto<>();
        Provinsi provinsi = provinsiRepository.findById(id).get();
        provinsi.setIsActive(0);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil dihapus!");
        result.setData(provinsi);

        return ResponseEntity.ok(result);
    }

}
