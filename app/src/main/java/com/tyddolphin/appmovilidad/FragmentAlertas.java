package com.tyddolphin.appmovilidad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentAlertas extends Fragment {

    Button btnAccidente;
    Button btnTrafico;
    Button btnFallaMec;
    Button btnAlumnoEnfermo;
    Button btnManual;

    LayoutInflater li;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_alertas, container, false);

        li = getLayoutInflater(savedInstanceState);
        btnAccidente = (Button) view.findViewById(R.id.button1);
        btnAccidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Alerta Accidente enviada", Toast.LENGTH_LONG).show();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View mView = li.inflate(R.layout.dialog_alerta_accidente,null);

                Button BTNEnviar = (Button) mView.findViewById(R.id.btnEnviar);
                Button BTNCancelar = (Button) mView.findViewById(R.id.btnCancelar);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                BTNCancelar.setOnClickListener(new  View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Elección de Alerta : Choque , cancelada", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

                BTNEnviar.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        

                    }
                });




//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
//                View mView = li.inflate(R.layout.dialog_ejemplo, null);
//                final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
//                final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
//                Button mLogin = (Button) mView.findViewById(R.id.btnLogin);
//                mBuilder.setView(mView);
//                final AlertDialog dialog = mBuilder.create();
//                dialog.show();
//                mLogin.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
//                            Toast.makeText(getContext(),
//                                    R.string.success_login_msg,
//                                    Toast.LENGTH_SHORT).show();
//                            dialog.dismiss();
//                        }else{
//                            Toast.makeText(getContext(),
//                                    R.string.error_login_msg,
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
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
