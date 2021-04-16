package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.PendidikanDto;
import com.alfian.latihanspring.models.entity.Pendidikan;

import org.springframework.http.ResponseEntity;

public interface PendidikanService {

    public ResponseEntity<?> regist(String username, PendidikanDto pendidikanDto);

    public ResponseEntity<?> edit(Integer id, PendidikanDto pendidikanDto);

    public ResponseEntity<?> delete(Integer id);

}
