package com.example.siswa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Siswa{

    @Id
    @Column(name= "NOMOR_INDUK", nullable = false)
    private Long id;
    @Column(name = "NAMA", nullable = false)
    private String nama;
    @Column(name ="KELAS", nullable = false)
    private String kelas;

    public Siswa(){}

    public Siswa(Long id, String nama, String kelas){
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
    }
}