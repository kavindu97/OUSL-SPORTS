package com.kavindu.service;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.RugbyPractisesDto;

public interface RugbyPractisesService {
    ResponseDto insertData(RugbyPractisesDto rugbyPractisesDto);
    ResponseDto updateData(RugbyPractisesDto rugbyPractisesDto);
    ResponseDto deleteData(int id);
    ResponseDto allData();

}
