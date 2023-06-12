package com.kavindu.service;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.SwimmingPractiseDto;

public interface SwimmingPractiseService {
    ResponseDto allData();
    ResponseDto updateData(SwimmingPractiseDto swimmingPractiseDto);
    ResponseDto insertData(SwimmingPractiseDto swimmingPractiseDto);
    ResponseDto deleteData(int id);
}
