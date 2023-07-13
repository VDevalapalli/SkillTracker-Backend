package com.iiht.fse4.skilltracker.common.exception;

import com.iiht.fse4.skilltracker.common.model.Error;
import com.iiht.fse4.skilltracker.common.model.ErrorResponse;
import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class SkillTrackerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> gernericException(Exception ex, WebRequest request) {
        log.info(CommonConstants.METHOD_START, CommonConstants.GERNERIC_EXCEPTION);
        String correlationId = MDC.get(CommonConstants.CI);
        String message = ex.getLocalizedMessage();
        ErrorResponse errorResponse = new ErrorResponse(correlationId, new Error(CommonConstants.INVALID_REQUEST_EXP, CommonConstants.INVALID_REQUEST_CODE, message));
        log.info(CommonConstants.METHOD_END, CommonConstants.GERNERIC_EXCEPTION);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.info(CommonConstants.METHOD_START, CommonConstants.HANDLE_EXCEPTION_INTERNAL);
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        String correlationId = MDC.get(CommonConstants.CI);
        ErrorResponse errorResponse = null;
        if (ex instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) ex).getBindingResult();
            List<Error> errors = new ArrayList<>();
            String message = null;
            for(FieldError fe : bindingResult.getFieldErrors()) {
                message = fe.getField() + CommonConstants.STRING_WHITE_SPACE + fe.getDefaultMessage();
                errors.add(new Error(CommonConstants.INVALID_INPUT_EXP, CommonConstants.INVALID_INPUT_CODE, message));
            }
            errorResponse = new ErrorResponse(correlationId, errors);
        } else if (ex instanceof HttpMessageNotReadableException) {
            String message = ex.getLocalizedMessage().split(CommonConstants.REQ_NOT_READABLE_DELIM)[0];
            errorResponse = new ErrorResponse(correlationId, new Error(CommonConstants.INVALID_INPUT_EXP, CommonConstants.INVALID_INPUT_CODE, message));
        } else {
            String message = ex.getLocalizedMessage();
            errorResponse = new ErrorResponse(correlationId, new Error(CommonConstants.INVALID_REQUEST_EXP, CommonConstants.INVALID_REQUEST_CODE, message));
        }
        log.info(CommonConstants.METHOD_END, CommonConstants.HANDLE_EXCEPTION_INTERNAL);
        return new ResponseEntity<>(errorResponse, status);
    }
}
