package com.example.multiapptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_click);

        btn.setOnClickListener(v ->
                startActivity(new Intent(this, SearchResultsActivity.class))
        );
    }
}