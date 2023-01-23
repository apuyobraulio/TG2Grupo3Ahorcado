package conn.example.tg2grupo3ahorcado.utilidades;

import android.content.Context;
import android.content.Intent;

import conn.example.tg2grupo3ahorcado.view.PantallaPrincipalActivity;

public class Utiliy {

    public  static void lanzarActividad(Context contexto, Class clase){
        Intent intent = new Intent(contexto, clase);
        contexto.startActivity(intent);
    }
}
