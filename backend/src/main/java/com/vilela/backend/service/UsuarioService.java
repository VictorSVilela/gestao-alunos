package com.vilela.backend.service;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vilela.backend.model.Usuario;
import com.vilela.backend.repository.UsuarioRepository;
import com.vilela.backend.utils.GeneralUtils;
import com.vilela.backend.utils.enumerador.ExceptionEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity<String> cadastrar(Map<String, String> requestMap) {
        log.info("TESTE");
        try {
            if (validarCadastro(requestMap)) {
                Usuario usuario = usuarioRepository.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(usuario)) {
                    usuarioRepository.save(getUsuarioMap(requestMap));
                    return GeneralUtils.getResponseSuccess("Cadastro Realizado com Sucesso", HttpStatus.OK);
                } else {
                    return GeneralUtils.getResponseError(ExceptionEnum.EMAIL_JA_EXISTE, HttpStatus.BAD_REQUEST);
                }
            } else {
                return GeneralUtils.getResponseError(ExceptionEnum.DADOS_INVALIDOS, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return GeneralUtils.getResponseError(ExceptionEnum.NAO_POSSIVEL_CADASTRAR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validarCadastro(Map<String, String> requestMap) {
        if (requestMap.containsKey("nome") && requestMap.containsKey("email") && requestMap.containsKey("senha")) {
            return true;
        }
        return false;
    }

    private Usuario getUsuarioMap(Map<String, String> requestMap) {
        Usuario usuario = new Usuario();
        usuario.setNome(requestMap.get("nome"));
        usuario.setEmail(requestMap.get("email"));
        usuario.setSenha(requestMap.get("senha"));
        usuario.setStatus("false");
        usuario.setPermissao("usuario");
        return usuario;
    }

}
