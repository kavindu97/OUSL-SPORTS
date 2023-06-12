package com.kavindu.service.impl;

import com.kavindu.dto.CricketNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.CricketNewsEntity;
import com.kavindu.repository.CricketRepository;
import com.kavindu.service.CricketNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class CricketNewsServiceImpl implements CricketNewsService {
    @Autowired
    private CricketRepository cricketRepository;

    @Override
    public ResponseDto saveData(CricketNewsDto cricketDto) {
        CricketNewsEntity cricketEntity = new CricketNewsEntity();
        ResponseDto responseDto = new ResponseDto();
        try {
            cricketEntity.setTitle(cricketDto.getTitle());
            cricketEntity.setContent(cricketDto.getContent());
            cricketEntity.setImg(cricketDto.getImg());
            cricketRepository.save(cricketEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Data inserted");
            return responseDto;
        } catch (Exception e) {
            responseDto.setCode(404);
            responseDto.setMsg("Data not inserted");
            return responseDto;
        }

    }

    @Override
    public ResponseDto updateData(CricketNewsDto cricketDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            Optional<CricketNewsEntity> optionalCricketEntity = cricketRepository.findById(cricketDto.getId());
            if (optionalCricketEntity.isPresent()) {
                CricketNewsEntity cricketEntity = optionalCricketEntity.get();
                cricketEntity.setImg(cricketDto.getImg());
                cricketEntity.setTitle(cricketDto.getTitle());
                cricketEntity.setContent(cricketDto.getContent());
                cricketRepository.save(cricketEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Data updated!");
                return responseDto;
            } else {
                responseDto.setCode(404);
                responseDto.setMsg("Data not updated!");
                return responseDto;
            }
        } catch (Exception e) {
            responseDto.setCode(500);
            responseDto.setMsg("Internal Server Error!");
            return responseDto;
        }
    }
@Override
    public ResponseDto all() throws ParseException {
        ResponseDto responseDto = new ResponseDto();
        List<CricketNewsEntity> all = cricketRepository.findAll();
        responseDto.setCode(200);
        responseDto.setData(all);
        return responseDto;
    }

    @Override
    public ResponseDto delete(int id) throws ParseException {
        ResponseDto responseDto =new ResponseDto();
        cricketRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Delete data");
        return  responseDto;
    }
}
