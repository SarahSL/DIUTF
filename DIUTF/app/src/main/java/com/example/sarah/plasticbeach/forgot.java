package com.example.sarah.plasticbeach;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cynthia on 09/01/2018.
 */

public class forgot extends Activity {

    EditText correo;
    EditText password;
    EditText confirmPass;

    Button cambio;
    TextView mensaje;
    TextView error2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        correo = (EditText) findViewById(R.id.correoChange);
        password = (EditText) findViewById(R.id.tPass1);
        confirmPass = (EditText) findViewById(R.id.tPass2);
        cambio = (Button) findViewById(R.id.establecer);
        mensaje = (TextView) findViewById(R.id.mensaje);
        error2 = (TextView) findViewById(R.id.error2);

        cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(correo.getText().toString().length()>0 && password.getText().toString().length()>0 && confirmPass.getText().toString().length()>0 && password.getText().toString().equals(confirmPass.getText().toString())){
                    error2.setVisibility(View.INVISIBLE);
                    mensaje.setVisibility(View.VISIBLE);
                }else {
                    mensaje.setVisibility(View.INVISIBLE);
                    error2.setVisibility(View.VISIBLE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Inténtelo de nuevo.", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });
    }

    }
