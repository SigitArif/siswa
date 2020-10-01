package com.example.siswa.controller;

import com.example.siswa.service.MapelService;
import com.example.siswa.service.NilaiService;
import com.example.siswa.util.RestUtil;
import com.example.siswa.vo.NilaiReqVO;
import com.example.siswa.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/siswa-service/api/v1/nilai")
public class NilaiController {

    @Autowired
    NilaiService nilaiService;

    @Autowired
    MapelService mapelService;
    @PostMapping(value="/list")
    public ResponseEntity<ResultVO> list(@RequestBody NilaiReqVO vo){
        ResultVO result = new ResultVO();
        result.setStatus(200);
        result.setResults(nilaiService.findAllFilter(vo));
        result.setMessage("OK");
        return RestUtil.getJsonResponse(result);
    }

    @PutMapping(value="/update")
    public ResponseEntity<ResultVO> update(@RequestBody NilaiReqVO vo){
        ResultVO result = new ResultVO();
        result.setStatus(200);
        result.setResults(nilaiService.update(vo));
        result.setMessage("OK");
        return RestUtil.getJsonResponse(result);
    }

    @DeleteMapping(value="/mapel/delete")
    public ResponseEntity<ResultVO> deleteMapel(@RequestParam("mapel") String mapel){
        ResultVO result = new ResultVO();
        nilaiService.deleteMapel(mapel);
        result.setStatus(204);
        result.setResults("Mapel "+mapel+" Terhapus");
        result.setMessage("OK");
        return RestUtil.getJsonResponse(result);
    }
}
