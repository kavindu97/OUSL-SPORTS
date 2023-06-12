package com.kavindu.service;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.TableTennisNewsDto;

public interface TableTennisNewsService {
    ResponseDto insert(TableTennisNewsDto tableTennisDto);
    ResponseDto show();

    ResponseDto update(TableTennisNewsDto tableTennisDto);

    ResponseDto delete(int id);
}
