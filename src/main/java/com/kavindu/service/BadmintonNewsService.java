package com.kavindu.service;


import com.kavindu.dto.BadmintonNewsDto;
import com.kavindu.dto.ResponseDto;

public interface BadmintonNewsService {
    ResponseDto allData();
    ResponseDto insertData(BadmintonNewsDto badmintonNewsDto);
    ResponseDto updateData(BadmintonNewsDto badmintonNewsDto);
    ResponseDto deleteData(int id);

}
