package com.kavindu.service.impl;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.TableTennisNewsDto;
import com.kavindu.model.TableTennisNewsEntity;
import com.kavindu.repository.TableTennisRepository;
import com.kavindu.service.TableTennisNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableTennisNewsServiceImpl implements TableTennisNewsService {
    @Autowired
    private TableTennisRepository tableTennisRepository;

    @Override
    public ResponseDto insert(TableTennisNewsDto tableTennisDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            TableTennisNewsEntity tableTennisEntity = new TableTennisNewsEntity();
            tableTennisEntity.setTitle(tableTennisDto.getTitle());
            tableTennisEntity.setContent(tableTennisDto.getContent());
            tableTennisEntity.setImg(tableTennisDto.getImg());
            tableTennisRepository.save(tableTennisEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Successfully inserted data");
            return responseDto;
        } catch (Exception e) {
            responseDto.setCode(500);
            responseDto.setMsg("internal server error");
            return responseDto;
        }
    }

    @Override
    public ResponseDto show() {
        ResponseDto responseDto =new ResponseDto();
        List<TableTennisNewsEntity> all=tableTennisRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        responseDto.setCode(200);
        responseDto.setData(all);
        return responseDto;

    }

    @Override
    public ResponseDto update(TableTennisNewsDto tableTennisDto) {
        ResponseDto responseDto=new ResponseDto();
        Optional<TableTennisNewsEntity> optionalTableTennisEntity=tableTennisRepository.findById(tableTennisDto.getId());
        if(optionalTableTennisEntity.isPresent()){
            TableTennisNewsEntity tableTennisEntity=optionalTableTennisEntity.get();
            if(tableTennisDto.getTitle()!=null) {
                tableTennisEntity.setTitle(tableTennisDto.getTitle());
            }
            if(tableTennisDto.getContent()!=null) {
                tableTennisEntity.setContent(tableTennisDto.getContent());
            }
            if(tableTennisDto.getImg()!=null) {
                tableTennisEntity.setImg(tableTennisDto.getImg());
            }
            tableTennisRepository.save(tableTennisEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Successfully Updated!!");
            return  responseDto;

        }else {
            responseDto.setCode(404);
            responseDto.setMsg("News Not Found!!");
            return  responseDto;
        }
    }

    @Override
    public ResponseDto delete(int id) {
        ResponseDto responseDto =new ResponseDto();
        tableTennisRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Successfully deleted ");
        return  responseDto;
    }
}
