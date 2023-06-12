package com.kavindu.controller;


import com.kavindu.dto.ResponseDto;
import com.kavindu.dto.UserDTO;
import com.kavindu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseDto getAll() {

        return userService.allUsers();
    }

    @PostMapping("/save")
    public ResponseDto insert(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);

    }

    @DeleteMapping("/delete/{id}")
    public String deleted(@PathVariable int id) {
        userService.deleteUser(id);
        return "deleted";
    }

    @GetMapping("/show/{field}")
    public ResponseDto getSortedUsers(@PathVariable String field) {
        return userService.sortedUsers(field);
    }

    @GetMapping("/pagination/{offSet}/{pageSize}/{field}")
    public ResponseDto pagination(@PathVariable int offSet, @PathVariable int pageSize, @PathVariable String field) {
        return userService.pagination(offSet, pageSize, field);
    }

    @GetMapping("/all")
    public ResponseDto all() {
        return userService.findAll();
    }

    @GetMapping("/search/{email}")
    public ResponseDto getSearched(@PathVariable String email) {
        return userService.searchEmail(email);
    }

    //     @GetMapping("/count")
//     public ResponseDto getCount(){
//         return userService.countUsers();
//     }
    @PostMapping("/login")
    public ResponseDto login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);

    }

}
