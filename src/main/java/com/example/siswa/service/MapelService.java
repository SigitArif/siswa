package com.example.siswa.service;

import com.example.siswa.repository.MapelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapelService {
    @Autowired
    MapelRepository mapelRepository;

    public void clearAllData(){
        mapelRepository.deleteAll();
    }
    public void delete(String mapel){
        mapelRepository.delete(mapelRepository.findByNama(mapel));
    }
}
