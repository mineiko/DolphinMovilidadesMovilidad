package com.tyddolphin.appmovilidad;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentAlertas extends Fragment {

    Button btnAccidente;
    Button btnTrafico;
    Button btnFallaMec;
    Button btnAlumnoEnfermo;
    Button btnManual;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_alertas, container, false);


        btnAccidente = (Button) view.findViewById(R.id.button1);
        btnAccidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Alerta Accidente enviada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
            }
        });
        btnTrafico= (Button) view.findViewById(R.id.button2);
        btnTrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Alerta Tráfico Enviada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
            }
        });
        btnFallaMec = (Button) view.findViewById(R.id.button3);
        btnFallaMec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Alerta Falla Mecanica Enviada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
            }
        });
        btnAlumnoEnfermo = (Button) view.findViewById(R.id.button4);
        btnAlumnoEnfermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Alerta Alumno Enfermo enviada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
            }
        });
        btnManual = (Button) view.findViewById(R.id.button5);
        btnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Alerta Manual: Accidente Leve, enviada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
            }
        });



        return view;
    }


}
