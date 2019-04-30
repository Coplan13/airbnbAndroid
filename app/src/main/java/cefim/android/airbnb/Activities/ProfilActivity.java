package cefim.android.airbnb.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import cefim.android.airbnb.R;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_explorer:
                        Toast.makeText(ProfilActivity.this, "Explorer", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProfilActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case R.id.action_favoris:
                        Toast.makeText(ProfilActivity.this, "Favoris", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profil:
                        Toast.makeText(ProfilActivity.this, "Profil", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }
}
