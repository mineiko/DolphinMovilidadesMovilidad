package com.tyddolphin.appmovilidad;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.view.View;

/**
 * Created by Gianella Milon on 29/06/2017.
 */

public class Notificaciones  {
    int id;
    Context contexto;
    Class Clase;
    String Title;
    String ContentText;



    public Notificaciones(int i,Context c, Class cl, String t, String CT){
        id = i;
        contexto = c;
        Clase = cl;
        Title = t;
        ContentText = CT;
        GenerarNotificacion();
    }

    public void GenerarNotificacion(){
        Intent intent = new Intent(contexto, Clase);
        PendingIntent pendingIntent = PendingIntent.getActivity(contexto, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(contexto);
        builder.setSmallIcon(R.drawable.ic_directions_bus_black_36dp);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(contexto.getResources(), R.drawable.icono));
        builder.setContentTitle(Title);
        builder.setContentText(ContentText);
        NotificationManager notificationManager = (NotificationManager) contexto.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id,builder.build());
    }


}
