package com.kavindu.service;

import com.kavindu.dto.AccountDto;
import com.kavindu.dto.ResponseDto;

public interface AccountService {
    ResponseDto saveAccount(AccountDto accountDto);
    ResponseDto updateAccount(AccountDto accountDto);
    ResponseDto allInfo();
}
