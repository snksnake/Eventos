package org.example.eventos;

import android.content.Context;
import android.content.Intent;

public class Comun {
    static void mostrarDialogo(final Context context
            , final String mensaje) {
        Intent intent = new Intent(context, Dialogo.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("mensaje", mensaje);
        context.startActivity(intent);
    }
}
