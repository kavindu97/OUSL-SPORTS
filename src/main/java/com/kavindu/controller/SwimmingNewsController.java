package com.kavindu.controller;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.SwimmingNewsDto;
import com.kavindu.service.SwimmingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/swimming-news")
public class SwimmingNewsController {
    @Autowired
    private SwimmingNewsService swimmingNewsService;
    @GetMapping("/all")
    public ResponseDto all(){
        return swimmingNewsService.allData();
    }
    @PostMapping("/insert")
    public ResponseDto insert(@RequestBody SwimmingNewsDto swimmingNewsDto){
        return swimmingNewsService.insertData(swimmingNewsDto);
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody SwimmingNewsDto swimmingNewsDto){
        return swimmingNewsService.updateData(swimmingNewsDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id){
        return swimmingNewsService.deleteData(id);
    }
}
