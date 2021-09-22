package com.example.geoespaciales.caracterizacion.variables_caracterizacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.example.geoespaciales.R;
import com.example.geoespaciales.caracterizacion.ciclo_caracterizacion2;
import com.example.geoespaciales.unidadcaracterizacionhortalizas.HortalizasPvunob;
import com.example.geoespaciales.unidadcaracterizacionhortalizas.date.CalendarioActivity;

public class CalendarioDate extends AppCompatActivity {
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_date);


        calendarView = findViewById(R.id.id_date_dos);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String anno = String.valueOf(year);
                String mes = String.valueOf(month);
                String dia = String.valueOf(dayOfMonth);

               // Log.d(TAG, "seleccion" + anno);

                Intent intent = new Intent(getApplicationContext(), ciclo_caracterizacion2.class);
                intent.putExtra("anno", anno);
                intent.putExtra("mes", mes);
                intent.putExtra("dia", dia);
                startActivity(intent);
            }
        });
    }
}
