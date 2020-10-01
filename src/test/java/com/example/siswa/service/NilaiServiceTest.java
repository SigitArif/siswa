package com.example.siswa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.example.siswa.entity.Mapel;
import com.example.siswa.entity.Nilai;
import com.example.siswa.entity.Siswa;
import com.example.siswa.repository.*;
import com.example.siswa.vo.NilaiDetailVO;
import com.example.siswa.vo.NilaiReqVO;

@SpringBootTest
public class NilaiServiceTest {

@Autowired
NilaiService nilaiService;

@Autowired
NilaiRepository nilaiRepository;

@Autowired
SiswaRepository siswaRepository;

@Autowired
MapelRepository mapelRepository;

@Test
public void clearData(){
    nilaiService.clearAllData();

    List<Nilai> nilai = nilaiRepository.findAll();
    List<Siswa> siswa = siswaRepository.findAll();
    List<Mapel> mapel = mapelRepository.findAll();
    assertTrue(nilai.size()==0 
               && siswa.size() ==0 
               && mapel.size()==0);
}
@Test
public void getAllFilterTest(){
    List<NilaiDetailVO> vos = nilaiService.getListFilter("1", null, "matematika", null);
    assertTrue(vos.size()>0);
}

public void updateTest(){
    NilaiReqVO vo = new NilaiReqVO();
    vo.setNama("Deni");
    vo.setMapel("agama");
    vo.setNilai("80");
    vo.setNoInduk("noInduk");
    NilaiDetailVO response = nilaiService.update(vo);
    assertNotNull(response);
}
}
