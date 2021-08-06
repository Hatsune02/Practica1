package com.navi;

public class SepararString {
    public static String texto;
    public static String[] palabras = new String[500];
    public static int cantidadPalabras = 0;
    public static int[] posiciones = new int[500];
    public static int cantidadPosiciones = 0;


    public static void separarString(){
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == ' ' || texto.charAt(i) == '\n' || texto.charAt(i) == '\t'){
                posiciones[cantidadPosiciones] = i;
                cantidadPosiciones++;
            }
        }
        if(cantidadPosiciones == 0){
            palabras[cantidadPalabras] = texto;
            cantidadPalabras++;
        }
        else{
            for (int i = 0; i < cantidadPosiciones+1; i++) {
                if (i == 0){
                    palabras[cantidadPalabras] = texto.substring(0, posiciones[i]);
                    cantidadPalabras++;
                }
                else if(i < cantidadPosiciones){
                    palabras[cantidadPalabras] = texto.substring(posiciones[i-1]+1, posiciones[i]);
                    cantidadPalabras++;
                }
                else if(i == cantidadPosiciones){
                    palabras[cantidadPalabras] = texto.substring(posiciones[i-1]+1, texto.length());
                    cantidadPalabras++;
                }

            }
        }

        System.out.println(cantidadPalabras);
        for (int i = 0; i < cantidadPalabras; i++) {
            System.out.println(palabras[i]);
        }

    }
}
