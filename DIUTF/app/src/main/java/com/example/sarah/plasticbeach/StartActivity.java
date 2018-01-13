package com.example.sarah.plasticbeach;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
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
    private  String[] usernames = new String[]{"Benjamin","Cynthia","Jorge","Tomás","Jesé","Jaime","Antonio","Judith","Benito","Jessica"};
    private String[] beaches = new String[]{"Las Canteras", "El Burrero", "Las Burras", "Playa del Cochino", "Playa del Inglés", "Ojos de Garza", "Playa de Cabrón", "Gui-gui", "Playa del hombre", "Playa de atrás", "La Garita"};
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
                Toast.makeText(StartActivity.this, "Camera opened", Toast.LENGTH_SHORT).show();
            }
        });
        //

        ArrayList<Beach> randomBeaches = new ArrayList<>();
        for (String beach : usernames) {
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


}
