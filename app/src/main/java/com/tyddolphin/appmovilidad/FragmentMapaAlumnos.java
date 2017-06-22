package com.tyddolphin.appmovilidad;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.tyddolphin.appmovilidad.datosfalsos.Ruta;
import com.tyddolphin.appmovilidad.rest.Ubicacion;


public class FragmentMapaAlumnos extends Fragment {

    MapView mMapView;
    GoogleMap googlemap;
    LinearLayout mLinearLayout;
    Marker Movilidad;

    //Clases
    class Notificaciones implements View.OnClickListener{
        int id;
        Notificaciones(int i){
            id = i;
        }
        @Override
        public void onClick(View view) {
            //Construccion de la accion del intent implicito
            Intent intent= new Intent(getContext(),FragmentMapaAlumnos.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(getContext(),0,intent,0);
            //Construccion de la notificacion;
            NotificationCompat.Builder builder= new NotificationCompat.Builder(getContext());
            builder.setSmallIcon(R.drawable.ic_directions_bus_black_36dp);
            builder.setContentIntent(pendingIntent);
            builder.setAutoCancel(true);
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icono));
            //Polyline a = new Polyline();
            if (id==0){
                builder.setContentTitle("Movilidad : José");
                builder.setContentText("Inicio su Recorrido");
                MarkerOptions moMovilidades = new MarkerOptions()
                        .position(new LatLng(-16.449572, -71.536306))
                        .title("Movilidad : José ").snippet("Llega en 5 min")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_36dp));
               Movilidad = googlemap.addMarker(moMovilidades);

            }
            if (id==1){
                builder.setContentTitle("Movilidad : José");
                builder.setContentText("Acaba de recoger a su Hij@ : María");

            }
            if (id==2){
                builder.setContentTitle("Movilidad : José");
                builder.setContentText("Alerta : Accidente");

            }
            //Enviar la notificacion
            NotificationManager notificationManager= (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id,builder.build());
        }
    }

    public FragmentMapaAlumnos() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa_alumnos, container, false);

        //Mapa
        mMapView = (MapView) view.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        MapsInitializer.initialize(getActivity().getApplicationContext());
        mMapView.getMapAsync(new OnMapReadyCallback() {
            public void onMapReady(GoogleMap _googleMap) {

                googlemap = _googleMap;
                googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-16.449572, -71.536306), 18));
                dibujarPolyline();
            }
        });

        //Botones
        mLinearLayout = (LinearLayout) view.findViewById(R.id.btn);

        Button btnA = new Button(super.getContext());
        Button btnB = new Button(super.getContext());
        Button btnC = new Button(super.getContext());
        Button btnD = new Button(super.getContext());
        btnA.setText("Inicio Recorrido");
        btnA.setOnClickListener(new Notificaciones(0));
        btnB.setText("Recogio Alumno");
        btnB.setOnClickListener(new Notificaciones(1));
        btnC.setText("Alerta Accidente");
        btnC.setOnClickListener(new Notificaciones(2));
        //btnD.setText("Inicio Recorrido");

        mLinearLayout.addView(btnA);
        mLinearLayout.addView(btnB);
        mLinearLayout.addView(btnC);



        return view;
    }

    private void dibujarPolyline(){
        Ubicacion[] ruta = new Ruta().ruta;
        PolylineOptions po = new PolylineOptions();
        for(Ubicacion ubicacion : ruta) {
            po.add(new LatLng(ubicacion.Latitud, ubicacion.Longitud));
        }
        googlemap.addPolyline(po);
    }

}
