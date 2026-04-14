package com.joaopaulo.project_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.joaopaulo.project_spring.model.Aluno;

import java.util.List;


public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}