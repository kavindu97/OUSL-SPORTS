package com.kavindu.controller;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.TableTennisNewsDto;
import com.kavindu.service.TableTennisNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/sport/tabletennis")
public class TableTennisNewsController {
    @Autowired
    private TableTennisNewsService tableTennisService;
    @PostMapping("/insert")
    public ResponseDto insertData(@RequestBody TableTennisNewsDto tableTennisDto){
        return  tableTennisService.insert(tableTennisDto);
    }
    @GetMapping("/all")
    public  ResponseDto getData(){
        return  tableTennisService.show();
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody TableTennisNewsDto tableTennisDto){
        return tableTennisService.update(tableTennisDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id){
        return  tableTennisService.delete(id);
    }
}
