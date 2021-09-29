package com.example.geosegalmex.Productor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class ProductorFamilia extends AppCompatActivity {


    //Variables locales
    private String CANTIDADINT = null;
    private String PERTORGANIZACION = null;

    private String COMPRAINSUMOS = null;
    private String ASESORIATECNICA = null;
    private String FINANCIAMIENTO = null;
    private String COMERCIALIZACION = null;
    private String GESTADMJURIDICA = null;

    private String TIENEFINANCIAMIENTO = null;

    //Modificar para que cambie para cada check
    //private String QUIENOTORGA = null;
    private String OTORGABANCO = null;
    private String OTORGAGOBIERNO = null;
    private String OTORGAFINNAC = null;
    private String OTORGAFINRUR = null;
    private String OTORGAFINOTRO = null;
    private String EDTOTORGFINOTRO = null;

    private String MONTOFINANCIAMIENTO = null;

    private String SERVSECTORSALUD = null;
    private String SERVSECTORSOCIAL = null;
    private String SERVOTROSSECTORES = null;
    private String SERVFINDELUCRO = null;
    private String SERVSINFINDELUCRO = null;

    private String CONTARPERSSUFICIENTE = null;
    private String SATISFACCIONSERVICIO = null;



    private DatabaseHelper baseBD;

    //TextView
    TextView txtMontofinanc;

    //EditText
    EditText edIntegrantes;
    EditText edtMontototfinanc;

    EditText edtOtofinancotro;


    //Linear layout
    LinearLayout layoutApOrgan;
    LinearLayout lnUtfinancpr;


    Button btnProductorcomp, btnIntegranteFamilia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productor_familia);


        //TextView
        txtMontofinanc = (TextView)findViewById(R.id.txtMontofinanc);

        //EditText
        edIntegrantes = (EditText)findViewById(R.id.edtIntegrantes);
        edtMontototfinanc = (EditText)findViewById(R.id.edtMontototfinanc);

        edtOtofinancotro = (EditText)findViewById(R.id.edtOtofinancotro);

        //Linearlayout
        layoutApOrgan = (LinearLayout)findViewById(R.id.layoutApOrgan);
        lnUtfinancpr = (LinearLayout)findViewById(R.id.lnUtfinancpr);


        //Botones
        btnProductorcomp = (Button)findViewById(R.id.btnAgrProdcomp);//Boton que retorna a la vista Identificacion del Cuestionario
        btnIntegranteFamilia = (Button)findViewById(R.id.btnAgrIntfamilia); // Manda a la vista Integrante Familia


        //BD
        baseBD         = new DatabaseHelper(this);



        btnIntegranteFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductorFamilia.this, IntegranteFamilia.class));
            }
        });


        btnProductorcomp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean valorCantint = validaCantidadintegrantes();

                if(!valorCantint){


                    General.CantidadIntegrantesUpf = CANTIDADINT;
                    General.PerteneceOrganizacion = PERTORGANIZACION;
                    General.ApoyoOrganizins = COMPRAINSUMOS;
                    General.ApoyoOrganizase = ASESORIATECNICA;
                    General.ApoyoOrganizfin = FINANCIAMIENTO;
                    General.ApoyoOrganizcom = COMERCIALIZACION;
                    General.ApoyoOrganizgest = GESTADMJURIDICA;
                    General.FinanciamientoOrganizacion = TIENEFINANCIAMIENTO;

                    //General.FinanciamientoOtorga = QUIENOTORGA;
                    General.OTORGABANCO = OTORGABANCO;
                    General.OTORGAGOBIERNO = OTORGAGOBIERNO;
                    General.OTORGAFINNAC = OTORGAFINNAC;
                    General.OTORGAFINRUR = OTORGAFINRUR;
                    General.OTORGAFINOTRO = OTORGAFINOTRO;

                    validaOtrofinanciamiento();
                    General.EDTOTORGFINOTRO = EDTOTORGFINOTRO;


                    montoTotalfinanciamiento();
                    General.MontoFinanciamiento = MONTOFINANCIAMIENTO;

                    General.ServicioSectorSalud = SERVSECTORSALUD;
                    General.ServicioSectorSocial = SERVSECTORSOCIAL;
                    General.ServicioOtroSector = SERVOTROSSECTORES;
                    General.PrivadoFinLucro = SERVFINDELUCRO;
                    General.PrivadoSinFinLucro = SERVSINFINDELUCRO;
                    General.SuficientePersonal = CONTARPERSSUFICIENTE;
                    General.SatisfaccionServicio = SATISFACCIONSERVICIO;

                    agregarInformacproductor();

                    Toast.makeText(getApplicationContext(), "Se agrego satisfactoriamente ", Toast.LENGTH_SHORT).show();
                    finish();

                }else{

                    Toast.makeText(getApplicationContext(), "Faltan datos del productor", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }





    public void agregarInformacproductor(){

        //General.MaterialViviendaParedOtro = edtOtromatpared.getText().toString();

        addProductorInfo();

    }




    ///Agregar el productor

    private void addProductorInfo(){
        boolean insertarData = baseBD.addProductorInformac();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }


    //VALIDA CANTIDAD INTEGRANTES
    private Boolean validaCantidadintegrantes(){
        if(edIntegrantes.getText().toString().isEmpty()){

            CANTIDADINT = null;

            return  true;

        }else if(!edIntegrantes.getText().toString().isEmpty()){
            CANTIDADINT = edIntegrantes.getText().toString();
            return false;
        }


        return false;
    }






    //Metodo para saber si pertenece organizacion
    public void clickPertorganizacion(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSiorganizac:
                if (checked) {
                    layoutApOrgan.setVisibility(View.VISIBLE);
                    PERTORGANIZACION = "Sí";

                }

                break;



            case R.id.radioNoorganizac:
                if (checked) {
                    layoutApOrgan.setVisibility(View.GONE);
                    PERTORGANIZACION = "No";

                }

                break;


        }

    }



    //
    public void clickApoyorganizacion(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkComprainsumos:
                if (checked) {
                    COMPRAINSUMOS = "Compra de insumos";

                } else {
                    COMPRAINSUMOS = null;
                }
                break;


            case R.id.checkAsetecnica:
                if (checked) {
                    ASESORIATECNICA = "Asesoría técnica";

                } else {
                    ASESORIATECNICA = null;
                }
                break;


            case R.id.checkFinanciamiento:
                if (checked) {
                    FINANCIAMIENTO = "Financiamiento";

                } else {
                    FINANCIAMIENTO = null;
                }
                break;


            case R.id.checkComercializac:
                if (checked) {
                    COMERCIALIZACION = "Comercialización";

                } else {
                    COMERCIALIZACION = null;
                }
                break;


            case R.id.checkGestadministrativa:
                if (checked) {
                    GESTADMJURIDICA = "Gestión administrativa - jurídica";

                } else {
                    GESTADMJURIDICA = null;
                }
                break;
        }
    }






    //Metodo para utiliza financiamiento
    public void clickUtilizafinanciamiento(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSifinanc:
                if (checked) {
                    lnUtfinancpr.setVisibility(View.VISIBLE);
                    txtMontofinanc.setVisibility(View.VISIBLE);
                    edtMontototfinanc.setVisibility(View.VISIBLE);
                    TIENEFINANCIAMIENTO = "Sí";

                }

                break;


            case R.id.radioNofinanc:
                if (checked) {
                    lnUtfinancpr.setVisibility(View.GONE);
                    txtMontofinanc.setVisibility(View.GONE);
                    edtMontototfinanc.setVisibility(View.GONE);
                    TIENEFINANCIAMIENTO = "No";

                }

                break;
        }

    }



    //Metodo para utiliza financiamiento
    public void clickQuienfinancia(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkOtobanco:
                if (checked) {
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGABANCO = "Banco";

                }else{
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGABANCO = null;
                }

                break;


            case R.id.checkOtogobierno:
                if (checked) {
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGAGOBIERNO = "Gobierno";

                }else{
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGAGOBIERNO = null;
                }

                break;



            case R.id.checkOtofinancnac:
                if (checked) {
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGAFINNAC = "Financiera nacional";

                }else{
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGAFINNAC = null;
                }

                break;


            case R.id.checkOtofinancotro:
                if (checked) {
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGAFINRUR = "Financiera rural";

                }else{
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGAFINRUR = null;
                }

                break;


            case R.id.checkOtofinancrur:
                if (checked) {
                    edtOtofinancotro.setVisibility(View.VISIBLE);
                    OTORGAFINOTRO = "Otro";

                }else{
                    edtOtofinancotro.setVisibility(View.GONE);
                    OTORGAFINOTRO = null;
                }

                break;
        }

    }



    public void validaOtrofinanciamiento(){
        if(!edtOtofinancotro.getText().toString().isEmpty()){
            EDTOTORGFINOTRO = edtOtofinancotro.getText().toString();
        }else{
            EDTOTORGFINOTRO = null;
        }
    }


    //Valida Monto total financiamiento
    public void montoTotalfinanciamiento(){
        if(!edtMontototfinanc.getText().toString().isEmpty()){
            MONTOFINANCIAMIENTO = edtMontototfinanc.getText().toString();
        }else {
            MONTOFINANCIAMIENTO = null;
        }

    }





    //Servicios de salud en el lugar
    public void clickServiciosalud(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkPubsectsal:
                if (checked) {
                    SERVSECTORSALUD = "Público sector salud";

                } else {
                    SERVSECTORSALUD = null;
                }
                break;


            case R.id.checkPubsectsoc:
                if (checked) {
                    SERVSECTORSOCIAL = "Público seguridad social";

                } else {
                    SERVSECTORSOCIAL = null;
                }
                break;



            case R.id.checkPubotrosect:
                if (checked) {
                    SERVOTROSSECTORES = "Público otros sectores";

                } else {
                    SERVOTROSSECTORES = null;
                }
                break;



            case R.id.checkPrivfinlucro:
                if (checked) {
                    SERVFINDELUCRO = "Privado con fines de lucro";

                } else {
                    SERVFINDELUCRO = null;
                }
                break;


            case R.id.checkPrivsinfinlucro:
                if (checked) {
                    SERVSINFINDELUCRO = "Privado sin fines de lucro";

                } else {
                    SERVSINFINDELUCRO = null;
                }
                break;
        }
    }





    //Contar Personal suficiente
    public void clickContarpersonalsufic(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSipersonservic:
                if (checked) {
                    CONTARPERSSUFICIENTE = "Sí";

                }

                break;



            case R.id.radioNopersonservic:
                if (checked) {
                    CONTARPERSSUFICIENTE = "No";

                }

                break;

        }
    }









    //Satisfaccion del servicio
    public void clickSatisfaccionserv(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSiperservexc:
                if (checked) {
                    SATISFACCIONSERVICIO = "Excelente";

                }

                break;



            case R.id.radioSiperservbuen:
                if (checked) {
                    SATISFACCIONSERVICIO = "Buena";

                }

                break;



            case R.id.radioSiperservreg:
                if (checked) {
                    SATISFACCIONSERVICIO = "Regular";

                }

                break;


            case R.id.radioSiperservmal:
                if (checked) {
                    SATISFACCIONSERVICIO = "Mala";

                }

                break;




            case R.id.radioSiperservmmal:
                if (checked) {
                    SATISFACCIONSERVICIO = "Muy mala";

                }

                break;

        }
    }




            @Override
    public void onBackPressed() {

    }
}
