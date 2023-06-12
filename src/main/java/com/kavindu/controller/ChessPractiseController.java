package com.kavindu.controller;

import com.kavindu.dto.ChessPractiseDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.ChessPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/chess-practise")
public class ChessPractiseController {
    @Autowired
    private ChessPractiseService chessPractiseService;

    @GetMapping("/all")
    public ResponseDto all(){
        return chessPractiseService.all();
    }
    @PostMapping("/insert")
    public ResponseDto insert(@RequestBody ChessPractiseDto chessPractiseDto){
         return  chessPractiseService.insert(chessPractiseDto);
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody ChessPractiseDto chessPractiseDto){
        return chessPractiseService.update(chessPractiseDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id){
        return chessPractiseService.delete(id);
    }
}

