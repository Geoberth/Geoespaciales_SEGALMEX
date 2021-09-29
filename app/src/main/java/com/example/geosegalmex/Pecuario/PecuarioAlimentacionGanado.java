package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioAlimentacionGanado extends AppCompatActivity {

    //Variables locales almacenar-informacion PRIMERA TABLA
    private String DIEBOVFOPAAGPCRIA = null;
    private String DIEBOVFOPAAGBEC = null;
    private String DIEBOVFOPAAGDES = null;
    private String DIEBOVFOPAAGFIN = null;
    private String DIEBOVFOPAAGCOSTO = null;

    //EditText de pastoreo agostadero
    EditText edtPecalimbovcosto;

    private String DIEBOVFOPAPRAPCRIA = null;
    private String DIEBOVFOPAPRABEC = null;
    private String DIEBOVFOPAPRADES = null;
    private String DIEBOVFOPAPRAFIN = null;
    private String DIEBOVFOPAPRACOSTO = null;


    //EditText de pastoreo pradera
    EditText edtPeculimpradbovcosto;




    ///////////////////////////////////////////////////////////////
    //Variables locales almacenar-informacion SEGUNDA TABLA
    private String DIEFORENSPCRIA = null;
    private String DIEFORENSBEC = null;
    private String DIEFORENSDES = null;
    private String DIEFORENSFIN = null;
    private String DIEFORENSCOSTO = null;

    private String DIEFORHENPCRIA = null;
    private String DIEFORHENBEC = null;
    private String DIEFORHENDES = null;
    private String DIEFORHENFIN = null;
    private String DIEFORHENCOSTO = null;

    private String DIEFORPACALFPCRIA = null;
    private String DIEFORPACALFBEC = null;
    private String DIEFORPACALFDES = null;
    private String DIEFORPACALFFIN = null;
    private String DIEFORPACALFCOSTO = null;



    private String DIECONCOMPCRIA = null;
    private String DIECONCOMBEC = null;
    private String DIECONCOMDES = null;
    private String DIECONCOMFIN = null;
    private String DIECONCOMCOSTO = null;

    private String DIECONMAIZPCRIA = null;
    private String DIECONMAIZBEC = null;
    private String DIECONMAIZDES = null;
    private String DIECONMAIZFIN = null;
    private String DIECONMAIZCOSTO = null;

    private String DIECONPASTAPCRIA = null;
    private String DIECONPASTABEC = null;
    private String DIECONPASTADES = null;
    private String DIECONPASTAFIN = null;
    private String DIECONPASTACOSTO = null;

    private String DIECONBLOQMINPCRIA = null;
    private String DIECONBLOQMINBEC = null;
    private String DIECONBLOQMINDES = null;
    private String DIECONBLOQMINFIN = null;
    private String DIECONBLOQMINCOSTO = null;

    private String DIECONMELPCRIA = null;
    private String DIECONMELBEC = null;
    private String DIECONMELDES = null;
    private String DIECONMELFIN = null;
    private String DIECONMELCOSTO = null;

    private String DIECONUREAPCRIA = null;
    private String DIECONUREABEC = null;
    private String DIECONUREADES = null;
    private String DIECONUREAFIN = null;
    private String DIECONUREACOSTO = null;

    private String DIECONVITAMPCRIA = null;
    private String DIECONVITAMBEC = null;
    private String DIECONVITAMDES = null;
    private String DIECONVITAMFIN = null;
    private String DIECONVITAMCOSTO = null;

    private String DIECONSUBPPCRIA = null;
    private String DIECONSUBPBEC = null;
    private String DIECONSUBPDES = null;
    private String DIECONSUBPFIN = null;
    private String DIECONSUBPCOSTO = null;






    //parte del checkbox  Forrajes-Ensilados
    EditText edtPecuarioalimensiladospiecria;
    EditText edtPecuarioalimensiladosbecerro;
    EditText edtPecuarioalimensiladosdesarrollo;
    EditText edtPecuarioalimensiladosfinalizacion;

    EditText edtPecalimenscosto;


    //parte del checkbox  Forrajes-HENOS
    EditText edtPecuarioalimhenospiecria;
    EditText edtPecuarioalimhenosbecerro;
    EditText edtPecuarioalimhenosdesarrollo;
    EditText edtPecuarioalimhenosfinalizacion;

    EditText edtPecalimhenoscosto;


    //parte del checkbox  Forrajes-PACAS DE ALFALFA
    EditText edtPecuarioalimalfalfapiecria;
    EditText edtPecuarioalimalfalfabecerro;
    EditText edtPecuarioalimalfalfadesarrollo;
    EditText edtPecuarioalimalfalfafinalizacion;

    EditText edtPecalimalfalfacosto;

    ////////////////////////////////////////////////////////////////////

    //parte del checkbox  Concentrados-COMERCIALES
    EditText edtPecuarioalimcomercialespiecria;
    EditText edtPecuarioalimcomercialesbecerro;
    EditText edtPecuarioalimcomercialesdesarrollo;
    EditText edtPecuarioalimcomercialesfinalizacion;

    EditText edtPecalimcomescosto;



    //parte del checkbox  Concentrados-GRANO DE MAIZ
    EditText edtPecuarioalimgranomaizpiecria;
    EditText edtPecuarioalimgranomaizbecerro;
    EditText edtPecuarioalimgranomaizdesarrollo;
    EditText edtPecuarioalimgranomaizfinalizacion;

    EditText edtPecalimgranomaizcosto;




    //parte del checkbox  Concentrados-PASTAS PROTEICAS
    EditText edtPecuarioalimpastasprotpiecria;
    EditText edtPecuarioalimpastasprotbecerro;
    EditText edtPecuarioalimpastasprotdesarrollo;
    EditText edtPecuarioalimpastasprotfinalizacion;

    EditText edtPecalimpastprotcosto;



    //parte del checkbox  Concentrados-BLOQUES MINERALES
    EditText edtPecuarioalimbloqminepiecria;
    EditText edtPecuarioalimbloqminebecerro;
    EditText edtPecuarioalimbloqminedesarrollo;
    EditText edtPecuarioalimbloqminefinalizacion;

    EditText edtPecalimbloqminecosto;


    //parte del checkbox  Concentrados-MELAZAS
    EditText edtPecuarioalimmelazapiecria;
    EditText edtPecuarioalimmelazabecerro;
    EditText edtPecuarioalimmelazadesarrollo;
    EditText edtPecuarioalimmelazafinalizacion;

    EditText edtPecalimmelazacosto;


    //parte del checkbox  Concentrados-UREA
    EditText edtPecuarioalimureapiecria;
    EditText edtPecuarioalimureabecerro;
    EditText edtPecuarioalimureadesarrollo;
    EditText edtPecuarioalimureafinalizacion;

    EditText edtPecalimureacosto;


    //parte del checkbox  Concentrados-VITAMINAS Y PREMEZCLAS
    EditText edtPecuarioalimvitaminerpiecria;
    EditText edtPecuarioalimvitaminerbecerro;
    EditText edtPecuarioalimvitaminerdesarrollo;
    EditText edtPecuarioalimvitaminerfinalizacion;

    EditText edtPecalimvitminercosto;


    //parte del checkbox  Concentrados-SUBPRODUCTOS
    EditText edtPecuarioalimsubproductopiecria;
    EditText edtPecuarioalimsubproductobecerro;
    EditText edtPecuarioalimsubproductodesarrollo;
    EditText edtPecuarioalimsubproductofinalizacion;

    EditText edtPecalimsubpcosto;



    //Botones
    Button btnPecualmganado;


    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_alimentacion_ganado);

        //EditText de pastoreo agostadero
        edtPecalimbovcosto = (EditText)findViewById(R.id.edtPecalimbovcosto);


        //EditText de pastoreo praderas
        edtPeculimpradbovcosto = (EditText)findViewById(R.id.edtPeculimpradbovcosto);




        ///////////////////////////////////checkbox  Forrajes-Ensilados/////////////////////////////
        edtPecuarioalimensiladospiecria = (EditText)findViewById(R.id.edtPecuarioalimensiladospiecria);
        edtPecuarioalimensiladosbecerro = (EditText)findViewById(R.id.edtPecuarioalimensiladosbecerro);
        edtPecuarioalimensiladosdesarrollo = (EditText)findViewById(R.id.edtPecuarioalimensiladosdesarrollo);
        edtPecuarioalimensiladosfinalizacion = (EditText)findViewById(R.id.edtPecuarioalimensiladosfinalizacion);

        edtPecalimenscosto = (EditText)findViewById(R.id.edtPecalimenscosto);


        ///////////////////////////////////checkbox  Forrajes-HENOS/////////////////////////////
        edtPecuarioalimhenospiecria = (EditText)findViewById(R.id.edtPecuarioalimhenospiecria);
        edtPecuarioalimhenosbecerro = (EditText)findViewById(R.id.edtPecuarioalimhenosbecerro);
        edtPecuarioalimhenosdesarrollo = (EditText)findViewById(R.id.edtPecuarioalimhenosdesarrollo);
        edtPecuarioalimhenosfinalizacion = (EditText)findViewById(R.id.edtPecuarioalimhenosfinalizacion);

        edtPecalimhenoscosto = (EditText)findViewById(R.id.edtPecalimhenoscosto);



        ///////////////////////////////////checkbox  Forrajes-PACAS DE ALFALFA/////////////////////////////
        edtPecuarioalimalfalfapiecria = (EditText)findViewById(R.id.edtPecuarioalimalfalfapiecria);
        edtPecuarioalimalfalfabecerro = (EditText)findViewById(R.id.edtPecuarioalimalfalfabecerro);
        edtPecuarioalimalfalfadesarrollo = (EditText)findViewById(R.id.edtPecuarioalimalfalfadesarrollo);
        edtPecuarioalimalfalfafinalizacion = (EditText)findViewById(R.id.edtPecuarioalimalfalfafinalizacion);

        edtPecalimalfalfacosto = (EditText)findViewById(R.id.edtPecalimalfalfacosto);




        ///////////////////////////////////checkbox  Concentrados-COMERCIALES/////////////////////////////
        edtPecuarioalimcomercialespiecria = (EditText)findViewById(R.id.edtPecuarioalimcomercialespiecria);
        edtPecuarioalimcomercialesbecerro = (EditText)findViewById(R.id.edtPecuarioalimcomercialesbecerro);
        edtPecuarioalimcomercialesdesarrollo = (EditText)findViewById(R.id.edtPecuarioalimcomercialesdesarrollo);
        edtPecuarioalimcomercialesfinalizacion = (EditText)findViewById(R.id.edtPecuarioalimcomercialesfinalizacion);

        edtPecalimcomescosto = (EditText)findViewById(R.id.edtPecalimcomescosto);


        ///////////////////////////////////checkbox  Concentrados-GRANO DE MAIZ/////////////////////////////
        edtPecuarioalimgranomaizpiecria = (EditText)findViewById(R.id.edtPecuarioalimgranomaizpiecria);
        edtPecuarioalimgranomaizbecerro = (EditText)findViewById(R.id.edtPecuarioalimgranomaizbecerro);
        edtPecuarioalimgranomaizdesarrollo = (EditText)findViewById(R.id.edtPecuarioalimgranomaizdesarrollo);
        edtPecuarioalimgranomaizfinalizacion = (EditText)findViewById(R.id.edtPecuarioalimgranomaizfinalizacion);

        edtPecalimgranomaizcosto = (EditText)findViewById(R.id.edtPecalimgranomaizcosto);



        ///////////////////////////////////checkbox  Concentrados-PASTAS PROTEICAS/////////////////////////////
        edtPecuarioalimpastasprotpiecria = (EditText)findViewById(R.id.edtPecuarioalimpastasprotpiecria);
        edtPecuarioalimpastasprotbecerro = (EditText)findViewById(R.id.edtPecuarioalimpastasprotbecerro);
        edtPecuarioalimpastasprotdesarrollo = (EditText)findViewById(R.id.edtPecuarioalimpastasprotdesarrollo);
        edtPecuarioalimpastasprotfinalizacion = (EditText)findViewById(R.id.edtPecuarioalimpastasprotfinalizacion);

        edtPecalimpastprotcosto = (EditText)findViewById(R.id.edtPecalimpastprotcosto);


        ///////////////////////////////////checkbox  Concentrados-BLOQUES MINERALES/////////////////////////////
        edtPecuarioalimbloqminepiecria = (EditText)findViewById(R.id.edtPecuarioalimbloqminepiecria);
        edtPecuarioalimbloqminebecerro = (EditText)findViewById(R.id.edtPecuarioalimbloqminebecerro);
        edtPecuarioalimbloqminedesarrollo = (EditText)findViewById(R.id.edtPecuarioalimbloqminedesarrollo);
        edtPecuarioalimbloqminefinalizacion = (EditText)findViewById(R.id.edtPecuarioalimbloqminefinalizacion);

        edtPecalimbloqminecosto = (EditText)findViewById(R.id.edtPecalimbloqminecosto);


        ///////////////////////////////////checkbox  Concentrados-MELAZAS/////////////////////////////
        edtPecuarioalimmelazapiecria = (EditText)findViewById(R.id.edtPecuarioalimmelazapiecria);
        edtPecuarioalimmelazabecerro = (EditText)findViewById(R.id.edtPecuarioalimmelazabecerro);
        edtPecuarioalimmelazadesarrollo = (EditText)findViewById(R.id.edtPecuarioalimmelazadesarrollo);
        edtPecuarioalimmelazafinalizacion = (EditText)findViewById(R.id.edtPecuarioalimmelazafinalizacion);

        edtPecalimmelazacosto = (EditText)findViewById(R.id.edtPecalimmelazacosto);


        ///////////////////////////////////checkbox  Concentrados-UREA/////////////////////////////
        edtPecuarioalimureapiecria = (EditText)findViewById(R.id.edtPecuarioalimureapiecria);
        edtPecuarioalimureabecerro = (EditText)findViewById(R.id.edtPecuarioalimureabecerro);
        edtPecuarioalimureadesarrollo = (EditText)findViewById(R.id.edtPecuarioalimureadesarrollo);
        edtPecuarioalimureafinalizacion = (EditText)findViewById(R.id.edtPecuarioalimureafinalizacion);

        edtPecalimureacosto = (EditText)findViewById(R.id.edtPecalimureacosto);


        ///////////////////////////////////checkbox  Concentrados-VITAMINAS Y PREMEZCLAS/////////////////////////////
        edtPecuarioalimvitaminerpiecria = (EditText)findViewById(R.id.edtPecuarioalimvitaminerpiecria);
        edtPecuarioalimvitaminerbecerro = (EditText)findViewById(R.id.edtPecuarioalimvitaminerbecerro);
        edtPecuarioalimvitaminerdesarrollo = (EditText)findViewById(R.id.edtPecuarioalimvitaminerdesarrollo);
        edtPecuarioalimvitaminerfinalizacion = (EditText)findViewById(R.id.edtPecuarioalimvitaminerfinalizacion);

        edtPecalimvitminercosto = (EditText)findViewById(R.id.edtPecalimvitminercosto);


        ///////////////////////////////////checkbox  Concentrados-SUBPRODUCTOS/////////////////////////////
        edtPecuarioalimsubproductopiecria = (EditText)findViewById(R.id.edtPecuarioalimsubproductopiecria);
        edtPecuarioalimsubproductobecerro = (EditText)findViewById(R.id.edtPecuarioalimsubproductobecerro);
        edtPecuarioalimsubproductodesarrollo = (EditText)findViewById(R.id.edtPecuarioalimsubproductodesarrollo);
        edtPecuarioalimsubproductofinalizacion = (EditText)findViewById(R.id.edtPecuarioalimsubproductofinalizacion);

        edtPecalimsubpcosto = (EditText)findViewById(R.id.edtPecalimsubpcosto);




        //Botones
        btnPecualmganado = (Button)findViewById(R.id.pecuario_next_alimentacion_ganado);


        //BD
        baseBD         = new DatabaseHelper(this);


        btnPecualmganado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobalPecuario.DIEBOVFOPAAGPCRIA = DIEBOVFOPAAGPCRIA;
                GlobalPecuario.DIEBOVFOPAAGBEC = DIEBOVFOPAAGBEC;
                GlobalPecuario.DIEBOVFOPAAGDES = DIEBOVFOPAAGDES;
                GlobalPecuario.DIEBOVFOPAAGFIN = DIEBOVFOPAAGFIN;
                obtenCostopastoagostadero();
                GlobalPecuario.DIEBOVFOPAAGCOSTO = DIEBOVFOPAAGCOSTO;

                /////////////////////////////////////////////////////
                GlobalPecuario.DIEBOVFOPAPRAPCRIA = DIEBOVFOPAPRAPCRIA;
                GlobalPecuario.DIEBOVFOPAPRABEC = DIEBOVFOPAPRABEC;
                GlobalPecuario.DIEBOVFOPAPRADES = DIEBOVFOPAPRADES;
                GlobalPecuario.DIEBOVFOPAPRAFIN = DIEBOVFOPAPRAFIN;
                obtenCostopastopradera();
                GlobalPecuario.DIEBOVFOPAPRACOSTO = DIEBOVFOPAPRACOSTO;

                agregarPecupastoreo();

                //Guardado de suministros de forrajes y concentrados
                validacionesAlimentacganado();
                GlobalPecuario.DIEFORENSPCRIA = DIEFORENSPCRIA;
                GlobalPecuario.DIEFORENSBEC = DIEFORENSBEC;
                GlobalPecuario.DIEFORENSDES = DIEFORENSDES;
                GlobalPecuario.DIEFORENSFIN = DIEFORENSFIN;
                GlobalPecuario.DIEFORENSCOSTO = DIEFORENSCOSTO;
                ///////////////
                GlobalPecuario.DIEFORHENPCRIA = DIEFORHENPCRIA;
                GlobalPecuario.DIEFORHENBEC = DIEFORHENBEC;
                GlobalPecuario.DIEFORHENDES = DIEFORHENDES;
                GlobalPecuario.DIEFORHENFIN = DIEFORHENFIN;
                GlobalPecuario.DIEFORHENCOSTO = DIEFORHENCOSTO;
                //////////////
                GlobalPecuario.DIEFORPACALFPCRIA = DIEFORPACALFPCRIA;
                GlobalPecuario.DIEFORPACALFBEC = DIEFORPACALFBEC;
                GlobalPecuario.DIEFORPACALFDES = DIEFORPACALFDES;
                GlobalPecuario.DIEFORPACALFFIN = DIEFORPACALFFIN;
                GlobalPecuario.DIEFORPACALFCOSTO = DIEFORPACALFCOSTO;
                //////////////
                GlobalPecuario.DIECONCOMPCRIA = DIECONCOMPCRIA;
                GlobalPecuario.DIECONCOMBEC = DIECONCOMBEC;
                GlobalPecuario.DIECONCOMDES = DIECONCOMDES;
                GlobalPecuario.DIECONCOMFIN = DIECONCOMFIN;
                GlobalPecuario.DIECONCOMCOSTO = DIECONCOMCOSTO;
                //////////////
                GlobalPecuario.DIECONMAIZPCRIA = DIECONMAIZPCRIA;
                GlobalPecuario.DIECONMAIZBEC = DIECONMAIZBEC;
                GlobalPecuario.DIECONMAIZDES = DIECONMAIZDES;
                GlobalPecuario.DIECONMAIZFIN = DIECONMAIZFIN;
                GlobalPecuario.DIECONMAIZCOSTO = DIECONMAIZCOSTO;
                //////////////
                GlobalPecuario.DIECONPASTAPCRIA = DIECONPASTAPCRIA;
                GlobalPecuario.DIECONPASTABEC = DIECONPASTABEC;
                GlobalPecuario.DIECONPASTADES = DIECONPASTADES;
                GlobalPecuario.DIECONPASTAFIN = DIECONPASTAFIN;
                GlobalPecuario.DIECONPASTACOSTO = DIECONPASTACOSTO;
                //////////////
                GlobalPecuario.DIECONBLOQMINPCRIA = DIECONBLOQMINPCRIA;
                GlobalPecuario.DIECONBLOQMINBEC = DIECONBLOQMINBEC;
                GlobalPecuario.DIECONBLOQMINDES = DIECONBLOQMINDES;
                GlobalPecuario.DIECONBLOQMINFIN = DIECONBLOQMINFIN;
                GlobalPecuario.DIECONBLOQMINCOSTO = DIECONBLOQMINCOSTO;
                //////////////
                GlobalPecuario.DIECONMELPCRIA = DIECONMELPCRIA;
                GlobalPecuario.DIECONMELBEC = DIECONMELBEC;
                GlobalPecuario.DIECONMELDES = DIECONMELDES;
                GlobalPecuario.DIECONMELFIN = DIECONMELFIN;
                GlobalPecuario.DIECONMELCOSTO = DIECONMELCOSTO;
                //////////////
                GlobalPecuario.DIECONUREAPCRIA = DIECONUREAPCRIA;
                GlobalPecuario.DIECONUREABEC = DIECONUREABEC;
                GlobalPecuario.DIECONUREADES = DIECONUREADES;
                GlobalPecuario.DIECONUREAFIN = DIECONUREAFIN;
                GlobalPecuario.DIECONUREACOSTO = DIECONUREACOSTO;
                //////////////
                GlobalPecuario.DIECONVITAMPCRIA = DIECONVITAMPCRIA;
                GlobalPecuario.DIECONVITAMBEC = DIECONVITAMBEC;
                GlobalPecuario.DIECONVITAMDES = DIECONVITAMDES;
                GlobalPecuario.DIECONVITAMFIN = DIECONVITAMFIN;
                GlobalPecuario.DIECONVITAMCOSTO = DIECONVITAMCOSTO;
                //////////////
                GlobalPecuario.DIECONSUBPPCRIA = DIECONSUBPPCRIA;
                GlobalPecuario.DIECONSUBPBEC = DIECONSUBPBEC;
                GlobalPecuario.DIECONSUBPDES = DIECONSUBPDES;
                GlobalPecuario.DIECONSUBPFIN = DIECONSUBPFIN;
                GlobalPecuario.DIECONSUBPCOSTO = DIECONSUBPCOSTO;


                agregarPecugastoforcom();

                Toast.makeText(getApplicationContext(), "Agregados satisfactoriamente", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PecuarioAlimentacionGanado.this, PecuarioComposicDietaOvinosCaprinos.class));
                finish();
            }
        });
    }




    //INSERCION DE DATOS PASTOREO
    public void agregarPecupastoreo(){

        addPecupastoreobov();
    }

    ///Agregar pecuario pastoreo

    private void addPecupastoreobov(){
        boolean insertarData = baseBD.addPecuariopastoreobov();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }



    //INSERCION DE DATOS PASTOREO -DIETA
    public void agregarPecugastoforcom(){

        addPecugastoforcom();
    }


    ///Agregar pecuario pastoreo -dieta

    private void addPecugastoforcom(){
        boolean insertarData = baseBD.addPecuariopastoreodietabov();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }





    ////////////////////////////////////////////////////////////////////////////////
    public void clickPastoagocria(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecuarioalimentacbovinopiecriasi:
                if (checked) {
                    DIEBOVFOPAAGPCRIA = "Sí";

                }
                break;

            case R.id.radioPecuarioalimentacbovinopiecriano:
                if (checked) {
                    DIEBOVFOPAAGPCRIA = "No";

                }
                break;
        }
    }



    ////////////////////////////////////////////////////////////////////////////////
    public void clickPastoagobecerro(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecuarioalimentacbovinobecerrosi:
                if (checked) {
                    DIEBOVFOPAAGBEC = "Sí";

                }
                break;

            case R.id.radioPecuarioalimentacbovinobecerrono:
                if (checked) {
                    DIEBOVFOPAAGBEC = "No";

                }
                break;
        }
    }



    ////////////////////////////////////////////////////////////////////////////////
    public void clickPastoagodesarrollo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecuarioalimentacbovinodesarrollosi:
                if (checked) {
                    DIEBOVFOPAAGDES = "Sí";

                }
                break;

            case R.id.radioPecuarioalimentacbovinodesarrollono:
                if (checked) {
                    DIEBOVFOPAAGDES = "No";

                }
                break;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    public void clickPastoagofinalizac(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecuarioalimentacbovinofinalizacionsi:
                if (checked) {
                    DIEBOVFOPAAGFIN = "Sí";

                }
                break;

            case R.id.radioPecuarioalimentacbovinofinalizacionno:
                if (checked) {
                    DIEBOVFOPAAGFIN = "No";

                }
                break;
        }
    }



    public void obtenCostopastoagostadero(){

        if (edtPecalimbovcosto.getText().toString().isEmpty()){
            DIEBOVFOPAAGCOSTO = null;
        }else{
            DIEBOVFOPAAGCOSTO = edtPecalimbovcosto.getText().toString();
        }

    }



