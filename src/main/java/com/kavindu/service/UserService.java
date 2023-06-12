package com.kavindu.service;

import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.UserDTO;



public interface UserService {
    ResponseDto allUsers();
    ResponseDto saveUser(UserDTO userDTO);
    ResponseDto deleteUser(int id);
    ResponseDto countUsers();

    ResponseDto sortedUsers(String field);
    ResponseDto pagination(int pageSize, int offSet,String field);
    ResponseDto findAll();
    ResponseDto searchEmail(String email);
    ResponseDto login(UserDTO userDTO);

}
