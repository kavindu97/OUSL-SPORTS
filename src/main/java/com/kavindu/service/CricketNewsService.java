package com.kavindu.service;

import com.kavindu.dto.CricketNewsDto;
import com.kavindu.dto.ResponseDto;

import java.text.ParseException;

public interface CricketNewsService {
    ResponseDto saveData(CricketNewsDto cricketDto);
    ResponseDto updateData(CricketNewsDto cricketDto);
    ResponseDto all() throws ParseException;

    ResponseDto delete(int id)throws ParseException;
}
