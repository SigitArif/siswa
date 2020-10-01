package com.example.siswa.service;

import com.example.siswa.repository.SiswaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiswaService {
    @Autowired
    SiswaRepository siswaRepository;
    public void clearAllData(){
        siswaRepository.deleteAll();
    }
}
