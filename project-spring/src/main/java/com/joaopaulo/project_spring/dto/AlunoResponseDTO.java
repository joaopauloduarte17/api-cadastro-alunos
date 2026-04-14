package com.joaopaulo.project_spring.dto;

public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private Integer matricula;
    private String curso;
    private Double media;
    private String status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMedia() {
        return media;
    }
    public void setMedia(Double media) {
        this.media = media;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
