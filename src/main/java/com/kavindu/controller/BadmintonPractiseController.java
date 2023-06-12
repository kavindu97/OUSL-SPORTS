package com.kavindu.controller;

import com.kavindu.dto.BadmintonNewsDto;
import com.kavindu.dto.BadmintonPractiseDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.BadmintonPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/badminton-practise")
public class BadmintonPractiseController {
    @Autowired
    private BadmintonPractiseService badmintonPractiseService;
    @GetMapping("/all")
    public ResponseDto allData(){
     return badmintonPractiseService.allData();
    }
    @DeleteMapping("/delete")
    public ResponseDto deleteData(@RequestParam int id ){
        return badmintonPractiseService.deleteData(id);
    }
    @PutMapping("/update")
    public ResponseDto updateData(@RequestBody BadmintonPractiseDto badmintonPractiseDto){
        return badmintonPractiseService.updateData(badmintonPractiseDto);
    }
    @PostMapping("/insert")
    public ResponseDto insertData(@RequestBody BadmintonPractiseDto badmintonPractiseDto ){
        return  badmintonPractiseService.insertData(badmintonPractiseDto);

    }
}
