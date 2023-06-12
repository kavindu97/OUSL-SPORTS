package com.kavindu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@JsonInclude
public class UserDTO {
    private int id;
    private String email;
    private String phone;
    private Date age;
    private String password;

}
