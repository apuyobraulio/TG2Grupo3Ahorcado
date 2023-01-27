package conn.example.tg2grupo3ahorcado.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import conn.example.tg2grupo3ahorcado.R;
import conn.example.tg2grupo3ahorcado.controller.ControllerCSV;
import conn.example.tg2grupo3ahorcado.controller.ControllerGame;
import conn.example.tg2grupo3ahorcado.controller.Counter;
import conn.example.tg2grupo3ahorcado.model.ListaPalabras;
import conn.example.tg2grupo3ahorcado.model.User;
import conn.example.tg2grupo3ahorcado.utilidades.DateUtil;

public class PantallaJuegoActivity extends AppCompatActivity{

    private final ArrayList<Character> letras = new ArrayList<>();
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
    TextView txtfallos;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pedirNombre();
        setContentView(R.layout.activity_pantalla_juego);
        txtfallos = findViewById(R.id.txtfallos);
        img = findViewById(R.id.imgahorcado);
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
                if(posiciones.isEmpty()) txtfallos.append(intent);
                addAciertos(posiciones, intent);
                if(!letras.contains(letra)){
                    letras.add(letra);
                }
                comprobarVictoria();
            }
            comprobarVidas();
            txtpalabra.setText("");
        });

    }

    private void pedirNombre() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);


        final EditText input = new EditText(this);
        input.setHint("Nombre");
        layout.addView(input);


        new AlertDialog.Builder(this).setView(layout)
            .setPositiveButton("OK", (dialog, which) -> nombreJugador = input.getText().toString())
            .setNegativeButton("Cancel", (v, x) -> finish())
            .setTitle("Nombre del jugador")
            .setMessage("Introduce tu nombre")
            .show();
    }

    private void comprobarVictoria() {
        boolean victoria = true;
        for (Character c : palabra.toCharArray()) {
            if (!letras.contains(c)) {
                victoria = false;
                break;
            }
        }
        if (victoria) gameWinner();
    }

    private void comprobarVidas() {
        switch (game.getVidas()){
            case 0: {
                img.setImageResource(R.drawable.cuerpoentero);
                gameLoser();
                break;
            }
            case 1: {
                img.setImageResource(R.drawable.pieizquierdo);
                break;
            }
            case 2: {
                img.setImageResource(R.drawable.brazoizquierdo);
                break;
            }
            case 3: {
                img.setImageResource(R.drawable.brazoderecho);
                break;
            }
            case 4: {
                img.setImageResource(R.drawable.cuerpo);
                break;
            }
            case 5: {
                img.setImageResource(R.drawable.cabeza);
                break;
            }
        }
    }

    private void gameLoser() {
        counter.finalizar();
        new AlertDialog.Builder(this)
                .setTitle("Derrota")
                .setMessage("No has sido capaz de acertar la palabra.\nLa palabra correcta era: " + palabra)
                .setPositiveButton("Volver a jugar", (v, x) -> nuevoJuego())
                .setNegativeButton("Cancelar", (v, x) -> finish())
                .setOnCancelListener(v -> finish())
                .show();
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
                .setPositiveButton("Volver a jugar", (v, x) -> nuevoJuego())
                .setNegativeButton("Cancelar", (v, x) -> finish())
                .setOnCancelListener(v -> finish())
                .show();
    }

    private void nuevoJuego() {
        onStart();
        txtletra1.setText("");
        txtletra2.setText("");
        txtletra3.setText("");
        txtletra4.setText("");
        txtletra5.setText("");
        txtletra6.setText("");
        txtfallos.setText("");
        img.setImageResource(R.drawable.patibulo);
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
        if(counter == null || !counter.isRunning()) counter = new Counter(count ->
                runOnUiThread(() -> txtDato.setText(String.valueOf(count))));
    }
}