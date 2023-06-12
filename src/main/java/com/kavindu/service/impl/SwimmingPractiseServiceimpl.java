package com.kavindu.service.impl;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.SwimmingPractiseDto;
import com.kavindu.model.SwimmingPractiseEntity;
import com.kavindu.repository.SwimmingPractiseRepository;
import com.kavindu.service.SwimmingPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwimmingPractiseServiceimpl implements SwimmingPractiseService {
    @Autowired
    private SwimmingPractiseRepository swimmingPractiseRepository;
    @Override
    public ResponseDto allData() {
        ResponseDto responseDto=new ResponseDto();
        List<SwimmingPractiseEntity> all=swimmingPractiseRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        responseDto.setCode(200);
        responseDto.setData(all);
        return responseDto;
    }

    @Override
    public ResponseDto updateData(SwimmingPractiseDto swimmingPractiseDto) {
        ResponseDto responseDto =new ResponseDto();
        try {
            Optional<SwimmingPractiseEntity> optionalSwimmingPractiseEntity = swimmingPractiseRepository.findById(swimmingPractiseDto.getId());

            if (optionalSwimmingPractiseEntity.isPresent()) {
                SwimmingPractiseEntity swimmingPractiseEntity=optionalSwimmingPractiseEntity.get();
                swimmingPractiseEntity.setCenter(swimmingPractiseDto.getCenter());
                swimmingPractiseEntity.setDate(swimmingPractiseDto.getDate());
                swimmingPractiseEntity.setTime(swimmingPractiseDto.getTime());
                swimmingPractiseRepository.save(swimmingPractiseEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Updated data");
                return responseDto;

            } else {
                responseDto.setCode(404);
                responseDto.setMsg("Not Updated data");
                return responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return  responseDto;

        }
    }

    @Override
    public ResponseDto insertData(SwimmingPractiseDto swimmingPractiseDto) {
        ResponseDto responseDto=new ResponseDto();
        SwimmingPractiseEntity swimmingPractiseEntity=new SwimmingPractiseEntity();
        swimmingPractiseEntity.setTime(swimmingPractiseDto.getTime());
        swimmingPractiseEntity.setDate(swimmingPractiseDto.getDate());
        swimmingPractiseEntity.setCenter(swimmingPractiseDto.getCenter());
        swimmingPractiseRepository.save(swimmingPractiseEntity);
        responseDto.setCode(200);
        responseDto.setMsg("Inserted data");
        return responseDto;
    }

    @Override
    public ResponseDto deleteData(int id) {
        ResponseDto responseDto =new ResponseDto();
         swimmingPractiseRepository.deleteById(id);
         responseDto.setCode(200);
         responseDto.setMsg("Sucessfully deleted");
         return responseDto;
    }
}
