package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioEventosUnidadProduccion extends AppCompatActivity {


    //Variables locales
    //Pecuario Eventos  escasez de forrajes
    private String EVEESCAFORENE = null;
    private String EVEESCAFORFEB = null;
    private String EVEESCAFORMAR = null;
    private String EVEESCAFORABR = null;
    private String EVEESCAFORMAY = null;
    private String EVEESCAFORJUN = null;
    private String EVEESCAFORJUL = null;
    private String EVEESCAFORAGO = null;
    private String EVEESCAFORSEP = null;
    private String EVEESCAFOROCT = null;
    private String EVEESCAFORNOV = null;
    private String EVEESCAFORDIC = null;



    //Pecuario Eventos  compra de forrajes
    private String EVECOMPFORENE = null;
    private String EVECOMPFORFEB = null;
    private String EVECOMPFORMAR = null;
    private String EVECOMPFORABR = null;
    private String EVECOMPFORMAY = null;
    private String EVECOMPFORJUN = null;
    private String EVECOMPFORJUL = null;
    private String EVECOMPFORAGO = null;
    private String EVECOMPFORSEP = null;
    private String EVECOMPFOROCT = null;
    private String EVECOMPFORNOV = null;
    private String EVECOMPFORDIC = null;
    private String EVECOMPFORCOST = null;


    //Pecuario Eventos  mantenimiento de praderas
    private String EVEMANTPRADENE = null;
    private String EVEMANTPRADFEB = null;
    private String EVEMANTPRADMAR = null;
    private String EVEMANTPRADABR = null;
    private String EVEMANTPRADMAY = null;
    private String EVEMANTPRADJUN = null;
    private String EVEMANTPRADJUL = null;
    private String EVEMANTPRADAGO = null;
    private String EVEMANTPRADSEP = null;
    private String EVEMANTPRADOCT = null;
    private String EVEMANTPRADNOV = null;
    private String EVEMANTPRADDIC = null;
    private String EVEMANTPRADCOST = null;


    //Pecuario Eventos  alimentacion en agostadero
    private String EVEALIMAGOSENE = null;
    private String EVEALIMAGOSFEB = null;
    private String EVEALIMAGOSMAR = null;
    private String EVEALIMAGOSABR = null;
    private String EVEALIMAGOSMAY = null;
    private String EVEALIMAGOSJUN = null;
    private String EVEALIMAGOSJUL = null;
    private String EVEALIMAGOSAGO = null;
    private String EVEALIMAGOSSEP = null;
    private String EVEALIMAGOSOCT = null;
    private String EVEALIMAGOSNOV = null;
    private String EVEALIMAGOSDIC = null;
    private String EVEALIMAGOSCOST = null;



    EditText edtPecuarioeventoupcompraforrajeotro;
    EditText edtPecuarioeventoupmanttopraderasotro;
    EditText edtPecuarioeventoupalimentacagostaderootro;


    //BASE DE DATOS
    private DatabaseHelper baseBD;


    Button btnPecueventoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_eventos_unidad_produccion);

        edtPecuarioeventoupcompraforrajeotro = (EditText)findViewById(R.id.edtPecuarioeventoupcompraforrajeotro);
        edtPecuarioeventoupmanttopraderasotro = (EditText)findViewById(R.id.edtPecuarioeventoupmanttopraderasotro);
        edtPecuarioeventoupalimentacagostaderootro = (EditText)findViewById(R.id.edtPecuarioeventoupalimentacagostaderootro);

        btnPecueventoup = (Button)findViewById(R.id.pecuario_next_eventos_undproduccion);



        //BD
        baseBD         = new DatabaseHelper(this);


        btnPecueventoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GlobalPecuario.EVEESCAFORENE = EVEESCAFORENE;
                GlobalPecuario.EVEESCAFORFEB = EVEESCAFORFEB;
                GlobalPecuario.EVEESCAFORMAR = EVEESCAFORMAR;
                GlobalPecuario.EVEESCAFORABR = EVEESCAFORABR;
                GlobalPecuario.EVEESCAFORMAY = EVEESCAFORMAY;
                GlobalPecuario.EVEESCAFORJUN = EVEESCAFORJUN;
                GlobalPecuario.EVEESCAFORJUL = EVEESCAFORJUL;
                GlobalPecuario.EVEESCAFORAGO = EVEESCAFORAGO;
                GlobalPecuario.EVEESCAFORSEP = EVEESCAFORSEP;
                GlobalPecuario.EVEESCAFOROCT = EVEESCAFOROCT;
                GlobalPecuario.EVEESCAFORNOV = EVEESCAFORNOV;
                GlobalPecuario.EVEESCAFORDIC = EVEESCAFORDIC;




                GlobalPecuario.EVECOMPFORENE = EVECOMPFORENE;
                GlobalPecuario.EVECOMPFORFEB = EVECOMPFORFEB;
                GlobalPecuario.EVECOMPFORMAR = EVECOMPFORMAR;
                GlobalPecuario.EVECOMPFORABR = EVECOMPFORABR;
                GlobalPecuario.EVECOMPFORMAY = EVECOMPFORMAY;
                GlobalPecuario.EVECOMPFORJUN = EVECOMPFORJUN;
                GlobalPecuario.EVECOMPFORJUL = EVECOMPFORJUL;
                GlobalPecuario.EVECOMPFORAGO = EVECOMPFORAGO;
                GlobalPecuario.EVECOMPFORSEP = EVECOMPFORSEP;
                GlobalPecuario.EVECOMPFOROCT = EVECOMPFOROCT;
                GlobalPecuario.EVECOMPFORNOV = EVECOMPFORNOV;
                GlobalPecuario.EVECOMPFORDIC = EVECOMPFORDIC;
                peceventcompraforraje();
                GlobalPecuario.EVECOMPFORCOST = EVECOMPFORCOST;


                GlobalPecuario.EVEMANTPRADENE = EVEMANTPRADENE;
                GlobalPecuario.EVEMANTPRADFEB = EVEMANTPRADFEB;
                GlobalPecuario.EVEMANTPRADMAR = EVEMANTPRADMAR;
                GlobalPecuario.EVEMANTPRADABR = EVEMANTPRADABR;
                GlobalPecuario.EVEMANTPRADMAY = EVEMANTPRADMAY;
                GlobalPecuario.EVEMANTPRADJUN = EVEMANTPRADJUN;
                GlobalPecuario.EVEMANTPRADJUL = EVEMANTPRADJUL;
                GlobalPecuario.EVEMANTPRADAGO = EVEMANTPRADAGO;
                GlobalPecuario.EVEMANTPRADSEP = EVEMANTPRADSEP;
                GlobalPecuario.EVEMANTPRADOCT = EVEMANTPRADOCT;
                GlobalPecuario.EVEMANTPRADNOV = EVEMANTPRADNOV;
                GlobalPecuario.EVEMANTPRADDIC = EVEMANTPRADDIC;
                peceventmattopraderas();
                GlobalPecuario.EVEMANTPRADCOST = EVEMANTPRADCOST;


                GlobalPecuario.EVEALIMAGOSENE = EVEALIMAGOSENE;
                GlobalPecuario.EVEALIMAGOSFEB = EVEALIMAGOSFEB;
                GlobalPecuario.EVEALIMAGOSMAR = EVEALIMAGOSMAR;
                GlobalPecuario.EVEALIMAGOSABR = EVEALIMAGOSABR;
                GlobalPecuario.EVEALIMAGOSMAY = EVEALIMAGOSMAY;
                GlobalPecuario.EVEALIMAGOSJUN = EVEALIMAGOSJUN;
                GlobalPecuario.EVEALIMAGOSJUL = EVEALIMAGOSJUL;
                GlobalPecuario.EVEALIMAGOSAGO = EVEALIMAGOSAGO;
                GlobalPecuario.EVEALIMAGOSSEP = EVEALIMAGOSSEP;
                GlobalPecuario.EVEALIMAGOSOCT = EVEALIMAGOSOCT;
                GlobalPecuario.EVEALIMAGOSNOV = EVEALIMAGOSNOV;
                GlobalPecuario.EVEALIMAGOSDIC = EVEALIMAGOSDIC;
                peceventalimentacagostader();
                GlobalPecuario.EVEALIMAGOSCOST = EVEALIMAGOSCOST;

                agregaEventosunidadprod();
                Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PecuarioEventosUnidadProduccion.this, PecuarioManejoAgostadero.class));
                finish();
            }
        });
    }



    //INSERCION DE DATOS
    public void agregaEventosunidadprod(){



        addEventosunidadprod();

    }




    ///Agregar evento unidad de produccion pecuario

    private void addEventosunidadprod(){
        boolean insertarData = baseBD.addPecuarioevunidprod();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }




    ////////////////////////////////////////////////////////////////////////////////
    //Meses para Eventos  escasez de forrajes
    public void clickescasezforraje(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecuarioeventoupescasezforrajeenero:
                if (checked) {
                    EVEESCAFORENE = "Sí";

                }
                else{
                    EVEESCAFORENE = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajefebrero:
                if (checked) {
                    EVEESCAFORFEB = "Sí";
                }
                else{
                    EVEESCAFORFEB = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajemarzo:
                if (checked) {
                    EVEESCAFORMAR = "Sí";

                }else{
                    EVEESCAFORMAR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajeabril:
                if (checked) {
                    EVEESCAFORABR = "Sí";

                }else{
                    EVEESCAFORABR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajemayo:
                if (checked) {
                    EVEESCAFORMAY = "Sí";

                }else{
                    EVEESCAFORMAY = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajejunio:
                if (checked) {
                    EVEESCAFORJUN = "Sí";

                }else{
                    EVEESCAFORJUN = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajejulio:
                if (checked) {
                    EVEESCAFORJUL = "Sí";

                }else{
                    EVEESCAFORJUL = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajeagosto:
                if (checked) {
                    EVEESCAFORAGO = "Sí";

                }else{
                    EVEESCAFORAGO = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajeseptiembre:
                if (checked) {
                    EVEESCAFORSEP = "Sí";

                }else{
                    EVEESCAFORSEP = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajeoctubre:
                if (checked) {
                    EVEESCAFOROCT = "Sí";

                }else{
                    EVEESCAFOROCT = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajenoviembre:
                if (checked) {
                    EVEESCAFORNOV = "Sí";

                }else{
                    EVEESCAFORNOV = "No";
                }
                break;

            case R.id.checkPecuarioeventoupescasezforrajediciembre:
                if (checked) {
                    EVEESCAFORDIC = "Sí";

                }else{
                    EVEESCAFORDIC = "No";
                }
                break;
        }
    }







    ////////////////////////////////////////////////////////////////////////////////
    //Meses para Eventos  compra de forrajes
    public void clickcompraforraje(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecuarioeventoupcompraforrajeenero:
                if (checked) {
                    EVEESCAFORENE = "Sí";

                }
                else{
                    EVEESCAFORENE = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajefebrero:
                if (checked) {
                    EVECOMPFORFEB = "Sí";
                }
                else{
                    EVECOMPFORFEB = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajemarzo:
                if (checked) {
                    EVECOMPFORMAR = "Sí";

                }else{
                    EVECOMPFORMAR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajeabril:
                if (checked) {
                    EVECOMPFORABR = "Sí";

                }else{
                    EVECOMPFORABR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajemayo:
                if (checked) {
                    EVECOMPFORMAY = "Sí";

                }else{
                    EVECOMPFORMAY = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajejunio:
                if (checked) {
                    EVECOMPFORJUN = "Sí";

                }else{
                    EVECOMPFORJUN = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajejulio:
                if (checked) {
                    EVECOMPFORJUL = "Sí";

                }else{
                    EVECOMPFORJUL = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajeagosto:
                if (checked) {
                    EVECOMPFORAGO = "Sí";

                }else{
                    EVECOMPFORAGO = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajeseptiembre:
                if (checked) {
                    EVECOMPFORSEP = "Sí";

                }else{
                    EVECOMPFORSEP = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajeoctubre:
                if (checked) {
                    EVECOMPFOROCT = "Sí";

                }else{
                    EVECOMPFOROCT = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajenoviembre:
                if (checked) {
                    EVECOMPFORNOV = "Sí";

                }else{
                    EVECOMPFORNOV = "No";
                }
                break;

            case R.id.checkPecuarioeventoupcompraforrajediciembre:
                if (checked) {
                    EVECOMPFORDIC = "Sí";

                }else{
                    EVECOMPFORDIC = "No";
                }
                break;
        }
    }




    public void peceventcompraforraje(){
        if(!edtPecuarioeventoupcompraforrajeotro.getText().toString().isEmpty()){
            EVECOMPFORCOST = edtPecuarioeventoupcompraforrajeotro.getText().toString();
        } else{
            EVECOMPFORCOST = null;
        }

    }





    ////////////////////////////////////////////////////////////////////////////////
    //Meses para Eventos  mantenimiento de praderas
    public void clickmattopraderas(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecuarioeventoupmanttopraderasenero:
                if (checked) {
                    EVEMANTPRADENE = "Sí";

                }
                else{
                    EVEMANTPRADENE = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasfebrero:
                if (checked) {
                    EVEMANTPRADFEB = "Sí";
                }
                else{
                    EVEMANTPRADFEB = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasmarzo:
                if (checked) {
                    EVEMANTPRADMAR = "Sí";

                }else{
                    EVEMANTPRADMAR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasabril:
                if (checked) {
                    EVEMANTPRADABR = "Sí";

                }else{
                    EVEMANTPRADABR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasmayo:
                if (checked) {
                    EVEMANTPRADMAY = "Sí";

                }else{
                    EVEMANTPRADMAY = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasjunio:
                if (checked) {
                    EVEMANTPRADJUN = "Sí";

                }else{
                    EVEMANTPRADJUN = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasjulio:
                if (checked) {
                    EVEMANTPRADJUL = "Sí";

                }else{
                    EVEMANTPRADJUL = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasagosto:
                if (checked) {
                    EVEMANTPRADAGO = "Sí";

                }else{
                    EVEMANTPRADAGO = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasseptiembre:
                if (checked) {
                    EVEMANTPRADSEP = "Sí";

                }else{
                    EVEMANTPRADSEP = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasoctubre:
                if (checked) {
                    EVEMANTPRADOCT = "Sí";

                }else{
                    EVEMANTPRADOCT = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasnoviembre:
                if (checked) {
                    EVEMANTPRADNOV = "Sí";

                }else{
                    EVEMANTPRADNOV = "No";
                }
                break;

            case R.id.checkPecuarioeventoupmanttopraderasdiciembre:
                if (checked) {
                    EVEMANTPRADDIC = "Sí";

                }else{
                    EVEMANTPRADDIC = "No";
                }
                break;
        }
    }




    public void peceventmattopraderas(){
        if(!edtPecuarioeventoupmanttopraderasotro.getText().toString().isEmpty()){
            EVEMANTPRADCOST = edtPecuarioeventoupmanttopraderasotro.getText().toString();
        } else{
            EVEMANTPRADCOST = null;
        }

    }





    ////////////////////////////////////////////////////////////////////////////////
    //Meses para Eventos  alimentacion en el agostadero
    public void clickalimentacagostader(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecuarioeventoupalimentacagostaderoenero:
                if (checked) {
                    EVEALIMAGOSENE = "Sí";

                }
                else{
                    EVEALIMAGOSENE = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderofebrero:
                if (checked) {
                    EVEALIMAGOSFEB = "Sí";
                }
                else{
                    EVEALIMAGOSFEB = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderomarzo:
                if (checked) {
                    EVEALIMAGOSMAR = "Sí";

                }else{
                    EVEALIMAGOSMAR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderoabril:
                if (checked) {
                    EVEALIMAGOSABR = "Sí";

                }else{
                    EVEALIMAGOSABR = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderomayo:
                if (checked) {
                    EVEALIMAGOSMAY = "Sí";

                }else{
                    EVEALIMAGOSMAY = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderojunio:
                if (checked) {
                    EVEALIMAGOSJUN = "Sí";

                }else{
                    EVEALIMAGOSJUN = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderojulio:
                if (checked) {
                    EVEALIMAGOSJUL = "Sí";

                }else{
                    EVEALIMAGOSJUL = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderoagosto:
                if (checked) {
                    EVEALIMAGOSAGO = "Sí";

                }else{
                    EVEALIMAGOSAGO = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderoseptiembre:
                if (checked) {
                    EVEALIMAGOSSEP = "Sí";

                }else{
                    EVEALIMAGOSSEP = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderooctubre:
                if (checked) {
                    EVEALIMAGOSOCT = "Sí";

                }else{
                    EVEALIMAGOSOCT = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderonoviembre:
                if (checked) {
                    EVEALIMAGOSNOV = "Sí";

                }else{
                    EVEALIMAGOSNOV = "No";
                }
                break;

            case R.id.checkPecuarioeventoupalimentacagostaderodiciembre:
                if (checked) {
                    EVEALIMAGOSDIC = "Sí";

                }else{
                    EVEALIMAGOSDIC = "No";
                }
                break;
        }
    }




    public void peceventalimentacagostader(){
        if(!edtPecuarioeventoupalimentacagostaderootro.getText().toString().isEmpty()){
            EVEALIMAGOSCOST = edtPecuarioeventoupalimentacagostaderootro.getText().toString();
        } else{
            EVEALIMAGOSCOST = null;
        }

    }




    @Override
    public void onBackPressed() {

    }

}
