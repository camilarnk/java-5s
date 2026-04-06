package com.cr.vehicles.enums;

public enum StatusVeiculo {

    DISPONIVEL(1),
    VENDIDO(2),
    RESERVADO(3);

    private final int opcao;

    StatusVeiculo(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return opcao;
    }
}
