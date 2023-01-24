package com.vilela.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilela.backend.service.UsuarioService;
import com.vilela.backend.utils.GeneralUtils;
import com.vilela.backend.utils.enumerador.ExceptionEnum;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody Map<String, String> requestMap) {
        try {
            return usuarioService.cadastrar(requestMap);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return GeneralUtils.getResponseError(ExceptionEnum.NAO_POSSIVEL_CADASTRAR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
