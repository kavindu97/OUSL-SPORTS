package com.kavindu.service.impl;

import com.kavindu.dto.ChessPractiseDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.ChessPractiseEntity;
import com.kavindu.repository.ChessPractiseRepository;
import com.kavindu.service.ChessPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChessPractiseServiceImpl implements ChessPractiseService {
    @Autowired
    private ChessPractiseRepository chessPractiseRepository;

    @Override
    public ResponseDto all() {
       ResponseDto responseDto=new ResponseDto();
        List<ChessPractiseEntity> chessPractiseEntityList=chessPractiseRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
     responseDto.setCode(200);
     responseDto.setMsg("all");
     responseDto.setData(chessPractiseEntityList);
     return responseDto;
    }

    @Override
    public ResponseDto insert(ChessPractiseDto chessPractiseDto) {
       ResponseDto responseDto =new ResponseDto();
       ChessPractiseEntity chessPractiseEntity=new ChessPractiseEntity();
       chessPractiseEntity.setCenter(chessPractiseDto.getCenter());
       chessPractiseEntity.setDate(chessPractiseDto.getDate());
       chessPractiseEntity.setTime(chessPractiseDto.getTime());
       chessPractiseRepository.save(chessPractiseEntity);
       responseDto.setCode(200);
       responseDto.setMsg("Inserted data");
       return responseDto;
    }

    @Override
    public ResponseDto update(ChessPractiseDto chessPractiseDto) {
        ResponseDto responseDto=new ResponseDto();
        Optional<ChessPractiseEntity> optionalChessPractiseEntity=chessPractiseRepository.findById(chessPractiseDto.getId());
        if(optionalChessPractiseEntity.isPresent()){
            ChessPractiseEntity chessPractiseEntity=optionalChessPractiseEntity.get();
            chessPractiseEntity.setTime(chessPractiseDto.getTime());
            chessPractiseEntity.setDate(chessPractiseDto.getDate());
            chessPractiseEntity.setCenter(chessPractiseDto.getCenter());
            chessPractiseRepository.save(chessPractiseEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Data updated");
            return  responseDto;
        }else {
            responseDto.setCode(404);
            responseDto.setMsg("Data  not updated");
            return  responseDto;
        }
    }

    @Override
    public ResponseDto delete(int id) {
        ResponseDto responseDto=new ResponseDto();
        chessPractiseRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Data  deleted");
        return  responseDto;
    }
}
