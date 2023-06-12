package com.kavindu.service.impl;

import com.kavindu.dto.ChessNewsDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.ChessNewsEntity;
import com.kavindu.repository.ChessNewsRepository;
import com.kavindu.service.ChessNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChessNewsServiceImpl implements ChessNewsService {
    @Autowired
    private ChessNewsRepository chessNewsRepository;

    @Override
    public ResponseDto all() {
        ResponseDto responseDto=new ResponseDto();
        List<ChessNewsEntity> all=chessNewsRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        responseDto.setCode(200);
        responseDto.setData(all);
        return responseDto;
    }

    @Override
    public ResponseDto insert(ChessNewsDto chessNewsDto) {
       ResponseDto responseDto=new ResponseDto();
       try {
           ChessNewsEntity chessNewsEntity = new ChessNewsEntity();
           chessNewsEntity.setContent(chessNewsDto.getContent());
           chessNewsEntity.setImg(chessNewsDto.getImg());
           chessNewsEntity.setTitle(chessNewsDto.getTitle());
           chessNewsRepository.save(chessNewsEntity);
           responseDto.setCode(200);
           responseDto.setMsg("Data inserted");
           return responseDto;
       }catch (Exception e){
           responseDto.setCode(500);
           responseDto.setMsg("Internal server error");
           return responseDto;
       }
    }

    @Override
    public ResponseDto update(ChessNewsDto chessNewsDto) {
        ResponseDto responseDto=new ResponseDto();
        try {
            Optional<ChessNewsEntity> optionalChessNewsEntity = chessNewsRepository.findById(chessNewsDto.getId());
            if (optionalChessNewsEntity.isPresent()) {
                ChessNewsEntity chessNewsEntity = optionalChessNewsEntity.get();
                chessNewsEntity.setTitle(chessNewsDto.getTitle());
                chessNewsEntity.setImg(chessNewsDto.getImg());
                chessNewsEntity.setContent(chessNewsDto.getContent());
                chessNewsRepository.save(chessNewsEntity);
                responseDto.setCode(200);
                responseDto.setMsg("updated data");
                return responseDto;
            } else {
                responseDto.setCode(404);
                responseDto.setMsg("Not updated data");
                return responseDto;
            }
        }catch (Exception e){
            responseDto.setCode(500);
            responseDto.setMsg("Internal server error");
            return responseDto;
        }
    }

    @Override
    public ResponseDto delete(int id) {
        ResponseDto responseDto=new ResponseDto();
        chessNewsRepository.deleteById(id);
        responseDto.setCode(200);
        responseDto.setMsg("Deleted");
        return responseDto;
    }
}
