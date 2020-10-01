package com.example.siswa.repository;

import java.util.List;
import java.util.Optional;

import com.example.siswa.entity.Siswa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Integer> {
    Siswa findById(Long id);
    
}
