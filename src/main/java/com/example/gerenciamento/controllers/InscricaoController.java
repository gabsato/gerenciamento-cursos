package com.example.gerenciamento.controllers;

import com.example.gerenciamento.dto.AlunoDTO;
import com.example.gerenciamento.dto.CursoDTO;
import com.example.gerenciamento.dto.InscricaoRequest;
import com.example.gerenciamento.entities.Aluno;
import com.example.gerenciamento.entities.Curso;
import com.example.gerenciamento.entities.Inscricao;
import com.example.gerenciamento.populator.InscricaoPopulator;
import com.example.gerenciamento.repositories.AlunoRepository;
import com.example.gerenciamento.repositories.CursoRepository;
import com.example.gerenciamento.repositories.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {
    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    //Método para inscrição dos alunos
    @PostMapping
    public Inscricao inscreverAluno(@RequestBody InscricaoRequest inscricaoRequest){
        Long alunoId = inscricaoRequest.getAlunoId();
        Long cursoId = inscricaoRequest.getCursoId();

        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não foi encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não foi encontrado"));

        Inscricao inscricao = new Inscricao(aluno, curso, new Date());

        return inscricaoRepository.save(inscricao);
    }

    //Lista de cursos do aluno
    @GetMapping("/aluno/{alunoId}")
    public List<CursoDTO> listaInscricoesPorAluno(@PathVariable Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("O aluno não foi encontrado"));
        List<Inscricao> inscricoes = inscricaoRepository.findByAluno(aluno);
        return inscricoes.stream().map(inscricao -> inscricaoPopulator.converterCursoDTO(inscricao.getCurso())).collect(Collectors.toList()); }

    //Lista de alunos no curso
    @GetMapping("/curso/{cursoId}")
    public List<AlunoDTO> listaInscricoesPorCurso(@PathVariable Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não foi encontrado"));
        List<Inscricao> inscricoes = inscricaoRepository.findByCurso(curso);
        return inscricoes.stream().map(inscricao -> inscricaoPopulator.converterAlunoDTO(inscricao.getAluno())).collect(Collectors.toList());
    }
}