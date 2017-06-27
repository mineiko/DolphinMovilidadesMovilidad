package com.tyddolphin.appmovilidad;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.tyddolphin.appmovilidad.datosfalsos.Ruta;
import com.tyddolphin.appmovilidad.signalr.SignalR;

/**
 * @author Gianella
 */

public class Hilo extends Thread{
    Ruta ruta;
    int i;
    private SignalR conexion;
    Marker movilidad;
    Marker alumno1;
    Marker alumno2;
    Marker alumno3;
    Marker alumno4;
    Handler handler;
    public Hilo(Context c, Marker m, Marker a1, Marker a2, Marker a3, Marker a4){
        conexion = new SignalR(c);
        handler = new Handler(c.getMainLooper());
        conexion.startSignalR();
        movilidad = m;
        alumno1 = a1;
        alumno2 = a2;
        alumno3 = a3;
        alumno4 = a4;
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
            if(i==15){
                conexion.AlumnoRecogido(0);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        alumno1.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        alumno1.setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==20){
                conexion.AlumnoRecogido(1);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        alumno2.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        alumno2.setSnippet("Estado: RECOGIDO");
                    }
                });
            }
            if(i==34){
                conexion.AlumnoRecogido(2);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        alumno3.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        alumno3.setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==40){
                conexion.AlumnoRecogido(3);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        alumno4.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        alumno4.setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            Log.i("Run",ruta.ruta[i].toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

