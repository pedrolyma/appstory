package com.lojastory.lojastory.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lojastory.lojastory.exception.NegocioException;

/*@ControllerAdvice*/
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * @Autowired private MessageSource messageSource;
	 * 
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatusCode status, WebRequest request) { List<Problema.Campo>
	 * campos = new ArrayList<>();
	 * 
	 * for (ObjectError error : ex.getBindingResult().getAllErrors()) { String nome
	 * = ((FieldError) error).getField(); String mensagem =
	 * messageSource.getMessage(error, LocaleContextHolder.getLocale());
	 * campos.add(new Problema.Campo(nome, mensagem)); } Problema problema = new
	 * Problema(); problema.setStatus(status.value());
	 * problema.setDataHora(LocalDateTime.now());
	 * problema.setTitulo("Campos Obrigatorio Não Foi Informado");
	 * problema.setCampos(campos); return handleExceptionInternal(ex, problema,
	 * headers, status, request); }
	 * 
	 * @ExceptionHandler(NegocioException.class) public ResponseEntity<Object>
	 * handleNegocio(NegocioException ex, WebRequest request) { HttpStatus status =
	 * HttpStatus.BAD_REQUEST;
	 * 
	 * Problema problema = new Problema(); problema.setStatus(status.value());
	 * problema.setDataHora(LocalDateTime.now());
	 * problema.setTitulo(ex.getMessage()); return handleExceptionInternal(ex,
	 * problema, new HttpHeaders(), status, request); }
	 */
}
