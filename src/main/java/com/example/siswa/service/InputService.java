package com.example.siswa.service;

import javax.transaction.Transactional;

import com.example.siswa.job.InputNilai;
import com.example.siswa.job.InputSiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InputService {

    @Autowired
    InputSiswa inputSiswa;

    @Autowired
    InputNilai inputNilai;

    @Scheduled(cron = "0 0 13 * * ?")
    public void inputAllData(){
        inputSiswa.loadData();
        inputNilai.loadData();
    }
}