//////////////////////////////////Inicia pastoreo en praderas ///////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////
    public void clickPastoprapiecria(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecualimpradbovpiecriasi:
                if (checked) {
                    DIEBOVFOPAPRAPCRIA = "Sí";

                }
                break;

            case R.id.radioPecualimpradbovpiecriano:
                if (checked) {
                    DIEBOVFOPAPRAPCRIA = "No";

                }
                break;
        }
    }



    //////////////////////////////////////////////////////////////////////////////////////
    public void clickPastoprabecerro(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecualimpradbovbecsi:
                if (checked) {
                    DIEBOVFOPAPRABEC = "Sí";

                }
                break;

            case R.id.radioPecualimpradbovbecno:
                if (checked) {
                    DIEBOVFOPAPRABEC = "No";

                }
                break;
        }
    }


    //////////////////////////////////////////////////////////////////////////////////////
    public void clickPastopradesarrollo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecualimpradbovdesarsi:
                if (checked) {
                    DIEBOVFOPAPRADES = "Sí";

                }
                break;

            case R.id.radioPecualimpradbovdesarno:
                if (checked) {
                    DIEBOVFOPAPRADES = "No";

                }
                break;
        }
    }



    //////////////////////////////////////////////////////////////////////////////////////
    public void clickPastoprafinalizacion(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radioPecualimpradbovfinalsi:
                if (checked) {
                    DIEBOVFOPAPRAFIN = "Sí";

                }
                break;

            case R.id.radioPecualimpradbovfinalno:
                if (checked) {
                    DIEBOVFOPAPRAFIN = "No";

                }
                break;
        }
    }


    public void obtenCostopastopradera(){

        if (edtPeculimpradbovcosto.getText().toString().isEmpty()){
            DIEBOVFOPAPRACOSTO = null;
        }else{
            DIEBOVFOPAPRACOSTO = edtPeculimpradbovcosto.getText().toString();
        }

    }




    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Forrajes-Ensilados ////////////////////////////////////
    public void clickPecuarioalimensilados(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimensiladospiecria:
                if (checked) {
                    edtPecuarioalimensiladospiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimensiladospiecria.setVisibility(View.GONE);

                }
                break;


                ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimensiladosbecerro:
                if (checked) {
                    edtPecuarioalimensiladosbecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimensiladosbecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimensiladosdesarrollo:
                if (checked) {
                    edtPecuarioalimensiladosdesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimensiladosdesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimensiladosfinalizacion:
                if (checked) {
                    edtPecuarioalimensiladosfinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimensiladosfinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }




    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Forrajes-HENOS ///////////////////////////////////
    public void clickPecuarioalimhenos(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimhenospiecria:
                if (checked) {
                    edtPecuarioalimhenospiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimhenospiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimhenosbecerro:
                if (checked) {
                    edtPecuarioalimhenosbecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimhenosbecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimhenosdesarrollo:
                if (checked) {
                    edtPecuarioalimhenosdesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimhenosdesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimhenosfinalizacion:
                if (checked) {
                    edtPecuarioalimhenosfinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimhenosfinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }


    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Forrajes-PACAS DE ALFALFA ///////////////////////////////////
    public void clickPecuarioalimpacasalfalfa(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimalfalfapiecria:
                if (checked) {
                    edtPecuarioalimalfalfapiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimalfalfapiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimalfalfabecerro:
                if (checked) {
                    edtPecuarioalimalfalfabecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimalfalfabecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimalfalfadesarrollo:
                if (checked) {
                    edtPecuarioalimalfalfadesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimalfalfadesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimalfalfafinalizacion:
                if (checked) {
                    edtPecuarioalimalfalfafinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimalfalfafinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }


    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-COMERCIALES ///////////////////////////////////
    public void clickPecuarioalimcomerciales(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimcomercialespiecria:
                if (checked) {
                    edtPecuarioalimcomercialespiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimcomercialespiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimcomercialesbecerro:
                if (checked) {
                    edtPecuarioalimcomercialesbecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimcomercialesbecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimcomercialesdesarrollo:
                if (checked) {
                    edtPecuarioalimcomercialesdesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimcomercialesdesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimcomercialesfinalizacion:
                if (checked) {
                    edtPecuarioalimcomercialesfinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimcomercialesfinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }



    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-GRANO DE MAIZ ///////////////////////////////////
    public void clickPecuarioalimgranomaiz(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimgranomaizpiecria:
                if (checked) {
                    edtPecuarioalimgranomaizpiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimgranomaizpiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimgranomaizbecerro:
                if (checked) {
                    edtPecuarioalimgranomaizbecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimgranomaizbecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimgranomaizdesarrollo:
                if (checked) {
                    edtPecuarioalimgranomaizdesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimgranomaizdesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimgranomaizfinalizacion:
                if (checked) {
                    edtPecuarioalimgranomaizfinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimgranomaizfinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }



    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-PASTAS PROTEICAS ///////////////////////////////////
    public void clickPecuarioalimpastasproteicas(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimpastasprotpiecria:
                if (checked) {
                    edtPecuarioalimpastasprotpiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimpastasprotpiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimpastasprotbecerro:
                if (checked) {
                    edtPecuarioalimpastasprotbecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimpastasprotbecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimpastasprotdesarrollo:
                if (checked) {
                    edtPecuarioalimpastasprotdesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimpastasprotdesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimpastasprotfinalizacion:
                if (checked) {
                    edtPecuarioalimpastasprotfinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimpastasprotfinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }


    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-BLOQUES MINERALES ///////////////////////////////////
    public void clickPecuarioalimbloquesminerales(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimbloqminepiecria:
                if (checked) {
                    edtPecuarioalimbloqminepiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimbloqminepiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimbloqminebecerro:
                if (checked) {
                    edtPecuarioalimbloqminebecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimbloqminebecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimbloqminedesarrollo:
                if (checked) {
                    edtPecuarioalimbloqminedesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimbloqminedesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimbloqminefinalizacion:
                if (checked) {
                    edtPecuarioalimbloqminefinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimbloqminefinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }



    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-MELAZAS ///////////////////////////////////
    public void clickPecuarioalimmelazas(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimmelazapiecria:
                if (checked) {
                    edtPecuarioalimmelazapiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimmelazapiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimmelazabecerro:
                if (checked) {
                    edtPecuarioalimmelazabecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimmelazabecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimmelazadesarrollo:
                if (checked) {
                    edtPecuarioalimmelazadesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimmelazadesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimmelazafinalizacion:
                if (checked) {
                    edtPecuarioalimmelazafinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimmelazafinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }




    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-UREA ///////////////////////////////////
    public void clickPecuarioalimurea(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimureapiecria:
                if (checked) {
                    edtPecuarioalimureapiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimureapiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimureabecerro:
                if (checked) {
                    edtPecuarioalimureabecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimureabecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimureadesarrollo:
                if (checked) {
                    edtPecuarioalimureadesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimureadesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimureafinalizacion:
                if (checked) {
                    edtPecuarioalimureafinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimureafinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }






    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-VITAMINAS Y PREMEZCLAS ///////////////////////////////////
    public void clickPecuarioalimvitaminaspremezclas(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimvitaminerpiecria:
                if (checked) {
                    edtPecuarioalimvitaminerpiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimvitaminerpiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimvitaminerbecerro:
                if (checked) {
                    edtPecuarioalimvitaminerbecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimvitaminerbecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimvitaminerdesarrollo:
                if (checked) {
                    edtPecuarioalimvitaminerdesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimvitaminerdesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimvitaminerfinalizacion:
                if (checked) {
                    edtPecuarioalimvitaminerfinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimvitaminerfinalizacion.setVisibility(View.GONE);

                }
                break;

        }
    }








    ////////////////////////////// validaciones de mostrar la informacion del checkbox  Concentrados-SUBPRODUCTOS ///////////////////////////////////
    public void clickPecuarioalimsubproductos(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimsubproductopiecria:
                if (checked) {
                    edtPecuarioalimsubproductopiecria.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimsubproductopiecria.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimsubproductobecerro:
                if (checked) {
                    edtPecuarioalimsubproductobecerro.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimsubproductobecerro.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimsubproductodesarrollo:
                if (checked) {
                    edtPecuarioalimsubproductodesarrollo.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimsubproductodesarrollo.setVisibility(View.GONE);

                }
                break;


            ////////////////////////////////////////////////////////////////////////
            case R.id.checkPecuarioalimsubproductofinalizacion:
                if (checked) {
                    edtPecuarioalimsubproductofinalizacion.setVisibility(View.VISIBLE);

                } else {
                    edtPecuarioalimsubproductofinalizacion.setVisibility(View.GONE);

                }
                break;




        }
    }


    public void validacionesAlimentacganado(){

        /////////////////////////////// 1 ///////////////////////////////////////////////////////
        if(edtPecuarioalimensiladospiecria.getText().toString().isEmpty()){
            DIEFORENSPCRIA = null;
        }else {
            DIEFORENSPCRIA = edtPecuarioalimensiladospiecria.getText().toString();
        }


        if(edtPecuarioalimensiladosbecerro.getText().toString().isEmpty()){
            DIEFORENSBEC = null;
        }else{
            DIEFORENSBEC = edtPecuarioalimensiladosbecerro.getText().toString();
        }


        if(edtPecuarioalimensiladosdesarrollo.getText().toString().isEmpty()){
            DIEFORENSDES = null;
        }else{
            DIEFORENSDES = edtPecuarioalimensiladosdesarrollo.getText().toString();
        }

        if(edtPecuarioalimensiladosfinalizacion.getText().toString().isEmpty()){
            DIEFORENSFIN = null;
        }else{
            DIEFORENSFIN = edtPecuarioalimensiladosfinalizacion.getText().toString();
        }

        if(edtPecalimenscosto.getText().toString().isEmpty()){
            DIEFORENSCOSTO = null;
        }else{
            DIEFORENSCOSTO = edtPecalimenscosto.getText().toString();
        }

        ///////////////////////////////// 2 /////////////////////////////////////////////////////
        if (edtPecuarioalimhenospiecria.getText().toString().isEmpty()){
            DIEFORHENPCRIA = null;
        }else{
            DIEFORHENPCRIA = edtPecuarioalimhenospiecria.getText().toString();
        }

        if(edtPecuarioalimhenosbecerro.getText().toString().isEmpty()){
            DIEFORHENBEC = null;
        }else {
            DIEFORHENBEC = edtPecuarioalimhenosbecerro.getText().toString();
        }

        if (edtPecuarioalimhenosdesarrollo.getText().toString().isEmpty()){
            DIEFORHENDES = null;
        }else{
            DIEFORHENDES = edtPecuarioalimhenosdesarrollo.getText().toString();
        }

        if (edtPecuarioalimhenosfinalizacion.getText().toString().isEmpty()){
            DIEFORHENFIN = null;
        }else{
            DIEFORHENFIN = edtPecuarioalimhenosfinalizacion.getText().toString();
        }

        if (edtPecalimhenoscosto.getText().toString().isEmpty()){
            DIEFORHENCOSTO = null;
        }else{
            DIEFORHENCOSTO = edtPecalimhenoscosto.getText().toString();
        }



        ///////////////////////////////// 3 /////////////////////////////////////////////////////
        if (edtPecuarioalimalfalfapiecria.getText().toString().isEmpty()){
            DIEFORPACALFPCRIA = null;
        }else{
            DIEFORPACALFPCRIA = edtPecuarioalimalfalfapiecria.getText().toString();
        }

        if(edtPecuarioalimalfalfabecerro.getText().toString().isEmpty()){
            DIEFORPACALFBEC = null;
        }else {
            DIEFORPACALFBEC = edtPecuarioalimalfalfabecerro.getText().toString();
        }

        if (edtPecuarioalimalfalfadesarrollo.getText().toString().isEmpty()){
            DIEFORPACALFDES = null;
        }else{
            DIEFORPACALFDES = edtPecuarioalimalfalfadesarrollo.getText().toString();
        }

        if (edtPecuarioalimalfalfafinalizacion.getText().toString().isEmpty()){
            DIEFORPACALFFIN = null;
        }else{
            DIEFORPACALFFIN = edtPecuarioalimalfalfafinalizacion.getText().toString();
        }

        if (edtPecalimalfalfacosto.getText().toString().isEmpty()){
            DIEFORPACALFCOSTO = null;
        }else{
            DIEFORPACALFCOSTO = edtPecalimalfalfacosto.getText().toString();
        }




        ///////////////////////////////// 4 /////////////////////////////////////////////////////
        if (edtPecuarioalimcomercialespiecria.getText().toString().isEmpty()){
            DIECONCOMPCRIA = null;
        }else{
            DIECONCOMPCRIA = edtPecuarioalimcomercialespiecria.getText().toString();
        }

        if(edtPecuarioalimcomercialesbecerro.getText().toString().isEmpty()){
            DIECONCOMBEC = null;
        }else {
            DIECONCOMBEC = edtPecuarioalimcomercialesbecerro.getText().toString();
        }

        if (edtPecuarioalimcomercialesdesarrollo.getText().toString().isEmpty()){
            DIECONCOMDES = null;
        }else{
            DIECONCOMDES = edtPecuarioalimcomercialesdesarrollo.getText().toString();
        }

        if (edtPecuarioalimcomercialesfinalizacion.getText().toString().isEmpty()){
            DIECONCOMFIN = null;
        }else{
            DIECONCOMFIN = edtPecuarioalimcomercialesfinalizacion.getText().toString();
        }

        if (edtPecalimcomescosto.getText().toString().isEmpty()){
            DIECONCOMCOSTO = null;
        }else{
            DIECONCOMCOSTO = edtPecalimcomescosto.getText().toString();
        }



        ///////////////////////////////// 5 /////////////////////////////////////////////////////
        if (edtPecuarioalimgranomaizpiecria.getText().toString().isEmpty()){
            DIECONMAIZPCRIA = null;
        }else{
            DIECONMAIZPCRIA = edtPecuarioalimgranomaizpiecria.getText().toString();
        }

        if(edtPecuarioalimgranomaizbecerro.getText().toString().isEmpty()){
            DIECONMAIZBEC = null;
        }else {
            DIECONMAIZBEC = edtPecuarioalimgranomaizbecerro.getText().toString();
        }

        if (edtPecuarioalimgranomaizdesarrollo.getText().toString().isEmpty()){
            DIECONMAIZDES = null;
        }else{
            DIECONMAIZDES = edtPecuarioalimgranomaizdesarrollo.getText().toString();
        }

        if (edtPecuarioalimgranomaizfinalizacion.getText().toString().isEmpty()){
            DIECONMAIZFIN = null;
        }else{
            DIECONMAIZFIN = edtPecuarioalimgranomaizfinalizacion.getText().toString();
        }

        if (edtPecalimgranomaizcosto.getText().toString().isEmpty()){
            DIECONMAIZCOSTO = null;
        }else{
            DIECONMAIZCOSTO = edtPecalimgranomaizcosto.getText().toString();
        }




        ///////////////////////////////// 6 /////////////////////////////////////////////////////
        if (edtPecuarioalimpastasprotpiecria.getText().toString().isEmpty()){
            DIECONPASTAPCRIA = null;
        }else{
            DIECONPASTAPCRIA = edtPecuarioalimpastasprotpiecria.getText().toString();
        }

        if(edtPecuarioalimpastasprotbecerro.getText().toString().isEmpty()){
            DIECONPASTABEC = null;
        }else {
            DIECONPASTABEC = edtPecuarioalimpastasprotbecerro.getText().toString();
        }

        if (edtPecuarioalimpastasprotdesarrollo.getText().toString().isEmpty()){
            DIECONPASTADES = null;
        }else{
            DIECONPASTADES = edtPecuarioalimpastasprotdesarrollo.getText().toString();
        }

        if (edtPecuarioalimpastasprotfinalizacion.getText().toString().isEmpty()){
            DIECONPASTAFIN = null;
        }else{
            DIECONPASTAFIN = edtPecuarioalimpastasprotfinalizacion.getText().toString();
        }

        if (edtPecalimpastprotcosto.getText().toString().isEmpty()){
            DIECONPASTACOSTO = null;
        }else{
            DIECONPASTACOSTO = edtPecalimpastprotcosto.getText().toString();
        }




        ///////////////////////////////// 7 /////////////////////////////////////////////////////
        if (edtPecuarioalimbloqminepiecria.getText().toString().isEmpty()){
            DIECONBLOQMINPCRIA = null;
        }else{
            DIECONBLOQMINPCRIA = edtPecuarioalimbloqminepiecria.getText().toString();
        }

        if(edtPecuarioalimbloqminebecerro.getText().toString().isEmpty()){
            DIECONBLOQMINBEC = null;
        }else {
            DIECONBLOQMINBEC = edtPecuarioalimbloqminebecerro.getText().toString();
        }

        if (edtPecuarioalimbloqminedesarrollo.getText().toString().isEmpty()){
            DIECONBLOQMINDES = null;
        }else{
            DIECONBLOQMINDES = edtPecuarioalimbloqminedesarrollo.getText().toString();
        }

        if (edtPecuarioalimbloqminefinalizacion.getText().toString().isEmpty()){
            DIECONBLOQMINFIN = null;
        }else{
            DIECONBLOQMINFIN = edtPecuarioalimbloqminefinalizacion.getText().toString();
        }

        if (edtPecalimbloqminecosto.getText().toString().isEmpty()){
            DIECONBLOQMINCOSTO = null;
        }else{
            DIECONBLOQMINCOSTO = edtPecalimbloqminecosto.getText().toString();
        }



        ///////////////////////////////// 8 /////////////////////////////////////////////////////
        if (edtPecuarioalimmelazapiecria.getText().toString().isEmpty()){
            DIECONMELPCRIA = null;
        }else{
            DIECONMELPCRIA = edtPecuarioalimmelazapiecria.getText().toString();
        }

        if(edtPecuarioalimmelazabecerro.getText().toString().isEmpty()){
            DIECONMELBEC = null;
        }else {
            DIECONMELBEC = edtPecuarioalimmelazabecerro.getText().toString();
        }

        if (edtPecuarioalimmelazadesarrollo.getText().toString().isEmpty()){
            DIECONMELDES = null;
        }else{
            DIECONMELDES = edtPecuarioalimmelazadesarrollo.getText().toString();
        }

        if (edtPecuarioalimmelazafinalizacion.getText().toString().isEmpty()){
            DIECONMELFIN = null;
        }else{
            DIECONMELFIN = edtPecuarioalimmelazafinalizacion.getText().toString();
        }

        if (edtPecalimmelazacosto.getText().toString().isEmpty()){
            DIECONMELCOSTO = null;
        }else{
            DIECONMELCOSTO = edtPecalimmelazacosto.getText().toString();
        }


        ///////////////////////////////// 9 /////////////////////////////////////////////////////
        if (edtPecuarioalimureapiecria.getText().toString().isEmpty()){
            DIECONUREAPCRIA = null;
        }else{
            DIECONUREAPCRIA = edtPecuarioalimureapiecria.getText().toString();
        }

        if(edtPecuarioalimureabecerro.getText().toString().isEmpty()){
            DIECONUREABEC = null;
        }else {
            DIECONUREABEC = edtPecuarioalimureabecerro.getText().toString();
        }

        if (edtPecuarioalimureadesarrollo.getText().toString().isEmpty()){
            DIECONUREADES = null;
        }else{
            DIECONUREADES = edtPecuarioalimureadesarrollo.getText().toString();
        }

        if (edtPecuarioalimureafinalizacion.getText().toString().isEmpty()){
            DIECONUREAFIN = null;
        }else{
            DIECONUREAFIN = edtPecuarioalimureafinalizacion.getText().toString();
        }

        if (edtPecalimureacosto.getText().toString().isEmpty()){
            DIECONUREACOSTO = null;
        }else{
            DIECONUREACOSTO = edtPecalimureacosto.getText().toString();
        }


        ///////////////////////////////// 10 /////////////////////////////////////////////////////
        if (edtPecuarioalimvitaminerpiecria.getText().toString().isEmpty()){
            DIECONVITAMPCRIA = null;
        }else{
            DIECONVITAMPCRIA = edtPecuarioalimvitaminerpiecria.getText().toString();
        }

        if(edtPecuarioalimvitaminerbecerro.getText().toString().isEmpty()){
            DIECONVITAMBEC = null;
        }else {
            DIECONVITAMBEC = edtPecuarioalimvitaminerbecerro.getText().toString();
        }

        if (edtPecuarioalimvitaminerdesarrollo.getText().toString().isEmpty()){
            DIECONVITAMDES = null;
        }else{
            DIECONVITAMDES = edtPecuarioalimvitaminerdesarrollo.getText().toString();
        }

        if (edtPecuarioalimvitaminerfinalizacion.getText().toString().isEmpty()){
            DIECONVITAMFIN = null;
        }else{
            DIECONVITAMFIN = edtPecuarioalimvitaminerfinalizacion.getText().toString();
        }

        if (edtPecalimvitminercosto.getText().toString().isEmpty()){
            DIECONVITAMCOSTO = null;
        }else{
            DIECONVITAMCOSTO = edtPecalimvitminercosto.getText().toString();
        }



        ///////////////////////////////// 11 /////////////////////////////////////////////////////
        if (edtPecuarioalimsubproductopiecria.getText().toString().isEmpty()){
            DIECONSUBPPCRIA = null;
        }else{
            DIECONSUBPPCRIA = edtPecuarioalimsubproductopiecria.getText().toString();
        }

        if(edtPecuarioalimsubproductobecerro.getText().toString().isEmpty()){
            DIECONSUBPBEC = null;
        }else {
            DIECONSUBPBEC = edtPecuarioalimsubproductobecerro.getText().toString();
        }

        if (edtPecuarioalimsubproductodesarrollo.getText().toString().isEmpty()){
            DIECONSUBPDES = null;
        }else{
            DIECONSUBPDES = edtPecuarioalimsubproductodesarrollo.getText().toString();
        }

        if (edtPecuarioalimsubproductofinalizacion.getText().toString().isEmpty()){
            DIECONSUBPFIN = null;
        }else{
            DIECONSUBPFIN = edtPecuarioalimsubproductofinalizacion.getText().toString();
        }

        if (edtPecalimsubpcosto.getText().toString().isEmpty()){
            DIECONSUBPCOSTO = null;
        }else{
            DIECONSUBPCOSTO = edtPecalimsubpcosto.getText().toString();
        }

    }



    @Override
    public void onBackPressed() {

    }


}
