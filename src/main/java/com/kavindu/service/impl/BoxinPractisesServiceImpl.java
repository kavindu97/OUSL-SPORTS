package com.kavindu.service.impl;

import com.kavindu.dto.BoxingNewsDto;
import com.kavindu.dto.BoxingPractisesDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.BoxingPractisesEntity;
import com.kavindu.repository.BoxingPractisesRepository;
import com.kavindu.service.BoxingPractisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxinPractisesServiceImpl implements BoxingPractisesService {
    @Autowired
    private BoxingPractisesRepository boxingPractisesRepository;
    public ResponseDto insertData(BoxingPractisesDto boxingPractisesDto){
     ResponseDto responseDto=new ResponseDto();
        try{
            BoxingPractisesEntity boxingPractisesEntity=new BoxingPractisesEntity();
            boxingPractisesEntity.setCenter(boxingPractisesDto.getCenter());
            boxingPractisesEntity.setDate(boxingPractisesDto.getDate());
            boxingPractisesEntity.setTime(boxingPractisesDto.getTime());
            boxingPractisesRepository.save(boxingPractisesEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Insert Data");
            return  responseDto;
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Data not inserted ");
            return  responseDto;
        }
    }

    @Override
    public ResponseDto updateData(BoxingPractisesDto boxingPractisesDto) {
        ResponseDto responseDto =new ResponseDto();
        try{
            Optional<BoxingPractisesEntity> optionalBoxingPractisesEntity=boxingPractisesRepository.findById(boxingPractisesDto.getId());
            if(optionalBoxingPractisesEntity.isPresent()){
                BoxingPractisesEntity boxingPractisesEntity=optionalBoxingPractisesEntity.get();
                boxingPractisesEntity.setTime(boxingPractisesDto.getTime());
                boxingPractisesEntity.setDate(boxingPractisesDto.getDate());
                boxingPractisesEntity.setCenter(boxingPractisesDto.getCenter());
                boxingPractisesRepository.save(boxingPractisesEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Successfully updated data!");
                return  responseDto;
            }else{
                responseDto.setCode(404);
                responseDto.setMsg("Not updated data");
                return  responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return responseDto;
        }
    }

    @Override
    public ResponseDto deleteData(int id) {
        ResponseDto responseDto=new ResponseDto();
        boxingPractisesRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Successfully deleted data");
        return responseDto;
    }

    @Override
    public ResponseDto allData() {
        ResponseDto responseDto = new ResponseDto();
       List<BoxingPractisesEntity> boxingPractisesEntities= boxingPractisesRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        responseDto.setCode(200);
        responseDto.setData(boxingPractisesEntities);
        return responseDto;
    }
}
