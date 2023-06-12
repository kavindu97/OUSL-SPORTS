package com.kavindu.service;

import com.kavindu.dto.BoxingNewsDto;
import com.kavindu.dto.ResponseDto;

import java.text.ParseException;

public interface BoxingNewsService {
    ResponseDto saveData (BoxingNewsDto boxingNewsDto) throws ParseException ;
    ResponseDto updateData(BoxingNewsDto boxingNewsDto) throws ParseException;
    ResponseDto allData() throws ParseException;
    ResponseDto deleteData(int id) throws  ParseException;

}
