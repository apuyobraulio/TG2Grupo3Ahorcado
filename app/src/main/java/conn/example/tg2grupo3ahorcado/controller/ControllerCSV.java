package conn.example.tg2grupo3ahorcado.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import conn.example.tg2grupo3ahorcado.model.User;

public class ControllerCSV {

    private final static String FILE = "results.csv";

    @SuppressLint("SimpleDateFormat")
    @NonNull
    public static List<User> bestMarks(Context context) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<User> users = new ArrayList<>();
        try (FileInputStream fis = context.openFileInput(FILE);
             InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            reader.readLine();
            String line ;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                users.add(new User(
                        data[0],
                        Integer.valueOf(data[1]),
                        format.parse(data[2])
                ));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return users.stream().sorted().collect(Collectors.toList());
    }

    public static boolean registrar(Context context, @NonNull User user){
        iniciarFichero(context);
        return escribir(context, user.toString());
    }

    private static void iniciarFichero(@NonNull Context context){
        if(existe(context)) {
            return;
        }
        escribir(context, "Name;Mark;Date");
    }

    private static boolean existe(@NonNull Context context){
        return Arrays.stream(context.fileList())
                .peek(file -> Log.i("File: ", file))
                .anyMatch(file -> file.equals(FILE));
    }

    private static boolean escribir(Context context, String data) {
        try(FileOutputStream out = context.openFileOutput(FILE, Context.MODE_APPEND);
            PrintWriter writer = new PrintWriter(out)){
            writer.println(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
