package conn.example.tg2grupo3ahorcado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import conn.example.tg2grupo3ahorcado.R;
import conn.example.tg2grupo3ahorcado.controller.Counter;

public class PantallaJuegoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        TextView txtfallos= findViewById(R.id.txtfallos);

        TextView txtletra1= findViewById(R.id.txtletra1);
        txtletra1.setPaintFlags(txtletra1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView txtletra2= findViewById(R.id.txtletra2);
        txtletra2.setPaintFlags(txtletra2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView txtletra3= findViewById(R.id.txtletra3);
        txtletra3.setPaintFlags(txtletra3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView txtletra4= findViewById(R.id.txtletra4);
        txtletra4.setPaintFlags(txtletra4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView txtletra5= findViewById(R.id.txtletra5);
        txtletra5.setPaintFlags(txtletra5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView txtletra6= findViewById(R.id.txtletra6);
        txtletra6.setPaintFlags(txtletra6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        EditText txtpalabra= findViewById(R.id.txtpalabra);
        Button btncomprobar= findViewById(R.id.btncomprobar);

        btncomprobar.setOnClickListener(v ->{

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView txtDato = findViewById(R.id.txtcontador);
        Counter counter = new Counter(count ->
                runOnUiThread(() -> txtDato.setText(String.valueOf(count))));
    }
}