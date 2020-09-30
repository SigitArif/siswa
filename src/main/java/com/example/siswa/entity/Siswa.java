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
    @GeneratedValue
    @Column(name= "NOMOR_INDUK")
    private Long id;

    private String nama;
    private String kelas;

    public Siswa(){}

    public Siswa(Long id, String nama, String kelas){
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
    }
}