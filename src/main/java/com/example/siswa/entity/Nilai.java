package com.example.siswa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Nilai {
    @Id
    @GeneratedValue
    @Column(name = "ID_NILAI")
    private Long id;

    @Column(name ="NOMOR_INDUK_SISWA")
    private Long idSiswa;

    @Column(name = "ID_MAPEL")
    private Long idMapel;

    private Integer nilai;

    public Nilai(){}

    public Nilai(Long id, Long idSiswa, Long idMapel, Integer nilai){
        this.id = id;
        this.idSiswa = idSiswa;
        this.idMapel = idMapel;
        this.nilai = nilai;
    }

    
}
