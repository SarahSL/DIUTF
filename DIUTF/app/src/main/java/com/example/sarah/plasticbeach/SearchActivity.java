package com.example.sarah.plasticbeach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarah.plasticbeach.adapters.BeachAdapter;
import com.example.sarah.plasticbeach.models.Beach;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sarah on 13/12/2017.
 */

public class SearchActivity extends AppCompatActivity{

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
                Toast.makeText(SearchActivity.this, "Camera opened", Toast.LENGTH_SHORT).show();
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
                            if (searchText.getText().toString().trim().equals("Las Palmas de Gran Canaria") ){
                                ListView listOfBeach = findViewById(R.id.beachSearch);
                                ArrayList<Beach> randomBeaches = new ArrayList<>();
                                for (String ignored : StartActivity.usernames) {
                                    if (new Random().nextBoolean()) {
                                        Beach randomBeach = new Beach( StartActivity.usernames[new Random().nextInt( StartActivity.usernames.length)]);
                                        randomBeach.setPhoto(ContextCompat.getDrawable(getApplicationContext(), R.drawable.playagc));
                                        randomBeach.setDescription( StartActivity.beaches[new Random().nextInt( StartActivity.beaches.length)]);
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
}
