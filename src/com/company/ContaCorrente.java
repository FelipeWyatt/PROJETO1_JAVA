package com.company;

public class ContaCorrente extends ContaBancaria { // Conta comum

    //MÉTDO CONSTRUTOR
    public ContaCorrente (float saldo, Cliente dono) {
        super(saldo, dono);
    }

    @Override
    public String toString () {
        String out = "CONTA CORRENTE \n";
        out += super.toString();
        return out;
    }
}
