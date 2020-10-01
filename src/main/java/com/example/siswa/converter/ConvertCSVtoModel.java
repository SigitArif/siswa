package com.example.siswa.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.example.siswa.vo.SiswaVO;

import org.springframework.stereotype.Component;

@Component
public class ConvertCSVtoModel {
    // modify this path to your local document path
    public static final String FILE_PATH = "/home/sigit/Documents/Exercise/siswa/src/main/resources/input";

    public List<SiswaVO> convertSiswaFiletoSiswaVO(){
        Path pathToSiswaFile = Paths.get(FILE_PATH + "/siswa.csv");
        List<SiswaVO> siswaVOs = new ArrayList<SiswaVO>();
        try(BufferedReader br = Files.newBufferedReader(pathToSiswaFile, 
                 StandardCharsets.US_ASCII)){
            String line = br.readLine();
            System.out.println(line);
            line = br.readLine();

            while(line!=null){
                String[] attributes = line.split(",");
                siswaVOs.add(convertAttributeToSiswa(attributes));

                line = br.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return siswaVOs;
    }

    public SiswaVO convertAttributeToSiswa(String[] attributes){
        SiswaVO siswaVO = new SiswaVO();
        Long id = Long.parseLong(attributes[0]);
        String nama = attributes[1];
        String kelas = attributes[2];
        siswaVO.setId(id);
        siswaVO.setNama(nama);
        siswaVO.setKelas(kelas);
        return siswaVO;
    }
}
