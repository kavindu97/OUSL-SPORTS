package com.kavindu.service.impl;

import com.kavindu.dto.BoxingNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.BoxingNewsEntity;
import com.kavindu.repository.BoxingNewsRepository;
import com.kavindu.service.BoxingNewsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class BoxingNewsServiceImpl implements BoxingNewsService {
    @Autowired
    private BoxingNewsRepository boxingNewsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDto saveData (BoxingNewsDto boxingNewsDto) {
        ResponseDto responseDto=new ResponseDto();
        BoxingNewsEntity boxingNewsEntity=new BoxingNewsEntity();
        try {
            boxingNewsEntity.setId(boxingNewsDto.getId());
            boxingNewsEntity.setImg(boxingNewsDto.getImg());
            boxingNewsEntity.setContent(boxingNewsDto.getContent());
            boxingNewsEntity.setTitle(boxingNewsDto.getTitle());
            boxingNewsRepository.save(boxingNewsEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Insert Data!");
            return  responseDto;
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return  responseDto;
        }
    }

    @Override
    public ResponseDto updateData(BoxingNewsDto boxingNewsDto) {
        ResponseDto responseDto =new ResponseDto();
        try {
            Optional<BoxingNewsEntity> optionalBoxingNewsEntity=boxingNewsRepository.findById(boxingNewsDto.getId());
            if(optionalBoxingNewsEntity.isPresent()){
                BoxingNewsEntity boxingNewsEntity=optionalBoxingNewsEntity.get();
                boxingNewsEntity.setTitle(boxingNewsDto.getTitle());
                boxingNewsEntity.setImg(boxingNewsDto.getImg());
                boxingNewsEntity.setContent(boxingNewsDto.getContent());
                boxingNewsRepository.save(boxingNewsEntity);
                responseDto.setCode(200);
                responseDto.setMsg("Updated data");
                return responseDto;
            }else{
                responseDto.setCode(404);
                responseDto.setMsg("News not found");
                return  responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal Server error");
            return responseDto;
        }

    }


    @Override
    public ResponseDto allData() throws ParseException{
        ResponseDto responseDto = new ResponseDto();
        try {
            PropertyMap<BoxingNewsEntity,BoxingNewsDto>propertyMap=new PropertyMap<BoxingNewsEntity, BoxingNewsDto>() {
                @Override
                protected void configure() {

                }
            };
            if(modelMapper.getTypeMap(BoxingNewsEntity.class,BoxingNewsDto.class)==null){
                modelMapper.addMappings(propertyMap);
            }
            List<BoxingNewsEntity> all=boxingNewsRepository.findAll();
            responseDto.setData(modelMapper.map(all,new TypeToken<List<BoxingNewsDto>>(){}.getType()));
            responseDto.setCode(200);
            responseDto.setMsg("Data successfully retrived");
            return responseDto;

        } catch (Exception e) {
            responseDto.setCode(500);
            responseDto.setMsg("Internal server");
            return responseDto;
        }
    }

    @Override
    public ResponseDto deleteData(int id) throws ParseException {
        ResponseDto responseDto=new ResponseDto();
        try {
        boxingNewsRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Successfully deleted data");
        return responseDto;}
        catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Not deleted");
            return responseDto;
        }
    }
}
