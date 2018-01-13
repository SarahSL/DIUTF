package com.example.sarah.plasticbeach;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cynthia on 09/01/2018.
 */

public class EditActivity extends Activity{
    EditText correo;
    EditText usuario;
    EditText contraseña;

    Button selec;
    Button aplicar;

    TextView error;
    ImageView foto;
    Uri imageUri;

    private static final int PICK_IMAGE=100;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        correo = findViewById(R.id.correoTexto);
        usuario = findViewById(R.id.nameText);
        contraseña = findViewById(R.id.contraseñaTexto);
        selec= findViewById(R.id.cambiarImagen);
        aplicar= findViewById(R.id.cambios);
        error= findViewById(R.id.errorEdit);
        foto= findViewById(R.id.imagen);

        aplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(correo.getText().toString().length()>0 && contraseña.getText().toString().length()>0 && usuario.getText().toString().length()>0){
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Los cambios se han aplicado correctamente.", Toast.LENGTH_SHORT);

                    toast1.show();
                }else {
                    error.setVisibility(View.VISIBLE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Inténtelo de nuevo", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        selec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                gallery.setType("image/");
                startActivityForResult(gallery.createChooser(gallery, "Seleccione una aplicación"), 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            imageUri = data.getData();
            foto.setImageURI(imageUri);
        }
    }
}
