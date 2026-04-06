package com.cr.vehicles.models;

import com.cr.vehicles.enums.StatusVeiculo;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo_veiculo")
    private String modelo;

    @Column(name = "marca_veiculo")
    private String marca;

    @Column(name = "ano_veiculo")
    private Integer ano;

    @Column(name = "preco_veiculo")
    private BigDecimal preco;

    @Column(name = "status_veiculo")
    private StatusVeiculo status;

    public Veiculo() {}

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }
}
