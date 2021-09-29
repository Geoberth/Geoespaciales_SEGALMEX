package com.example.geosegalmex.unidadcaracterizacionhortalizas.date;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.HortalizasPvunob;

public class CalendarioActivity extends AppCompatActivity {
    private static final String TAG = "calendaria";
    private CalendarView calendarView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendarView = findViewById(R.id.id_date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String anno = String.valueOf(year);
                String mes = String.valueOf(month);
                String dia = String.valueOf(dayOfMonth);

                Log.d(TAG, "seleccion" + anno);

                Intent intent = new Intent(CalendarioActivity.this, HortalizasPvunob.class);
                intent.putExtra("anno", anno);
                intent.putExtra("mes", mes);
                intent.putExtra("dia", dia);
                startActivity(intent);
            }
        });

    }
}
