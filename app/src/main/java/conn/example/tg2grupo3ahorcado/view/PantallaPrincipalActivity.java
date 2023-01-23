package conn.example.tg2grupo3ahorcado.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import conn.example.tg2grupo3ahorcado.R;
import conn.example.tg2grupo3ahorcado.controller.ControllerCSV;
import conn.example.tg2grupo3ahorcado.model.User;
import conn.example.tg2grupo3ahorcado.utilidades.UtilityAlertDialog;
import conn.example.tg2grupo3ahorcado.utilidades.Utiliy;

public class PantallaPrincipalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Button btnIniciarPartida = findViewById(R.id.btnIniciarPartida);
        btnIniciarPartida.setOnClickListener(v -> {
            Utiliy.lanzarActividad(this,PantallaJuegoActivity.class);

        });
        Button btnRanking = findViewById(R.id.btnRanking);
        btnRanking.setOnClickListener(v->{
            String textoMostrar = mostrarMejores();

            if(mostrarMejores().isEmpty()){
                UtilityAlertDialog.launcAlertDialog(this,"Ranking", "No se han encotrado partidas","Cerrar");
            } else{
                UtilityAlertDialog.launcAlertDialog(this, "Ranking", mostrarMejores(),"Cerrar");
            }

        });

    }
    private String mostrarMejores(){
        StringBuilder builder = new StringBuilder();
        for (User user :ControllerCSV.bestMarks(this)) {
            builder.append(user.mostrarDatos());

        }
        return builder.toString();
    }
}