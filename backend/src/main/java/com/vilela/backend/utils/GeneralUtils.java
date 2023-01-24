package com.vilela.backend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vilela.backend.utils.enumerador.ExceptionEnum;

import lombok.Data;

@Data
public class GeneralUtils {

    public static ResponseEntity<String> getResponseError(ExceptionEnum mensagem, HttpStatus httpStatus) {
        return new ResponseEntity<>("{\"mensagem\":\"" + mensagem + "\"}", httpStatus);
    }
    public static ResponseEntity<String> getResponseSuccess(String mensagem, HttpStatus httpStatus) {
        return new ResponseEntity<>("{\"mensagem\":\"" + mensagem + "\"}", httpStatus);
    }
}
