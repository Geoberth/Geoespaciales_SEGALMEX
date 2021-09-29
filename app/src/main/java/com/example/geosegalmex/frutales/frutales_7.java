package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.geosegalmex.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_7 extends AppCompatActivity {
    ExtendedFloatingActionButton f7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_7);

        f7 = findViewById(R.id.fr7);

        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), frutales_8.class));
            }
        });
    }
}
