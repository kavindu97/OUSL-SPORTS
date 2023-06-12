package com.kavindu.controller;

import com.kavindu.dto.CricketNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.CricketNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/cricket-news")
public class CricketNewsController {
    @Autowired
    private CricketNewsService cricketService;
    @PostMapping("/insert")
    public ResponseDto insertData(@RequestBody CricketNewsDto cricketDto){

        return cricketService.saveData(cricketDto);
    }
    @GetMapping("/all")
    public ResponseDto show() throws ParseException {
        return  cricketService.all();
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody CricketNewsDto cricketNewsDto){
        return  cricketService.updateData(cricketNewsDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete (@RequestParam int id)throws ParseException{
        return cricketService.delete(id);
    }
}
