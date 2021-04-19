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
@Table(name = "pendidikan")
public class Pendidikan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String kodePendidikan;

    @Column
    private String jenjang;

    @Column
    private String institusi;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Pendidikan(String kodePendidikan, String jenjang, String institusi, User user) {
        this.kodePendidikan = kodePendidikan;
        this.jenjang = jenjang;
        this.institusi = institusi;
        this.user = user;
    }
}
