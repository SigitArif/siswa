package com.example.siswa.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.siswa.entity.Nilai;
import com.example.siswa.repository.MapelRepository;
import com.example.siswa.repository.NilaiRepository;
import com.example.siswa.repository.SiswaRepository;
import com.example.siswa.vo.NilaiDetailVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NilaiService {
    @Autowired
    NilaiRepository nilaiRepository;
    
    @Autowired
    SiswaRepository siswaRepository;

    @Autowired
    MapelRepository mapelRepository;
    
    public List<NilaiDetailVO> getAllNilai(){

        return convertModeltoVO(nilaiRepository.findAll());
    }

    protected List<NilaiDetailVO> convertModeltoVO(List<Nilai> models){
        
        return models.stream().map(model->{
            NilaiDetailVO vo = new NilaiDetailVO();
            vo.setNama(model.getSiswa().getNama());
            vo.setId(model.getSiswa().getId());
            vo.setMapel(model.getMapel().getNama());
            vo.setNilai(model.getNilai());
            return vo;
        }).collect(Collectors.toList());
    }

    public void clearAllData(){
        nilaiRepository.deleteAll();
        siswaRepository.deleteAll();
        mapelRepository.deleteAll();
    }
}
