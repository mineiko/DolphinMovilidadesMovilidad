package com.tyddolphin.appmovilidad;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.tyddolphin.appmovilidad.datosfalsos.Ruta;
import com.tyddolphin.appmovilidad.rest.Ubicacion;
import com.tyddolphin.appmovilidad.signalr.SignalR;


public class FragmentMapaAlumnos extends Fragment {

    MapView mMapView;
    GoogleMap googlemap;
    LinearLayout mLinearLayout;
    Marker Movilidad;
    Marker Alumno01;
    Marker Alumno02;
    Marker Alumno03;
    Marker Alumno04;
    Marker Colegio;


    //Clases
    class Notificaciones implements View.OnClickListener {
        int id;

        Notificaciones(int i) {
            id = i;
        }
        public void BorrarOtrosMarkers(){
            if(Alumno01!=null)Alumno01.remove();
            if(Alumno02!=null)Alumno02.remove();
            if(Alumno03!=null)Alumno03.remove();
            if(Alumno04!=null)Alumno04.remove();
            //if(Movilidad!=null)Movilidad.remove();
            //if(Colegio!=null)Colegio.remove();
        }
        public void BorrarPolylineRuta(){
            if(polyline!=null) polyline.remove();
        }
        public void AgregarAlumnosMapaRutaNormal(){


            MarkerOptions moAlumno01 = new MarkerOptions()
                    .position(new LatLng(-16.380715462751205, -71.52199616665655))
                    .title("Alumno : Christian Loza ").snippet("Estado: NO RECOGIDO")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_blanco));
            MarkerOptions moAlumno02 = new MarkerOptions()
                    .position(new LatLng(-16.383741681611987, -71.520043518493708))
                    .title("Alumno : Adriana Luque ").snippet("Estado: NO RECOGIDO")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_blanco));
            MarkerOptions moAlumno03 = new MarkerOptions()
                    .position(new LatLng(-16.390535062986793, -71.521652843902643))
                    .title("Alumno : Rodrigo Mendoza").snippet("Estado: NO RECOGIDO")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_blanco));
            MarkerOptions moAlumno04 = new MarkerOptions()
                    .position(new LatLng(-16.393787567781231, -71.52538647885137))
                    .title("Alumno : Jarol Butron").snippet("Estado: NO RECOGIDO")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_blanco));

            Alumno01=googlemap.addMarker(moAlumno01);
            Alumno02=googlemap.addMarker(moAlumno02);
            Alumno03=googlemap.addMarker(moAlumno03);
            Alumno04=googlemap.addMarker(moAlumno04);

        }
        public void AgregarAlumniMapaNoVaIr(int i){
            AgregarAlumnosMapaRutaNormal();
            if(i ==1 ){
                Alumno01.remove();
                MarkerOptions moAlumno01 = new MarkerOptions()
                        .position(new LatLng(-16.380715462751205, -71.52199616665655))
                        .title("Alumno : Christian Loza ").snippet("Estado : NO VA A IR")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_plomo));
                Alumno01=googlemap.addMarker(moAlumno01);
            }
            if(i ==2 ){
                Alumno02.remove();
                MarkerOptions moAlumno02 = new MarkerOptions()
                        .position(new LatLng(-16.383741681611987, -71.520043518493708))
                        .title("Alumno : Adriana Luque ").snippet("Estado : NO VA A IR")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_plomo));
                Alumno02=googlemap.addMarker(moAlumno02);
            }
            if(i == 3 ){
                Alumno03.remove();
                MarkerOptions moAlumno03 = new MarkerOptions()
                        .position(new LatLng(-16.390535062986793, -71.521652843902643))
                        .title("Alumno : Rodrigo Mendoza").snippet("Estado : NO VA A IR")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_plomo));
                Alumno03=googlemap.addMarker(moAlumno03);
            }
            if(i == 4 ){
                Alumno04.remove();
                MarkerOptions moAlumno04 = new MarkerOptions()
                        .position(new LatLng(-16.393787567781231, -71.52538647885137))
                        .title("Alumno : Jarol Butron").snippet("Estado : NO VA A IR")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_plomo));
                Alumno04=googlemap.addMarker(moAlumno04);
            }
        }

        @Override
        public void onClick(View view) {
            //Construccion de la accion del intent implicito
            Intent intent = new Intent(getContext(), FragmentMapaAlumnos.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);
            //Construccion de la notificacion;
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
            builder.setSmallIcon(R.drawable.ic_directions_bus_black_36dp);
            builder.setContentIntent(pendingIntent);
            builder.setAutoCancel(true);
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icono));
            //Polyline a = new Polyline();
            BorrarPolylineRuta();
            BorrarOtrosMarkers();
            if (id == 0) {
                builder.setContentTitle("Movilidad : José");
                builder.setContentText("Acaba de Iniciar su Recorrido");
                dibujarPolyline(id);
                AgregarAlumnosMapaRutaNormal();
                MarkerOptions moMovilidades = new MarkerOptions()
                        .position(new LatLng(-16.449572, -71.536306))
                        .title("Movilidad : José ").snippet("A dos minutos del siguiente Alumno")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus_verde));
                MarkerOptions moColegio = new MarkerOptions()
                        .position(new LatLng(-16.404880000000002,-71.55035000000001))
                        .title("Colegio : San Juan Bautista de La Salle")//.snippet("Estado: Normal")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_school_black_36dp));

                Movilidad = googlemap.addMarker(moMovilidades);

                Colegio=googlemap.addMarker(moColegio);
                Hilo ruta = new Hilo(getContext(),Movilidad, Alumno01, Alumno02, Alumno03, Alumno04 );
                ruta.start();
            }
            if (id == 1) {
                builder.setContentTitle("Alumno : Jarol Butron")
                .setContentText("Estado : NO VA A IR")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Estado : NO VA A IR\nEl alumno Jarol Butron no va a ir en la movilidad"));
                dibujarPolyline(id);
                AgregarAlumniMapaNoVaIr(2);
               /* MarkerOptions moMovilidades = new MarkerOptions()
                        .position(new LatLng(-16.449572, -71.536306))
                        .title("Movilidad : José ").snippet("A dos minutos del siguiente Alumno")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus_verde));
                MarkerOptions moColegio = new MarkerOptions()
                        .position(new LatLng(-16.404880000000002,-71.55035000000001))
                        .title("Colegio : San Juan Bautista de La Salle")//.snippet("Estado: Normal")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_school_black_36dp));

                Movilidad = googlemap.addMarker(moMovilidades);

                Colegio=googlemap.addMarker(moColegio);*/
            }

            //Enviar la notificacion
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id, builder.build());
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
                googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-16.377010000000002,-71.51788), 18));


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
        btnB.setText("Alumno no va a ir");
        btnB.setOnClickListener(new Notificaciones(1));
        //btnC.setText("Alerta Accidente");
        //btnC.setOnClickListener(new Notificaciones(2));
        //btnD.setText("Inicio Recorrido");

        mLinearLayout.addView(btnA);
        mLinearLayout.addView(btnB);
        //mLinearLayout.addView(btnC);




        return view;
    }

    Polyline polyline;

    private void dibujarPolyline(int i){//entre 0 y 1
        PolylineOptions po = new PolylineOptions();
        if (i ==0){
            Ubicacion[] ruta = new Ruta().ruta;

            for(Ubicacion ubicacion : ruta) {
                po.add(new LatLng(ubicacion.Latitud, ubicacion.Longitud));
            }
        }else{
            Ubicacion[] ruta = new Ruta().ruta2;
            //PolylineOptions po = new PolylineOptions();
            for(Ubicacion ubicacion : ruta) {
                po.add(new LatLng(ubicacion.Latitud, ubicacion.Longitud));
            }
        }
        polyline = googlemap.addPolyline(po);
        //return polyline;
        //
    }

}
