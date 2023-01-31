package conn.example.tg2grupo3ahorcado.utilidades;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundsUtil {

     static MediaPlayer mediaPlayer;
    public static void reproducirMusica(Context context, int recurso){

        mediaPlayer = MediaPlayer.create(context, recurso);
        mediaPlayer.start();
    }

    public static void pararMusica(){
        mediaPlayer.stop();
    }

}
