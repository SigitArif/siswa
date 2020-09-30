package com.example.siswa.job;

import java.util.List;

import com.example.siswa.entity.Mapel;
import com.example.siswa.entity.Nilai;
import com.example.siswa.repository.MapelRepository;
import com.example.siswa.repository.NilaiRepository;
import com.example.siswa.repository.SiswaRepository;
import com.example.siswa.vo.NilaiVO;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputNilai {
    
    @Autowired
    MapelRepository mapelRepository;
    
    @Autowired
    SiswaRepository siswaRepository;

    @Autowired
    NilaiRepository nilaiRepository;

    public void persist(List<NilaiVO> vos){
        vos.stream().forEach( nilai->{
            // init nilai entity
            Nilai model = new Nilai();
            // set mapel
            model.setMapel(getMapel(nilai));
            // set siswa
            model.setSiswa(siswaRepository.findById(nilai.getNoInduk()).get());
            // set nilai
            model.setNilai(nilai.getNilai());
            nilaiRepository.save(model);         
        });
    }

    public Mapel getMapel(NilaiVO vo){

        Mapel mapel = mapelRepository.findByNama(vo.getMapel());
        if(mapel==null){
            mapel.setNama(vo.getMapel());
            mapel = mapelRepository.save(mapel);
        }

        return mapel;
    }
}
