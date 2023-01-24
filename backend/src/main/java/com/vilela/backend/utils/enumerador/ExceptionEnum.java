package com.vilela.backend.utils.enumerador;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    NAO_POSSIVEL_CADASTRAR("Não foi possível cadastrar"),
    DADOS_INVALIDOS("Dados inválidos"),
    EMAIL_JA_EXISTE("Email já existe");
    private String descricao;
}
