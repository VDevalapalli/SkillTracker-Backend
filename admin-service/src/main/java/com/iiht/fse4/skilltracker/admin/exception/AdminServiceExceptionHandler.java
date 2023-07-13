package com.iiht.fse4.skilltracker.admin.exception;

import com.iiht.fse4.skilltracker.admin.util.Constants;
import com.iiht.fse4.skilltracker.common.exception.SkillTrackerExceptionHandler;
import com.iiht.fse4.skilltracker.common.model.Error;
import com.iiht.fse4.skilltracker.common.model.ErrorResponse;
import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice(value = "com.iiht.fse4.skilltracker.admin.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AdminServiceExceptionHandler extends SkillTrackerExceptionHandler {

    @ExceptionHandler(AdminServiceException.class)
    public ResponseEntity<ErrorResponse> handleAdminServiceException(AdminServiceException ex, WebRequest request) {
        log.info(CommonConstants.METHOD_START, Constants.HANDLE_ADMIN_SERVICE_EXCEPTION);
        String correlationId = MDC.get(CommonConstants.CI);
        HttpStatus httpStatus = ex.getHttpStatus();
        String message = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(correlationId, new Error(Constants.ADMIN_SERVICE_EXP, Constants.ADMIN_SERVICE_CODE, message));
        log.info(CommonConstants.METHOD_END, Constants.HANDLE_ADMIN_SERVICE_EXCEPTION);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
