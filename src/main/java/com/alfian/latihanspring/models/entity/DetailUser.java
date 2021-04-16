package com.alfian.latihanspring.models.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "detail_user")
public class DetailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String nik;

    @Column
    private String domisili;

    @Column
    private Date tanggalLahir;

    @Column
    private String golDarah;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public DetailUser(String firstName, String lastName, String nik, String domisili, Date tanggalLahir,
            String golDarah) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nik = nik;
        this.domisili = domisili;
        this.tanggalLahir = tanggalLahir;
        this.golDarah = golDarah;
    }
}
