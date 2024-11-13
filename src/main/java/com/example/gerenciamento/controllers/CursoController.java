package com.example.gerenciamento.controllers;

import com.example.gerenciamento.dto.CursoDTO;
import com.example.gerenciamento.entities.Curso;
import com.example.gerenciamento.populator.InscricaoPopulator;
import com.example.gerenciamento.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    @PostMapping
    public CursoDTO criarCurso(@RequestBody Curso curso){
        Curso cursoCriado = cursoRepository.save(curso);
        return inscricaoPopulator.converterCursoDTO(cursoCriado);
    }

    @GetMapping
    public List<CursoDTO> listaCursos(){
        return cursoRepository.findAll().stream().map(inscricaoPopulator::converterCursoDTO).collect(Collectors.toList());
    }
}