package com.kavindu.service.impl;

import com.kavindu.dto.BadmintonNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.BadmintonNewsEntity;
import com.kavindu.repository.BadmintonNewsRepository;
import com.kavindu.service.BadmintonNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadmintonNewsServiceImpl implements BadmintonNewsService {
    @Autowired
    private BadmintonNewsRepository badmintonRepository;

    @Override
    public ResponseDto allData() {
        ResponseDto responseDto=new ResponseDto();
        List<BadmintonNewsEntity> all= badmintonRepository.findAll();
        responseDto.setCode(200);
        responseDto.setMsg("all data");
        responseDto.setData(all);
        return responseDto;
    }

    @Override
    public ResponseDto insertData(BadmintonNewsDto badmintonNewsDto) {
        ResponseDto responseDto =new ResponseDto();
        BadmintonNewsEntity badmintonNewsEntity= new BadmintonNewsEntity();
        badmintonNewsEntity.setContent(badmintonNewsDto.getContent());
        badmintonNewsEntity.setTitle(badmintonNewsDto.getTitle());
        badmintonNewsEntity.setImg(badmintonNewsDto.getImg());
        badmintonRepository.save(badmintonNewsEntity);
        responseDto.setCode(200);
        responseDto.setMsg("Insert data");
        return responseDto;
    }

    @Override
    public ResponseDto updateData(BadmintonNewsDto badmintonNewsDto) {
        ResponseDto responseDto =new ResponseDto();
        try{
            Optional<BadmintonNewsEntity> optionalBadmintonNewsEntity=badmintonRepository.findById(badmintonNewsDto.getId());
            if(optionalBadmintonNewsEntity.isPresent()){
                BadmintonNewsEntity badmintonNewsEntity=optionalBadmintonNewsEntity.get();
                badmintonNewsEntity.setImg(badmintonNewsDto.getImg());
                badmintonNewsEntity.setContent(badmintonNewsDto.getContent());
                badmintonNewsEntity.setTitle(badmintonNewsDto.getTitle());
                badmintonRepository.save(badmintonNewsEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Updated data ");
                return  responseDto;
            }else{
                responseDto.setCode(404);
                responseDto.setMsg("Data not inserted");
                return  responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return  responseDto;

        }
    }

    @Override
    public ResponseDto deleteData(int id) {
        ResponseDto responseDto =new ResponseDto();
        try {
            badmintonRepository.deleteById(id);
            responseDto.setCode(200);
            responseDto.setMsg("Deleted data successfully");
            return responseDto;
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return  responseDto;
        }
    }

}
