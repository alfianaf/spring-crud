package com.alfian.latihanspring.controllers;

import java.util.List;

import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.dto.WilayahDto;
import com.alfian.latihanspring.models.entity.Kabupaten;
import com.alfian.latihanspring.repository.KabupatenRepository;

import com.alfian.latihanspring.service.KabupatenService;

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
@RequestMapping("/kabupaten")
public class KabupatenController {
    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private KabupatenService kabupatenService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {

        List<Kabupaten> kabupaten = kabupatenRepository.findActive();
        return ResponseEntity.ok(kabupaten);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getId(@PathVariable Integer id) {
        Kabupaten kabupaten = kabupatenRepository.findById(id).get();

        return ResponseEntity.ok(kabupaten);
    }

    @GetMapping("/get-by-kode/{kode}")
    public ResponseEntity<?> getKode(@PathVariable String kode) {

        Kabupaten kabupaten = kabupatenRepository.findKode(kode);
        return ResponseEntity.ok(kabupaten);
    }

    @GetMapping("/get-by-provinsi/{kode}")
    public ResponseEntity<?> getProvinsi(@PathVariable String kode) {

        List<Kabupaten> kabupaten = kabupatenRepository.findFromProvinsi(kode);
        return ResponseEntity.ok(kabupaten);
    }

    @PostMapping("/add/{kode}")
    public ResponseEntity<?> insertKabupaten(@PathVariable String kode, @RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Kabupaten> result = new StatusMessageDto<>();
        try {
            return kabupatenService.add(kode, wilayahDto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editWilayah(@PathVariable Integer id, @RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Kabupaten> result = new StatusMessageDto<>();

        try {
            return kabupatenService.edit(id, wilayahDto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return kabupatenService.delete(id);
    }
}
