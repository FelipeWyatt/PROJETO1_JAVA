package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ContaInvestidor extends ContaBancaria { // Tem acesso a investimentos
    private ArrayList<Investimento> investimentos;

    //MÉTDO CONSTRUTOR
    public ContaInvestidor (float saldo, Cliente dono) {
        super(saldo, dono);

        investimentos = new ArrayList<Investimento>();
    }

    //GETTERS E SETTERS
    public ArrayList<Investimento> getInvestimentos () { return investimentos; }
    // Não faz sentido ter um set para um ArrayList

    //DEMAIS MÉTODOS
    public boolean criarInvestimentoRF (AtivosRF ativo, float montante) {
    	if (getDono().getStatus() && getSaldo() >= montante) {
	        RendaFixa novo_investimento = new RendaFixa(montante, new GregorianCalendar(), ativo);
	        investimentos.add(novo_investimento);
	        setSaldo(getSaldo() - montante);
            return true;
    	} else {
    		return false;
    	}
    }

    //Retira o dinheiro aplicado em um investimento determinado, rendendo uma quantiidade propocional ao tempo que o dinheiro ficou aplicado. Caso a retirada eja feita antes da data de vencimento do ativo, uma penalidade é aplicada
    public void resgatarInvestimento(Investimento investimento) {
    	if (getDono().getStatus()) {
            // Metodo mais geral que poderá ser adicionado outros tipos de investimentos
            if (investimento instanceof RendaFixa) { // Tem regras de resgate diferentes para cada tipo de investimento
                investimentos.remove(investimento);
                //investimento = (RendaFixa) investimento;
                GregorianCalendar dataCompra = investimento.getDataCompra();
                GregorianCalendar dataVencimento = ((RendaFixa) investimento).getAtivo().getVencimento();

                if (Main.diasEntre(dataCompra, dataVencimento) >= 0) { // verificar ordem das datas
                    // Então está sendo resgatado depois do prazo, sem penalidade
                    setSaldo(getSaldo() + investimento.getMontante());

                } else {
                    // Então está sendo resgatado antes do prazo, com penalidade
                    float montante = investimento.getMontante();
                    float valorPenalidade = montante * ((RendaFixa) investimento).getAtivo().getPenalidade();
                    setSaldo(getSaldo() + montante - valorPenalidade);

                }
            }

            // Para outro tipo de investimento adicionar else if (investimento instanceof tipoInvestimento)
        }
    }

    public String mostraAtivos() { // Chama os toString de cada investimento, mais geral
    	DecimalFormat d1 = new DecimalFormat("#. 00");
    	if (getDono().getStatus()) {
	    	String out = "Investimentos:\n";
	        for (Investimento i : investimentos){
	            if (i instanceof RendaFixa) {
	                out += "- " + ((RendaFixa) i).getAtivo().getNome() + ": R$" + d1.format(i.getMontante()) + "\n";
	            }
	            // Para outro tipo de investimento adicionar else if (investimento instanceof tipoInvestimento)
	        }
	        return out;
    	}
    	else {
    		return "Erro: Cliente desativado";
    	}
    }

    @Override
    public String toString () {
    	DecimalFormat d1 = new DecimalFormat("#. 00");
        String out = "CONTA INVESTIDOR \n";
        out += super.toString();
        out += "Montante total investido: R$" + d1.format(getMontanteTotal()) + "\n";
        out += mostraAtivos();
        //out += "Ativos investidos: " + getNomeAtivo() + "\n";
        return out;
    }

    public float getMontanteTotal () {
        float total = 0;
        for (Investimento i : investimentos) {
            RendaFixa aux = (RendaFixa) i;
            total += aux.getMontante();
        }
        return (float) Math.round(total*100)/100; // Arredonda para 2 casas decimais
    }

    public String getNomeAtivo() {
        String out = "";
        for (Investimento i : investimentos){
            if (i instanceof RendaFixa) {
                out += ((RendaFixa) i).getAtivo().getNome() + "   ";
            }
            // Para outro tipo de investimento adicionar else if (investimento instanceof tipoInvestimento)
        }
        return out;
    }



}
