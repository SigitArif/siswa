package com.example.siswa.job;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.example.siswa.entity.Mapel;
import com.example.siswa.entity.Nilai;
import com.example.siswa.repository.MapelRepository;
import com.example.siswa.repository.NilaiRepository;
import com.example.siswa.vo.NilaiVO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InputNilaiTest {

@Autowired
NilaiRepository nilaiRepository;
@Autowired
InputNilai inputNilai;

@Autowired
MapelRepository mapelRepository;

@Test
public void persistTest(){

    List<NilaiVO> vos = new ArrayList<NilaiVO>();
    NilaiVO vo = new NilaiVO();
    vo.setNoInduk(2L);
    vo.setMapel("matematika");
    vo.setNilai(60);
    vos.add(vo);
    inputNilai.persist(vos);

    List<Nilai> models = nilaiRepository.findAll();
    List<Mapel> mapelList = mapelRepository.findAll();
    assertTrue(models.size()>0 &&mapelList.size()>0);
}
@Test
public void loadDataTest(){
    inputNilai.loadData();
    List<Nilai> models = nilaiRepository.findAll();
    List<Mapel> mapelList = mapelRepository.findAll();
    assertTrue(models.size()>0 &&mapelList.size()>0);
}
    
}
