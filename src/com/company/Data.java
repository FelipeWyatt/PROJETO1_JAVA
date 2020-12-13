package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {
    // Métodos estáticos usados em outras classes

    public static String formataDMA(GregorianCalendar data){
        // Converte o objeto GregorianCalendar em String formatada em dd/mm/aaaa.

        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH);
        int ano = data.get(Calendar.YEAR);

        return (dia + "/" + mes  + "/" + ano);
    }

    public static String formataDMA_HMS(GregorianCalendar data){
        // Converte o objeto GregorianCalendar em String formatada em dd/mm/aaaa hh:mm:ss.

        int seg = data.get(Calendar.SECOND);
        int minuto = data.get(Calendar.MINUTE);
        int hora = data.get(Calendar.HOUR_OF_DAY);

        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH);
        int ano = data.get(Calendar.YEAR);

        return (dia + "/" + mes  + "/" + ano + " " + hora + ":" + minuto + ":" + seg);
    }
}
