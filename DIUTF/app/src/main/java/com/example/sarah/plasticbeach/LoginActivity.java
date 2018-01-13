package com.example.sarah.plasticbeach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cynthia on 09/01/2018.
 */

public class LoginActivity extends Activity {

    EditText nombreIn;
    EditText passwIn;
    TextView error;
    String clave;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombreIn = findViewById(R.id.textoNombre);
        passwIn= findViewById(R.id.contrasena);

        error = findViewById(R.id.error);

        this.findViewById(R.id.inicio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clave= passwIn.getText().toString().trim();

                if(clave.equals("root")){
                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                    startActivity(intent);
                }else {

                    error.setVisibility(View.VISIBLE);
                    Toast toast1 = Toast.makeText(getApplicationContext(),"Try again", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

        this.findViewById(R.id.register).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent actividadR = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(actividadR);
            }

        });

        this.findViewById(R.id.forgot).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent actividadR = new Intent(getApplicationContext(), ForgotActivity.class);
                startActivity(actividadR);
            }

        });
    }

}
