package cefim.android.airbnb.ApiManager;

import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static android.content.ContentValues.TAG;


public class ApiManager {
    static String text;

    public String requestContent(String url) {

        OkHttpClient okhttpClient = new OkHttpClient();

        Request myGetRequest = new Request.Builder()
                .url("https://gameofhome.herokuapp.com/voyageurs")
                .build();

        okhttpClient.newCall(myGetRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                Log.d(TAG,"Marche pas : ");

            }

            @Override
            public void onResponse(Response response) throws IOException {

                text = response.body().string().toString();
                final int statusCode = response.code();
                Log.d(TAG,"Marche : "+ text);

            }
        });
        Log.d(TAG,"Marche2 : "+ text);
        return text;
    }

    public static String getEncodedPassword(String key) throws NoSuchAlgorithmException {
        byte[] uniqueKey = key.getBytes() ;
        byte[] hash = null ;
        hash = MessageDigest.getInstance("MD5").digest(uniqueKey) ;
        StringBuffer hashString = new StringBuffer() ;
        for ( int i = 0 ; i < hash.length ; ++i ) {
            String hex = Integer.toHexString(hash[i]) ;
            if ( hex.length() == 1 ) {
                hashString.append('0') ;
                hashString.append(hex.charAt(hex.length()-1)) ;
            } else {
                hashString.append(hex.substring(hex.length()-2)) ;
            }
        }
        return hashString.toString() ;
    }

}
