package com.example.sarah.plasticbeach;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sarah.plasticbeach.adapters.BeachAdapter;
import com.example.sarah.plasticbeach.models.Beach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

/**
 * Created by Sarah on 13/12/2017.
 */

public class StartActivity extends AppCompatActivity{
    ImageView photo;
    public  static String[] usernames = new String[]{"Benjamin","Cynthia","Jorge","Tomás","Jesé","Jaime","Antonio","Judith","Benito","Jessica"};
    public static String[] beaches = new String[]{"Las Canteras, Las Palmas de Gran Canaria", "El Burrero, Las Palmas de Gran Canaria", "Las Burras, Las Palmas de Gran Canaria",
            "Playa del Cochino, Las Palmas de Gran Canaria", "Playa del Inglés, Las Palmas de Gran Canaria", "Ojos de Garza, Las Palmas de Gran Canaria", "Playa de Cabrón, Las Palmas de Gran Canaria",
            "Gui-gui, Las Palmas de Gran Canaria", "Playa del hombre, Las Palmas de Gran Canaria", "Playa de atrás, Las Palmas de Gran Canaria", "La Garita, Las Palmas de Gran Canaria"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
//Commun in all class inside the app
        this.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        this.findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, SearchActivity.class));
            }
        });
        this.findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(StartActivity.this,StartActivity.class));
            }
        });
        this.findViewById(R.id.perfil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,ProfileActivity.class));
            }
        });

        this.findViewById(R.id.cameraButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);

                builder.setMessage("Modo").setTitle("Subir imagen");


                builder.setPositiveButton("Galeria", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        gallery.setType("image/");
                        startActivityForResult(gallery.createChooser(gallery, "Seleccione una aplicación"), 10);

                    }
                });
                builder.setNegativeButton("Camara", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        startActivity(new Intent(getApplicationContext(),CameraActivity.class));
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        this.findViewById(R.id.profileButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,EditActivity.class));
            }
        });
        //

        ArrayList<Beach> randomBeaches = new ArrayList<>();
        for (String ignored : usernames) {
            if (new Random().nextBoolean()) {
                Beach randomBeach = new Beach(usernames[new Random().nextInt(usernames.length)]);
                randomBeach.setPhoto(ContextCompat.getDrawable(this, R.drawable.playagc));
                randomBeach.setDescription(beaches[new Random().nextInt(beaches.length)]);
                randomBeaches.add(randomBeach);
            }
        }


        BeachAdapter adapter = new BeachAdapter(this, R.layout.beach, randomBeaches);

        ListView list = this.findViewById(R.id.listBeach);

        list.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            Uri imageUri = data.getData();
            photo.setImageURI(imageUri);
        }
    }

}
