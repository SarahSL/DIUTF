package com.example.sarah.plasticbeach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cynthia on 09/01/2018.
 */

public class login extends Activity {

    EditText nombreIn;
    EditText passwIn;
    Button register;
    Button inicio;
    TextView forgot;
    TextView error;

    String clave;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombreIn = (EditText) findViewById(R.id.textoNombre);
        passwIn= (EditText) findViewById(R.id.contrasena);

        register = (Button) findViewById(R.id.signUp);
        inicio = (Button) findViewById(R.id.inicio);

        forgot= (TextView) findViewById(R.id.forgot);
        error = (TextView) findViewById(R.id.error);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clave= passwIn.getText().toString().trim();

                if(clave.equals("prueba")){
                    //Vamos a la pagina principal
                    //Intent actividad = new Intent(getApplicationContext(), /*PON LA CLASE*/);
                   // startActivity(actividad);
                }else {

                    error.setVisibility(View.VISIBLE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Inténtelo de nuevo", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent actividadR = new Intent(getApplicationContext(), register.class);
                startActivity(actividadR);
            }

        });

        forgot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent actividadR = new Intent(getApplicationContext(), forgot.class);
                startActivity(actividadR);
            }

        });
    }

}
