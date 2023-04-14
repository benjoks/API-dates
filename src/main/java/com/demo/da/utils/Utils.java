package com.demo.da.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Utils {
    public static String digitoVerificador(String rut){
        int num;
        try {
            num = Integer.parseInt(rut);
        } catch (NumberFormatException e) {
            return "400";
        }
        int suma = 0;
        int multiplicador = 2;
        for (int i = rut.length() - 1; i >= 0; i--) {
            suma += multiplicador * Character.getNumericValue(rut.charAt(i));
            multiplicador++;
            if (multiplicador == 8) {
                multiplicador = 2;
            }
        }
        int resto = suma % 11;
        String dvEsperado;
        if (resto == 1) {
            dvEsperado = "K";
        } else if (resto == 0) {
            dvEsperado = "0";
        } else {
            dvEsperado = Integer.toString(11 - resto);
        }
        return dvEsperado;
    }

    public static boolean verificarFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate.parse(fecha,formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
