package com.example.siswa.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class NilaiDetailVO {

    @JsonProperty("nomor_induk")
    private Long id;
    private String nama;

    @JsonProperty("mata_pelajaran")
    private String mapel;    
    private Integer nilai;
}
