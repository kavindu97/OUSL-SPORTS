package com.kavindu.controller;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.RugbyPractisesDto;
import com.kavindu.service.RugbyPractisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/rugby-practises")
public class RugbyPractisesController {
    @Autowired
    private RugbyPractisesService rugbyPractisesService;
    @PostMapping("/save")
    public ResponseDto insert(@RequestBody RugbyPractisesDto rugbyPractisesDto){
        return  rugbyPractisesService.insertData(rugbyPractisesDto);
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody RugbyPractisesDto rugbyPractisesDto){
        return  rugbyPractisesService.updateData(rugbyPractisesDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id){
        return rugbyPractisesService.deleteData(id);
    }
    @GetMapping("/all")
    public ResponseDto getAll(){
        return  rugbyPractisesService.allData();
    }

}
