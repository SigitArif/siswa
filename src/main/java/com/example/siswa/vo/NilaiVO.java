package com.example.siswa.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NilaiVO {
    @JsonProperty("no_induk")
    private Long noInduk;
    private String mapel;
    private Integer nilai;

}
