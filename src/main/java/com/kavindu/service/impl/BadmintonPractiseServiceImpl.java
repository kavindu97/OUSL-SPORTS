package com.kavindu.service.impl;

import com.kavindu.dto.BadmintonPractiseDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.BadmintonPractiseEntity;
import com.kavindu.repository.BadmintonPractiseRepository;
import com.kavindu.service.BadmintonPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadmintonPractiseServiceImpl  implements BadmintonPractiseService {
    @Autowired
    private BadmintonPractiseRepository badmintonPractiseRepository;

    @Override
    public ResponseDto allData() {
        ResponseDto responseDto=new ResponseDto();
        List<BadmintonPractiseEntity> dataAll=badmintonPractiseRepository.findAll();
        responseDto.setCode(200);
        responseDto.setData(dataAll);
        return responseDto;
    }

    @Override
    public ResponseDto updateData(BadmintonPractiseDto badmintonPractiseDto) {
        ResponseDto responseDto =new ResponseDto();
        Optional<BadmintonPractiseEntity> optionalBadmintonPractiseEntity=badmintonPractiseRepository.findById(badmintonPractiseDto.getId());
        try{
            if(optionalBadmintonPractiseEntity.isPresent()){
                BadmintonPractiseEntity badmintonPractiseEntity=optionalBadmintonPractiseEntity.get();
                badmintonPractiseEntity.setCenter(badmintonPractiseDto.getCenter());
                badmintonPractiseEntity.setDate(badmintonPractiseDto.getDate());
                badmintonPractiseEntity.setTime(badmintonPractiseDto.getTime());
                badmintonPractiseRepository.save(badmintonPractiseEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Updated data");
                return  responseDto;

            }else {
                responseDto.setCode(404);
                responseDto.setMsg("Error in updating data");
                return  responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("internal error");
            return responseDto;
        }

    }

    @Override
    public ResponseDto insertData(BadmintonPractiseDto badmintonPractiseDto) {
       BadmintonPractiseEntity badmintonPractiseEntity=new BadmintonPractiseEntity();
       ResponseDto responseDto =new ResponseDto();
       try {
           badmintonPractiseEntity.setTime(badmintonPractiseDto.getTime());
           badmintonPractiseEntity.setDate(badmintonPractiseDto.getDate());
           badmintonPractiseEntity.setCenter(badmintonPractiseDto.getCenter());
           badmintonPractiseRepository.save(badmintonPractiseEntity);
           responseDto.setCode(200);
           responseDto.setMsg("Insert Data");
           return responseDto;
       }catch (Exception e){
           responseDto.setCode(500);
           responseDto.setMsg("Internal server error");
           return   responseDto;
       }
    }

    @Override
    public ResponseDto deleteData(int id) {
        ResponseDto responseDto =new ResponseDto();
        try{
            badmintonPractiseRepository.deleteById(id);
            responseDto.setCode(200);
            responseDto.setMsg("Deleted data");
            return responseDto;
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return  responseDto;
        }

    }
}
