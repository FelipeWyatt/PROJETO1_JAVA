package com.company;
import java.util.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    // Tudo static porque Main não é instanciada
    public static GregorianCalendar dataAtual = new GregorianCalendar(2020, 11, 7);

    public static void main(String[] args) {
        float valor;

        Admin.novoCliente("Felipe", "abcd", 19, Sexo.MASCULINO, "Engenheiro", 5000f);
        Cliente c1 = Admin.getClientes().get(0);
        Admin.novoCliente("Matheus", "02", 13, Sexo.MASCULINO, "Engenheiro", 40000f);
        Cliente c2 = Admin.getClientes().get(1);
        Cliente c3 = new Cliente("Miguelzinho", "senha123", 25, Sexo.MASCULINO, "Soldador", 10000.01f);
        Cliente c4 = new Cliente("Pedrão", "Diniz", 34, Sexo.MASCULINO, "Tecnico do senai", 20000f);

        c1.abrirConta(1); // Conta Corrente
        c2.abrirConta(2); // Conta Poupança
        c3.abrirConta(3); // Conta Investidor
        c4.abrirConta(1); // Conta Corrente

        Scanner entrada = new Scanner(System.in);
        Cliente c5 = new Cliente();
        boolean v = false;

        System.out.print("*** Cadastro de novo cliente - Entradas do usuário ***\nInsira as informações solicitadas abaixo:\n");
        System.out.print("Nome: ");
        c5.setNome(entrada.nextLine());
        System.out.print("Idade: ");
        c5.setIdade(entrada.nextInt());
        System.out.print("Sexo (M ou F): ");
        while (!v) {
            String v2 = entrada.next();
            if (v2.equals("M")){
                c5.setSexo(Sexo.MASCULINO);
                v = true;
            } else if (v2.equals("F")) {
                c5.setSexo(Sexo.FEMININO);
                v = true;
            } else {
                System.out.print("Entrada inválida, por favor, redigite: ");
            }
        }
        entrada.nextLine();
        System.out.print("Profissao: ");
        c5.setProfissao(entrada.nextLine());
        System.out.print("O login para acesso à sua conta é: ");
        System.out.print(c5.getId());
        System.out.print("\nDefina uma senha (sem espaços): ");
        c5.setSenha(entrada.next());
        System.out.print("Qual o tipo da conta?\n 1 - Conta Corrente\n 2 - Conta Poupança\n 3 - Conta Investidor\nResp: ");
        v = false;
        while (!v) {
            int v3 = entrada.nextInt();
            if (v3 == 1){
                c5.abrirConta(v3);
                v = true;
            } else if (v3 == 2) {
                c5.abrirConta(v3);
                v = true;
            } else if (v3 == 3){
                c5.abrirConta(v3);
                v = true;
            } else {
                System.out.print("Entrada inválida, por favor, redigite: ");
            }
        }
        System.out.print("Qual o valor do depósito inicial (utilize ',' para casas decimais)? ");
        c5.getConta().depositar(entrada.nextFloat());
        System.out.print("Novo cliente criado. Seja bem-vindo!\n\n");

        System.out.println("*** Instanciando Objetos ***");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);


        System.out.println("*** Métodos de Cliente ***");
        System.out.println("-> Cliente.fecharConta()");
        c4.fecharConta();
        System.out.println(c4);
        System.out.println("-> Cliente.abrirConta()");
        c4.abrirConta(3); // Abre nova conta Investidor
        System.out.println(c4);
        System.out.println("-> Cliente.verConta()");
        System.out.println(c2.verConta());

        System.out.println("*** Métodos de ContaBancaria ***");
        System.out.println("-> ContaBancaria.depositar()");

        valor = 1350;
        if (c2.getConta().depositar(valor)) System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        else System.out.println("Não foi possível fazer o depósito!");
        System.out.println(c2);

        System.out.println("-> ContaBancaria.retirar()");

        valor = 720;
        if (c3.getConta().retirar(valor)) System.out.println("Valor de R$" + valor + " retirado com sucesso!");
        else System.out.println("Não foi possível retirar o valor de R$" + valor + " !");
        System.out.println(c3);

        System.out.println("-> ContaBancaria.depositar() - objeto criado via entradas do usuário");
        valor = 200;
        if (c5.getConta().depositar(valor)) System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        else System.out.println("Não foi possível fazer o depósito!");
        System.out.println(c5);

        System.out.println("-> ContaBancaria.retirar() - objeto criado via entradas do usuário");
        valor = 2000;
        if (c5.getConta().retirar(valor)) System.out.println("Valor de R$" + valor + " retirado com sucesso!");
        else System.out.println("Não foi possível retirar o valor de R$" + valor + " !");
        System.out.println(c5);

        System.out.println("*** Métodos de Admin ***");
        System.out.println("-> Admin.desativaCliente()");
        Admin.desativaCliente(c1);
        System.out.println(c1);
        System.out.println("-> c1 tenta depositar");

        valor = 10000;
        if (c1.getConta().depositar(valor)) System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        else System.out.println("Não foi possível fazer o depósito!");

        System.out.println(c1);
        System.out.println("-> c1 tenta retirar");

        valor = 423;
        if (c1.getConta().retirar(valor)) System.out.println("Valor de R$" + valor + " retirado com sucesso!");
        else System.out.println("Não foi possível retirar o valor de R$" + valor + " !");

        System.out.println(c1);
        System.out.println("-> Admin.ativaCliente()");
        Admin.ativaCliente(c1);
        System.out.println("-> c1 tenta depositar");

        valor = 1280;
        if (c1.getConta().depositar(valor)) System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        else System.out.println("Não foi possível fazer o depósito!");

        System.out.println(c1);
        System.out.println("-> Admin.alterarSaldo()");
        Admin.alterarSaldo(2,1234);
        System.out.println(c2);
        System.out.println("-> Admin.verCliente()");
        System.out.println(Admin.verCliente(3));

        System.out.println("*** Métodos de ContaInvestidor ***");
        System.out.println("-> ContaInvestidor.criaInvestimentoRF()");

        ContaInvestidor conta3 = (ContaInvestidor) c3.getConta();
        if (conta3.criarInvestimentoRF(AtivosRF.TESOURO_SELIC, 500f)) System.out.println("Novo investimento criado com sucesso!");
        else System.out.println("Não foi possível criar o investimento!");
        if (conta3.criarInvestimentoRF(AtivosRF.CDB_BANCO_INTER, 1000f)) System.out.println("Novo investimento criado com sucesso!");
        else System.out.println("Não foi possível criar o investimento!");

        System.out.println(conta3);

        ContaInvestidor conta4 = (ContaInvestidor) c4.getConta();
        if (conta4.criarInvestimentoRF(AtivosRF.CDB_BANCO_ITAU, 1300f)) System.out.println("Novo investimento criado com sucesso!");
        else System.out.println("Não foi possível criar o investimento!");
        if (conta4.criarInvestimentoRF(AtivosRF.LCI_CAIXA, 900f)) System.out.println("Novo investimento criado com sucesso!");
        else System.out.println("Não foi possível criar o investimento!");

        System.out.println(conta4);

        System.out.println("-> ContaInvestidor.resgatarInvestimento()");
        conta3.resgatarInvestimento(conta3.getInvestimentos().get(1));
        System.out.println(conta3);

        System.out.println("*** Simulando passagem do tempo, mostrando rendimentos ***");
        System.out.println("Data Atual: " + Data.formataDMA(dataAtual) + "\n");
        System.out.println("-> setDataAtual()");
        setDataAtual(new GregorianCalendar(2020, 11, 8));
        System.out.println("Data Atual: " + Data.formataDMA(dataAtual) + "\n");
        System.out.println(c2.getConta());
        System.out.println(conta3);
        System.out.println(conta4);

        System.out.println("-> setDataAtual()");
        setDataAtual(new GregorianCalendar(2021, 5, 13));
        System.out.println("Data Atual: " + Data.formataDMA(dataAtual) + "\n");
        System.out.println(c2.getConta());
        System.out.println(conta3);
        System.out.println(conta4);
    }

    public static void rendeTudo(GregorianCalendar ultimaVezQueRendeu){
        // Atauliza todos os valores de todas as contas de todos os clientes
        long diasPassados = diasEntre(ultimaVezQueRendeu, dataAtual);

        for(Cliente cliente : Admin.getClientes()){
            if(cliente.getStatus()){
                ContaBancaria conta = cliente.getConta();
                if (conta instanceof ContaPoupanca){
                    // Saldo após n dias = saldo*(1 + rendimentoDiário)^n
                    float novoSaldo = (float) (conta.getSaldo() * Math.pow((1 + ContaPoupanca.getRendimentoDiario()), diasPassados));

                    novoSaldo = (float) Math.round(novoSaldo*100)/100; // Arredonda pra duas casas decimais
                    conta.setSaldo(novoSaldo);
                    // atualiza o dinheiroTotal do Cliente
                    cliente.setDinheiroTotal(novoSaldo);
                } else if (conta instanceof ContaInvestidor){
                    // deve render os montantes dos investimentos
                    for(Investimento i : ((ContaInvestidor) conta).getInvestimentos()){
                        if (i instanceof RendaFixa){
                            AtivosRF ativo = ((RendaFixa) i).getAtivo();
                            float novoMontante = (float) (i.getMontante() * Math.pow(1 + ativo.getRentabilidade(), diasPassados));
                            novoMontante = (float) Math.round(novoMontante*100)/100; // Arredonda pra duas casas decimais
                            i.setMontante(novoMontante);
                        }
                    }
                    // atualiza o dinheiroTotal do Cliente
                    cliente.setDinheiroTotal(conta.getSaldo() + ((ContaInvestidor) conta).getMontanteTotal());

                } // Conta Corrente não rende nada
            }
        }
    }

    public static void setDataAtual(GregorianCalendar novaData){
        GregorianCalendar dataAntiga = dataAtual;
        dataAtual = novaData;
        rendeTudo(dataAntiga); // Compara com a data atual
    }

    public static long diasEntre(GregorianCalendar dataAntiga, GregorianCalendar dataProxima){
        // Para evitar que as horas, minutos e segundos façam diferença no número de dias, deve-se zerar os seus valores
        dataAntiga.set(Calendar.HOUR, 0);
        dataAntiga.set(Calendar.MINUTE, 0);
        dataAntiga.set(Calendar.SECOND, 0);
        dataAntiga.set(Calendar.MILLISECOND, 0);

        dataProxima.set(Calendar.HOUR, 0);
        dataProxima.set(Calendar.MINUTE, 0);
        dataProxima.set(Calendar.SECOND, 0);
        dataProxima.set(Calendar.MILLISECOND, 0);
        // Diferença entre as datas em segundos
        long dif_segundos = (dataProxima.getTimeInMillis() - dataAntiga.getTimeInMillis()) / 1000;
        long dif_dias = dif_segundos/(3600*24);

        return dif_dias;
    }
}