package com.iiht.fse4.skilltracker.engineer.exception;

import com.iiht.fse4.skilltracker.common.exception.SkillTrackerExceptionHandler;
import com.iiht.fse4.skilltracker.common.model.EngineerErrorResponse;
import com.iiht.fse4.skilltracker.common.model.Error;
import com.iiht.fse4.skilltracker.common.model.ErrorResponse;
import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import com.iiht.fse4.skilltracker.engineer.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice(value = "com.iiht.fse4.skilltracker.engineer.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EngineerServiceExceptionHandler extends SkillTrackerExceptionHandler {

    @ExceptionHandler(EngineerServiceException.class)
    public ResponseEntity<ErrorResponse> handleEngineerServiceException(EngineerServiceException ex, WebRequest request) {
        log.info(CommonConstants.METHOD_START, Constants.HANDLE_ENGINEER_SERVICE_EXCEPTION);
        String correlationId = MDC.get(CommonConstants.CI);
        HttpStatus httpStatus = ex.getHttpStatus();
        String message = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(correlationId, new Error(Constants.ENGINEER_SERVICE_EXP, Constants.ENGINEER_SERVICE_CODE, message));
        log.info(CommonConstants.METHOD_END, Constants.HANDLE_ENGINEER_SERVICE_EXCEPTION);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

//    @ExceptionHandler(EngineerServiceException.class)
//    public ResponseEntity<Object> handleAllOtherErrors(EngineerServiceException ex, WebRequest request) {
//        HttpStatus httpStatus = ex.getHttpStatus();
//        String message = ex.getMessage();
//        return ResponseEntity.status(httpStatus)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(new EngineerErrorResponse(message));
//    }
}
