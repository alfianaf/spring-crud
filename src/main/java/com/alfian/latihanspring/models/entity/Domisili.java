package com.alfian.latihanspring.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "domisili")
public class Domisili {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String kelurahan;

    @Column
    private String kecamatan;

    @Column
    private String provinsi;

    @OneToOne
    @JoinColumn(name = "detailUser")
    private DetailUser detailUser;

    public Domisili(String kelurahan, String kecamatan, String provinsi) {
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.provinsi = provinsi;
    }

}
