package com.company;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

class RendaFixa extends Investimento { // Um tipo de investimento, entao é uma classe-filha de investimento

	private AtivosRF ativo;

	public AtivosRF getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivosRF ativo) {
		this.ativo = ativo;
	}

	public RendaFixa(float montante, GregorianCalendar dataCompra, AtivosRF ativo) {
		super(montante, dataCompra);
		this.ativo = ativo;
	}

	public String toString() {
		DecimalFormat d1 = new DecimalFormat("#. 00");
		String out = "Montante: R$" + d1.format(getMontante()) + "\n";
		out = out + "Data da Compra: " + Data.formataDMA(getDataCompra()) + "\n";
		out = out + "Ativo: " + ativo.getNome() + "\n";
		out = out + "*rentabilidade: " + 100*ativo.getRentabilidade()+ "%" + "\n";
		out = out + "*vencimento: " + Data.formataDMA(ativo.getVencimento()) + "\n";
		out = out + "*penalidade: " + 100*ativo.getPenalidade()+ "%" + "\n";
		return out;
	}

}
