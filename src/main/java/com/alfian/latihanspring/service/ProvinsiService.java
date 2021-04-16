package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.WilayahDto;

import org.springframework.http.ResponseEntity;

public interface ProvinsiService {
    public ResponseEntity<?> add(WilayahDto wilayahDto);

    public ResponseEntity<?> edit(Integer id, WilayahDto wilayahDto);

    public ResponseEntity<?> delete(Integer id);

}
