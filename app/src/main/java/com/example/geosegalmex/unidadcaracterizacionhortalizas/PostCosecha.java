package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PostCosecha extends AppCompatActivity {
    ExtendedFloatingActionButton fabPostCos;
    TextView txtPstcs;
    private DatabaseHelper db;

    List<String> listPostCosecha = new ArrayList<>();
    private String MPHORTOTRO = null;
    private String MPHORT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_cosecha);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        fabPostCos = findViewById(R.id.fab_next_cos_pos_fe);
        txtPstcs    = findViewById(R.id.tx_tit_pos_cos);

        if(hortalizas.valorTempCosPv == 1){
            txtPstcs.setText(getString(R.string.name_mod_pcs_pv));
        }else if(hortalizas.valorTempCosOi == 1){
            txtPstcs.setText(getString(R.string.name_mod_pcs_oi));
        }

        db         = new DatabaseHelper(this);

        if(hortalizas.valorTempCosPvOi == 1){
            hortalizas.valorTempCosPvOi = 0;
            hortalizas.valorTempCosPv = 0;
            hortalizas.valorTempCosOi = 1;
            fabPostCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    funCadanePostCosecha();
                    VariblesGlobalesHortalizas.MPHORT = MPHORT;
                    VariblesGlobalesHortalizas.MPHORTOTRO = MPHORTOTRO;
                    agregarHortalizas();
                    startActivity(new Intent(getBaseContext(), HortalizasPVuno.class));
                }
            });
        }else{
            fabPostCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    funCadanePostCosecha();
                    VariblesGlobalesHortalizas.MPHORT = MPHORT;
                    VariblesGlobalesHortalizas.MPHORTOTRO = MPHORTOTRO;
                    agregarHortalizas();
                    startActivity(new Intent(getBaseContext(), IdentificacionCuestionario.class));
                }
            });
        }
    }

    private void funCadanePostCosecha() {
        String cadenaPostCosecha = null;
        for (int i = 0; i <= listPostCosecha.size() - 1; i++) {
            System.out.println(listPostCosecha.get(i));
            if(cadenaPostCosecha == null){
                cadenaPostCosecha = listPostCosecha.get(i) + ",";
            }else {
                cadenaPostCosecha = cadenaPostCosecha + listPostCosecha.get(i) + ",";
            }
        }

        //  String r = listaMeses.stream().collect(Collectors.joining(""));
        if(cadenaPostCosecha != null) {
            MPHORTOTRO = cadenaPostCosecha;
            Log.e("=====>", cadenaPostCosecha);
        }else {
            MPHORTOTRO = null;
        }
    }


    private void agregarHortalizas() {
        boolean insertarData = db.addHortalizas();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {

    }

    public void sinoPostCosecha(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_ps_fe:
                if (checkedTipo) {
                    MPHORT = "Si";
                }
                break;
            case R.id.rd_no_ps_fe:
                if (checkedTipo) {
                    MPHORT = "No";
                }
                break;
        }

    }

    public void manejoPostCosecha(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pas_fe:
                if (checkedTipo) {
                    MPHORTOTRO = "Pastoreo";
                    listPostCosecha.add(MPHORTOTRO);
                } else {
                    listPostCosecha.remove("Pastoreo");
                }
                break;
            case R.id.ck_pi_fe:
                if (checkedTipo) {
                    MPHORTOTRO = "Pizca o pepena";
                    listPostCosecha.add(MPHORTOTRO);
                } else {
                    listPostCosecha.remove("Pizca o pepena");
                }
                break;
            case R.id.ck_vn_fe:
                if (checkedTipo) {
                    MPHORTOTRO = "Venta de esquilmos";
                    listPostCosecha.add(MPHORTOTRO);
                } else {
                    listPostCosecha.remove("Venta de esquilmos");
                }
                break;
            case R.id.ck_inc_fe:
                if (checkedTipo) {
                    MPHORTOTRO = "Incorporación al suelo";
                    listPostCosecha.add(MPHORTOTRO);
                } else {
                    listPostCosecha.remove("Incorporación al suelo");
                }
                break;
            case R.id.ck_qe_fe:
                if (checkedTipo) {
                    MPHORTOTRO = "Quema";
                    listPostCosecha.add(MPHORTOTRO);
                } else {
                    listPostCosecha.remove("Quema");
                }
                break;
        }
    }
}

