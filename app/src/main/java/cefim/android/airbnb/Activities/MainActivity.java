package cefim.android.airbnb.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import cefim.android.airbnb.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
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
                        Toast.makeText(MainActivity.this, "Profil", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
