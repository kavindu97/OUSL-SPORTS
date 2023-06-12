package com.kavindu.controller;

import com.kavindu.dto.ChessNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.ChessNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/chess-news")
public class ChessNewsController {
    @Autowired
    private ChessNewsService chessNewsService;
    @GetMapping("/all")
    public ResponseDto all(){
        return chessNewsService.all();
    }
    @PostMapping("/insert")
    public ResponseDto insert(@RequestBody ChessNewsDto chessNewsDto){
    return  chessNewsService.insert(chessNewsDto);
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody ChessNewsDto chessNewsDto){
        return  chessNewsService.update(chessNewsDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id){
        return  chessNewsService.delete(id);
    }
}
