package com.example.siswa.repository;

import com.example.siswa.entity.Nilai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NilaiRepository extends JpaRepository<Nilai, Long>, JpaSpecificationExecutor<Nilai> {
    
}
