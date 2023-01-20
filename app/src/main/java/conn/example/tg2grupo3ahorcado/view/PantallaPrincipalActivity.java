package conn.example.tg2grupo3ahorcado.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import conn.example.tg2grupo3ahorcado.R;
import conn.example.tg2grupo3ahorcado.controller.ControllerCSV;
import conn.example.tg2grupo3ahorcado.model.User;

public class PantallaPrincipalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Button btnIniciarPartida = findViewById(R.id.btnIniciarPartida);
        btnIniciarPartida.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PantallaJuegoActivity.class);
            startActivity(intent);
        });
        Button btnRanking = findViewById(R.id.btnRanking);
        btnRanking.setOnClickListener(v->{


            new AlertDialog.Builder(this)
                    .setTitle("Lista de mejores partidas")
                    .setMessage(mostrarMejores())
                    .setNegativeButton("Cerrar", null)
                    .show();
        });

    }
    private String mostrarMejores(){
        StringBuilder builder = new StringBuilder();
        for (User u :ControllerCSV.bestMarks(this)) {
            builder.append(u.mostrarDatos());

        }
        return builder.toString();
    }
}