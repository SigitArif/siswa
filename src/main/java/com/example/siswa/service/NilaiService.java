package com.example.siswa.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.example.siswa.entity.Nilai;
import com.example.siswa.repository.MapelRepository;
import com.example.siswa.repository.NilaiRepository;
import com.example.siswa.repository.SiswaRepository;
import com.example.siswa.util.AssertUtil;
import com.example.siswa.vo.NilaiDetailVO;
import com.example.siswa.vo.NilaiReqVO;

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

    @Autowired
    private EntityManager entityManager;
    
    public List<NilaiDetailVO> getAllNilai(){

        return convertModeltoVO(nilaiRepository.findAll());
    }

    public List<NilaiDetailVO> convertModeltoVO(List<Nilai> models){
        
        return models.stream().map(this::getDetailVO).collect(Collectors.toList());
    }

    public NilaiDetailVO getDetailVO(Nilai model){
        NilaiDetailVO vo = new NilaiDetailVO();
            vo.setNama(model.getSiswa().getNama());
            vo.setId(model.getSiswa().getId());
            vo.setMapel(model.getMapel().getNama());
            vo.setNilai(model.getNilai());
            return vo;
    }

    public void clearAllData(){
        nilaiRepository.deleteAll();
        siswaRepository.deleteAll();
        mapelRepository.deleteAll();
    }

    public List<NilaiDetailVO> getListFilter(String noInduk, String nama, String mapel, String nilai){
        List<NilaiDetailVO> nilaiDetailVOs = getAllNilai();
        Stream<NilaiDetailVO> streamNilai = nilaiDetailVOs.stream();

        if(!AssertUtil.isEmptyOrNull(noInduk)){
           streamNilai = streamNilai.filter( n-> noInduk.equals(String.valueOf(n.getId())));
        }
        if(!AssertUtil.isEmptyOrNull(mapel)){
            streamNilai = streamNilai.filter(n->mapel.equals(n.getMapel()));
        }
        if(!AssertUtil.isEmptyOrNull(nama)){
            streamNilai = streamNilai.filter(n -> nama.equals(n.getNama()));
        }
        if(!AssertUtil.isEmptyOrNull(nilai)){
            streamNilai = streamNilai.filter(n-> nilai.equals(String.valueOf(n.getNilai())));
        }
        return streamNilai.collect(Collectors.toList());
    }

    public List<NilaiDetailVO> findAllFilter(NilaiReqVO vo){
        return getListFilter(vo.getNoInduk(), vo.getNama(), vo.getMapel(), vo.getNilai());
    }

    public NilaiDetailVO update(NilaiReqVO vo){
        Long noInduk = Long.parseLong(vo.getNoInduk());
        String mapel = vo.getMapel();
        List<Nilai> models = nilaiRepository.findBySiswa_IdAndMapel_Nama(noInduk, mapel);
        Nilai nilai = models.get(0);
        nilai.setNilai(Integer.parseInt(vo.getNilai()));
        nilaiRepository.saveAndFlush(nilai);
        return getDetailVO(nilai);
    }
    
    public void deleteMapel(String mapel){
        nilaiRepository.deleteByMapel_Nama(mapel);
        mapelRepository.deleteByNama(mapel);
        
    }
}
