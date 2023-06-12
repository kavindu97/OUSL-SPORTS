package com.kavindu.service.impl;

import com.kavindu.dto.AccountDto;
import com.kavindu.dto.ResponseDto;
import com.kavindu.model.AccountEntity;
import com.kavindu.repository.AccountRepository;
import com.kavindu.service.AccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDto saveAccount(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        ResponseDto responseDto = new ResponseDto();

        try {
            accountEntity.setDescription(accountDto.getDescription());
            accountEntity.setDebit(accountDto.getDebit());
            accountEntity.setCredit(accountDto.getCredit());
            accountRepository.save(accountEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Successfully Inserted data");
            return responseDto;
        } catch (Exception e) {
            responseDto.setCode(404);
            responseDto.setMsg("Didn't insert data");
            return responseDto;
        }

    }

    @Override
    public ResponseDto updateAccount(AccountDto accountDto) {
        ResponseDto responseDto = new ResponseDto();
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(accountDto.getId());
        if (optionalAccountEntity.isPresent()) {
            AccountEntity accountEntity = optionalAccountEntity.get();
            accountEntity.setCredit(accountDto.getCredit());
            accountEntity.setDebit(accountDto.getDebit());
            accountEntity.setDescription(accountDto.getDescription());
            accountRepository.save(accountEntity);
            responseDto.setCode(200);
            responseDto.setMsg("Updated Successfully");
            return responseDto;
        } else {
            responseDto.setCode(404);
            responseDto.setMsg("Transaction not found");
            return responseDto;
        }
    }

    @Override
    public ResponseDto allInfo() {
        ResponseDto responseDto = new ResponseDto();
        try {
            PropertyMap<AccountEntity, AccountDto> propertyMap = new PropertyMap<AccountEntity, AccountDto>() {
                @Override
                protected void configure() {

                }
            };
            if (modelMapper.getTypeMap(AccountEntity.class, AccountDto.class) == null) {
                modelMapper.addMappings(propertyMap);
            }
            List<AccountEntity> accountEntities = accountRepository.findAll();
            responseDto.setCode(200);
            responseDto.setData(modelMapper.map(accountEntities, new TypeToken<List<AccountDto>>() {
            }.getType()));
            return responseDto;
        } catch (Exception e) {
            responseDto.setCode(500);
            responseDto.setMsg("Error in showing data");
            return responseDto;
        }
    }
}
