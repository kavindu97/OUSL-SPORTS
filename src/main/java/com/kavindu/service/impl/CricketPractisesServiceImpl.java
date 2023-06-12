package com.kavindu.service.impl;

import com.kavindu.dto.CricketPractiseDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.CricketPractisesEntity;
import com.kavindu.repository.CricketPractisesRepository;
import com.kavindu.service.CricketPractisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CricketPractisesServiceImpl implements CricketPractisesService {
    @Autowired
    private CricketPractisesRepository cricketPractisesRepository;

    @Override
    public ResponseDto insert(CricketPractiseDto cricketPractiseDto) {
ResponseDto responseDto =new ResponseDto();
        try{
            CricketPractisesEntity cricketPractisesEntity=new CricketPractisesEntity();
            cricketPractisesEntity.setCenter(cricketPractiseDto.getCenter());
            cricketPractisesEntity.setDate(cricketPractiseDto.getDate());
            cricketPractisesEntity.setTime(cricketPractiseDto.getTime());
            cricketPractisesRepository.save(cricketPractisesEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Data inserted!");
            return  responseDto;
        }catch(Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error!");
            return  responseDto;
        }
    }

    @Override
    public ResponseDto all() {
        ResponseDto responseDto =new ResponseDto();
        List<CricketPractisesEntity> all=cricketPractisesRepository.findAll();
        responseDto.setCode(200);
        responseDto.setData(all);
        return  responseDto;
    }

    @Override
    public ResponseDto delete(int id) {
      ResponseDto responseDto=new ResponseDto();
        cricketPractisesRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("successfully deleted data");
        return  responseDto;
    }

    @Override
    public ResponseDto update(CricketPractiseDto cricketPractiseDto) {
        ResponseDto responseDto=new ResponseDto();
        try{

            Optional<CricketPractisesEntity> optionalcricketPractisesEntity=cricketPractisesRepository.findById(cricketPractiseDto.getId());
            if(optionalcricketPractisesEntity.isPresent()){
                CricketPractisesEntity cricketPractisesEntity=optionalcricketPractisesEntity.get();
                cricketPractisesEntity.setTime(cricketPractiseDto.getTime());
                cricketPractisesEntity.setDate(cricketPractiseDto.getDate());
                cricketPractisesEntity.setCenter(cricketPractiseDto.getCenter());
                cricketPractisesRepository.save(cricketPractisesEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Successfully updated data");
                return  responseDto;
            }else{
                responseDto.setCode(404);
                responseDto.setMsg("Id not found");
                return  responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return  responseDto;

        }
    }
}
