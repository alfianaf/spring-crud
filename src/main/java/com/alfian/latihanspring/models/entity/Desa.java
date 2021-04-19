package com.alfian.latihanspring.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "desa")
public class Desa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 25)
    private String kodeDesa;

    @Column
    private String namaDesa;

    @ManyToOne
    @JoinColumn(name = "kodeKecamatan", referencedColumnName = "kodeKecamatan")
    private Kecamatan kodeKecamatan;

    @ManyToOne
    @JoinColumn(name = "kodeKabupaten", referencedColumnName = "kodeKabupaten")
    private Kabupaten kodeKabupaten;

    @ManyToOne
    @JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
    private Provinsi kodeProvinsi;

    @Column
    private Integer isActive;
}
