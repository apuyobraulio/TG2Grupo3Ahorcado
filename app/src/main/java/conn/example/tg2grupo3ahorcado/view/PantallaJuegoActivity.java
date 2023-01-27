package conn.example.tg2grupo3ahorcado.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import conn.example.tg2grupo3ahorcado.R;
import conn.example.tg2grupo3ahorcado.controller.ControllerCSV;
import conn.example.tg2grupo3ahorcado.controller.ControllerGame;
import conn.example.tg2grupo3ahorcado.controller.Counter;
import conn.example.tg2grupo3ahorcado.model.ListaPalabras;
import conn.example.tg2grupo3ahorcado.model.User;
import conn.example.tg2grupo3ahorcado.utilidades.DateUtil;
import conn.example.tg2grupo3ahorcado.utilidades.UtilityAlertDialog;

public class PantallaJuegoActivity extends AppCompatActivity{

    private ArrayList<Character> letras = new ArrayList<>();
    String palabra;
    private Counter counter;
    private ControllerGame game;
    String nombreJugador;
    TextView txtletra1;
    TextView txtletra2;
    TextView txtletra3;
    TextView txtletra4;
    TextView txtletra5;
    TextView txtletra6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nombreJugador= UtilityAlertDialog.dialogoJugador(this);
        setContentView(R.layout.activity_pantalla_juego);

        TextView txtfallos= findViewById(R.id.txtfallos);

        txtletra1= findViewById(R.id.txtletra1);
        txtletra1.setPaintFlags(txtletra1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtletra2= findViewById(R.id.txtletra2);
        txtletra2.setPaintFlags(txtletra2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtletra3= findViewById(R.id.txtletra3);
        txtletra3.setPaintFlags(txtletra3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtletra4= findViewById(R.id.txtletra4);
        txtletra4.setPaintFlags(txtletra4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtletra5= findViewById(R.id.txtletra5);
        txtletra5.setPaintFlags(txtletra5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtletra6= findViewById(R.id.txtletra6);
        txtletra6.setPaintFlags(txtletra6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        EditText txtpalabra= findViewById(R.id.txtpalabra);
        Button btncomprobar= findViewById(R.id.btncomprobar);

        btncomprobar.setOnClickListener(v ->{
            String intent = txtpalabra.getText().toString();
            if (intent.length() != 1 && intent.length() != 6){
                alertaCaracteres();
                return;
            }
            if(intent.length() == 6){
                if(game.introducirPalabra(intent)){
                    gameWinner();
                }
                else palabraFallada(intent);
            }
            if(intent.length() == 1){
                Character letra = intent.charAt(0);
                ArrayList<Integer> posiciones = game.introducirLetra(letra);
                if(posiciones.isEmpty());
                addAciertos(posiciones, intent);
                if(!letras.contains(letra)){
                    letras.add(letra);
                }
                comprobarVictoria();
            }
            comprobarVidas();

        });

    }

    private void comprobarVictoria() {
        boolean victoria = true;
        for (Character c : palabra.toCharArray()) {
            if(!letras.contains(c)) victoria = false;
        }
        if (victoria) gameWinner();
    }

    private void comprobarVidas() {
    }

    private void addAciertos(@NonNull ArrayList<Integer> posiciones, String letra) {
        for (Integer posicion : posiciones) {
            switch (posicion){
                case 0: {
                    txtletra1.setText(letra);
                    break;
                }
                case 1: {
                    txtletra2.setText(letra);
                    break;
                }
                case 2: {
                    txtletra3.setText(letra);
                    break;
                }
                case 3: {
                    txtletra4.setText(letra);
                    break;
                }
                case 4: {
                    txtletra5.setText(letra);
                    break;
                }
                case 5: {
                    txtletra6.setText(letra);
                    break;
                }
            }
        }
    }

    private void palabraFallada(String intent) {
        new AlertDialog.Builder(this)
                .setTitle("Palabra erronea")
                .setMessage(String.format("La palabra %s no es la correcta sigue probando", intent))
                .setPositiveButton("Ok", null)
                .show();
    }

    private void gameWinner() {
        int timer = counter.finalizar();
        User user = new User(nombreJugador, game.getVidas(), DateUtil.now(), timer);
        ControllerCSV.registrar(this, user);
        new AlertDialog.Builder(this)
                .setTitle("Victoria")
                .setMessage("Enhorabuena has acertado la palabra")
                .setPositiveButton("Ok", null)
                .show();
    }

    private void alertaCaracteres() {
        new AlertDialog.Builder(this)
                .setTitle("Caracteres mal introducidos")
                .setMessage("Solo puedes introducir una letra o una palabra de 6 letras")
                .setPositiveButton("Ok", null)
                .show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        palabra = ListaPalabras.getRandom();
        game = new ControllerGame(palabra);
        TextView txtDato = findViewById(R.id.txtcontador);
        counter = new Counter(count ->
                runOnUiThread(() -> txtDato.setText(String.valueOf(count))));
    }
}