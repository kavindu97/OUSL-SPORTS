package com.kavindu.service;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.SwimmingNewsDto;

public interface SwimmingNewsService {
    ResponseDto allData();
    ResponseDto updateData(SwimmingNewsDto swimmingNewsDto);
    ResponseDto insertData(SwimmingNewsDto swimmingNewsDto);
    ResponseDto deleteData(int id);
}
