package com.tyddolphin.appmovilidad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.tyddolphin.appmovilidad.rest.Rest;
import com.tyddolphin.appmovilidad.rest.Ubicacion;
import com.tyddolphin.appmovilidad.signalr.SignalR;
import com.tyddolphin.appmovilidad.rest.Movilidad;
import com.tyddolphin.appmovilidad.rest.Alumno;


public class FragmentMapaAlumnos extends Fragment implements
        OnMapReadyCallback,
        Rest.OnMovilidadObtenidaCallback,
        Rest.OnRutaGeneradaCallback{

    //Clases
    /*class Notificaciones implements View.OnClickListener {
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
            if(id==0){

            }

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
            }

            //Enviar la notificacion
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id, builder.build());
        }
    }*/

    Ubicacion[] ubicacionMovilidades = {
            new Ubicacion( -16.377030411719353,-71.51785483593756),
            new Ubicacion(-16.377287,  -71.560222 ),
            new Ubicacion(-16.426182, -71.526631 )
    };
    public int n_movilidad = 0;

    MapView mMapView;

    GoogleMap googlemap;
    Marker MarcadorMovilidad;
    Marker[] MarcadoresAlumnos;

    Rest rest;

    public FragmentMapaAlumnos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Movilidad a;
    public void ObtenerMovilidad(){
        rest.GetInfoMovilidad(n_movilidad, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rest = new Rest(getActivity().getApplicationContext());
        View view = inflater.inflate(R.layout.fragment_mapa_alumnos, container, false);


        CargarMapa(view, savedInstanceState);

//        Button btnA = new Button(super.getContext());
//        Button btnB = new Button(super.getContext());
//        Button btnC = new Button(super.getContext());
//        Button btnD = new Button(super.getContext());
//        btnA.setText("Inicio Recorrido");
//        //btnA.setOnClickListener(new Notificaciones(1,getContext(),FragmentMapaAlumnos.class,"aaa","bbb"));
//        btnB.setText("Alumno no va a ir");
        //btnB.setOnClickListener(new Notificaciones(1));
        //btnC.setText("Alerta Accidente");
        //btnC.setOnClickListener(new Notificaciones(2));
        //btnD.setText("Inicio Recorrido");

        //mLinearLayout.addView(btnA);
        //mLinearLayout.addView(btnB);
        //mLinearLayout.addView(btnC);

        return view;
    }

    public void CargarMapa(View view, Bundle savedInstanceState){
        mMapView = (MapView) view.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        MapsInitializer.initialize(getActivity().getApplicationContext());
        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap _googleMap) {
        googlemap = _googleMap;

        googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(ubicacionMovilidades[n_movilidad].Latitud, ubicacionMovilidades[n_movilidad].Longitud), 15));

        SignalR.InicioDeRecorrido(n_movilidad, ubicacionMovilidades[n_movilidad]);

        ObtenerMovilidad();



    }

    @Override
    public void onRutaGenerada(Ubicacion[] ruta) {
        final PolylineOptions po = new PolylineOptions();
        //Toast.makeText(getActivity(), "Ya llego la movilidad", Toast.LENGTH_SHORT).show();
        for (Ubicacion ubicacion : ruta){

            po.add(new LatLng(ubicacion.Latitud, ubicacion.Longitud));

        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                googlemap.addPolyline(po);
            }
        });
    }

    @Override
    public void onMovilidadObtenida(Movilidad movilidad) {
        a = movilidad;
        Ubicacion fin = new Ubicacion(-16.405366, -71.550558);
        Log.i("","");
        Toast.makeText(getActivity(), "Ya llego la movilidad", Toast.LENGTH_SHORT).show();

        Ubicacion posicionMovilidad = ubicacionMovilidades[movilidad.Id];
        MarkerOptions mo = new MarkerOptions()
                .position(new LatLng(posicionMovilidad.Latitud,  posicionMovilidad.Longitud))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus_verde));
        MarcadorMovilidad = googlemap.addMarker(mo);
        MarcadoresAlumnos = new Marker[movilidad.Alumnos.length];
        Ubicacion[] paradas = new Ubicacion[movilidad.Alumnos.length];
        for (int i = 0; i <movilidad.Alumnos.length; i++){
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(new LatLng(movilidad.Alumnos[i].Casa.Latitud, movilidad.Alumnos[i].Casa.Longitud))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_face_blanco));
            MarcadoresAlumnos[i] = googlemap.addMarker(markerOptions);
            paradas[i] = movilidad.Alumnos[i].Casa;
        }
        Hilo hilo = new Hilo(getActivity().getApplicationContext(), movilidad, MarcadorMovilidad, MarcadoresAlumnos,
                ubicacionMovilidades[n_movilidad],
                new Ubicacion(-16.405366, -71.550558),
                paradas
        );

        rest.GenerarRuta(posicionMovilidad,fin, paradas, this);
    }

}
