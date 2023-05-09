package com.cairiton.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cairiton.exception.HrException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(HrException.class)
	public ResponseEntity<Object> handlerHr(HrException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		Problema problema = new Problema();
		problema.setStatus(HttpStatus.NOT_FOUND.value());
		problema.setDataHora(LocalDateTime.now());
		problema.setTitulo(ex.getMessage());

		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	

}
