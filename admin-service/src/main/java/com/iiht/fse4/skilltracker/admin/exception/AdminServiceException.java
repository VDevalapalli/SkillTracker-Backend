package com.iiht.fse4.skilltracker.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@ToString
public class AdminServiceException extends RuntimeException {

    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String message;
}
