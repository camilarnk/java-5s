package com.cr.employees.models;

import com.cr.employees.enums.StatusFuncionario;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_funcionario")
    private String nome;

    @Column(name = "salario_funcionario")
    private BigDecimal salario;

    @Column(name = "cargo_funcionario")
    private String cargo;

    @Column(name = "status_funcionario")
    @Enumerated(EnumType.STRING)
    private StatusFuncionario status;

    public Funcionario() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }
}
