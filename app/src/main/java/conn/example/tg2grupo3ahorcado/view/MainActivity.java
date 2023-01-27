package conn.example.tg2grupo3ahorcado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;

import conn.example.tg2grupo3ahorcado.R;
import conn.example.tg2grupo3ahorcado.controller.ControllerTXT;
import conn.example.tg2grupo3ahorcado.model.ListaPalabras;
import conn.example.tg2grupo3ahorcado.utilidades.IntentUtility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(Looper.myLooper());

        handler.postDelayed(()-> {
            IntentUtility.lanzarActividad(this,PantallaPrincipalActivity.class);
            finish();
        }, 1500);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ControllerTXT.iniciarTxt(this);
        ArrayList <String> palabras = ControllerTXT.leerArchivoTxT(this);

        ListaPalabras lista = new ListaPalabras(palabras);

    }
}