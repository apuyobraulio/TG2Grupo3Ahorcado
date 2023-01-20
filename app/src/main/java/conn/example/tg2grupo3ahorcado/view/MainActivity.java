package conn.example.tg2grupo3ahorcado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import conn.example.tg2grupo3ahorcado.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(Looper.myLooper());

        handler.postDelayed(()-> {
            Intent intent = new Intent(getApplicationContext(),PantallaPrincipalActivity.class);
            startActivity(intent);
            finish();
        }, 1500);

    }
}