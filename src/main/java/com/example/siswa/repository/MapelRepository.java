package com.example.siswa.repository;

import com.example.siswa.entity.Mapel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapelRepository extends JpaRepository<Mapel, Long>{
 
    Mapel findByNama(String nama);
    void deleteByNama(String nama);
}
