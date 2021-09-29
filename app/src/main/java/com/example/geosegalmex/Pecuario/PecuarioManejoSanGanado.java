package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioManejoSanGanado extends AppCompatActivity {


    //Pecuario Manejo sanitario ganado
    private String MANEJOSANCAMZOO = null;
    private String MANEJOSANTUBERC = null;
    private String MANEJOSANRABIAP = null;
    private String MANEJOSANGARRAP = null;
    private String MANEJOSANBRUCEL = null;
    private String MANEJOSANOTROCA = null;
    private String MANEJOSANEDTOTR = null;

    private String MANEJOSANPROVAC = null;
    private String MANEJOSANNEUMON = null;
    private String MANEJOSANDOBLEV = null;
    private String MANEJOSANTRIPLE = null;
    private String MANEJOSANCLOSTR = null;
    private String MANEJOSANDERRIE = null;
    private String MANEJOSANLEPTOS = null;
    private String MANEJOSANOTRAVA = null;
    private String MANEJOSANEDTOTV = null;

    private String MANEJOSANCGARRA = null;
    private String MANEJOSANCONGAR = null;
    private String MANEJOSANGAREOT = null;
    private String MANEJOSANGARCOS = null;

    private String MANEJOSANANAPAR = null;
    private String MANEJOSANFREDES = null;
    private String MANEJOSANFREOTR = null;

    private String MANEJOSANPERPAR = null;
    private String MANEJOSANABORTO = null;
    private String MANEJOSANDIARRE = null;
    private String MANEJOSANSEPTIC = null;
    private String MANEJOSANENFRES = null;
    private String MANEJOSANMASTIT = null;
    private String MANEJOSANRABIAD = null;
    private String MANEJOSANOCULAR = null;
    private String MANEJOSANGABARR = null;
    private String MANEJOSANECTIMA = null;
    private String MANEJOSANPARASA = null;
    private String MANEJOSANOTROPR = null;
    private String MANEJOSANPREDTO = null;

    private String MANEJOSANBAJFER = null;
    private String MANEJOSANEDADDE = null;
    private String MANEJOSANBAJPRO = null;
    private String MANEJOSANENFERM = null;
    private String MANEJOSANTEMPER = null;
    private String MANEJOSANPROPAT = null;
    private String MANEJOSANOTRODE = null;
    private String MANEJOSANEDTODE = null;

    private String MANEJOSANCOSTME = null;
    private String MANEJOSANCAPCEN = null;
    private String MANEJOSANREGINF = null;
    private String MANEJOSANDISVET = null;
    private String MANEJOSANCOSVET = null;
    private String MANEJOSANDIAGSI = null;
    private String MANEJOSANOTROSA = null;
    private String MANEJOSANEDTOSA = null;


    //Linearlayout
    LinearLayout lncampsan;
    LinearLayout lnprogvac;
    LinearLayout lncontgarrap;


    //EditText
    EditText edtPecuariocampaniasanitariaotra;
    EditText edtPecuarioprogramavacotr;
    EditText edtPecuariocontrolgarrapataotra;
    EditText edtPecuariocontrolgarrapatacosto;
    EditText edtPecuariodesparasitarotra;
    EditText edtSanganadootroesp;
    EditText edtSanganadodesotra;
    EditText edtSanganadoprobotro;


    //Boton
    Button btnPecusanganado;


    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_manejo_san_ganado);

        //Linearlayout
        lncampsan = (LinearLayout)findViewById(R.id.lncampsan);
        lnprogvac = (LinearLayout)findViewById(R.id.lnprogvac);
        lncontgarrap = (LinearLayout)findViewById(R.id.lncontgarrap);

        //EditText
        edtPecuariocampaniasanitariaotra = (EditText)findViewById(R.id.edtPecuariocampaniasanitariaotra);
        edtPecuarioprogramavacotr = (EditText)findViewById(R.id.edtPecuarioprogramavacotr);
        edtPecuariocontrolgarrapataotra = (EditText)findViewById(R.id.edtPecuariocontrolgarrapataotra);
        edtPecuariocontrolgarrapatacosto = (EditText)findViewById(R.id.edtPecuariocontrolgarrapatacosto);
        edtPecuariodesparasitarotra = (EditText)findViewById(R.id.edtPecuariodesparasitarotra);
        edtSanganadootroesp = (EditText)findViewById(R.id.edtSanganadootroesp);
        edtSanganadodesotra = (EditText)findViewById(R.id.edtSanganadodesotra);
        edtSanganadoprobotro = (EditText)findViewById(R.id.edtSanganadoprobotro);

        //Boton
        btnPecusanganado = (Button)findViewById(R.id.pecuario_next_manejo_ganado);


        //BD
        baseBD         = new DatabaseHelper(this);



        btnPecusanganado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobalPecuario.MANEJOSANCAMZOO = MANEJOSANCAMZOO;
                GlobalPecuario.MANEJOSANTUBERC = MANEJOSANTUBERC;
                GlobalPecuario.MANEJOSANRABIAP = MANEJOSANRABIAP;
                GlobalPecuario.MANEJOSANGARRAP = MANEJOSANGARRAP;
                GlobalPecuario.MANEJOSANBRUCEL = MANEJOSANBRUCEL;
                GlobalPecuario.MANEJOSANOTROCA = MANEJOSANOTROCA;
                obtenerOtracampaniasan();
                GlobalPecuario.MANEJOSANEDTOTR = MANEJOSANEDTOTR;


                GlobalPecuario.MANEJOSANPROVAC = MANEJOSANPROVAC;
                GlobalPecuario.MANEJOSANNEUMON = MANEJOSANNEUMON;
                GlobalPecuario.MANEJOSANDOBLEV = MANEJOSANDOBLEV;
                GlobalPecuario.MANEJOSANTRIPLE = MANEJOSANTRIPLE;
                GlobalPecuario.MANEJOSANCLOSTR = MANEJOSANCLOSTR;
                GlobalPecuario.MANEJOSANDERRIE = MANEJOSANDERRIE;
                GlobalPecuario.MANEJOSANLEPTOS = MANEJOSANLEPTOS;
                GlobalPecuario.MANEJOSANOTRAVA = MANEJOSANOTRAVA;
                obtenerOtroprogramvac();
                GlobalPecuario.MANEJOSANEDTOTV = MANEJOSANEDTOTV;


                GlobalPecuario.MANEJOSANCGARRA = MANEJOSANCGARRA;
                GlobalPecuario.MANEJOSANCONGAR = MANEJOSANCONGAR;
                obtenerOtroctrlgar();
                GlobalPecuario.MANEJOSANGAREOT = MANEJOSANGAREOT;
                GlobalPecuario.MANEJOSANGARCOS = MANEJOSANGARCOS;


                GlobalPecuario.MANEJOSANANAPAR = MANEJOSANANAPAR;
                GlobalPecuario.MANEJOSANFREDES = MANEJOSANFREDES;
                obtenerOtrafrecdesparas();
                GlobalPecuario.MANEJOSANFREOTR = MANEJOSANFREOTR;



                GlobalPecuario.MANEJOSANPERPAR = MANEJOSANPERPAR;
                GlobalPecuario.MANEJOSANABORTO = MANEJOSANABORTO;
                GlobalPecuario.MANEJOSANDIARRE = MANEJOSANDIARRE;
                GlobalPecuario.MANEJOSANSEPTIC = MANEJOSANSEPTIC;
                GlobalPecuario.MANEJOSANENFRES = MANEJOSANENFRES;
                GlobalPecuario.MANEJOSANMASTIT = MANEJOSANMASTIT;
                GlobalPecuario.MANEJOSANRABIAD = MANEJOSANRABIAD;
                GlobalPecuario.MANEJOSANOCULAR = MANEJOSANOCULAR;
                GlobalPecuario.MANEJOSANGABARR = MANEJOSANGABARR;
                GlobalPecuario.MANEJOSANECTIMA = MANEJOSANECTIMA;
                GlobalPecuario.MANEJOSANPARASA = MANEJOSANPARASA;
                GlobalPecuario.MANEJOSANOTROPR = MANEJOSANOTROPR;
                obtenerOtroprobsan();
                GlobalPecuario.MANEJOSANPREDTO = MANEJOSANPREDTO;



                GlobalPecuario.MANEJOSANBAJFER = MANEJOSANBAJFER;
                GlobalPecuario.MANEJOSANEDADDE = MANEJOSANEDADDE;
                GlobalPecuario.MANEJOSANBAJPRO = MANEJOSANBAJPRO;
                GlobalPecuario.MANEJOSANENFERM = MANEJOSANENFERM;
                GlobalPecuario.MANEJOSANTEMPER = MANEJOSANTEMPER;
                GlobalPecuario.MANEJOSANPROPAT = MANEJOSANPROPAT;
                GlobalPecuario.MANEJOSANOTRODE = MANEJOSANOTRODE;
                obtenerOtracausadesanim();
                GlobalPecuario.MANEJOSANEDTODE = MANEJOSANEDTODE;



                GlobalPecuario.MANEJOSANCOSTME = MANEJOSANCOSTME;
                GlobalPecuario.MANEJOSANCAPCEN = MANEJOSANCAPCEN;
                GlobalPecuario.MANEJOSANREGINF = MANEJOSANREGINF;
                GlobalPecuario.MANEJOSANDISVET = MANEJOSANDISVET;
                GlobalPecuario.MANEJOSANCOSVET = MANEJOSANCOSVET;
                GlobalPecuario.MANEJOSANDIAGSI = MANEJOSANDIAGSI;
                GlobalPecuario.MANEJOSANOTROSA = MANEJOSANOTROSA;
                obtenerOtroproblareasalud();
                GlobalPecuario.MANEJOSANEDTOSA = MANEJOSANEDTOSA;


                agregaMansanitariog();
                Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PecuarioManejoSanGanado.this, ManejoSanitarioOrdenia.class));
                finish();
            }
        });
    }


    //INSERCION DE DATOS
    public void agregaMansanitariog(){

        addManejosanitariogan();

    }




    ///Agregar manejo sanitario ganado

    private void addManejosanitariogan(){
        boolean insertarData = baseBD.addPecumanejosanganado();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }






    //Participa en alguna campaña zoosanitaria
    public void clickcampaniazoo(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariocampaniasanitariasi:
                if (checked) {
                    lncampsan.setVisibility(View.VISIBLE);
                    MANEJOSANCAMZOO = "Sí";

                }

                break;


            case R.id.radioPecuariocampaniasanitariano:
                if (checked) {
                    lncampsan.setVisibility(View.GONE);
                    MANEJOSANCAMZOO = "No";

                }

                break;

        }

    }


    //campañas en las que participa
    public void clickcampaniapartic(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkPecuariocampaniasanitariatuberculosis:
                if (checked) {
                    MANEJOSANTUBERC = "Tuberculosis bovina";

                }else{
                    MANEJOSANTUBERC = null;
                }

                break;


            case R.id.checkPecuariocampaniasanitariarabia:
                if (checked) {
                    MANEJOSANRABIAP = "Rabia paralítica";

                }else{
                    MANEJOSANRABIAP = null;
                }

                break;




            case R.id.checkPecuariocampaniasanitariagarrapata:
                if (checked) {
                    MANEJOSANGARRAP = "Garrapata";

                }else{
                    MANEJOSANGARRAP = null;
                }

                break;



            case R.id.checkPecuariocampaniasanitariabrucelosis:
                if (checked) {
                    MANEJOSANBRUCEL = "Brucelosis";

                }else{
                    MANEJOSANBRUCEL = null;
                }

                break;


            case R.id.checkPecuariocampaniasanitariaotra:
                if (checked) {
                    edtPecuariocampaniasanitariaotra.setVisibility(View.VISIBLE);
                    MANEJOSANOTROCA = "Otra";

                }else{
                    edtPecuariocampaniasanitariaotra.setVisibility(View.GONE);
                    MANEJOSANOTROCA = null;
                }

                break;

        }

    }


    public void obtenerOtracampaniasan(){

        if(!edtPecuariocampaniasanitariaotra.getText().toString().isEmpty()){
            MANEJOSANEDTOTR = edtPecuariocampaniasanitariaotra.getText().toString();
        } else{
            MANEJOSANEDTOTR = null;
        }
    }








    //Participa programa de vacunacion establecido
    public void clickprogramavacunacion(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuarioprogramavacsi:
                if (checked) {
                    lnprogvac.setVisibility(View.VISIBLE);
                    MANEJOSANPROVAC = "Sí";

                }

                break;


            case R.id.radioPecuarioprogramavacno:
                if (checked) {
                    lnprogvac.setVisibility(View.GONE);
                    MANEJOSANPROVAC = "No";

                }

                break;

        }

    }


    //programas de vacunacion
    public void clickprogramasvacunac(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkPecuarioprogramavacneumonia:
                if (checked) {
                    MANEJOSANNEUMON = "Neumonía";

                }else{
                    MANEJOSANNEUMON = null;
                }

                break;


            case R.id.checkPecuarioprogramavacdoblesepcarb:
                if (checked) {
                    MANEJOSANDOBLEV = "Doble (septicemia + Carbón)";

                }else{
                    MANEJOSANDOBLEV = null;
                }

                break;




            case R.id.checkPecuarioprogramavactriplesepcarbedema:
                if (checked) {
                    MANEJOSANTRIPLE = "triple (Septicemia + Carbón + Edema)";

                }else{
                    MANEJOSANTRIPLE = null;
                }

                break;



            case R.id.checkPecuarioprogramavacclost:
                if (checked) {
                    MANEJOSANCLOSTR = "Clostridiasis (ocho vías o más)";

                }else{
                    MANEJOSANCLOSTR = null;
                }

                break;


            case R.id.checkPecuarioprogramavacder:
                if (checked) {
                    MANEJOSANDERRIE = "Derriengue";

                }else{
                    MANEJOSANDERRIE = null;
                }

                break;


            case R.id.checkPecuarioprogramavaclep:
                if (checked) {
                    MANEJOSANLEPTOS = "Leptospira";

                }else{
                    MANEJOSANLEPTOS = null;
                }

                break;


            case R.id.checkPecuarioprogramavacotra:
                if (checked) {
                    edtPecuarioprogramavacotr.setVisibility(View.VISIBLE);
                    MANEJOSANOTRAVA = "Otra";

                }else{
                    edtPecuarioprogramavacotr.setVisibility(View.GONE);
                    MANEJOSANOTRAVA = null;
                }

                break;

        }

    }


    public void obtenerOtroprogramvac(){

        if(!edtPecuarioprogramavacotr.getText().toString().isEmpty()){
            MANEJOSANEDTOTV = edtPecuarioprogramavacotr.getText().toString();
        } else{
            MANEJOSANEDTOTV = null;
        }
    }




    //control de garrapatas
    public void clickctrlgarrapata(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariocontrolgarrapatasi:
                if (checked) {
                    lncontgarrap.setVisibility(View.VISIBLE);
                    MANEJOSANCGARRA = "Sí";

                }

                break;


            case R.id.radioPecuariocontrolgarrapatano:
                if (checked) {
                    lncontgarrap.setVisibility(View.GONE);
                    MANEJOSANCGARRA = "No";

                }

                break;

        }

    }

    //seleccion de control de garrapatas
    public void clickselctrlgarrapata(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariocontrolgarrapatabanio:
                if (checked) {
                    edtPecuariocontrolgarrapataotra.setVisibility(View.GONE);
                    MANEJOSANCONGAR = "Baño";

                }

                break;


            case R.id.radioPecuariocontrolgarrapatapour:
                if (checked) {
                    edtPecuariocontrolgarrapataotra.setVisibility(View.GONE);
                    MANEJOSANCONGAR = "Pour on (lomo)";

                }

                break;

            case R.id.radioPecuariocontrolgarrapatainyectado:
                if (checked) {
                    edtPecuariocontrolgarrapataotra.setVisibility(View.GONE);
                    MANEJOSANCONGAR = "Inyectado";

                }

                break;


            case R.id.radioPecuariocontrolgarrapataotra:
                if (checked) {
                    edtPecuariocontrolgarrapataotra.setVisibility(View.VISIBLE);
                    MANEJOSANCONGAR = "Otra";

                }

                break;

        }

    }


    public void obtenerOtroctrlgar(){

        if(!edtPecuariocontrolgarrapataotra.getText().toString().isEmpty()){
            MANEJOSANGAREOT = edtPecuariocontrolgarrapataotra.getText().toString();
        } else{
            MANEJOSANGAREOT = null;
        }

        if(!edtPecuariocontrolgarrapatacosto.getText().toString().isEmpty()){
            MANEJOSANGARCOS = edtPecuariocontrolgarrapatacosto.getText().toString();
        } else{
            MANEJOSANGARCOS = null;
        }

    }


    //analisis para determinar parasitos
    public void clickanalidetermparasitos(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuarioanalisisparasitosi:
                if (checked) {
                    MANEJOSANANAPAR = "Sí";

                }

                break;


            case R.id.radioPecuarioanalisisparasitono:
                if (checked) {
                    MANEJOSANANAPAR = "No";

                }

                break;

        }

    }



    //Frecuencia desparasita ganado
    public void clickfrecuencdespganado(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariodesparasitaranio:
                if (checked) {
                    edtPecuariodesparasitarotra.setVisibility(View.GONE);
                    MANEJOSANFREDES = "Una vez al año";

                }

                break;


            case R.id.radioPecuariodesparasitarseismeses:
                if (checked) {
                    edtPecuariodesparasitarotra.setVisibility(View.GONE);
                    MANEJOSANFREDES = "Cada seis meses";

                }

                break;


            case R.id.radioPecuariodesparasitarmes:
                if (checked) {
                    edtPecuariodesparasitarotra.setVisibility(View.GONE);
                    MANEJOSANFREDES = "Una vez al mes ";

                }

                break;


            case R.id.radioPecuariodesparasitarnunca:
                if (checked) {
                    edtPecuariodesparasitarotra.setVisibility(View.GONE);
                    MANEJOSANFREDES = "Nunca";

                }

                break;


            case R.id.radioPecuariodesparasitarotra:
                if (checked) {
                    edtPecuariodesparasitarotra.setVisibility(View.VISIBLE);
                    MANEJOSANFREDES = "Otro (especificar)";

                }

                break;


        }

    }


    public void obtenerOtrafrecdesparas(){

        if(!edtPecuariodesparasitarotra.getText().toString().isEmpty()){
            MANEJOSANFREOTR = edtPecuariodesparasitarotra.getText().toString();
        } else{
            MANEJOSANFREOTR = null;
        }


    }







    //problemas sanitarios presentado en ganado
    public void clickproblemassangan(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkSanganadoperiparto:
                if (checked) {
                    MANEJOSANPERPAR = "Peri parto: retención de placenta, metritis, piometra";

                }else{
                    MANEJOSANPERPAR = null;
                }

                break;


            case R.id.checkSanganadoaborto:
                if (checked) {
                    MANEJOSANABORTO = "Abortos";

                }else{
                    MANEJOSANABORTO = null;
                }

                break;




            case R.id.checkSanganadodiarrea:
                if (checked) {
                    MANEJOSANDIARRE = "Diarreas";

                }else{
                    MANEJOSANDIARRE = null;
                }

                break;



            case R.id.checkSanganadosepticem:
                if (checked) {
                    MANEJOSANSEPTIC = "Septicemias";

                }else{
                    MANEJOSANSEPTIC = null;
                }

                break;


            case R.id.checkSanganadoenfrespiratorias:
                if (checked) {
                    MANEJOSANENFRES = "Enfermedades respiratorias ";

                }else{
                    MANEJOSANENFRES = null;
                }

                break;


            case R.id.checkSanganadomastitis:
                if (checked) {
                    MANEJOSANMASTIT = "Mastitis";

                }else{
                    MANEJOSANMASTIT = null;
                }

                break;


            case R.id.checkSanganadorabiader:
                if (checked) {
                    MANEJOSANRABIAD = "Rabia (derriengue)";

                }else{
                    MANEJOSANRABIAD = null;
                }

                break;


            case R.id.checkSanganadooculares:
                if (checked) {
                    MANEJOSANOCULAR = "Oculares (conjuntivitis)";

                }else{
                    MANEJOSANOCULAR = null;
                }

                break;



            case R.id.checkSanganadogarrabos:
                if (checked) {
                    MANEJOSANGABARR = "Gabarro ";

                }else{
                    MANEJOSANGABARR = null;
                }

                break;


            case R.id.checkSanganadoectima:
                if (checked) {
                    MANEJOSANECTIMA = "Ectima contagioso (ovinos y caprinos)";

                }else{
                    MANEJOSANECTIMA = null;
                }

                break;


            case R.id.checkSanganadoparasitarias:
                if (checked) {
                    MANEJOSANPARASA = "Parasitarias asociadas con la garrapata ";

                }else{
                    MANEJOSANPARASA = null;
                }

                break;



            case R.id.checkSanganadootroesp:
                if (checked) {
                    edtSanganadootroesp.setVisibility(View.VISIBLE);
                    MANEJOSANOTROPR = "Otro (especificar)";

                }else{
                    edtSanganadootroesp.setVisibility(View.GONE);
                    MANEJOSANOTROPR = null;
                }

                break;

        }

    }


    //OTRO PROBLEMA SANITARIO
    public void obtenerOtroprobsan() {

        if (!edtSanganadootroesp.getText().toString().isEmpty()) {
            MANEJOSANPREDTO = edtSanganadootroesp.getText().toString();
        } else {
            MANEJOSANPREDTO = null;
        }

    }





    //causas de desechos animales
    public void clickcausasdesechanim(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkSanganadobajafertilidad:
                if (checked) {
                    MANEJOSANBAJFER = "Baja fertilidad";

                }else{
                    MANEJOSANBAJFER = null;
                }

                break;


            case R.id.checkSanganadoedad:
                if (checked) {
                    MANEJOSANEDADDE = "Edad";

                }else{
                    MANEJOSANEDADDE = null;
                }

                break;




            case R.id.checkSanganadobajaproduccion:
                if (checked) {
                    MANEJOSANBAJPRO = "Baja producción (leche, partos, destetes)";

                }else{
                    MANEJOSANBAJPRO = null;
                }

                break;



            case R.id.checkSanganadoenfermedad:
                if (checked) {
                    MANEJOSANENFERM = "Enfermedades";

                }else{
                    MANEJOSANENFERM = null;
                }

                break;


            case R.id.checkSanganadotemperamento:
                if (checked) {
                    MANEJOSANTEMPER = "Temperamento";

                }else{
                    MANEJOSANTEMPER = null;
                }

                break;


            case R.id.checkSanganadoprobpatas:
                if (checked) {
                    MANEJOSANPROPAT = "Problemas de patas";

                }else{
                    MANEJOSANPROPAT = null;
                }

                break;


            case R.id.checkSanganadodesotra:
                if (checked) {
                    edtSanganadodesotra.setVisibility(View.VISIBLE);
                    MANEJOSANOTRODE = "Otro (especificar)" ;

                }else{
                    edtSanganadodesotra.setVisibility(View.GONE);
                    MANEJOSANOTRODE = null;
                }

                break;



        }

    }


    //OTRO CAUSA DESECHO ANIMAL
    public void obtenerOtracausadesanim() {

        if (!edtSanganadodesotra.getText().toString().isEmpty()) {
            MANEJOSANEDTODE = edtSanganadodesotra.getText().toString();
        } else {
            MANEJOSANEDTODE = null;
        }
    }





    //problemas aquejan en area de salud
    public void clickproblemareasalud(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkSanganadocostomedicamentos:
                if (checked) {
                    MANEJOSANCOSTME = "Costo de medicamentos e insumos veterinarios";

                }else{
                    MANEJOSANCOSTME = null;
                }

                break;


            case R.id.checkSanganadocapaccontrolenferm:
                if (checked) {
                    MANEJOSANCAPCEN = "Capacitación para control de enfermedades";

                }else{
                    MANEJOSANCAPCEN = null;
                }

                break;




            case R.id.checkSanganadoregistroinformacion:
                if (checked) {
                    MANEJOSANREGINF = "Registro de información";

                }else{
                    MANEJOSANREGINF = null;
                }

                break;



            case R.id.checkSanganadodisponveter:
                if (checked) {
                    MANEJOSANDISVET = "Disponibilidad de Veterinario ";

                }else{
                    MANEJOSANDISVET = null;
                }

                break;


            case R.id.checkSanganadocostoveterinario:
                if (checked) {
                    MANEJOSANCOSVET = "Costo del veterinario";

                }else{
                    MANEJOSANCOSVET = null;
                }

                break;


            case R.id.checkSanganadodiagsintomas:
                if (checked) {
                    MANEJOSANDIAGSI = "Diagnóstico de síntomas básicos";

                }else{
                    MANEJOSANDIAGSI = null;
                }

                break;


            case R.id.checkSanganadoprobotro:
                if (checked) {
                    edtSanganadoprobotro.setVisibility(View.VISIBLE);
                    MANEJOSANOTROSA = "Otro (especificar)" ;

                }else{
                    edtSanganadoprobotro.setVisibility(View.GONE);
                    MANEJOSANOTROSA = null;
                }

                break;



        }

    }


    //OTRO CAUSA DESECHO ANIMAL
    public void obtenerOtroproblareasalud() {

        if (!edtSanganadoprobotro.getText().toString().isEmpty()) {
            MANEJOSANEDTOSA = edtSanganadoprobotro.getText().toString();
        } else {
            MANEJOSANEDTOSA = null;
        }
    }



    @Override
    public void onBackPressed() {

    }


}
