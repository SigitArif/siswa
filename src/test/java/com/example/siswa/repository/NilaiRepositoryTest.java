package com.example.siswa.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.siswa.entity.*;
import com.example.siswa.service.NilaiService;
import com.example.siswa.vo.NilaiDetailVO;
@SpringBootTest
public class NilaiRepositoryTest {
    
@Autowired
private NilaiRepository nilaiRepository;

@Autowired
NilaiService nilaiService;
    @Test
    public void findByIdSiswaAndMapelNameTest(){
        Long noInduk = 1L;
        String mapel = "matematika";
        List<Nilai> nilai = nilaiRepository.findBySiswa_IdAndMapel_Nama(noInduk, mapel);
        List<NilaiDetailVO> nilaiDetail = nilaiService.convertModeltoVO(nilai);
        assertTrue(nilai.size()>0);
    }
}

