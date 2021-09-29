package com.example.geosegalmex.unidadcaracterizacionhortalizas.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.geosegalmex.R;

import java.util.List;

public class MlTiempoRiegoAdapter extends ArrayAdapter <MlTiempoRiego> {

    private List<MlTiempoRiego> mlTiempoRiegoList;
    private Context context;

    public MlTiempoRiegoAdapter(@NonNull Context context, int resource, @NonNull List<MlTiempoRiego> mlTiempoRiegoList) {
        super(context, resource, mlTiempoRiegoList);
        this.mlTiempoRiegoList = mlTiempoRiegoList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listViewItemNum = inflater.inflate(R.layout.lista_num_riego, null, true);
        TextView textView = listViewItemNum.findViewById(R.id.txt_num_rig);
        TextView textView1 = listViewItemNum.findViewById(R.id.txt_cs_ag);
        TextView textView2 = listViewItemNum.findViewById(R.id.txt_nm_jr);

        MlTiempoRiego actividadTiempoRiego = mlTiempoRiegoList.get(position);

        String cntNm = String.valueOf(actividadTiempoRiego.getNumRiego());
        String agua = String.valueOf(actividadTiempoRiego.getCstAgua());
        String jornales = String.valueOf(actividadTiempoRiego.getNumJorn());
        //textView.setText(actividadTiempoRiego.getNumRiego());
        textView.setText(cntNm);

        textView1.setText(agua);

        textView2.setText(jornales);


        return listViewItemNum;
    }
}
