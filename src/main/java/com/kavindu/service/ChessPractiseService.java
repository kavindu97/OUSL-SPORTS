package com.kavindu.service;

import com.kavindu.dto.ChessPractiseDto;
import com.kavindu.dto.ResponseDto;

public interface ChessPractiseService {
     ResponseDto all();
     ResponseDto insert(ChessPractiseDto chessPractiseDto);
    ResponseDto update(ChessPractiseDto chessPractiseDto);
    ResponseDto delete(int id);
}
