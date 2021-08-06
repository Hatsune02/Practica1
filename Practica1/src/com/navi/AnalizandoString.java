package com.navi;

import javax.swing.*;

public class AnalizandoString {
    public static TipoToken[] tokens = new TipoToken[100];
    public static int cantidadTokens = 0;

    public static void analizarString(){
        cantidadTokens = 0;
        for (int i = 0; i < SepararString.cantidadPalabras; i++) {
            if(esId(SepararString.palabras[i])){
                tokens[cantidadTokens] = TipoToken.IDENTIFICADOR;
            }
            else if(esNumeroEntero(SepararString.palabras[i])){
                tokens[cantidadTokens] = TipoToken.NUMEROENTERO;
            }
            else if(esDecimal(SepararString.palabras[i])){
                tokens[cantidadTokens] = TipoToken.DECIMAL;
            }
            else if(esSimbolo(SepararString.palabras[i])){
                tokens[cantidadTokens] = TipoToken.SIMBOLO;
            }
            else{
                tokens[cantidadTokens] = TipoToken.ERROR;
            }
            cantidadTokens++;
        }
    }

    public static String mostrarTokens(){
        String texto = "";
        for (int i = 0; i < cantidadTokens; i++) {
            texto = texto + "Tipo: " + tokens[i].getTipo() + "\nTexto: " + SepararString.palabras[i] + "\n\n";
        }
        return texto;
    }

    public static boolean esLetra(char letra){
        char[] alfabeto = {'a', 'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
                'v','w','x','y','z','A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',
                'V','W','X','Q','Z'
        };
        for (int i = 0; i < alfabeto.length; i++) {
            if(letra == alfabeto[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean esId(String valor){
        boolean siEs = false;

        for (int i = 0; i < valor.length(); i++) {
            if(i == 0){
                if(esNumeroEntero(valor.charAt(i))){
                    return false;
                }
                else if(esLetra(valor.charAt(i))){
                    siEs = true;
                }
            }
            else{
                if(esNumeroEntero(valor.charAt(i)) || esLetra(valor.charAt(i))){
                    siEs = true;
                }
                else{
                    siEs = false;
                }
            }
        }
        return siEs;
    }
    public static boolean esNumeroEntero(String valor){
        try{
            var n =Integer.parseInt(valor);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public static boolean esNumeroEntero(char valor){
        try{
            var n =Integer.parseInt(String.valueOf(valor));
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public static boolean esDecimal(String valor){
        try{
            var n =Float.parseFloat(valor);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public static boolean esSimbolo(String valor){
        boolean siEs = false;
        for (int i = 0; i < valor.length(); i++) {
            if(valor.charAt(i) == '[' || valor.charAt(i) == ']' || valor.charAt(i) == '{' || valor.charAt(i) == '}' || valor.charAt(i) == ';' || valor.charAt(i) == ','){
                siEs = true;
            }
            else {
                siEs = false;
            }
        }
        return siEs;
    }
}
