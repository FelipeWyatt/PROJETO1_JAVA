package com.company;

public class ContaPoupanca extends ContaBancaria { // Rende diariamente a uma taxa fixa
    private static final float rendimentoDiario = 0.00007f; //em Porcento

    //MÉTDO CONSTRUTOR
    public ContaPoupanca (float saldo, Cliente dono) {
        super(saldo, dono);
    }

    //GETTERS E SETTERS
    public static float getRendimentoDiario () { return rendimentoDiario; }

    @Override
    public String toString () {
        String out = "CONTA POUPANÇA \n";
        out += super.toString();
        out += "Rendimento Diario da poupança: " + 100*getRendimentoDiario() + "%" + "\n";
        return out;
    }
}
