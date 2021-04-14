package com.alfian.latihanspring.models.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MahasiswaDto {
    private String username;
    private String password;
    private String nama;
    private String jurusan;
    private String nim;
    private String domisili;
    private Date tanggalLahir;
    private String firstName;
    private String lastName;
    private String nik;
    private String golDarah;
    private String kelurahan;
    private String kecamatan;
    private String provinsi;

    public MahasiswaDto() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public MahasiswaDto(String nama, String jurusan, String nim, String domisili, Date tanggalLahir, String firstName,
            String lastName, String nik) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.nim = nim;
        this.domisili = domisili;
        this.tanggalLahir = tanggalLahir;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nik = nik;
    }

}
