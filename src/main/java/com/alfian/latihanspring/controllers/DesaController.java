package com.alfian.latihanspring.controllers;

import java.util.List;

import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.dto.WilayahDto;
import com.alfian.latihanspring.models.entity.Desa;
import com.alfian.latihanspring.repository.DesaRepository;
import com.alfian.latihanspring.repository.KabupatenRepository;
import com.alfian.latihanspring.repository.KecamatanRepository;
import com.alfian.latihanspring.repository.ProvinsiRepository;
import com.alfian.latihanspring.service.DesaService;

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
@RequestMapping("/desa")
public class DesaController {
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private DesaRepository desaRepository;

    @Autowired
    private DesaService desaService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {

        List<Desa> desa = desaRepository.findActive();
        return ResponseEntity.ok(desa);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getId(@PathVariable Integer id) {
        Desa desa = desaRepository.findById(id).get();

        return ResponseEntity.ok(desa);
    }

    @GetMapping("/get-by-kode/{kode}")
    public ResponseEntity<?> getKode(@PathVariable String kode) {

        Desa desa = desaRepository.findKode(kode);
        return ResponseEntity.ok(desa);
    }

    @GetMapping("/get-by-provinsi/{kode}")
    public ResponseEntity<?> getProvinsi(@PathVariable String kode) {

        List<Desa> desa = desaRepository.findFromProvinsi(kode);
        return ResponseEntity.ok(desa);
    }

    @GetMapping("/get-by-kabupaten/{kode}")
    public ResponseEntity<?> getKabupaten(@PathVariable String kode) {

        List<Desa> desa = desaRepository.findFromKabupaten(kode);
        return ResponseEntity.ok(desa);
    }

    @GetMapping("/get-by-kecamatan/{kode}")
    public ResponseEntity<?> getKecamatan(@PathVariable String kode) {

        List<Desa> desa = desaRepository.findFromKecamatan(kode);
        return ResponseEntity.ok(desa);
    }

    @PostMapping("/add")
    public ResponseEntity<?> insertDesa(@RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Desa> result = new StatusMessageDto<>();
        try {
            return desaService.add(wilayahDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editWilayah(@PathVariable Integer id, @RequestBody WilayahDto wilayahDto) {
        StatusMessageDto<Desa> result = new StatusMessageDto<>();

        try {
            return desaService.edit(id, wilayahDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return desaService.delete(id);
    }

}
