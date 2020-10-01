package com.example.siswa.job;

import java.util.List;

import com.example.siswa.entity.Siswa;
import com.example.siswa.repository.SiswaRepository;
import com.example.siswa.vo.SiswaVO;
import com.example.siswa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.siswa.converter.*;
@Component
public class InputSiswa {
    @Autowired
    SiswaRepository siswaRepository;

    @Autowired
    NilaiService nilaiService;

    @Autowired
    ConvertCSVtoModel converter;

    public void loadData(){
        nilaiService.clearAllData();
        persist(converter.convertSiswaFiletoSiswaVO());
    }

    public void persist(List<SiswaVO> vos){
        vos.stream().forEach((siswa)->{
            Siswa model = new Siswa(siswa.getId(), siswa.getNama(), siswa.getKelas());
            siswaRepository.save(model);            
        });
    }

}
