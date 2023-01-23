package conn.example.tg2grupo3ahorcado.utilidades;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static String fechaTexto(Date date){
        return format.format(date);
    }

    public static Date fechaDate(String date){
        try{
        return format.parse(date);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Date obtenerFecha(){
        return Date.from(Instant.now());
    }

}
