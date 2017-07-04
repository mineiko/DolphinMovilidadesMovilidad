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
    int j;
    Movilidad movilidad;
    Marker MarcadorMovilidad;
    Marker[] MarcadoresAlumnos;

    Handler handler;
    public Hilo(Context c, Movilidad _movilidad, Marker m_movilidad, Marker[] m_alumnos, Ubicacion inicio, Ubicacion fin, Ubicacion[] paradas){
        handler = new Handler(c.getMainLooper());
        rest = new Rest(c);
        movilidad = _movilidad;
        MarcadoresAlumnos = m_alumnos;
        MarcadorMovilidad = m_movilidad;


        rest.GenerarRuta(inicio, fin, paradas,new Rest.OnRutaGeneradaCallback() {
            @Override
            public void onRutaGenerada(Ubicacion[] _ruta) {
                ruta = _ruta;
                start();
            }
        } );
    }
    @Override
    public void run() {
        for ( i = 0; i<ruta.length;i++){
            SignalR.NuevaUbicacion(movilidad.Id, ruta[i]);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    MarcadorMovilidad.setPosition(new LatLng(ruta[i].Latitud,ruta[i].Longitud));
                }
            });

            for (j = 0; j < movilidad.Alumnos.length; j++){
                if (ruta[i].equals(movilidad.Alumnos[j].Casa)){
                    SignalR.AlumnoRecogido(movilidad.Id,movilidad.Alumnos[j].Id);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            MarcadoresAlumnos[j].setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_celeste));
                            MarcadoresAlumnos[j].setSnippet("Estado: RECOGIDO");
                        }
                    });
                    break;
                }
            }


            Log.i("Run",ruta[i].toString());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

