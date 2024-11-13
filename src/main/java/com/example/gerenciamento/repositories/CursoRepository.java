package com.example.gerenciamento.repositories;

import com.example.gerenciamento.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
