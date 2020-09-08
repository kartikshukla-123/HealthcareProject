package com.cg.diagnostic.web;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.diagnostic.dto.DiagnosticError;
import com.cg.diagnostic.exceptions.SlotException;


@RestControllerAdvice
public class SlotAdvice {

	@ExceptionHandler(SlotException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public DiagnosticError handleAppointException(SlotException ex) {
	return new DiagnosticError(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
}
