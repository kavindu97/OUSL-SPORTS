package com.kavindu.service.impl;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.SwimmingNewsDto;
import com.kavindu.model.SwimmingNewsEntity;
import com.kavindu.repository.SwimmingNewsRepository;
import com.kavindu.service.SwimmingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwimmingNewsServiceImpl implements SwimmingNewsService {
    @Autowired
    private SwimmingNewsRepository swimmingNewsRepository;
    @Override
    public ResponseDto allData() {
        ResponseDto responseDto=new ResponseDto();
        List<SwimmingNewsEntity> allnews=swimmingNewsRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        responseDto.setCode(200);
        responseDto.setMsg("Data retrived");
        responseDto.setData(allnews);
        return responseDto;
    }

    @Override
    public ResponseDto updateData(SwimmingNewsDto swimmingNewsDto) {
        ResponseDto responseDto =new ResponseDto();
        try {
            Optional<SwimmingNewsEntity> optionalSwimmingNewsEntity=swimmingNewsRepository.findById(swimmingNewsDto.getId());
            if(optionalSwimmingNewsEntity.isPresent()){
                SwimmingNewsEntity swimmingNewsEntity=optionalSwimmingNewsEntity.get();
                swimmingNewsEntity.setContent(swimmingNewsDto.getContent());
                swimmingNewsEntity.setImg(swimmingNewsDto.getImg());
                swimmingNewsEntity.setTitle(swimmingNewsDto.getTitle());
                swimmingNewsRepository.save(swimmingNewsEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Successfully updated data");
                return responseDto;
            }else {
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
    public ResponseDto insertData(SwimmingNewsDto swimmingNewsDto) {
        ResponseDto responseDto=new ResponseDto();
        SwimmingNewsEntity swimmingNewsEntity=new SwimmingNewsEntity();
        swimmingNewsEntity.setTitle(swimmingNewsDto.getTitle());
        swimmingNewsEntity.setImg(swimmingNewsDto.getImg());
        swimmingNewsEntity.setContent(swimmingNewsDto.getContent());
        swimmingNewsRepository.save(swimmingNewsEntity);
        responseDto.setCode(200);
        responseDto.setMsg("Inserted data");
        return responseDto;
    }

    @Override
    public ResponseDto deleteData(int id) {
        ResponseDto responseDto= new ResponseDto();
        swimmingNewsRepository.deleteById(id);
         responseDto.setCode(200);
         responseDto.setMsg("daleted data");
         return responseDto;
    }
}
