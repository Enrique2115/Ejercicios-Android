package com.reymi.ucvsesion5trabajos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSpinner, btnListView, btnGrid, btnFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpinner = findViewById(R.id.btnSpinner);
        btnListView = findViewById(R.id.btnList);
        btnGrid = findViewById(R.id.btnGrid);
        btnFragments = findViewById(R.id.btnFragments);

        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SpinnerActivity.class));
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GridActivity.class));
            }
        });


        btnFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FragmentActivity.class));
            }
        });

    }
}