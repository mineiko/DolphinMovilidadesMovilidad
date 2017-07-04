package com.tyddolphin.appmovilidad;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.tyddolphin.appmovilidad.rest.Ubicacion;
import com.tyddolphin.appmovilidad.signalr.SignalR;
import com.tyddolphin.appmovilidad.rest.Movilidad;

import static java.lang.Integer.parseInt;


public class FragmentIniciarJornada extends Fragment {

    Button btnIJ;
    LinearLayout LLOB;
    Movilidad a;

    EditText txtNumeroMovilidad;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_iniciar_jornada, container, false);

        LLOB = (LinearLayout) view.findViewById(R.id.LLObutton);
        btnIJ = (Button) view.findViewById(R.id.btnIniciarJornada);

        txtNumeroMovilidad = (EditText)view.findViewById(R.id.txtNumeroMovilidad);

        btnIJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Acaba de Iniciar Jornada", Toast.LENGTH_LONG).show();
                //Enviar mi ubicacion
                //SignalR.InicioDeRecorrido(1,(new Ubicacion(-16.377030411719353,-71.51785483593756 )));
                //en id va el id de la movilidad
                new Notificaciones(1,getContext(),FragmentMapaAlumnos.class,"Movilidad : Jose"  ,"Acaba de Iniciar su Recorrido", "");
                FragmentTransaction trans = getFragmentManager()
                        .beginTransaction();
                FragmentMapaAlumnos f = new FragmentMapaAlumnos();
                int mov = txtNumeroMovilidad.getText().toString().equals("") ? 0 : Integer.parseInt(txtNumeroMovilidad.getText().toString());
                f.n_movilidad = mov;
                trans.replace(R.id.IJ, f);
                //trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                //trans.addToBackStack(null);
                trans.commit();
            }
        });

        return view;
    }


}
