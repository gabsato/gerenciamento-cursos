package com.example.gerenciamento.controllers;

import com.example.gerenciamento.dto.InscricaoRequest;
import com.example.gerenciamento.entities.Aluno;
import com.example.gerenciamento.entities.Curso;
import com.example.gerenciamento.entities.Inscricao;
import com.example.gerenciamento.repositories.AlunoRepository;
import com.example.gerenciamento.repositories.CursoRepository;
import com.example.gerenciamento.repositories.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {
    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Inscricao inscreverAluno(@RequestBody InscricaoRequest inscricaoRequest){
        Long alunoId = inscricaoRequest.getAlunoId();
        Long cursoId = inscricaoRequest.getCursoId();

        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não foi encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não foi encontrado"));

        Inscricao inscricao = new Inscricao(aluno, curso, new Date());

        return inscricaoRepository.save(inscricao);
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Inscricao> listaInscricoesPorAluno(@PathVariable Long alunoId){
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(()-> new RuntimeException("O aluno não foi encontrado"));
        return inscricaoRepository.findByAluno(aluno);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Inscricao> listaInscricoesPorCurso(@PathVariable Long cursoId){
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("O curso não foi encontrado"));
        return inscricaoRepository.findByCurso(curso);
    }

}