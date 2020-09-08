package com.example.multiapptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.multiapptest.results.SearchResultsActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.search_input);
        Button btn = findViewById(R.id.btn_click);

        btn.setOnClickListener(v -> {
            final String searchQuery = input.getText().toString();

            Intent intent = new Intent(this, SearchResultsActivity.class);
            intent.putExtra("query", searchQuery);
            startActivity(intent);
        });
    }
}