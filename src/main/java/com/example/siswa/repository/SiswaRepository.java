package com.example.siswa.repository;

import com.example.siswa.entity.Siswa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long>{
    
}
