package conn.example.tg2grupo3ahorcado.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Comparable<User>{
    String name;
    Integer mark;
    Date date;

    public User(String name, Integer mark, Date date) {
        this.name = name;
        this.mark = mark;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @SuppressLint({"SimpleDateFormat", "DefaultLocale"})
    @NonNull
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = format.format(date);
        return String.format("%s;%d;%s",name, mark, dateString);
    }

    @Override
    public int compareTo(@NonNull User compare) {
        if (this.mark > compare.getMark()){
            return 1;
        }
        else if (this.mark < compare.getMark()){
            return -1;
        }
        else {
            return this.date.compareTo(compare.getDate());
        }
    }

    public String mostrarDatos(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = format.format(date);
        return String.format("Nombre: %s  Puntuación: %d  Fecha:  %s",name, mark, dateString);
    }
}
