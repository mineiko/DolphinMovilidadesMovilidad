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
}
