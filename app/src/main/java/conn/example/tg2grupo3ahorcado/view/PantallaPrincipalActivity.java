package conn.example.tg2grupo3ahorcado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import conn.example.tg2grupo3ahorcado.R;
import conn.example.tg2grupo3ahorcado.controller.ControllerCSV;
import conn.example.tg2grupo3ahorcado.model.User;
import conn.example.tg2grupo3ahorcado.utilidades.SoundsUtil;
import conn.example.tg2grupo3ahorcado.utilidades.UtilityAlertDialog;
import conn.example.tg2grupo3ahorcado.utilidades.IntentUtility;

public class PantallaPrincipalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Button btnIniciarPartida = findViewById(R.id.btnIniciarPartida);
        btnIniciarPartida.setOnClickListener(v -> {
            IntentUtility.lanzarActividad(this,PantallaJuegoActivity.class);
            SoundsUtil.pararMusica();

        });
        Button btnRanking = findViewById(R.id.btnRanking);
        btnRanking.setOnClickListener(v->{

            if(mostrarMejores().isEmpty()){
                UtilityAlertDialog.launchAlertDialog(this,getString(R.string.ranking), getString(R.string.no_ranking),getString(R.string.cerrar));
            } else{
                UtilityAlertDialog.launchAlertDialog(this, getString(R.string.ranking), mostrarMejores(),getString(R.string.cerrar));
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