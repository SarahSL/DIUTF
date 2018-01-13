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

/**
 * Created by Cynthia on 09/01/2018.
 */

public class RegisterActivity extends Activity {

    EditText email;
    EditText user;
    EditText password;
    EditText confirmPassword;

    Button selec;
    Button register;

    TextView error;
    ImageView photo;
    Uri imageUri;
    private static final int PICK_IMAGE=100;

    boolean changeImage = false;
    Bitmap bitmap= null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.correoTexto);
        user = findViewById(R.id.nameText);
        password = findViewById(R.id.contraseñaTexto);
        confirmPassword = findViewById(R.id.tconfirm);
        selec = findViewById(R.id.cambiarImagen);
        register = findViewById(R.id.register);
        error = findViewById(R.id.errorMensaje);
        photo = findViewById(R.id.imagen);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString().length()>0 && user.getText().toString().length()>0 && password.getText().toString().length()>0 && confirmPassword.getText().toString().length()>0 && password.getText().toString().equals(confirmPassword.getText().toString())){
                    Intent actividadR = new Intent(getApplicationContext(), LoginActivity.class);
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
            photo.setImageURI(imageUri);
        }
    }
}
