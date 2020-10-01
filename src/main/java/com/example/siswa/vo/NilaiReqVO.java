package com.example.siswa.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class NilaiReqVO {
    @JsonProperty("no_induk")
    private String noInduk;
    private String nama;
    @JsonProperty("mata_pelajaran")
    private String mapel;
    private String nilai;
}
