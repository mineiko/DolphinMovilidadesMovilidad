package com.tyddolphin.appmovilidad;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.tyddolphin.appmovilidad.datosfalsos.Ruta;
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

    Handler handler;
    public Hilo(Context c,Marker m, Ubicacion inicio, Ubicacion fin, Ubicacion[] paradas){
        handler = new Handler(c.getMainLooper());
        rest = new Rest(c);
        movilidad = m;
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
                        //alumno1.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        //alumno1.setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==55){
                SignalR.AlumnoRecogido(1,1);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //alumno2.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        //alumno2.setSnippet("Estado: RECOGIDO");
                    }
                });
            }
            if(i==75){
                SignalR.AlumnoRecogido(1,2);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //alumno3.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        //alumno3.setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==86){
                SignalR.AlumnoRecogido(1,3);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //alumno4.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        //alumno4.setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            if(i==109){
                SignalR.AlumnoRecogido(1,4);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //alumno4.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                        //alumno4.setSnippet("Estado: RECOGIDO");

                    }
                });
            }
            Log.i("Run",ruta[i].toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

