package com.alfian.latihanspring.controllers;

import java.util.List;

import com.alfian.latihanspring.models.dto.PendidikanDto;
import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.entity.Pendidikan;
import com.alfian.latihanspring.models.entity.User;
import com.alfian.latihanspring.repository.PendidikanRepository;
import com.alfian.latihanspring.repository.UserRepository;
import com.alfian.latihanspring.service.PendidikanService;

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
@RequestMapping("/pendidikan")
public class PendidikanController {
    @Autowired
    private PendidikanRepository pendidikanRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PendidikanService pendidikanService;

    @PostMapping("/add/{username}")
    public ResponseEntity<?> insertPendidikan(@PathVariable String username, @RequestBody PendidikanDto pendidikanDto) {
        StatusMessageDto<Pendidikan> result = new StatusMessageDto<>();
        try {
            return pendidikanService.regist(username, pendidikanDto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editPendidikan(@PathVariable Integer id, @RequestBody PendidikanDto pendidikanDto) {
        StatusMessageDto<Pendidikan> result = new StatusMessageDto<>();

        try {
            return pendidikanService.edit(id, pendidikanDto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return pendidikanService.delete(id);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        List<Pendidikan> pendidikan = pendidikanRepository.findAll();
        return ResponseEntity.ok(pendidikan);
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Pendidikan pendidikan = pendidikanRepository.findById(id).get();
        return ResponseEntity.ok(pendidikan);
    }

    private Pendidikan convert(PendidikanDto pendidikanDto) {
        Pendidikan pendidikan = new Pendidikan();
        pendidikan.setInstitusi(pendidikanDto.getInstitusi());
        pendidikan.setJenjang(pendidikanDto.getJenjang());
        pendidikan.setKodePendidikan(pendidikanDto.getKodePendidikan());
        pendidikanRepository.save(pendidikan);
        pendidikan.setKodePendidikan("P" + pendidikan.getId());

        User user = userRepository.findByUsername(pendidikanDto.getUsername());
        pendidikan.setUser(user);
        pendidikanRepository.save(pendidikan);
        return pendidikan;
    }

    @PostMapping("/add/list")
    public ResponseEntity<?> insertList(@RequestBody List<PendidikanDto> listDto) {

        for (PendidikanDto pendidikanDto : listDto) {
            convert(pendidikanDto);
        }

        return ResponseEntity.ok(listDto);
    }
}
