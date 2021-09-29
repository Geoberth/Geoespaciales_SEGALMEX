package com.example.geosegalmex.unidadproduccion.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.example.geosegalmex.R;

import java.util.List;

public class ActividadAgricolaAdapter extends ArrayAdapter<ActividadAgricola> {

    private List<ActividadAgricola> agricolaList;
    private Context context;

    public ActividadAgricolaAdapter(@NonNull Context context, int resource, @NonNull List<ActividadAgricola> agricolaList) {
        super(context, resource, agricolaList);
        this.context = context;
        this.agricolaList = agricolaList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listViewItem = inflater.inflate(R.layout.lista_agricola, null, true);
        TextView textView = listViewItem.findViewById(R.id.textViewAct);
        TextView textView1 = listViewItem.findViewById(R.id.textViewSup);

        ActividadAgricola actividadAgricola = agricolaList.get(position);
        textView.setText(actividadAgricola.getNombreActividad());
        textView1.setText(actividadAgricola.getSuperficie());

        return listViewItem;
    }
}
