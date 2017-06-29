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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tyddolphin.appmovilidad.signalr.SignalR;


public class FragmentIniciarJornada extends Fragment {

    Button btnIJ;
    LinearLayout LLOB;




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

        //FragmentTransaction transaction = getFragmentManager()
                //.beginTransaction();
        //transaction.replace(R.id.IJ, new FragmentMapaAlumnos());
        //Boton
        btnIJ = (Button) view.findViewById(R.id.btnIniciarJornada);
        //btnIJ.setText("Iniciar Jornada");
        //int color = ContextCompat.getColor(getContext(),R.color.colorBlanco);
        //int bg = ContextCompat.getColor(getContext(),R.drawable.button);

        //btnIJ.setTextColor(color);
        //btnIJ.setTypeface(Typeface.DEFAULT_BOLD);



        btnIJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Iniciar Jornada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
                FragmentTransaction trans = getFragmentManager()
                        .beginTransaction();
				/*
				 * IMPORTANT: We use the "root frame" defined in
				 * "root_fragment.xml" as the reference to replace fragment
				 */
                trans.replace(R.id.IJ, new FragmentMapaAlumnos());

				/*
				 * IMPORTANT: The following lines allow us to add the fragment
				 * to the stack and return to it later, by pressing back
				 */
                //trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                //trans.addToBackStack(null);

                trans.commit();
            }
        });
        //LLOB.addView(btnIJ);
        return view;
    }


}
