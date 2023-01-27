package conn.example.tg2grupo3ahorcado.utilidades;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;

public class UtilityAlertDialog {

    public static void launchAlertDialog(Context context, String title, String text, String button){
        new androidx.appcompat.app.AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(text)
                .setNegativeButton(button, null)
                .show();
    }

    public static String dialogoJugador(Context context){
        final String[] text = new String[1];
        AlertDialog.Builder builder = new AlertDialog.Builder(context);


        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);


        final EditText input = new EditText(context);
        input.setHint("Nombre");
        layout.addView(input);


        builder.setView(layout);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                text[0] = input.getText().toString();

            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.setTitle("Nombre del jugador");
        builder.setMessage("Introduce tu nombre");


        AlertDialog dialog = builder.create();
        dialog.show();

        return text[0];

    }

}
