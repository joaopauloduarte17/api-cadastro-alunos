package com.joaopaulo.project_spring.exception;

import java.util.List;

public class ErroResposta {

    private int status;
    private String erro;
    private List<String> mensagens;

    public ErroResposta(int status, String erro, List<String> mensagens) {
        this.status = status;
        this.erro = erro;
        this.mensagens = mensagens;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public List<String> getMensagens() {
        return mensagens;
    }
}
