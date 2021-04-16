package com.alfian.latihanspring.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WilayahDto {
    private String kodeKecamatan;
    private String kodeKabupaten;
    private String kodeDesa;
    private String kodeProvinsi;
    private String namaProvinsi;
    private String namaKabupaten;
    private String namaKecamatan;
    private String namaDesa;
}
