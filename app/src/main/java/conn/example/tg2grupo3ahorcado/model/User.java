package conn.example.tg2grupo3ahorcado.model;

public class User {
    String name;
    String mark;
    String date;

    public User() {
    }

    public User(String name, String mark, String date) {
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s",name, mark, date);
    }
}
