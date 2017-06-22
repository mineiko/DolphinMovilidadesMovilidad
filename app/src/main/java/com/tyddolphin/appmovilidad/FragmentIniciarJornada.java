package com.tyddolphin.appmovilidad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.tyddolphin.appmovilidad.signalr.SignalR;


public class FragmentIniciarJornada extends Fragment {

    Button btnIJ;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_iniciar_jornada, container, false);

        //Boton
        btnIJ = (Button) view.findViewById(R.id.btnIniciarJornada);
        btnIJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Iniciar Jornada", Toast.LENGTH_LONG).show();
                SignalR.enviarMensaje("Holiiii");
            }
        });
        return view;
    }


}
