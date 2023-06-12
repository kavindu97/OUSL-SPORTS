package com.kavindu.service.impl;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.TableTennisPractiseDto;
import com.kavindu.model.TableTennisPractiseEntity;
import com.kavindu.repository.TableTennisPractiseRepository;

import com.kavindu.service.TableTennisPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableTennisPractiseServiceImpl implements TableTennisPractiseService {
    @Autowired
    private TableTennisPractiseRepository tableTennisPractiseRepository;
    public ResponseDto insert(TableTennisPractiseDto tableTennisPractiseDto){
        ResponseDto responseDto =new ResponseDto();
        try {
            TableTennisPractiseEntity tableTennisPractiseEntity = new TableTennisPractiseEntity();
            tableTennisPractiseEntity.setCenter(tableTennisPractiseDto.getCenter());
            tableTennisPractiseEntity.setDate(tableTennisPractiseDto.getDate());
            tableTennisPractiseEntity.setTime(tableTennisPractiseDto.getTime());
            tableTennisPractiseRepository.save(tableTennisPractiseEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Successfully inserted data");
            return responseDto;
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Data not inserted");
            return responseDto;
        }
    }

    @Override
    public ResponseDto getting() {
       ResponseDto responseDto=new ResponseDto();
        List<TableTennisPractiseEntity> tableTennisPractiseEntityList=tableTennisPractiseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        responseDto.setCode(200);
        responseDto.setData(tableTennisPractiseEntityList);
        return  responseDto;

    }
    @Override
    public ResponseDto update(TableTennisPractiseDto tableTennisPractiseDto) {
        ResponseDto responseDto = new ResponseDto();
        Optional<TableTennisPractiseEntity> optionalTableTennisPractiseEntity = tableTennisPractiseRepository.findById(tableTennisPractiseDto.getId());
        if (optionalTableTennisPractiseEntity.isPresent()) {
            TableTennisPractiseEntity tableTennisPractiseEntity = optionalTableTennisPractiseEntity.get();
            if(tableTennisPractiseDto.getCenter()!=null) {
                tableTennisPractiseEntity.setCenter(tableTennisPractiseDto.getCenter());
            }
            if(tableTennisPractiseDto.getDate()!=null) {
                tableTennisPractiseEntity.setDate(tableTennisPractiseDto.getDate());
            }
            if(tableTennisPractiseDto.getTime()!=null) {
                tableTennisPractiseEntity.setTime(tableTennisPractiseDto.getTime());
            }
            tableTennisPractiseRepository.save(tableTennisPractiseEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Updated data successfully!");
            return responseDto;
        }else {
            responseDto.setCode(404);
            responseDto.setMsg("Id not found!");
            return responseDto;
    }
    }

    @Override
    public ResponseDto delete(int id) {
        ResponseDto responseDto=new ResponseDto();
        tableTennisPractiseRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Successfully deleted ");
        return  responseDto;
    }
}
