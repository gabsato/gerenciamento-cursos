package com.example.gerenciamento.controllers;

import com.example.gerenciamento.dto.AlunoDTO;
import com.example.gerenciamento.entities.Aluno;
import com.example.gerenciamento.populator.InscricaoPopulator;
import com.example.gerenciamento.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    @PostMapping
    public AlunoDTO criarAluno(@RequestBody Aluno aluno){
        Aluno alunoCriado = alunoRepository.save(aluno);
        return inscricaoPopulator.converterAlunoDTO(alunoCriado);
    }

    @GetMapping
    public List<AlunoDTO> listaAlunos(){
        return alunoRepository.findAll().stream().map(inscricaoPopulator::converterAlunoDTO).collect(Collectors.toList());
    }
}