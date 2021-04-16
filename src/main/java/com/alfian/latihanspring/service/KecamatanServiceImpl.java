package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.dto.WilayahDto;
import com.alfian.latihanspring.models.entity.Kabupaten;
import com.alfian.latihanspring.models.entity.Kecamatan;
import com.alfian.latihanspring.models.entity.Provinsi;
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
public class KecamatanServiceImpl implements KecamatanService {
    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> add(WilayahDto wilayahDto) {
        StatusMessageDto<Kecamatan> result = new StatusMessageDto<>();
        Kecamatan kecamatan = new Kecamatan();

        kecamatan.setNamaKecamatan(wilayahDto.getNamaKecamatan());

        Provinsi provinsi = provinsiRepository.findKode(wilayahDto.getKodeProvinsi());
        kecamatan.setKodeProvinsi(provinsi);

        Kabupaten kabupaten = kabupatenRepository.findKode(wilayahDto.getKodeKabupaten());
        kecamatan.setKodeKabupaten(kabupaten);

        kecamatan.setIsActive(1);

        kecamatanRepository.save(kecamatan);
        kecamatan.setKodeKecamatan("KCM" + kecamatan.getId());

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil ditambahkan!");
        result.setData(kecamatan);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> edit(Integer id, WilayahDto wilayahDto) {
        StatusMessageDto<Kecamatan> result = new StatusMessageDto<>();
        Kecamatan kecamatan = kecamatanRepository.findById(id).get();

        kecamatan.setNamaKecamatan(wilayahDto.getNamaKecamatan());
        kecamatanRepository.save(kecamatan);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil diubah!");
        result.setData(kecamatan);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        StatusMessageDto<Kecamatan> result = new StatusMessageDto<>();
        Kecamatan kecamatan = kecamatanRepository.findById(id).get();

        kecamatan.setIsActive(0);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil dihapus!");
        result.setData(kecamatan);

        return ResponseEntity.ok(result);
    }

}
