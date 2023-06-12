package com.kavindu.service;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.TableTennisPractiseDto;

public interface TableTennisPractiseService {
    ResponseDto insert(TableTennisPractiseDto tableTennisPractiseDto);
    ResponseDto getting();
    ResponseDto update(TableTennisPractiseDto tableTennisPractiseDto);

    ResponseDto delete(int id);
}
