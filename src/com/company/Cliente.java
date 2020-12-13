package com.company;

import java.text.DecimalFormat;

public class Cliente {

    private static int numClientes = 0; // Começa em 1 porque Admin é 0
    private final int id;
    private String senha;
    private boolean status;
    private String nome;
    private int idade;
    private Sexo sexo;
    private String profissao;
    private ContaBancaria conta;
    private float dinheiroTotal;

    public Cliente(String nome, String senha, int idade, Sexo sexo, String profissao, float dinheiroTotal) {
        // Construtor sobrecarregado para criar novo cliente em Admin
        this.id = numClientes + 1; // Começa em 1 porque Admin é 0
        this.senha = senha;
        this.status = true;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
        this.conta = null;
        this.dinheiroTotal = dinheiroTotal;

        numClientes++;

        //Adiciona o cliente na lista de clientes do Admin
        Admin.adicionaCliente(this);
    }

    public Cliente() {
        // Construtor sobrecarregado, definir atributos com sets
        this.id = numClientes + 1; // Começa em 1 porque Admin é 0

        numClientes++;

        //Adiciona o cliente na lista de clientes do Admin
        Admin.adicionaCliente(this);
    }



    public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public static int getNumClientes() {
        return numClientes;
    }
    public static void setNumClientes(int numClientes) {
        Cliente.numClientes = numClientes;
    }

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public ContaBancaria getConta() {
        return conta;
    }
    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public float getDinheiroTotal() {
        return dinheiroTotal;
    }
    public void setDinheiroTotal(float dinheiroTotal) {
        this.dinheiroTotal = dinheiroTotal;
    }


    public boolean abrirConta(int tipoDaConta){
        // Tipo da conta: 1 - Conta Corrente
        //                2 - Conta Poupança
        //                3 - Conta investidor

        if (status) {
            if(tipoDaConta == 1){
                this.conta = new ContaCorrente(dinheiroTotal, this);
                return true;
            } else if(tipoDaConta == 2){
                this.conta = new ContaPoupanca(dinheiroTotal, this);
                return true;
            } else if(tipoDaConta == 3){
                this.conta = new ContaInvestidor(dinheiroTotal, this);
                return true;
            }
        }
        return false;
    }

    public void fecharConta(){
        conta = null;
    }

    public String verConta(){
        return conta.toString();
    }

    public String toString() {
        DecimalFormat d1 = new DecimalFormat("#. 00");

        String out = "Dados do Cliente:\n";
        out += "Nome: " + getNome() + "\n";
        out += "Idade: " + getIdade() + "\n";
        out += "Sexo: " + getSexo().getAtributos() + "\n";
        out += "Profissão: " + getProfissao() + "\n";
        out += "ID do cliente: " + getId() + "\n";
        out += "Senha: " + getSenha() + "\n";
        out += "Status: " + converteStatus(getStatus()) + "\n";
        out += "Dinheiro total: R$" + d1.format(getDinheiroTotal()) + "\n";
        if(conta != null){
            out += "Tipo da conta: " + tipoDaConta() + "\n";
            out += "ID da conta: " + getConta().getId() + "\n";
            out += "Saldo da conta: R$" + d1.format(getConta().getSaldo()) + "\n";
            if(this.getConta() instanceof ContaInvestidor){
            	out += "Total Investido: R$";            
            	if (((ContaInvestidor) getConta()).getMontanteTotal() != 0) {
            		out += d1.format(((ContaInvestidor) getConta()).getMontanteTotal()) + "\n";
            	}
            	else {
            		out += "0,00\n";
            	}
            }
        } else {
            out += "Sem conta!\n";
        }

        return out;
    }

    private String converteStatus (boolean status) {
        if(status) return "Cliente ativo";
        else return "Cliente inativo";
    }

    private String tipoDaConta () {
        if(this.getConta() instanceof ContaInvestidor) return "Conta Investidor";
        else if (this.getConta() instanceof ContaPoupanca) return "Conta Poupança";
        else return "Conta Corrente";
    }

}