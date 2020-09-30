package com.example.siswa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Nilai {
    @Id
    @GeneratedValue
    @Column(name = "ID_NILAI", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="NOMOR_INDUK_SISWA", nullable = false)
    private Siswa siswa;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MAPEL", nullable = false)
    private Mapel mapel;

    @Column(name = "NILAI", nullable = false)
    private Integer nilai;

    public Nilai(){}

    public Nilai(Long id, Siswa siswa, Mapel mapel, Integer nilai){
        this.id = id;
        this.siswa = siswa;
        this.mapel = mapel;
        this.nilai = nilai;
    }

    
}
