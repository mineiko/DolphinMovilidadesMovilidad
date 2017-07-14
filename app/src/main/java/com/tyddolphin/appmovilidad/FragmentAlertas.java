package com.tyddolphin.appmovilidad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FragmentAlertas extends Fragment {

    ImageButton btnAccidente;
    ImageButton btnTrafico;
    ImageButton btnFallaMec;
    ImageButton btnAlumnoEnfermo;
    ImageButton btnManual;
//    Button btnAccidente;
//    Button btnTrafico;
//    Button btnFallaMec;
//    Button btnAlumnoEnfermo;
//    Button btnManual;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private RadioGroup radioGroup2;
    private RadioButton radioButton2;
    LinearLayout ListaAlumnos;
    public static String[] Alumnos = {
            "Juan Salas",
            "Jose Muñoz",
            "Maria Mendoza",
            "Adriana Martinez",
            "Karen Espinoza"
    };


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
        btnAccidente = (ImageButton) view.findViewById(R.id.choque);

        //btnAccidente = (Button) view.findViewById(R.id.button1);
        btnAccidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Alerta Accidente enviada", Toast.LENGTH_LONG).show();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                final View mView = li.inflate(R.layout.dialog_alerta_accidente,null);

                Button BTNEnviar = (Button) mView.findViewById(R.id.btnEnviar);
                Button BTNCancelar = (Button) mView.findViewById(R.id.btnCancelar);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                radioGroup = (RadioGroup) mView.findViewById(R.id.TiposDeChoque);

                BTNCancelar.setOnClickListener(new  View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Elección de Alerta : Choque , cancelada", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

                BTNEnviar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        // get selected radio button from radioGroup
                        int selectedId = radioGroup.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        radioButton = (RadioButton) mView.findViewById(selectedId);
                        if(radioButton==null)Toast.makeText(getContext(), "Seleccione una opción", Toast.LENGTH_SHORT).show();
                        else{
                        Toast.makeText(getContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                        dialog.cancel();}

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
        btnTrafico= (ImageButton) view.findViewById(R.id.trafico);
        btnTrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Alerta Tráfico Enviada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
            }
        });
        btnFallaMec = (ImageButton) view.findViewById(R.id.fallamecanica);
        btnFallaMec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Alerta Accidente enviada", Toast.LENGTH_LONG).show();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                final View mView = li.inflate(R.layout.dialog_alerta_falla_mecanica,null);

                Button BTNEnviar = (Button) mView.findViewById(R.id.btnEnviar);
                Button BTNCancelar = (Button) mView.findViewById(R.id.btnCancelar);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                radioGroup2 = (RadioGroup) mView.findViewById(R.id.TiposDeFM);

                BTNCancelar.setOnClickListener(new  View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Elección de Alerta : Falla Mecánica , cancelada", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

                BTNEnviar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {


                        // get selected radio button from radioGroup
                        int selectedId = radioGroup2.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        radioButton2 = (RadioButton) mView.findViewById(selectedId);

                        if(radioButton2==null)Toast.makeText(getContext(), "Seleccione una opción", Toast.LENGTH_SHORT).show();
                        else{
                        Toast.makeText(getContext(), radioButton2.getText(), Toast.LENGTH_SHORT).show();
                        dialog.cancel();}

                    }

                });
            }
        });


        //ListaAlumnos.addView(Alumno);
        //ListaAlumnos.addView(Alumno2);

        btnAlumnoEnfermo = (ImageButton) view.findViewById(R.id.enfermo);
        btnAlumnoEnfermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                final View mView = li.inflate(R.layout.dialog_alerta_alumno_enfermo,null);

                Button BTNEnviar = (Button) mView.findViewById(R.id.btnEnviar);
                Button BTNCancelar = (Button) mView.findViewById(R.id.btnCancelar);
                ListaAlumnos = (LinearLayout) mView.findViewById(R.id.LLOListaAlumnos);
                for (String alumno : Alumnos) {
                    CheckBox opcion = new CheckBox(getContext());
                    opcion.setText(alumno);
                    opcion.setTextSize(14);
                    opcion.setLayoutParams(
                            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    ListaAlumnos.addView(opcion);
                }
//                CheckBox Alumno = new CheckBox(getContext());
//                CheckBox Alumno2 = new CheckBox(getContext());
//
//                Alumno.setText("Adriana Luque");
//                Alumno2.setText("Christian Lopez");
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                //radioGroup = (RadioGroup) mView.findViewById(R.id.TiposDeChoque);

                BTNCancelar.setOnClickListener(new  View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Elección de Alerta : Alumno Enfermo , cancelada", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

                BTNEnviar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        // get selected radio button from radioGroup
                        //int selectedId = radioGroup.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        //radioButton = (RadioButton) mView.findViewById(selectedId);

                        Toast.makeText(getContext(), "Alerta Alumno Enfermo enviada", Toast.LENGTH_LONG).show();
                        dialog.cancel();

                    }

                });
                //SignalR.enviarMensaje("Holiiii");
            }
        });
        btnManual = (ImageButton) view.findViewById(R.id.manual);
        btnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View mView = li.inflate(R.layout.dialog_alerta_manual, null);
                final EditText mManual = (EditText) mView.findViewById(R.id.etmanual);
                Button BTNEnviar = (Button) mView.findViewById(R.id.btnEnviar);
                Button BTNCancelar = (Button) mView.findViewById(R.id.btnCancelar);



                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                BTNCancelar.setOnClickListener(new  View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Elección de Alerta : Alerta Manual , cancelada", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });
                BTNEnviar.setOnClickListener(new  View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Elección de Alerta : Alerta Manual , enviada", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });


                //Toast.makeText(getContext(), "Alerta Manual: Accidente Leve, enviada", Toast.LENGTH_LONG).show();
                //SignalR.enviarMensaje("Holiiii");
            }
        });



        return view;
    }


}
