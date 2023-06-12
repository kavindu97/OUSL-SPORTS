package com.kavindu.controller;

import com.kavindu.dto.BoxingPractisesDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.BoxingPractisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/boxing-practises")
public class BoxingPractisesController {
    @Autowired
    private BoxingPractisesService boxingPractisesService;
    @PostMapping("/insert")
    public ResponseDto insert(@RequestBody BoxingPractisesDto boxingPractisesDto){
      return   boxingPractisesService.insertData(boxingPractisesDto);
    }
    @PutMapping("/update")
    public  ResponseDto update(@RequestBody BoxingPractisesDto boxingPractisesDto){
        return  boxingPractisesService.updateData(boxingPractisesDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id){
        return  boxingPractisesService.deleteData(id);
    }
    @GetMapping("/all")
    public ResponseDto allData(){
        return boxingPractisesService.allData();
    }

}
