package conn.example.tg2grupo3ahorcado.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.util.Date;

import conn.example.tg2grupo3ahorcado.utilidades.DateUtil;

public class User implements Comparable<User>{
    String name;
    Integer mark;
    Date date;
    Integer seconds;

    public User(String name, Integer mark, Date date, Integer seconds) {
        this.name = name;
        this.mark = mark;
        this.date = date;
        this.seconds = seconds;
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

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @SuppressLint({"SimpleDateFormat", "DefaultLocale"})
    @NonNull
    @Override
    public String toString() {
        String dateString = DateUtil.toDate(date);
        return String.format("%s;%d;%s;%d",name, mark, dateString, seconds);
    }

    @Override
    public int compareTo(@NonNull User compare) {
        if (this.mark > compare.getMark()){
            return -1;
        }
        else if (this.mark < compare.getMark()){
            return 1;
        }
        else {
            return this.seconds.compareTo(compare.getSeconds());
        }
    }

    @SuppressLint({"DefaultLocale", "SimpleDateFormat"})
    public String mostrarDatos(){
        String dateString = DateUtil.toDate(date);
        return String.format("%s,  %d,  %s, %d s.\n",name, mark, dateString, seconds);
    }
}
