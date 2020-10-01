package com.example.siswa.vo;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class SiswaVO {

   private Long id;
   private String nama;
   private String kelas;

}
