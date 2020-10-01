package com.example.siswa.controller;

import com.example.siswa.service.NilaiService;
import com.example.siswa.util.RestUtil;
import com.example.siswa.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/siswa-service/api/v1/nilai")
public class NilaiController {

    @Autowired
    NilaiService nilaiService;

    @GetMapping(value="/list")
    public ResponseEntity<ResultVO> list(){
        ResultVO result = new ResultVO();
        result.setStatus(200);
        result.setResults(nilaiService.getAllNilai());
        result.setMessage("OK");
        return RestUtil.getJsonResponse(result);
    }

}
