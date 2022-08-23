package com.example.refactorCRUDbp.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CustomError {

    private Date timestamp;
    private String message;
    private int HttpCode;

}
