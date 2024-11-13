package com.example.gerenciamento.populator;

import com.example.gerenciamento.dto.AlunoDTO;
import com.example.gerenciamento.dto.CursoDTO;
import com.example.gerenciamento.entities.Aluno;
import com.example.gerenciamento.entities.Curso;
import org.springframework.stereotype.Component;

@Component
public class InscricaoPopulator {

    public AlunoDTO converterAlunoDTO(Aluno aluno){
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public CursoDTO converterCursoDTO(Curso curso){
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setDataCriacao(curso.getDataCriacao());
        return dto;
    }
}