package com.company;

import java.util.ArrayList;

public class Admin {
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static final int id = 0;
	private static String senha = "abcd";
	private static String nome = "Bob";
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	// Clientes são adicionados ou removidos

	public static String getSenha() {
		return senha;
	}
	public static void setSenha(String novaSenha) {
		senha = novaSenha;
	}

	public static String getNome() {
		return nome;
	}
	public static void setNome(String novoNome) {
		nome = novoNome;
	}

	public static int getId() {
		return id;
	}

	public static void novoCliente(String nome, String senha, int idade, Sexo sexo, String profissao, float dinheiroTotal){
		Cliente novo = new Cliente(nome, senha, idade, sexo, profissao, dinheiroTotal);
		// adicionaCliente é chamado no construtor do Cliente, portanto é adicionado no ArrayList

	}

	public static void adicionaCliente(Cliente novo){
		clientes.add(novo);
	}

	public static void desativaCliente(Cliente cliente){
		cliente.setStatus(false);
	}

	public static void ativaCliente(Cliente cliente){
		cliente.setStatus(true);
	}


	public static void desativaCliente(int id){
		for(Cliente i : clientes){
			if(i.getId() == id){
				i.setStatus(false);
			}
		}
	}

	public static String verCliente(int id) {
		String out;

		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				return cliente.toString();
			}
		}
		return "Cliente inválido";
	}
	
	public static void alterarSaldo(int id, float saldo) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				cliente.getConta().setSaldo(saldo);
				if (cliente.getConta() instanceof ContaInvestidor){
					cliente.setDinheiroTotal(cliente.getConta().getSaldo() + ((ContaInvestidor) cliente.getConta()).getMontanteTotal());
				} else {
					cliente.setDinheiroTotal(cliente.getConta().getSaldo());
				}
			}
		}
	}
	
	
}
