package conn.example.tg2grupo3ahorcado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import conn.example.tg2grupo3ahorcado.R;

public class PantallaJuegoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        TextView txtfallos= findViewById(R.id.txtfallos);
        TextView txtletra1= findViewById(R.id.txtletra1);
        TextView txtletra2= findViewById(R.id.txtletra2);
        TextView txtletra3= findViewById(R.id.txtletra3);
        TextView txtletra4= findViewById(R.id.txtletra4);
        TextView txtletra5= findViewById(R.id.txtletra5);
        TextView txtletra6= findViewById(R.id.txtletra6);
        EditText txtpalabra= findViewById(R.id.txtpalabra);
        Button btncomprobar= findViewById(R.id.btncomprobar);

    }
}