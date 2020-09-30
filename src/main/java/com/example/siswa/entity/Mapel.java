package com.example.siswa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Mapel {
    @Id
    @GeneratedValue
    @Column(name = "ID_MAPEL")
    private Long id;

    private String nama;

    public Mapel(){}
    public Mapel(Long id, String nama){
        this.id = id;
        this.nama = nama;
    }
    
}
