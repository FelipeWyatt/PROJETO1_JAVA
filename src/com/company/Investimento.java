package com.company;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Investimento {
	
	 private float montante;
	 private GregorianCalendar dataCompra;
	 
	public float getMontante() {
		return montante;
	}
	public void setMontante(float montante) {
		this.montante = montante;
	}

	public GregorianCalendar getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(GregorianCalendar dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	public Investimento(float montante, GregorianCalendar dataCompra) {
		this.montante = montante;
		this.dataCompra = dataCompra;
	}
	
	
	public String toString() {
		DecimalFormat d1 = new DecimalFormat("#. 00");
		String out = "Montante: R$" + d1.format(getMontante())+"\n";
		out = out+"Data da Compra: "+ Data.formataDMA(dataCompra)+"\n";
		return out;
	}
	

}
