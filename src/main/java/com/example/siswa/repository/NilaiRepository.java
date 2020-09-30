package com.example.siswa.repository;

import com.example.siswa.entity.Nilai;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NilaiRepository extends JpaRepository<Nilai, Long> {
    
}
