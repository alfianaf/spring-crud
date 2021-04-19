package com.alfian.latihanspring.models.entity;

import java.io.Serializable;

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
@Table(name = "kabupaten")
public class Kabupaten implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 25)
    private String kodeKabupaten;

    @Column
    private String namaKabupaten;

    @ManyToOne
    @JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
    private Provinsi kodeProvinsi;

    @Column
    private Integer isActive;
}
