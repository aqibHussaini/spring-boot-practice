package com.myproject.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHanlder extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={Exception.class})
    public String  handleException(RuntimeException e, WebRequest webRequest, Model model)
    {
        System.out.println("chala"+e.getCause());
        model.addAttribute("msg",""+e.getMessage());
        return "data.html";
//        return new ResponseEntity<Object>("my exception "+e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={NumberFormatException.class, IOException.class})
    public ResponseEntity<Object> handleNumberException(RuntimeException e, WebRequest webRequest)
    {
        return new ResponseEntity<Object>("NumberFormatException "+e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
