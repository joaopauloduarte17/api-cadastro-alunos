package com.joaopaulo.project_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErroResposta tratarErroValidacao(MethodArgumentNotValidException ex){
        List<String> erros = ex.getBindingResult().getFieldErrors().stream().map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

        return new ErroResposta(400, "Erro de validação", erros);
    }
}
