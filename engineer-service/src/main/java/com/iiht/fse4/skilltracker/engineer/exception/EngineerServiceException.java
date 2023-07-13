package com.iiht.fse4.skilltracker.engineer.exception;


import lombok.*;
import org.springframework.http.HttpStatus;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EngineerServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String message;
}
