package com.tyddolphin.appmovilidad.rest;

/**
 * @author Gianella
 */

public class Ubicacion {
    public double Latitud;
    public double Longitud;
    public Ubicacion(double lat, double lng){
        Latitud = lat;
        Longitud = lng;
    }

    @Override
    public String toString() {
        return "lat: " + Latitud + ", lng: " + Longitud;
    }

    @Override
    public boolean equals(Object obj) {
        Ubicacion otro = (Ubicacion)obj;
        double deltaLatitud = Math.abs(this.Latitud - otro.Latitud);
        double deltaLongitud= Math.abs(this.Longitud - otro.Longitud);
        if (deltaLatitud <= 0.0001 && deltaLongitud <= 0.0001)
            return true;
        else
            return false;
    }
}
