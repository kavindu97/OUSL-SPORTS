package com.kavindu.service.impl;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.RugbyNewsDto;
import com.kavindu.dto.RugbyPractisesDto;
import com.kavindu.model.RugbyNewsEntity;
import com.kavindu.model.RugbyPractisesEntity;
import com.kavindu.repository.RugbyNewsRepository;
import com.kavindu.service.RugbyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RugbyNewsServiceImpl implements RugbyNewsService {
    @Autowired
private RugbyNewsRepository rugbyNewsRepository;

    @Override
    public ResponseDto allData() {
        ResponseDto responseDto=new ResponseDto();
        List<RugbyNewsEntity> rugbyNewsEntities=rugbyNewsRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        responseDto.setCode(200);
        responseDto.setData(rugbyNewsEntities);
        return responseDto;
    }

    @Override
    public ResponseDto insertData(RugbyNewsDto rugbyNewsDto) {
       ResponseDto responseDto=new ResponseDto();
        RugbyNewsEntity rugbyNewsEntity=new RugbyNewsEntity();
       try{
           rugbyNewsEntity.setContent(rugbyNewsDto.getContent());
           rugbyNewsEntity.setImg(rugbyNewsDto.getImg());
           rugbyNewsEntity.setTitle(rugbyNewsDto.getTitle());
           rugbyNewsRepository.save(rugbyNewsEntity);
        responseDto.setCode(200);
        responseDto.setMsg("Data inserted ");
        return  responseDto;
       }catch(Exception e){
        responseDto.setCode(500);
        responseDto.setMsg("Internal server error");
        return responseDto;
       }
    }

    @Override
    public ResponseDto updateData(RugbyNewsDto rugbyNewsDto) {
        ResponseDto responseDto=new ResponseDto();
        try {
            Optional<RugbyNewsEntity> optionalRugbyNewsEntity=rugbyNewsRepository.findById(rugbyNewsDto.getId());
            if(optionalRugbyNewsEntity.isPresent()){
              RugbyNewsEntity rugbyNewsEntity =optionalRugbyNewsEntity.get();
              rugbyNewsEntity.setTitle(rugbyNewsDto.getTitle());
              rugbyNewsEntity.setContent(rugbyNewsDto.getContent());
              rugbyNewsEntity.setImg(rugbyNewsDto.getImg());
              rugbyNewsRepository.save(rugbyNewsEntity);
              responseDto.setCode(200);
              responseDto.setMsg("updated data");
              return  responseDto;

            }else{
                responseDto.setCode(404);
                responseDto.setMsg("Not updated data");
                return  responseDto;
            }}catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal Server Error");
            return  responseDto;
        }
    }

    @Override
    public ResponseDto deleteData(int id) {
        ResponseDto responseDto =new ResponseDto();
        rugbyNewsRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Deleted data!");
        return  responseDto;
    }
}
