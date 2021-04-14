package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.MahasiswaDto;

import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> regist(MahasiswaDto mahasiswaDto);

    public ResponseEntity<?> edit(Integer id, MahasiswaDto mahasiswaDto);

    public ResponseEntity<?> delete(Integer id);
}
