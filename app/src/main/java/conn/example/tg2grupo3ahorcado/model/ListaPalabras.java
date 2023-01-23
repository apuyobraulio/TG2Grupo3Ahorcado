package conn.example.tg2grupo3ahorcado.model;

import java.util.ArrayList;
import java.util.Random;

public class ListaPalabras {
    private static ArrayList<String> listado;

    public ListaPalabras(ArrayList<String> listado) {
        this.listado = listado;
    }

    public static String getRandom(){
        Random random = new Random();
        int position = random.nextInt(listado.size());
        return listado.get(position);
    }
}
