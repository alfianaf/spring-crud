package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.MahasiswaDto;
import com.alfian.latihanspring.models.entity.Mahasiswa;

public interface MahasiswaService {
    public Mahasiswa insertData(MahasiswaDto mahasiswaDto);

}
