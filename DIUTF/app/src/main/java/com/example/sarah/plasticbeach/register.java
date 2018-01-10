package com.example.sarah.plasticbeach;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

/**
 * Created by Cynthia on 09/01/2018.
 */

public class register extends Activity {

    EditText correo;
    EditText usuario;
    EditText contraseña;
    EditText confirmContraseña;

    Button selec;
    Button registrar;

    TextView error;
    ImageView foto;
    Uri imageUri;
    private static final int PICK_IMAGE=100;

    boolean changeImage = false;
    Bitmap bitmap= null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        correo = (EditText) findViewById(R.id.correoTexto);
        usuario = (EditText) findViewById(R.id.nameText);
        contraseña = (EditText) findViewById(R.id.contraseñaTexto);
        confirmContraseña = (EditText) findViewById(R.id.tconfirm);
        selec= (Button) findViewById(R.id.cambiarImagen);
        registrar= (Button) findViewById(R.id.register);
        error= (TextView) findViewById(R.id.errorMensaje);
        foto= (ImageView) findViewById(R.id.imagen);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(correo.getText().toString().length()>0 && usuario.getText().toString().length()>0 && contraseña.getText().toString().length()>0 && confirmContraseña.getText().toString().length()>0 && contraseña.getText().toString().equals(confirmContraseña.getText().toString())){
                    Intent actividadR = new Intent(getApplicationContext(), login.class);
                    startActivity(actividadR);
                }else {
                    error.setVisibility(View.VISIBLE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Inténtelo de nuevo", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        selec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                gallery.setType("image/");
                startActivityForResult(gallery.createChooser(gallery, "Seleccione una aplicación"), 10);
            }
        });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            imageUri = data.getData();
            foto.setImageURI(imageUri);
        }
    }
}
