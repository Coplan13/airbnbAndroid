package cefim.android.airbnb.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import cefim.android.airbnb.ApiManager.ApiManager;
import cefim.android.airbnb.R;
import cefim.android.airbnb.data.utilisateurs.Voyageur;



public class LoginActivity extends AppCompatActivity {
        private static final String VoyageurURL = "http://gameofhome.herokuapp.com/voyageurs";
        private static final String TAG = "LoginActivity";
        private static final int REQUEST_SIGNUP = 0;

        @BindView(R.id.input_email) EditText _emailText;
        @BindView(R.id.input_password) EditText _passwordText;
        @BindView(R.id.btn_login) AppCompatButton _loginButton;
        @BindView(R.id.link_signup) TextView _signupLink;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            ButterKnife.bind(this);


            findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        login();
                    }
                });


                _signupLink.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // Start the Signup activity
                        //  Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                        //  startActivityForResult(intent, REQUEST_SIGNUP);
                    }
                });




        }


        public void login() {



            Log.d(TAG, "Login");

            if (!validate()) {
                onLoginFailed();
                return;
            }

            _loginButton.setEnabled(false);

            final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                    R.style.Theme_Design_Light);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating...");
            progressDialog.show();


            // TODO: Implement your own authentication logic here.


            String email = _emailText.getText().toString();
            String password = _passwordText.getText().toString();



            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onLoginSuccess or onLoginFailed
                            onLoginSuccess();
                            // onLoginFailed();
                            progressDialog.dismiss();
                        }
                    }, 3000);
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_SIGNUP) {
                if (resultCode == RESULT_OK) {

                    // TODO: Implement successful signup logic here
                    // By default we just finish the Activity and log them in automatically
                    this.finish();
                }
            }
        }

        @Override
        public void onBackPressed() {
            // disable going back to the MainActivity
            moveTaskToBack(true);
        }

        public void onLoginSuccess() {
            Log.d(TAG, "Rentre ici !!");
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            _loginButton.setEnabled(true);
            finish();
        }

        public void onLoginFailed() {
            Toast.makeText(getBaseContext(), "Echec de la connexion", Toast.LENGTH_LONG).show();

            _loginButton.setEnabled(true);
        }

        public boolean validate() {
            boolean valid = true;

            String email = _emailText.getText().toString();
            String password = _passwordText.getText().toString();

            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _emailText.setError("Entrer une adresse email valide");
                valid = false;
            } else {
                _emailText.setError(null);
            }

            if (password.isEmpty() ) {
                _passwordText.setError("Le mot de passe est vide");
                valid = false;
            } else {
                _passwordText.setError(null);
            }


            ApiManager api = new ApiManager();

            ArrayList<Voyageur> voyageurs = new ArrayList<Voyageur>();

            try {

                String res = api.requestContent(VoyageurURL);



                JSONArray json;

                if(res == null)
                {
                    res = "[{\"nom\":\"tutu\",\"prenom\":\"Mehdi\",\"age\":23,\"email\":\"sam@gmail.com\",\"mdp\":\"sam123\",\"notes\":\"2.6\"},{\"nom\":\"tutu\",\"prenom\":\"Pierre\",\"age\":27,\"email\":\"admin.admin@gmail.com\",\"mdp\":\"21232f297a57a5a743894a0e4a801fc3\",\"notes\":\"1\"}]";
                    json = new JSONArray(res);
                }
                else
                {
                    json = new JSONArray(res);
                }

                //  JSONObject dataObject = json.getJSONObject("");
                //  JSONArray items = dataObject.getJSONArray("items");

                for (int i = 0; i < json.length(); i++) {
                    JSONObject videoObject = json.getJSONObject(i);
                    Voyageur video = new Voyageur(videoObject.getString("nom"),
                            videoObject.getString("prenom"),
                            videoObject.getInt("age"),
                            videoObject.getString("email"),
                            videoObject.getString("mdp"),
                            videoObject.getString("notes"));

                    voyageurs.add(video);

                }

            } catch (JSONException e) {
                Log.v(TAG, e.getMessage());
            }

            if(valid == true)
            {
                valid = false;
                for( Voyageur voyageur1 : voyageurs )
                {





                    try{
                        if(email.equals(voyageur1.getEmail()) && ApiManager.getEncodedPassword(password).equals(voyageur1.getMdp()) )
                        {
                            valid = true;
                        }
                    }
                    catch(Exception e)
                    {
                        Log.d(TAG, "mdp bug");
                    }


                }

                if(valid == false){
                    _emailText.setError("Email ou mot de passe incorrect.");
                }

            }




            return valid;
        }
    }

