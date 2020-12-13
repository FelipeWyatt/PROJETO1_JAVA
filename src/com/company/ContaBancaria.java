package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ContaBancaria {
    private static int numContas = 0;
    private final int id; // Número/login da conta
    private float saldo;
    private final Cliente dono;

    //MÉTODO CONSTRUTOR
    public ContaBancaria (float saldo, Cliente dono) {
        this.id = numContas + 1; // Segue a logica do id +1 em Cliente
        this.saldo = saldo;
        this.dono = dono;

        numContas++;
    }

    //GETTERS E SETTERS
    public static int getNumContas () { return numContas; }
    public static void setNumContas (int numC) { numContas = numC; }

    public int getId () { return id; }

    public float getSaldo () { return saldo; }
    public void setSaldo (float saldo) { this.saldo = saldo; }

    public Cliente getDono () { return dono; }


    //DEMAIS MÉTODOS
    public boolean retirar (float valor) { //porque retornar boolean?
    	if (dono.getStatus()) {
	        if (valor <= getSaldo()) {
	            this.saldo = this.saldo - valor;
	            // também deve-se atualizar o montanteTotal do cliente
	            getDono().setDinheiroTotal(getDono().getDinheiroTotal() - valor);

	            return true;
	        } else {
	            return false;
	        }
    	}
    	else {
    		return false;
    	}
    		
    }

    public boolean depositar (float valor) {
    	if (dono.getStatus()) {
	        this.saldo = this.saldo + valor;
	        // também deve-se atualizar o montanteTotal do cliente
	        getDono().setDinheiroTotal(getDono().getDinheiroTotal() + valor);
	        return true;
    	}
    	else {
    		return false;
    	}
    }



    @Override
    public String toString () {
    	DecimalFormat d1 = new DecimalFormat("#. 00");
        String out = "Id/login da conta: " + getId() + "\n";
        out += "Dono da conta: " + getDono().getNome() + "\n";
        out += "Saldo disponível: R$" + d1.format(getSaldo()) + "\n";
        return out;
    }
}
