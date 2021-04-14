package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.PendidikanDto;
import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.entity.Pendidikan;
import com.alfian.latihanspring.models.entity.User;
import com.alfian.latihanspring.repository.PendidikanRepository;
import com.alfian.latihanspring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class PendidikanServiceImpl implements PendidikanService {
    @Autowired
    private PendidikanRepository pendidikanRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> regist(@RequestBody PendidikanDto pendidikanDto) {
        StatusMessageDto<Pendidikan> result = new StatusMessageDto<>();

        Pendidikan pendidikan = new Pendidikan();
        pendidikan.setInstitusi(pendidikanDto.getInstitusi());
        pendidikan.setJenjang(pendidikanDto.getJenjang());
        pendidikan.setKodePendidikan(pendidikanDto.getKodePendidikan());
        pendidikanRepository.save(pendidikan);
        pendidikan.setKodePendidikan("P" + pendidikan.getId());

        User user = userRepository.findByUsername(pendidikanDto.getUsername());
        pendidikan.setUser(user);

        pendidikanRepository.save(pendidikan);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil tersimpan!");
        result.setData(pendidikan);

        return ResponseEntity.ok(result);

    }

    @Override
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody PendidikanDto pendidikanDto) {
        StatusMessageDto<Pendidikan> result = new StatusMessageDto<>();
        Pendidikan pendidikan = pendidikanRepository.findById(id).get();
        pendidikan.setInstitusi(pendidikanDto.getInstitusi());
        pendidikan.setJenjang(pendidikanDto.getJenjang());
        pendidikan.setKodePendidikan(pendidikanDto.getKodePendidikan());
        pendidikanRepository.save(pendidikan);
        pendidikan.setKodePendidikan("P" + pendidikan.getId());

        User user = userRepository.findByUsername(pendidikanDto.getUsername());
        pendidikan.setUser(user);

        pendidikanRepository.save(pendidikan);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil diubah!");
        result.setData(pendidikan);

        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        StatusMessageDto<Pendidikan> result = new StatusMessageDto<>();
        Pendidikan pendidikan = pendidikanRepository.findById(id).get();

        pendidikanRepository.delete(pendidikan);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil dihapus!");
        result.setData(pendidikan);

        return ResponseEntity.ok(result);
    }

}
