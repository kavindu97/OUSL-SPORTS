package com.kavindu.controller;

import com.kavindu.dto.AccountDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public ResponseDto saveAccount(@RequestBody AccountDto accountDto) {
        return accountService.saveAccount(accountDto);
    }

    @PutMapping("/update")
    public ResponseDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountService.updateAccount(accountDto);
    }

    @GetMapping("/all")
    public ResponseDto getAll() {
        return accountService.allInfo();
    }

}
