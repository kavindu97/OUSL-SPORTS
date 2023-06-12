package com.kavindu.controller;

import com.kavindu.dto.BadmintonNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.BadmintonNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/badminton-news")
public class BadmintonNewsController {
    @Autowired
    private BadmintonNewsService badmintonService;
    @GetMapping("/all")
    public ResponseDto allData(){
        return badmintonService.allData();
    }
    @PostMapping("/insert")
    public ResponseDto insertData(@RequestBody BadmintonNewsDto badmintonNewsDto){
        return  badmintonService.insertData(badmintonNewsDto);
    }
    @PutMapping("/update")
    public ResponseDto updateData(@RequestBody BadmintonNewsDto badmintonNewsDto){
        return  badmintonService.updateData(badmintonNewsDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto  deleteData(@RequestParam int id){
        return badmintonService.deleteData(id);
    }
}
