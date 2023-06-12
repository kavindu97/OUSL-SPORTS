package com.kavindu.controller;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.SwimmingPractiseDto;
import com.kavindu.service.SwimmingPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/swimming-practise")
public class SwimmingPractiseController {
    @Autowired
    private SwimmingPractiseService swimmingPractiseService;
    @GetMapping("/all")
    public ResponseDto all(){
        return swimmingPractiseService.allData();
    }
    @PostMapping("/insert")
    public ResponseDto insert(@RequestBody SwimmingPractiseDto swimmingPractiseDto){
        return  swimmingPractiseService.insertData(swimmingPractiseDto);
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody SwimmingPractiseDto swimmingPractiseDto){
        return swimmingPractiseService.updateData(swimmingPractiseDto);
    }
    @DeleteMapping("/delete")
    public  ResponseDto delete(@RequestParam int id){
        return  swimmingPractiseService.deleteData(id);
    }
}
