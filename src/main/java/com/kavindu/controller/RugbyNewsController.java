package com.kavindu.controller;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.RugbyNewsDto;
import com.kavindu.service.RugbyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/rugby-news")
public class RugbyNewsController {
    @Autowired
    private RugbyNewsService rugbyNewsService;
    @PostMapping("/insert")
    public ResponseDto insertData(@RequestBody RugbyNewsDto rugbyNewsDto){
        return rugbyNewsService.insertData(rugbyNewsDto);
    }
    @PutMapping("/update")
    public ResponseDto updateData(@RequestBody RugbyNewsDto rugbyNewsDto){
        return  rugbyNewsService.updateData(rugbyNewsDto);
    }
    @GetMapping("/all")
    public ResponseDto allData(){
        return  rugbyNewsService.allData();
    }
    @DeleteMapping("/delete")
    public ResponseDto deleteData(@RequestParam int id){
        return  rugbyNewsService.deleteData(id);
    }
}
