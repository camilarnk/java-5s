package com.cr.registrations.models;

import com.cr.registrations.enums.StatusMatricula;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;

    private LocalDate dataMatricula;

    @Enumerated(EnumType.STRING)
    private StatusMatricula status;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Matricula() {}

    public Long getId() {
        return id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public StatusMatricula getStatus() {
        return status;
    }

    public void setStatus(StatusMatricula status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
