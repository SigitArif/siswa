package com.example.siswa.converter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConvertCSVtoModelTest {
    
    @Autowired
    ConvertCSVtoModel converter;

    @Test
    public void convertSiswaTest(){
        
    assertNotNull(converter.convertSiswaFiletoSiswaVO());
    }

    @Test
    public void convertNilaiTest(){
    assertNotNull(converter.convertNilaiFiletoNilaiVO());
    }
}
