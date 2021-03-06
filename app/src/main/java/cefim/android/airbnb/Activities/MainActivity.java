package cefim.android.airbnb.Activities;


import android.annotation.SuppressLint;
import android.app.ActionBar;

import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


import cefim.android.airbnb.MyAdapter;
import cefim.android.airbnb.MyObject;
import cefim.android.airbnb.R;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<MyObject> cities = new ArrayList<>();



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toto);
        setSupportActionBar(toolbar);




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_explorer:
                        Toast.makeText(MainActivity.this, "Explorer", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favoris:
                        Toast.makeText(MainActivity.this, "Favoris", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profil:
                        Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                        startActivity(intent);
                        break;
                }

                return true;
            }
        });

        ImageButton button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 setContentView(R.layout.fragment_recycler);
                 ajouterVilles();
                 recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                 recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                 recyclerView.setAdapter(new MyAdapter(cities));

            }
        });


    }

    private void ajouterVilles() {
        cities.add(new MyObject("Appartement trés grand et agéable","https://images.unsplash.com/photo-1464890100898-a385f744067f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",22,"4.5","France"));
        cities.add(new MyObject("Appartement trés grand et agéable","https://www.telegraph.co.uk/content/dam/Travel/hotels/galleries/city-breaks-europe-hotels-new/hotel-mama-palma-dining-small.jpg",56,"3.2","Angleterre"));
        cities.add(new MyObject("Appartement trés grand et agéable","https://www.telegraph.co.uk/content/dam/Travel/hotels/asia/maldives/beach-bubble-finolhu-maldives-large.jpg",67,"2.5", "USA"));
        cities.add(new MyObject("Appartement trés grand et agéable","https://www.telegraph.co.uk/content/dam/Travel/hotels/asia/maldives/beach-bubble-finolhu-maldives-large.jpg",126,"7.9","Amsterdam"));
        cities.add(new MyObject("Appartement trés grand et agéable","https://www.telegraph.co.uk/content/dam/Travel/hotels/asia/maldives/beach-bubble-finolhu-maldives-large.jpg",132,"7.8","Belgique"));
        cities.add(new MyObject("Appartement trés grand et agéable","https://www.telegraph.co.uk/content/dam/Travel/hotels/asia/maldives/beach-bubble-finolhu-maldives-large.jpg",43,"3.5", "France"));
    }

}
