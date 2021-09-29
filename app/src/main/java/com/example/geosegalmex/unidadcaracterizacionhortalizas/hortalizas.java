package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;


public class hortalizas extends AppCompatActivity {
    public static int valorTempCosPv = 0;
    public static int valorTempCosOi = 0;
    public static int valorTempCosPvOi = 0;
    ExtendedFloatingActionButton fabNextPv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hortalizas);


        fabNextPv = findViewById(R.id.fab_next_pv);

        hortalizas.valorTempCosPv = 0;
        hortalizas.valorTempCosOi = 0;
        hortalizas.valorTempCosPvOi = 0;
        /*
        fabNextPv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HortalizasPVuno.class));
            }
        });*/
    }

    @Override
    public void onBackPressed() {

    }

    public void temporalCosecha(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.rd_pv_c:
                if(checked){
                    valorTempCosPv = 1;
                    fabNextPv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getBaseContext(), HortalizasPVuno.class));
                        }
                    });
                }

                break;
            case R.id.rd_ot_c:
                if(checked){
                    valorTempCosOi = 1;
                    fabNextPv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getBaseContext(), HortalizasPVuno.class));
                        }
                    });
                }

                break;
            case R.id.rd_pv_ot_c:
                if(checked){
                    valorTempCosPvOi = 1;
                    valorTempCosPv = 1;
                    fabNextPv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getBaseContext(), HortalizasPVuno.class));
                        }
                    });
                }
                break;
        }
    }
}
