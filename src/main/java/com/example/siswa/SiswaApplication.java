package com.example.siswa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SiswaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiswaApplication.class, args);
	}

}
