package com.kavindu.service.impl;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.RugbyPractisesDto;
import com.kavindu.model.RugbyPractisesEntity;
import com.kavindu.repository.RugbyPractisesRepository;
import com.kavindu.service.RugbyPractisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RugbyPractisesServiceImpl implements RugbyPractisesService {
    @Autowired
    private RugbyPractisesRepository rugbyPractisesRepository;
    @Override
    public ResponseDto insertData(RugbyPractisesDto rugbyPractisesDto) {
        ResponseDto responseDto=new ResponseDto();
        try{
            RugbyPractisesEntity rugbyPractisesEntity=new RugbyPractisesEntity();
            rugbyPractisesEntity.setCenter(rugbyPractisesDto.getCenter());
            rugbyPractisesEntity.setDate(rugbyPractisesDto.getDate());
            rugbyPractisesEntity.setTime(rugbyPractisesDto.getTime());
            rugbyPractisesRepository.save(rugbyPractisesEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Data inserted successfully!");
            return  responseDto;

        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal Server error!!");
            return  responseDto;
        }
    }

    @Override
    public ResponseDto updateData(RugbyPractisesDto rugbyPractisesDto) {
        ResponseDto responseDto=new ResponseDto();
        try {
            Optional<RugbyPractisesEntity> optionalRugbyPractisesEntity=rugbyPractisesRepository.findById(rugbyPractisesDto.getId());
            if(optionalRugbyPractisesEntity.isPresent()){
                RugbyPractisesEntity rugbyPractisesEntity=optionalRugbyPractisesEntity.get();
                rugbyPractisesEntity.setCenter(rugbyPractisesDto.getCenter());
                rugbyPractisesEntity.setDate(rugbyPractisesDto.getDate());
                rugbyPractisesEntity.setTime(rugbyPractisesDto.getTime());
                rugbyPractisesRepository.save(rugbyPractisesEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Updated Data!!");
                return responseDto;
            }else {
                responseDto.setCode(404);
                responseDto.setMsg("News not found!!");
                return responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal Server!!");
            return responseDto;
        }
    }

    @Override
    public ResponseDto deleteData(int id) {
        ResponseDto responseDto=new ResponseDto();
        rugbyPractisesRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Successfully Deleted");
        return responseDto;
    }

    @Override
    public ResponseDto allData() {
        ResponseDto responseDto =new ResponseDto();
       List<RugbyPractisesEntity> rugbyPractisesEntities= rugbyPractisesRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
       responseDto.setData(rugbyPractisesEntities);
        return  responseDto;
    }
}
