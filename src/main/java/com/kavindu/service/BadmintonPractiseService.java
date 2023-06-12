package com.kavindu.service;

import com.kavindu.dto.BadmintonPractiseDto;
import com.kavindu.dto.ResponseDto;

public interface BadmintonPractiseService {
    ResponseDto allData();
    ResponseDto  updateData(BadmintonPractiseDto badmintonPractiseDto);
    ResponseDto  insertData(BadmintonPractiseDto badmintonPractiseDto);
    ResponseDto  deleteData(int id);
}
