package com.example.sarah.plasticbeach;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarah.plasticbeach.adapters.BeachAdapter;
import com.example.sarah.plasticbeach.models.Beach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by Sarah on 13/12/2017.
 */

public class SearchActivity extends AppCompatActivity{
    ImageView photo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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
                startActivity(new Intent(SearchActivity.this, SearchActivity.class));
            }
        });
        this.findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchActivity.this,StartActivity.class));
            }
        });
        this.findViewById(R.id.perfil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchActivity.this,ProfileActivity.class));
            }
        });

        this.findViewById(R.id.cameraButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);

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
                startActivity(new Intent(SearchActivity.this,EditActivity.class));
            }
        });
        //
        findViewById(R.id.localizationInput).setOnKeyListener(new View.OnKeyListener() {
            TextView searchText = findViewById(R.id.localizationInput);
            @Override
            public boolean onKey(View view, int KeyCode, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    switch (KeyCode){
                        case KeyEvent.KEYCODE_ENTER:
                            if (searchText.getText().toString().trim().equals("Las Palmas de Gran Canaria") || searchText.getText().toString().trim().contains("29/04/17") ){
                                ListView listOfBeach = findViewById(R.id.beachSearch);
                                ArrayList<Beach> randomBeaches = new ArrayList<>();
                                for (String ignored : StartActivity.usernames) {
                                    if (new Random().nextBoolean()) {
                                        Beach randomBeach = new Beach( StartActivity.usernames[new Random().nextInt( StartActivity.usernames.length)]);
                                        randomBeach.setPhoto(ContextCompat.getDrawable(getApplicationContext(), R.drawable.playagc));
                                        randomBeach.setDescription( StartActivity.beaches[new Random().nextInt( StartActivity.beaches.length)]);
                                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
                                        Date date = null;
                                        try {
                                            date = sdf2.parse("29-04-2017");
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        randomBeach.setDate(date);
                                        randomBeaches.add(randomBeach);
                                    }
                                }


                                BeachAdapter adapter = new BeachAdapter(getApplicationContext(), R.layout.beach, randomBeaches);
                                listOfBeach.setAdapter(adapter);

                            }else{
                                Toast.makeText(getApplicationContext(),"No existen playas con esa localización",Toast.LENGTH_SHORT).show();
                            }
                            return true;
                        default:
                                break;
                    }
                }
                return false;
            }
        });



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
