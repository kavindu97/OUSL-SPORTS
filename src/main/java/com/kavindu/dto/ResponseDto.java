package com.kavindu.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ResponseDto {
    private Integer code;
    private String msg;
    private Object data;
}
