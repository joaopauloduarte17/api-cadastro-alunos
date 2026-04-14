package com.joaopaulo.project_spring.controller;

import com.joaopaulo.project_spring.dto.AlunoRequestDTO;
import com.joaopaulo.project_spring.dto.AlunoResponseDTO;
import com.joaopaulo.project_spring.repository.AlunoRepository;
import com.joaopaulo.project_spring.model.Aluno;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<AlunoResponseDTO> listarAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(this::toResponseDTO).toList();
    }

    @GetMapping("/buscar/{nome}")
    public List<Aluno> buscarPorParteDoNome(@PathVariable String nome){
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @PostMapping
    public AlunoResponseDTO cadastrar(@RequestBody @Valid AlunoRequestDTO dto ){
        Aluno aluno = toEntity(dto);
        Aluno salvo =  alunoRepository.save(aluno);
        return toResponseDTO(salvo);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO atualizarAluno(@PathVariable Long id, @RequestBody @Valid AlunoRequestDTO dto){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setCurso(dto.getCurso());
        aluno.setNota1(dto.getNota1());
        aluno.setNota2(dto.getNota2());
        aluno.setNota3(dto.getNota3());

        Aluno atualizado = alunoRepository.save(aluno);

        return toResponseDTO(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        alunoRepository.deleteById(id);
    }

    private Aluno toEntity(AlunoRequestDTO dto){
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setCurso(dto.getCurso());
        aluno.setNota1(dto.getNota1());
        aluno.setNota2(dto.getNota2());
        aluno.setNota3(dto.getNota3());
        return aluno;
    }

    private AlunoResponseDTO toResponseDTO(Aluno aluno){
        AlunoResponseDTO dto = new AlunoResponseDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setMatricula(aluno.getMatricula());
        dto.setCurso(aluno.getCurso());
        dto.setMedia(aluno.getMedia());
        dto.setStatus(aluno.getStatus());
        return dto;
    }
}
