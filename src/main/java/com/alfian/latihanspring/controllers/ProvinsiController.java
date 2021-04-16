package com.alfian.latihanspring.controllers;

import java.util.List;

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
import com.alfian.latihanspring.service.ProvinsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private DesaRepository desaRepository;

    @Autowired
    private ProvinsiService provinsiService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        Provinsi provinsi = provinsiRepository.findActive();
        return ResponseEntity.ok(provinsi);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getId(@PathVariable Integer id) {
        Provinsi provinsi = provinsiRepository.findById(id).get();

        return ResponseEntity.ok(provinsi);
    }

    @GetMapping("/get-by-kode/{kode}")
    public ResponseEntity<?> getKode(@PathVariable String kode) {

        Provinsi provinsi = provinsiRepository.findKode(kode);
        return ResponseEntity.ok(provinsi);
    }

    @PostMapping("/add")
    public ResponseEntity<?> insertWilayah(@RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Provinsi> result = new StatusMessageDto<>();
        try {
            return provinsiService.add(wilayahDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editWilayah(@PathVariable Integer id, @RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Provinsi> result = new StatusMessageDto<>();

        try {
            return provinsiService.edit(id, wilayahDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return provinsiService.delete(id);
    }
}
