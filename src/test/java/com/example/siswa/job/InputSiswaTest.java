package com.example.siswa.job;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.example.siswa.entity.Siswa;
import com.example.siswa.repository.SiswaRepository;
import com.example.siswa.vo.SiswaVO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
// @RunWith(SpringRunner.class)
public class InputSiswaTest {

    @Autowired
    InputSiswa input;

    @Autowired
    SiswaRepository siswaRepository;
    @Test
    public void persisTest(){
        List<SiswaVO> vos = new ArrayList<SiswaVO>();
        SiswaVO siswaVO = new SiswaVO();
        siswaVO.setId(1L);
        siswaVO.setKelas("VII");
        siswaVO.setNama("Juanda");
        vos.add(siswaVO);
        input.persist(vos);
        String result = "";
        List<Siswa> models = siswaRepository.findAll();
        assertTrue(models.size()>0);        
    }

    @Test
    public void loadDataTest(){
        input.loadData();
        List<Siswa> models = siswaRepository.findAll();
        assertTrue(models.size()>0); 
    }
}
