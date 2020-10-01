package com.example.siswa.repository;

import java.util.List;

import com.example.siswa.entity.Nilai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface NilaiRepository extends JpaRepository<Nilai, Long>, JpaSpecificationExecutor<Nilai> {

    List<Nilai> findBySiswa_IdAndMapel_Nama(Long noInduk, String mapel);
    void deleteByMapel_Nama(String mapel);
}
