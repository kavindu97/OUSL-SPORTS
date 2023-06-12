package com.kavindu.controller;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.TableTennisPractiseDto;
import com.kavindu.service.TableTennisPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/table-tennis/practise")
public class TableTennisPractiseController {
    @Autowired
    private TableTennisPractiseService tableTennisPractiseService;
    @PostMapping("/insert")
    public ResponseDto insert(@RequestBody TableTennisPractiseDto tableTennisPractiseDto){
        return  tableTennisPractiseService.insert(tableTennisPractiseDto);
    }
    @GetMapping("/show")
    public ResponseDto getAll(){
        return  tableTennisPractiseService.getting();
    }
    @PutMapping("/update")
    public ResponseDto update(@RequestBody TableTennisPractiseDto tableTennisPractiseDto){
        return tableTennisPractiseService.update(tableTennisPractiseDto);
    }
    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id){
        return  tableTennisPractiseService.delete(id);
    }
}
