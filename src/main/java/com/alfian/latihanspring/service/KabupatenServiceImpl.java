package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.dto.WilayahDto;
import com.alfian.latihanspring.models.entity.Kabupaten;
import com.alfian.latihanspring.models.entity.Provinsi;
import com.alfian.latihanspring.repository.KabupatenRepository;
import com.alfian.latihanspring.repository.ProvinsiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class KabupatenServiceImpl implements KabupatenService {
    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> add(@PathVariable String kode, @RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Kabupaten> result = new StatusMessageDto<>();
        Kabupaten kabupaten = new Kabupaten();
        // Provinsi provinsi = new Provinsi();
        kabupaten.setNamaKabupaten(wilayahDto.getNamaKabupaten());

        Provinsi provinsi = provinsiRepository.findKode(kode);
        kabupaten.setKodeProvinsi(provinsi);

        kabupaten.setIsActive(1);

        kabupatenRepository.save(kabupaten);
        kabupaten.setKodeKabupaten("KBP" + kabupaten.getId());

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil ditambahkan!");
        result.setData(kabupaten);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Kabupaten> result = new StatusMessageDto<>();
        Kabupaten kabupaten = kabupatenRepository.findById(id).get();

        kabupaten.setNamaKabupaten(wilayahDto.getNamaKabupaten());

        kabupatenRepository.save(kabupaten);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil diubah!");
        result.setData(kabupaten);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        StatusMessageDto<Kabupaten> result = new StatusMessageDto<>();
        Kabupaten kabupaten = kabupatenRepository.findById(id).get();

        kabupaten.setIsActive(0);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil dihapus!");
        result.setData(kabupaten);

        return ResponseEntity.ok(result);
    }

}
