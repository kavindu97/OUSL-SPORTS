package com.kavindu.service;

import com.kavindu.dto.CricketPractiseDto;
import com.kavindu.dto.ResponseDto;

public interface CricketPractisesService {

    ResponseDto insert(CricketPractiseDto cricketPractiseDto);
    ResponseDto all();
    ResponseDto delete(int id);
    ResponseDto update(CricketPractiseDto cricketPractiseDto);
}
