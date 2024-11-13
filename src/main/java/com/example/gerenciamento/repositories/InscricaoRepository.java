package com.example.gerenciamento.repositories;

import com.example.gerenciamento.entities.Aluno;
import com.example.gerenciamento.entities.Curso;
import com.example.gerenciamento.entities.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByAluno(Aluno aluno);
    List<Inscricao> findByCurso(Curso curso);
}
