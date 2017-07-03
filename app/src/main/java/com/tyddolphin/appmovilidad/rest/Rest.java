package com.tyddolphin.appmovilidad.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tyddolphin.appmovilidad.dto.DtoGenerarRuta;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Gianella
 */

public class Rest {

    public interface OnRutaGeneradaCallback{
        void onRutaGenerada(Ubicacion[] ruta);
    }

    public interface OnMovilidadObtenidaCallback{
        void onMovilidadObtenida(Movilidad movilidad);
    }

    Context Contexto;
    public Rest(Context c){
        this.Contexto=c;

    }


    public void GenerarRuta(Ubicacion inicio, Ubicacion fin, Ubicacion[] paradas, final OnRutaGeneradaCallback onRutaGeneradaCallback){
        try{
            String url = "http://movilidadessignalr20170616114841.azurewebsites.net/ServicioMock.svc/ruta";

            DtoGenerarRuta dto = new DtoGenerarRuta();
            dto.setInicio(inicio);
            dto.setFin(fin);
            dto.setParadas(paradas);

            Gson gson = new Gson();
            String json = gson.toJson(dto);

            JSONObject body = new JSONObject(json);

            JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url, body, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Ubicacion[] ruta = new Gson().fromJson(response.toString(), Ubicacion[].class);
                    onRutaGeneradaCallback.onRutaGenerada(ruta);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(Contexto);
            request.setTag("rest");
            requestQueue.add(request);
        }catch (Exception e){
            Log.e("Rest", e.getMessage());
            e.printStackTrace();
        }
    }


    public void GetInfoMovilidad(int id, final OnMovilidadObtenidaCallback onMovilidadObtenidaCallback){


        try {
            String url = "http://movilidadessignalr20170616114841.azurewebsites.net/ServicioMock.svc/movilidades/"+id;


            JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.i("rest", response.toString());
                    Gson gson = new Gson();
                    Movilidad mov = gson.fromJson(response.toString(),Movilidad.class);
                    Log.i("","");
                    onMovilidadObtenidaCallback.onMovilidadObtenida(mov);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("rest", error.getMessage());
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(Contexto);
            request.setTag("rest");
            requestQueue.add(request);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
