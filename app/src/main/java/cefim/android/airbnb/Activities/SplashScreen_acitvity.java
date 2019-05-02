package cefim.android.airbnb.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cefim.android.airbnb.R;

public class SplashScreen_acitvity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screeb_acitvity);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashScreen_acitvity.this, LoginActivity.class);
                SplashScreen_acitvity.this.startActivity(mainIntent);
                SplashScreen_acitvity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
