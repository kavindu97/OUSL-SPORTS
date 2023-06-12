package com.kavindu.service;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.RugbyNewsDto;
import com.kavindu.dto.RugbyPractisesDto;

public interface RugbyNewsService {
    ResponseDto allData();
    ResponseDto insertData(RugbyNewsDto rugbyNewsDto);
    ResponseDto updateData(RugbyNewsDto rugbyNewsDto);
    ResponseDto deleteData(int id);

}
