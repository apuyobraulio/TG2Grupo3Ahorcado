package conn.example.tg2grupo3ahorcado.utilidades;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateUtil {
    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static String toDate(Date date){
        return format.format(date);
    }

    public static Date fromString(String date){
        try{
        return format.parse(date);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Date now(){
        return Date.from(Instant.now());
    }

}
