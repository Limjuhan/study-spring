package com.example.websample.dto;

import com.example.websample.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private ErrorCode errorCode;
    private String message;

}
