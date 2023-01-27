package conn.example.tg2grupo3ahorcado.controller;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Observable;
import java.util.stream.Stream;

public class ControllerGame{

    private final String palabra;
    private int vidas;
    private Stream<Character> letter;

    public ControllerGame(@NonNull String palabra){
        this.palabra = palabra.toUpperCase(Locale.ROOT);
        this.vidas = 6;
    }

    public boolean introducirPalabra(String intento){
        if(this.palabra.equals(intento.toUpperCase(Locale.ROOT))){
            return true;
        }
        vidas--;
        return false;
    }

    public ArrayList<Integer> introducirLetra(char letra){
        ArrayList<Integer> posiciones = new ArrayList<>();
        char[] letras = palabra.toCharArray();
        letra = Character.toUpperCase(letra);
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
