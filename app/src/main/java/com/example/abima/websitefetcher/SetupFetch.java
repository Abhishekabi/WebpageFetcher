package com.example.abima.websitefetcher;

import android.os.AsyncTask;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SetupFetch extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {

        URL url;
        StringBuilder page = new StringBuilder();
        HttpURLConnection urlConnection = null;

        try{
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int data = inputStreamReader.read();

            while(data != -1){
                page.append((char) data);
                data = inputStreamReader.read();
            }
            return page.toString();

        }catch (Exception e){
            e.printStackTrace();
            return ("Error : " + e + "Web page not found!");
        }


    }
}
