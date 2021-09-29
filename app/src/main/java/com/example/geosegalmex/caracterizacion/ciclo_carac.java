package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_carac extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente1;
    public static int valorTempCosPvAgricola = 0;
    public static int valorTempCosOiAgricola = 0;
    public static int valorTempCosPvOiAgricola = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_carac);
        siguiente1 = findViewById(R.id.btn_sig1);

        /*
        siguiente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion.class));
            }
        });

         */
    }

    public void temporalAgricola(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.pv_agr_1:
                if (checkedTipo) {
                    valorTempCosPvAgricola = 1;
                    siguiente1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion.class));
                        }
                    });
                }
                break;
            case R.id.oi_agr_2:
                if (checkedTipo) {
                    valorTempCosOiAgricola = 1;
                    siguiente1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion.class));
                        }
                    });
                }
                break;
            case R.id.pv_oi_agr_3:
                if (checkedTipo) {
                    //valorTempCosPvOiAgricola = 1;
                    valorTempCosPvOiAgricola = 1;
                    valorTempCosPvAgricola= 1;
                    siguiente1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion.class));
                        }
                    });
                }
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }
}
