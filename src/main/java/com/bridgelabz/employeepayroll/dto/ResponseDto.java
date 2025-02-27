package com.bridgelabz.employeepayroll.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ResponseDto {
    private String message;
    private String detail;
    private LocalDateTime timeStamp;


    public ResponseDto(String message, String detail) {
        this.message = message;
        this.detail = detail;
        this.timeStamp = LocalDateTime.now();
    }



}
