package com.example.gerenciamento.repositories;

import com.example.gerenciamento.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}