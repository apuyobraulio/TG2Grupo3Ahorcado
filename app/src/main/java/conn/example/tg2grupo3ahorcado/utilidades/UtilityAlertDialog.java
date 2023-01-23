package conn.example.tg2grupo3ahorcado.utilidades;

import android.content.Context;

public class UtilityAlertDialog {

    public static void launcAlertDialog(Context context,String title, String text, String button){
        new androidx.appcompat.app.AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(text)
                .setNegativeButton(button, null)
                .show();
    }

}
