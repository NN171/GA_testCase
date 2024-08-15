package org.example.greenatom.exhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

@ControllerAdvice
public class Handler {

    @ResponseBody
    @ExceptionHandler(FileNotExist.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fileNotFound(FileNotExist ex) {
        return ex.getMessage();
    }
}
