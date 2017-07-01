package com.tyddolphin.appmovilidad;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.tyddolphin.appmovilidad.datosfalsos.Ruta;
import com.tyddolphin.appmovilidad.rest.Alumno;
import com.tyddolphin.appmovilidad.rest.Movilidad;
import com.tyddolphin.appmovilidad.rest.Rest;
import com.tyddolphin.appmovilidad.rest.Ubicacion;
import com.tyddolphin.appmovilidad.signalr.SignalR;

/**
 * @author Gianella
 */

public class Hilo extends Thread{
    Rest rest;
    Ubicacion[] ruta;
    int i;
    Marker movilidad;
    Marker[] Alumnos;

    Handler handler;
    public Hilo(Context c,Marker m, Ubicacion inicio, Ubicacion fin, Marker[] a, Ubicacion[] paradas){
        handler = new Handler(c.getMainLooper());
        rest = new Rest(c);
        movilidad = m;
        Alumnos = a;
        rest.GenerarRutaCompleted = new Rest.RestListener<Ubicacion[]>() {
            @Override
            public void onRespuesta(Ubicacion[] respuesta) {
                ruta = respuesta;
                start();
            }
        };

        rest.GenerarRuta(inicio, fin, paradas);
    }
    @Override
    public void run() {
        for ( i = 0; i<ruta.length;i++){
            SignalR.NuevaUbicacion(1, ruta[i]);
            handler.post(new Runnable() {
                @Override
                public void run() {
                         movilidad.setPosition(new LatLng(ruta[i].Latitud,ruta[i].Longitud));

                }
            });
            if(i==37){
                SignalR.AlumnoRecogido(1,0);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Alumnos[0].setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        Alumnos[0].setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==55){
                SignalR.AlumnoRecogido(1,1);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Alumnos[1].setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        Alumnos[1].setSnippet("Estado: RECOGIDO");
                    }
                });
            }
            if(i==75){
                SignalR.AlumnoRecogido(1,2);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Alumnos[2].setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        Alumnos[2].setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==86){
                SignalR.AlumnoRecogido(1,3);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Alumnos[3].setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        Alumnos[3].setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==109){
                SignalR.AlumnoRecogido(1,4);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Alumnos[4].setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        Alumnos[4].setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            Log.i("Run",ruta[i].toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

