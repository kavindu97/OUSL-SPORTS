package com.kavindu.controller;

import com.kavindu.dto.CricketPractiseDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.CricketPractisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/cricket-practise")
public class CricketPractisesController {
    @Autowired
   private CricketPractisesService cricketPractisesService;
   @PostMapping("/insert")
   public ResponseDto insert(@RequestBody CricketPractiseDto cricketPractiseDto){
        return  cricketPractisesService.insert(cricketPractiseDto);
    }
    @GetMapping("/all")
    public ResponseDto all(){
       return  cricketPractisesService.all();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable  int id){
       return cricketPractisesService.delete(id);
    }
    @PutMapping("/update")
    public  ResponseDto update(@RequestBody CricketPractiseDto cricketPractiseDto) throws ParseException {
       return cricketPractisesService.update(cricketPractiseDto);
    }
}
