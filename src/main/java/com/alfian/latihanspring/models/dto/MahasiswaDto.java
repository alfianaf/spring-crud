package com.alfian.latihanspring.models.dto;

import java.util.Date;

public class MahasiswaDto {
    private String nama;
    private String jurusan;
    private String nim;
    private String domisili;
    private Date tanggalLahir;

    public MahasiswaDto() {
    }

    public MahasiswaDto(String nama, String jurusan, String nim, String domisili, Date tanggalLahir) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.nim = nim;
        this.domisili = domisili;
        this.tanggalLahir = tanggalLahir;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

}
