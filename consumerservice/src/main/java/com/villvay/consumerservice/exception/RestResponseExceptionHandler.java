package com.villvay.consumerservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestResponseExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        log.info("Exception : {}", resourceNotFoundException);
        return new ResponseEntity<Object>(resourceNotFoundException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException noDataFoundException) {
        log.info("Exception : {}", noDataFoundException);
        return new ResponseEntity<Object>(noDataFoundException.getMessage(), new HttpHeaders(), HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleGenericException(Exception exception) {
        log.info("Exception : {}", exception);
        return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
