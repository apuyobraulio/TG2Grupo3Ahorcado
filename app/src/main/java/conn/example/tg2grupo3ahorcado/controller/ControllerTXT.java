package conn.example.tg2grupo3ahorcado.controller;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import conn.example.tg2grupo3ahorcado.R;

public class ControllerTXT {


    public static void iniciarTxt(Context context){

        if(existe(context))return;

        try(InputStream is = context.getResources().openRawResource(R.raw.palabras);
            FileOutputStream fos = context.openFileOutput("palabras.txt", Context.MODE_PRIVATE)){
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) > 0){
                fos.write(buffer, 0, len);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static boolean existe(@NonNull Context context){
        return Arrays.stream(context.fileList())
                .peek(file -> Log.i("File: ", file))
                .anyMatch(file -> file.equals("palabras.txt"));
    }


    public static ArrayList<String> leerArchivoTxT(Context context){

        ArrayList <String> palabras= new ArrayList<>();

        try (FileInputStream fis = context.openFileInput("palabras.txt");
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr)){
                String linea;
                while ((linea = br.readLine()) != null) {
                    int i = 0;
                    i++;
                    palabras.add(linea);
                }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return palabras;
    }


}
