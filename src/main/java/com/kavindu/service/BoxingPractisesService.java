package com.kavindu.service;

import com.kavindu.dto.BoxingPractisesDto;
import com.kavindu.dto.ResponseDto;

public interface BoxingPractisesService {
    ResponseDto insertData(BoxingPractisesDto boxingPractisesDto);
    ResponseDto updateData(BoxingPractisesDto boxingPractisesDto);
    ResponseDto deleteData(int id);
    ResponseDto allData();
}
