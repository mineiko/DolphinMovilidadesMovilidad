package com.tyddolphin.appmovilidad;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.tyddolphin.appmovilidad.datosfalsos.Ruta;
import com.tyddolphin.appmovilidad.signalr.SignalR;

/**
 * Created by Gianella Milon on 22/06/2017.
 */

public class Hilo extends Thread{
    Ruta ruta;
    int i;
    SignalR conexion;
    Marker movilidad;
    Handler handler;
    public Hilo(Context c, Marker m){
        conexion = new SignalR(c);
        handler = new Handler(c.getMainLooper());
        conexion.startSignalR();
        movilidad = m;
    }
    @Override
    public void run() {
        ruta = new Ruta();
        for ( i = 0; i<ruta.ruta.length;i++){
            conexion.NuevaUbicacion(ruta.ruta[i]);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    movilidad.setPosition(new LatLng(ruta.ruta[i].Latitud,ruta.ruta[i].Longitud));
                }
            });

            Log.i("Run",ruta.ruta[i].toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
