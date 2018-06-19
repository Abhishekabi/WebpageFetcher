package com.example.abima.websitefetcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.page);

        SetupFetch setupFetch = new SetupFetch();
        String page = null;
        try{

            page = setupFetch.execute("http://www.hiteshchoudhary.com").get();
            textView.setText(page);
            Log.i("TAG", "onCreate: " + page);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
