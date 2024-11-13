package com.example.gerenciamento.dto;

public class InscricaoRequest {
    private Long alunoId;
    private Long cursoId;

    //Get e Set
    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    //Construtor
    public InscricaoRequest(){}
}