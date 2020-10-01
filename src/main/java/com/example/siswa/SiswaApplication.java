package com.example.siswa;

import com.example.siswa.job.InputNilai;
import com.example.siswa.job.InputSiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SiswaApplication {
	@Autowired
	InputSiswa inputSiswa;

	@Autowired
	InputNilai inputNilai;
	public static void main(String[] args) {
		SpringApplication.run(SiswaApplication.class, args);
		
	}

}
