package com.kavindu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude
public class TableTennisPractiseDto {
    private int id;
    private String center;
    private Date date;
    private String time;
}
