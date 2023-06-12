package com.kavindu.controller;

import com.kavindu.dto.BoxingNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.BoxingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/boxing-news")
public class BoxingNewsController {
    @Autowired
    private BoxingNewsService boxingNewsService;

    @GetMapping("/all")
    public ResponseDto getAll ()throws ParseException {
       return boxingNewsService.allData();
    }
    @PostMapping("/save")
    public ResponseDto insertData(@RequestBody BoxingNewsDto boxingNewsDto) throws ParseException{
        return boxingNewsService.saveData(boxingNewsDto);
    }
    @PutMapping("/update")
    public ResponseDto updateData(@RequestBody BoxingNewsDto boxingNewsDto) throws ParseException{
        return boxingNewsService.updateData(boxingNewsDto);
    }
    @DeleteMapping("delete/{id}")
    public  ResponseDto deleteData(@PathVariable int id) throws  ParseException{
        return boxingNewsService.deleteData(id);
    }
}
