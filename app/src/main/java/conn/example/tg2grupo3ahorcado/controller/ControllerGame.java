package conn.example.tg2grupo3ahorcado.controller;

import java.util.ArrayList;

public class ControllerGame {

    private final String palabra;
    private int vidas;

    public ControllerGame(String palabra){
        this.palabra = palabra;
        this.vidas = 6;
    }

    public boolean introducirPalabra(String intento){
        if(this.palabra.equals(intento)){
            return true;
        }
        vidas--;
        return false;
    }

    public ArrayList<Integer> introducirLetra(char letra){
        ArrayList<Integer> posiciones = new ArrayList<>();
        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            if (letra == letras[i]) posiciones.add(i);
        }
        if (posiciones.isEmpty()) vidas--;
        return posiciones;
    }

    public int getVidas() {
        return vidas;
    }
}
