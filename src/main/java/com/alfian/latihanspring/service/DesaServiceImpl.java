package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.dto.WilayahDto;
import com.alfian.latihanspring.models.entity.Desa;
import com.alfian.latihanspring.models.entity.Kabupaten;
import com.alfian.latihanspring.models.entity.Kecamatan;
import com.alfian.latihanspring.models.entity.Provinsi;
import com.alfian.latihanspring.repository.DesaRepository;
import com.alfian.latihanspring.repository.KabupatenRepository;
import com.alfian.latihanspring.repository.KecamatanRepository;
import com.alfian.latihanspring.repository.ProvinsiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DesaServiceImpl implements DesaService {
    @Autowired
    private DesaRepository desaRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> add(WilayahDto wilayahDto) {
        StatusMessageDto<Desa> result = new StatusMessageDto<>();
        Desa desa = new Desa();

        desa.setNamaDesa(wilayahDto.getNamaDesa());

        Provinsi provinsi = provinsiRepository.findKode(wilayahDto.getKodeProvinsi());
        desa.setKodeProvinsi(provinsi);

        Kabupaten kabupaten = kabupatenRepository.findKode(wilayahDto.getKodeKabupaten());
        desa.setKodeKabupaten(kabupaten);

        Kecamatan kecamatan = kecamatanRepository.findKode(wilayahDto.getKodeKecamatan());
        desa.setKodeKecamatan(kecamatan);

        desa.setIsActive(1);

        desaRepository.save(desa);
        desa.setKodeDesa("DES" + desa.getId());

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil ditambahkan!");
        result.setData(desa);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> edit(Integer id, WilayahDto wilayahDto) {
        StatusMessageDto<Desa> result = new StatusMessageDto<>();
        Desa desa = desaRepository.findById(id).get();

        desa.setNamaDesa(wilayahDto.getNamaDesa());
        desaRepository.save(desa);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil diubah!");
        result.setData(desa);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        StatusMessageDto<Desa> result = new StatusMessageDto<>();
        Desa desa = desaRepository.findById(id).get();

        desa.setIsActive(0);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil dihapus!");
        result.setData(desa);

        return ResponseEntity.ok(result);
    }

}
