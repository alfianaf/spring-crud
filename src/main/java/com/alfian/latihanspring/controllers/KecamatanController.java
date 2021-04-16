package com.alfian.latihanspring.controllers;

import java.util.List;

import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.dto.WilayahDto;
import com.alfian.latihanspring.models.entity.Kecamatan;
import com.alfian.latihanspring.repository.DesaRepository;
import com.alfian.latihanspring.repository.KabupatenRepository;
import com.alfian.latihanspring.repository.KecamatanRepository;
import com.alfian.latihanspring.repository.ProvinsiRepository;
import com.alfian.latihanspring.service.KabupatenService;
import com.alfian.latihanspring.service.KecamatanService;

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
@RequestMapping("/kecamatan")
public class KecamatanController {
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private DesaRepository desaRepository;

    @Autowired
    private KecamatanService kecamatanService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {

        List<Kecamatan> kecamatan = kecamatanRepository.findActive();
        return ResponseEntity.ok(kecamatan);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getId(@PathVariable Integer id) {
        Kecamatan kecamatan = kecamatanRepository.findById(id).get();

        return ResponseEntity.ok(kecamatan);
    }

    @GetMapping("/get-by-kode/{kode}")
    public ResponseEntity<?> getKode(@PathVariable String kode) {

        Kecamatan kecamatan = kecamatanRepository.findKode(kode);
        return ResponseEntity.ok(kecamatan);
    }

    @GetMapping("/get-by-provinsi/{kode}")
    public ResponseEntity<?> getProvinsi(@PathVariable String kode) {

        List<Kecamatan> kecamatan = kecamatanRepository.findFromProvinsi(kode);
        return ResponseEntity.ok(kecamatan);
    }

    @GetMapping("/get-by-kabupaten/{kode}")
    public ResponseEntity<?> getKabupaten(@PathVariable String kode) {

        List<Kecamatan> kecamatan = kecamatanRepository.findFromKabupaten(kode);
        return ResponseEntity.ok(kecamatan);
    }

    @PostMapping("/add")
    public ResponseEntity<?> insertKecamatan(@RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Kecamatan> result = new StatusMessageDto<>();
        try {
            return kecamatanService.add(wilayahDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editKecamatan(@PathVariable Integer id, @RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Kecamatan> result = new StatusMessageDto<>();

        try {
            return kecamatanService.edit(id, wilayahDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return kecamatanService.delete(id);
    }

}
