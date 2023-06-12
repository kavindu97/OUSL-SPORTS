package com.kavindu.service;

import com.kavindu.dto.ChessNewsDto;
import com.kavindu.dto.ResponseDto;

public interface ChessNewsService {
    ResponseDto all();
    ResponseDto insert(ChessNewsDto chessNewsDto);
    ResponseDto update(ChessNewsDto chessNewsDto);
    ResponseDto delete(int id);

}
