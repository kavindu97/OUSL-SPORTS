package com.kavindu.service.impl;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.UserDTO;
import com.kavindu.model.UserEntity;
import com.kavindu.repository.UserRepository;
import com.kavindu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseDto allUsers() {
        ResponseDto responseDto = new ResponseDto();
        try {
         List<Map<String,Object>> myneededcolums = userRepository.neededcolumns();
            responseDto.setCode(200);
            responseDto.setMsg("Sucessfully retrived data");
            responseDto.setData(myneededcolums);
            return responseDto;
        } catch (Exception e) {
            responseDto.setCode(404);
            responseDto.setMsg("not found list");
            return responseDto;
        }


    }

    @Override
    public ResponseDto saveUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        ResponseDto responseDto=new ResponseDto();
try {
    userEntity.setEmail(userDTO.getEmail());
    userEntity.setAge(userDTO.getAge());
    userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
    userEntity.setPhone(userDTO.getPhone());
    userRepository.save(userEntity);
    responseDto.setCode(200);
    responseDto.setMsg("Successfully inserted");
    return responseDto;

}catch (Exception e){
    responseDto.setCode(404);
    responseDto.setMsg("User already regisetered");
    return responseDto;
}

    }

    @Override
    public ResponseDto deleteUser(int id) {
        ResponseDto responseDto=new ResponseDto();
        try{
            userRepository.deleteById(id);
            responseDto.setCode(200);
            responseDto.setMsg("Successfully deleted");
            return responseDto;
        }catch(Exception e){
            responseDto.setCode(404);
            responseDto.setMsg("Not found user");
            return responseDto;
        }


    }

    @Override
    public ResponseDto countUsers() {
        ResponseDto responseDto =new ResponseDto();
        long countusers=userRepository.count();
        responseDto.setData(countusers);
        responseDto.setCode(200);
        return responseDto;
    }

    @Override
    public ResponseDto sortedUsers(String field) {
        ResponseDto responseDto=new ResponseDto();
        List<UserEntity> users=userRepository.findAll(Sort.by(Sort.Direction.DESC,field));
        responseDto.setCode(200);
        responseDto.setData(users);
        return  responseDto;
    }

    @Override
    public ResponseDto pagination(int offSet,int pageSize, String field) {
        ResponseDto responseDto =new ResponseDto();
        Page <UserEntity> userEntities=userRepository.findAll(PageRequest.of(offSet,pageSize).withSort(Sort.by(field)));
        responseDto.setCode(200);
        responseDto.setData(userEntities);
        return  responseDto;
    }

    @Override
    public ResponseDto findAll() {
        ResponseDto responseDto =new ResponseDto();
        List<UserEntity> all=userRepository.findAll();
        responseDto.setCode(200);
        responseDto.setData(all);
        return responseDto;
    }

    @Override
    public ResponseDto searchEmail(String email) {
        ResponseDto responseDto=new ResponseDto();
        List<Object> find=userRepository.findByEmailContainingIgnoreCase(email);
        responseDto.setCode(200);
        responseDto.setData(find);
        return  responseDto;
    }

    @Override
    public ResponseDto login(UserDTO userDTO) {
        ResponseDto responseDto =new ResponseDto();
        UserEntity userRegisterEntity=userRepository.findByEmail(userDTO.getEmail());
        if(userRegisterEntity !=null){
            String password=userDTO.getPassword();
            String encodedPassword=userRegisterEntity.getPassword();
            boolean isPwdRight=bCryptPasswordEncoder.matches(password,encodedPassword);
            if(isPwdRight){
                Optional<UserEntity> optionalUserRegisterEntity=userRepository.findOneByEmailAndPassword(userDTO.getEmail(),encodedPassword);
                if(optionalUserRegisterEntity.isPresent()){
                    responseDto.setCode(200);
                    responseDto.setMsg("Login Success");
                    return responseDto;
                }else {
                    responseDto.setCode(404);
                    responseDto.setMsg("Login Failed");
                    return responseDto;
                }
            }else {
                responseDto.setCode(300);
                responseDto.setMsg("Error password doesn't match");
                return responseDto;
            }
        }else {
            responseDto.setCode(404);
            responseDto.setMsg("Email not exists");
            return responseDto;
        }

    }
}
