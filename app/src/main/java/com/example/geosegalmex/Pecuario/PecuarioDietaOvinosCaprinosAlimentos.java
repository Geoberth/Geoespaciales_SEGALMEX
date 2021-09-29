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

public class PecuarioDietaOvinosCaprinosAlimentos extends AppCompatActivity {

    //Pecuario Alimentos Concentrados comerciales
    private String PASTCONCOMENE = null;
    private String PASTCONCOMFEB = null;
    private String PASTCONCOMMAR = null;
    private String PASTCONCOMABR = null;
    private String PASTCONCOMMAY = null;
    private String PASTCONCOMJUN = null;
    private String PASTCONCOMJUL = null;
    private String PASTCONCOMAGO = null;
    private String PASTCONCOMSEP = null;
    private String PASTCONCOMOCT = null;
    private String PASTCONCOMNOV = null;
    private String PASTCONCOMDIC = null;

    private String PASTCONCOMCOS = null;



    //Pecuario Alimentos elaboracion propia
    private String PASTELPROPENE = null;
    private String PASTELPROPFEB = null;
    private String PASTELPROPMAR = null;
    private String PASTELPROPABR = null;
    private String PASTELPROPMAY = null;
    private String PASTELPROPJUN = null;
    private String PASTELPROPJUL = null;
    private String PASTELPROPAGO = null;
    private String PASTELPROPSEP = null;
    private String PASTELPROPOCT = null;
    private String PASTELPROPNOV = null;
    private String PASTELPROPDIC = null;

    private String PASTELPROPCOS = null;

    //Pecuario Alimentos bloques comerciales
    private String PASTBLOQCOMENE = null;
    private String PASTBLOQCOMFEB = null;
    private String PASTBLOQCOMMAR = null;
    private String PASTBLOQCOMABR = null;
    private String PASTBLOQCOMMAY = null;
    private String PASTBLOQCOMJUN = null;
    private String PASTBLOQCOMJUL = null;
    private String PASTBLOQCOMAGO = null;
    private String PASTBLOQCOMSEP = null;
    private String PASTBLOQCOMOCT = null;
    private String PASTBLOQCOMNOV = null;
    private String PASTBLOQCOMDIC = null;

    private String PASTBLOQCOMCOS = null;

    //Pecuario Alimentos Bloques de elaboración propia
    private String PASTBLOQELPRENE = null;
    private String PASTBLOQELPRFEB = null;
    private String PASTBLOQELPRMAR = null;
    private String PASTBLOQELPRABR = null;
    private String PASTBLOQELPRMAY = null;
    private String PASTBLOQELPRJUN = null;
    private String PASTBLOQELPRJUL = null;
    private String PASTBLOQELPRAGO = null;
    private String PASTBLOQELPRSEP = null;
    private String PASTBLOQELPROCT = null;
    private String PASTBLOQELPRNOV = null;
    private String PASBLOQELPRDIC = null;

    private String PASTBLOQELPRCOS = null;




    //Pecuario Alimentos Melaza - urea
    private String PASTMELUREAENE = null;
    private String PASTMELUREAFEB = null;
    private String PASTMELUREAMAR = null;
    private String PASTMELUREAABR = null;
    private String PASTMELUREAMAY = null;
    private String PASTMELUREAJUN = null;
    private String PASTMELUREAJUL = null;
    private String PASTMELUREAAGO = null;
    private String PASTMELUREASEP = null;
    private String PASTMELUREAOCT = null;
    private String PASTMELUREANOV = null;
    private String PASMELUREADIC = null;

    private String PASTMELUREACOS = null;



    //Pecuario Alimentos Granos y oleaginosas
    private String PASTGRANOLEENE = null;
    private String PASTGRANOLEFEB = null;
    private String PASTGRANOLEMAR = null;
    private String PASTGRANOLEABR = null;
    private String PASTGRANOLEMAY = null;
    private String PASTGRANOLEJUN = null;
    private String PASTGRANOLEJUL = null;
    private String PASTGRANOLEAGO = null;
    private String PASTGRANOLESEP = null;
    private String PASTGRANOLEOCT = null;
    private String PASTGRANOLENOV = null;
    private String PASGRANOLEDIC = null;

    private String PASTGRANOLECOS = null;


    //Pecuario Alimentos Sal comun
    private String PASTSALCOMENE = null;
    private String PASTSALCOMFEB = null;
    private String PASTSALCOMMAR = null;
    private String PASTSALCOMABR = null;
    private String PASTSALCOMMAY = null;
    private String PASTSALCOMJUN = null;
    private String PASTSALCOMJUL = null;
    private String PASTSALCOMAGO = null;
    private String PASTSALCOMSEP = null;
    private String PASTSALCOMOCT = null;
    private String PASTSALCOMNOV = null;
    private String PASSALCOMDIC = null;

    private String PASTSALCOMCOS = null;


    //Pecuario Alimentos sales minerales
    private String PASTSALMINENE = null;
    private String PASTSALMINFEB = null;
    private String PASTSALMINMAR = null;
    private String PASTSALMINABR = null;
    private String PASTSALMINMAY = null;
    private String PASTSALMINJUN = null;
    private String PASTSALMINJUL = null;
    private String PASTSALMINAGO = null;
    private String PASTSALMINSEP = null;
    private String PASTSALMINOCT = null;
    private String PASTSALMINNOV = null;
    private String PASSALMINDIC = null;

    private String PASTSALMINCOS = null;



    //Pecuario Alimentos bloques minersales
    private String PASTBLOQMINENE = null;
    private String PASTBLOQMINFEB = null;
    private String PASTBLOQMINMAR = null;
    private String PASTBLOQMINABR = null;
    private String PASTBLOQMINMAY = null;
    private String PASTBLOQMINJUN = null;
    private String PASTBLOQMINJUL = null;
    private String PASTBLOQMINAGO = null;
    private String PASTBLOQMINSEP = null;
    private String PASTBLOQMINOCT = null;
    private String PASTBLOQMINNOV = null;
    private String PASBLOQMINDIC = null;

    private String PASTBLOQMINCOS = null;


    //Pecuario Alimentos vitaminas
    private String PASTVITAMINENE = null;
    private String PASTVITAMINFEB = null;
    private String PASTVITAMINMAR = null;
    private String PASTVITAMINABR = null;
    private String PASTVITAMINMAY = null;
    private String PASTVITAMINJUN = null;
    private String PASTVITAMINJUL = null;
    private String PASTVITAMINAGO = null;
    private String PASTVITAMINSEP = null;
    private String PASTVITAMINOCT = null;
    private String PASTVITAMINNOV = null;
    private String PASVITAMINDIC = null;

    private String PASTVITAMINCOS = null;



    //Pecuario Alimentos selenio
    private String PASTSELENIOENE = null;
    private String PASTSELENIOFEB = null;
    private String PASTSELENIOMAR = null;
    private String PASTSELENIOABR = null;
    private String PASTSELENIOMAY = null;
    private String PASTSELENIOJUN = null;
    private String PASTSELENIOJUL = null;
    private String PASTSELENIOAGO = null;
    private String PASTSELENIOSEP = null;
    private String PASTSELENIOOCT = null;
    private String PASTSELENIONOV = null;
    private String PASSELENIODIC = null;

    private String PASTSELENIOCOS = null;


    //Pecuario Alimentos otro tipo de alimento
    private String PASTOTROTIPOENE = null;
    private String PASTOTROTIPOFEB = null;
    private String PASTOTROTIPOMAR = null;
    private String PASTOTROTIPOABR = null;
    private String PASTOTROTIPOMAY = null;
    private String PASTOTROTIPOJUN = null;
    private String PASTOTROTIPOJUL = null;
    private String PASTOTROTIPOAGO = null;
    private String PASTOTROTIPOSEP = null;
    private String PASTOTROTIPOOCT = null;
    private String PASTOTROTIPONOV = null;
    private String PASOTROTIPODIC = null;

    private String PASTOTROTIPOCOS = null;



    //EditText
    EditText edtPecuconccomcosto;
    EditText edtPecuelabpropiacosto;
    EditText edtPecubloqcomerccosto;
    EditText edtPecbloqelprocosto;
    EditText edtPecuariomelazaureacosto;
    EditText edtPecgraoleagicosto;
    EditText edtPecsalcomuncosto;
    EditText Pecuariosalmineralcosto;
    EditText Pecuariobloquemineralcosto;
    EditText Pecuariovitaminascosto;
    EditText Pecuarioseleniocosto;
    EditText Pecuariootroalimentocosto;



    Button btnPecucompdietaovicapri;

    //BASE DE DATOS
    private DatabaseHelper baseBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_dieta_ovinos_caprinos_alimentos);

        //EditText
        edtPecuconccomcosto = (EditText)findViewById(R.id.edtPecuconccomcosto);
        edtPecuelabpropiacosto = (EditText)findViewById(R.id.edtPecuelabpropiacosto);
        edtPecubloqcomerccosto = (EditText)findViewById(R.id.edtPecubloqcomerccosto);
        edtPecbloqelprocosto = (EditText)findViewById(R.id.edtPecbloqelprocosto);
        edtPecuariomelazaureacosto = (EditText)findViewById(R.id.edtPecuariomelazaureacosto);
        edtPecgraoleagicosto = (EditText)findViewById(R.id.edtPecgraoleagicosto);
        edtPecsalcomuncosto = (EditText)findViewById(R.id.edtPecsalcomuncosto);
        Pecuariosalmineralcosto = (EditText)findViewById(R.id.Pecuariosalmineralcosto);
        Pecuariobloquemineralcosto = (EditText)findViewById(R.id.Pecuariobloquemineralcosto);
        Pecuariovitaminascosto = (EditText)findViewById(R.id.Pecuariovitaminascosto);
        Pecuarioseleniocosto = (EditText)findViewById(R.id.Pecuarioseleniocosto);
        Pecuariootroalimentocosto = (EditText)findViewById(R.id.Pecuariootroalimentocosto);

        btnPecucompdietaovicapri = (Button)findViewById(R.id.pecuario_next_dietas_ovinoscaprinos);


        //BD
        baseBD         = new DatabaseHelper(this);

        btnPecucompdietaovicapri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GlobalPecuario.PASTCONCOMENE = PASTCONCOMENE;
                GlobalPecuario.PASTCONCOMFEB = PASTCONCOMFEB;
                GlobalPecuario.PASTCONCOMMAR = PASTCONCOMMAR;
                GlobalPecuario.PASTCONCOMABR = PASTCONCOMABR;
                GlobalPecuario.PASTCONCOMMAY = PASTCONCOMMAY;
                GlobalPecuario.PASTCONCOMJUN = PASTCONCOMJUN;
                GlobalPecuario.PASTCONCOMJUL = PASTCONCOMJUL;
                GlobalPecuario.PASTCONCOMAGO = PASTCONCOMAGO;
                GlobalPecuario.PASTCONCOMSEP = PASTCONCOMSEP;
                GlobalPecuario.PASTCONCOMOCT = PASTCONCOMOCT;
                GlobalPecuario.PASTCONCOMNOV = PASTCONCOMNOV;
                GlobalPecuario.PASTCONCOMDIC = PASTCONCOMDIC;
                pastalimconcomerc();
                GlobalPecuario.PASTCONCOMCOS = PASTCONCOMCOS;



                GlobalPecuario.PASTELPROPENE = PASTELPROPENE;
                GlobalPecuario.PASTELPROPFEB = PASTELPROPFEB;
                GlobalPecuario.PASTELPROPMAR = PASTELPROPMAR;
                GlobalPecuario.PASTELPROPABR = PASTELPROPABR;
                GlobalPecuario.PASTELPROPMAY = PASTELPROPMAY;
                GlobalPecuario.PASTELPROPJUN = PASTELPROPJUN;
                GlobalPecuario.PASTELPROPJUL = PASTELPROPJUL;
                GlobalPecuario.PASTELPROPAGO = PASTELPROPAGO;
                GlobalPecuario.PASTELPROPSEP = PASTELPROPSEP;
                GlobalPecuario.PASTELPROPOCT = PASTELPROPOCT;
                GlobalPecuario.PASTELPROPNOV = PASTELPROPNOV;
                GlobalPecuario.PASTELPROPDIC = PASTELPROPDIC;
                pastalimelpropia();
                GlobalPecuario.PASTELPROPCOS = PASTELPROPCOS;



                GlobalPecuario.PASTBLOQCOMENE = PASTBLOQCOMENE;
                GlobalPecuario.PASTBLOQCOMFEB = PASTBLOQCOMFEB;
                GlobalPecuario.PASTBLOQCOMMAR = PASTBLOQCOMMAR;
                GlobalPecuario.PASTBLOQCOMABR = PASTBLOQCOMABR;
                GlobalPecuario.PASTBLOQCOMMAY = PASTBLOQCOMMAY;
                GlobalPecuario.PASTBLOQCOMJUN = PASTBLOQCOMJUN;
                GlobalPecuario.PASTBLOQCOMJUL = PASTBLOQCOMJUL;
                GlobalPecuario.PASTBLOQCOMAGO = PASTBLOQCOMAGO;
                GlobalPecuario.PASTBLOQCOMSEP = PASTBLOQCOMSEP;
                GlobalPecuario.PASTBLOQCOMOCT = PASTBLOQCOMOCT;
                GlobalPecuario.PASTBLOQCOMNOV = PASTBLOQCOMNOV;
                GlobalPecuario.PASTBLOQCOMDIC = PASTBLOQCOMDIC;
                pastalimbcomerc();
                GlobalPecuario.PASTBLOQCOMCOS = PASTBLOQCOMCOS;


                GlobalPecuario.PASTBLOQELPRENE = PASTBLOQELPRENE;
                GlobalPecuario.PASTBLOQELPRFEB = PASTBLOQELPRFEB;
                GlobalPecuario.PASTBLOQELPRMAR = PASTBLOQELPRMAR;
                GlobalPecuario.PASTBLOQELPRABR = PASTBLOQELPRABR;
                GlobalPecuario.PASTBLOQELPRMAY = PASTBLOQELPRMAY;
                GlobalPecuario.PASTBLOQELPRJUN = PASTBLOQELPRJUN;
                GlobalPecuario.PASTBLOQELPRJUL = PASTBLOQELPRJUL;
                GlobalPecuario.PASTBLOQELPRAGO = PASTBLOQELPRAGO;
                GlobalPecuario.PASTBLOQELPRSEP = PASTBLOQELPRSEP;
                GlobalPecuario.PASTBLOQELPROCT = PASTBLOQELPROCT;
                GlobalPecuario.PASTBLOQELPRNOV = PASTBLOQELPRNOV;
                GlobalPecuario.PASBLOQELPRDIC = PASBLOQELPRDIC;
                pastalimbelaboracpropia();
                GlobalPecuario.PASTBLOQELPRCOS = PASTBLOQELPRCOS;



                GlobalPecuario.PASTMELUREAENE = PASTMELUREAENE;
                GlobalPecuario.PASTMELUREAFEB = PASTMELUREAFEB;
                GlobalPecuario.PASTMELUREAMAR = PASTMELUREAMAR;
                GlobalPecuario.PASTMELUREAABR = PASTMELUREAABR;
                GlobalPecuario.PASTMELUREAMAY = PASTMELUREAMAY;
                GlobalPecuario.PASTMELUREAJUN = PASTMELUREAJUN;
                GlobalPecuario.PASTMELUREAJUL = PASTMELUREAJUL;
                GlobalPecuario.PASTMELUREAAGO = PASTMELUREAAGO;
                GlobalPecuario.PASTMELUREASEP = PASTMELUREASEP;
                GlobalPecuario.PASTMELUREAOCT = PASTMELUREAOCT;
                GlobalPecuario.PASTMELUREANOV = PASTMELUREANOV;
                GlobalPecuario.PASMELUREADIC = PASMELUREADIC;
                pastalimmelazaurea();
                GlobalPecuario.PASTMELUREACOS = PASTMELUREACOS;


                GlobalPecuario.PASTGRANOLEENE = PASTGRANOLEENE;
                GlobalPecuario.PASTGRANOLEFEB = PASTGRANOLEFEB;
                GlobalPecuario.PASTGRANOLEMAR = PASTGRANOLEMAR;
                GlobalPecuario.PASTGRANOLEABR = PASTGRANOLEABR;
                GlobalPecuario.PASTGRANOLEMAY = PASTGRANOLEMAY;
                GlobalPecuario.PASTGRANOLEJUN = PASTGRANOLEJUN;
                GlobalPecuario.PASTGRANOLEJUL = PASTGRANOLEJUL;
                GlobalPecuario.PASTGRANOLEAGO = PASTGRANOLEAGO;
                GlobalPecuario.PASTGRANOLESEP = PASTGRANOLESEP;
                GlobalPecuario.PASTGRANOLEOCT = PASTGRANOLEOCT;
                GlobalPecuario.PASTGRANOLENOV = PASTGRANOLENOV;
                GlobalPecuario.PASGRANOLEDIC = PASGRANOLEDIC;
                pastalimgranoleg();
                GlobalPecuario.PASTGRANOLECOS = PASTGRANOLECOS;


                GlobalPecuario.PASTSALCOMENE = PASTSALCOMENE;
                GlobalPecuario.PASTSALCOMFEB = PASTSALCOMFEB;
                GlobalPecuario.PASTSALCOMMAR = PASTSALCOMMAR;
                GlobalPecuario.PASTSALCOMABR = PASTSALCOMABR;
                GlobalPecuario.PASTSALCOMMAY = PASTSALCOMMAY;
                GlobalPecuario.PASTSALCOMJUN = PASTSALCOMJUN;
                GlobalPecuario.PASTSALCOMJUL = PASTSALCOMJUL;
                GlobalPecuario.PASTSALCOMAGO = PASTSALCOMAGO;
                GlobalPecuario.PASTSALCOMSEP = PASTSALCOMSEP;
                GlobalPecuario.PASTSALCOMOCT = PASTSALCOMOCT;
                GlobalPecuario.PASTSALCOMNOV = PASTSALCOMNOV;
                GlobalPecuario.PASSALCOMDIC = PASSALCOMDIC;
                pastalimsalcomun();
                GlobalPecuario.PASTSALCOMCOS = PASTSALCOMCOS;


                GlobalPecuario.PASTSALMINENE = PASTSALMINENE;
                GlobalPecuario.PASTSALMINFEB = PASTSALMINFEB;
                GlobalPecuario.PASTSALMINMAR = PASTSALMINMAR;
                GlobalPecuario.PASTSALMINABR = PASTSALMINABR;
                GlobalPecuario.PASTSALMINMAY = PASTSALMINMAY;
                GlobalPecuario.PASTSALMINJUN = PASTSALMINJUN;
                GlobalPecuario.PASTSALMINJUL = PASTSALMINJUL;
                GlobalPecuario.PASTSALMINAGO = PASTSALMINAGO;
                GlobalPecuario.PASTSALMINSEP = PASTSALMINSEP;
                GlobalPecuario.PASTSALMINOCT = PASTSALMINOCT;
                GlobalPecuario.PASTSALMINNOV = PASTSALMINNOV;
                GlobalPecuario.PASSALMINDIC = PASSALMINDIC;
                pastalimsalmineral();
                GlobalPecuario.PASTSALMINCOS = PASTSALMINCOS;


                GlobalPecuario.PASTBLOQMINENE = PASTBLOQMINENE;
                GlobalPecuario.PASTBLOQMINFEB = PASTBLOQMINFEB;
                GlobalPecuario.PASTBLOQMINMAR = PASTBLOQMINMAR;
                GlobalPecuario.PASTBLOQMINABR = PASTBLOQMINABR;
                GlobalPecuario.PASTBLOQMINMAY = PASTBLOQMINMAY;
                GlobalPecuario.PASTBLOQMINJUN = PASTBLOQMINJUN;
                GlobalPecuario.PASTBLOQMINJUL = PASTBLOQMINJUL;
                GlobalPecuario.PASTBLOQMINAGO = PASTBLOQMINAGO;
                GlobalPecuario.PASTBLOQMINSEP = PASTBLOQMINSEP;
                GlobalPecuario.PASTBLOQMINOCT = PASTBLOQMINOCT;
                GlobalPecuario.PASTBLOQMINNOV = PASTBLOQMINNOV;
                GlobalPecuario.PASBLOQMINDIC = PASBLOQMINDIC;
                pastalimbloquemineral();
                GlobalPecuario.PASTBLOQMINCOS = PASTBLOQMINCOS;


                GlobalPecuario.PASTVITAMINENE = PASTVITAMINENE;
                GlobalPecuario.PASTVITAMINFEB = PASTVITAMINFEB;
                GlobalPecuario.PASTVITAMINMAR = PASTVITAMINMAR;
                GlobalPecuario.PASTVITAMINABR = PASTVITAMINABR;
                GlobalPecuario.PASTVITAMINMAY = PASTVITAMINMAY;
                GlobalPecuario.PASTVITAMINJUN = PASTVITAMINJUN;
                GlobalPecuario.PASTVITAMINJUL = PASTVITAMINJUL;
                GlobalPecuario.PASTVITAMINAGO = PASTVITAMINAGO;
                GlobalPecuario.PASTVITAMINSEP = PASTVITAMINSEP;
                GlobalPecuario.PASTVITAMINOCT = PASTVITAMINOCT;
                GlobalPecuario.PASTVITAMINNOV = PASTVITAMINNOV;
                GlobalPecuario.PASVITAMINDIC = PASVITAMINDIC;
                pastalimvitaminas();
                GlobalPecuario.PASTVITAMINCOS = PASTVITAMINCOS;


                GlobalPecuario.PASTSELENIOENE = PASTSELENIOENE;
                GlobalPecuario.PASTSELENIOFEB = PASTSELENIOFEB;
                GlobalPecuario.PASTSELENIOMAR = PASTSELENIOMAR;
                GlobalPecuario.PASTSELENIOABR = PASTSELENIOABR;
                GlobalPecuario.PASTSELENIOMAY = PASTSELENIOMAY;
                GlobalPecuario.PASTSELENIOJUN = PASTSELENIOJUN;
                GlobalPecuario.PASTSELENIOJUL = PASTSELENIOJUL;
                GlobalPecuario.PASTSELENIOAGO = PASTSELENIOAGO;
                GlobalPecuario.PASTSELENIOSEP = PASTSELENIOSEP;
                GlobalPecuario.PASTSELENIOOCT = PASTSELENIOOCT;
                GlobalPecuario.PASTSELENIONOV = PASTSELENIONOV;
                GlobalPecuario.PASSELENIODIC = PASSELENIODIC;
                pastalimselenio();
                GlobalPecuario.PASTSELENIOCOS = PASTSELENIOCOS;


                GlobalPecuario.PASTOTROTIPOENE = PASTOTROTIPOENE;
                GlobalPecuario.PASTOTROTIPOFEB = PASTOTROTIPOFEB;
                GlobalPecuario.PASTOTROTIPOMAR = PASTOTROTIPOMAR;
                GlobalPecuario.PASTOTROTIPOABR = PASTOTROTIPOABR;
                GlobalPecuario.PASTOTROTIPOMAY = PASTOTROTIPOMAY;
                GlobalPecuario.PASTOTROTIPOJUN = PASTOTROTIPOJUN;
                GlobalPecuario.PASTOTROTIPOJUL = PASTOTROTIPOJUL;
                GlobalPecuario.PASTOTROTIPOAGO = PASTOTROTIPOAGO;
                GlobalPecuario.PASTOTROTIPOSEP = PASTOTROTIPOSEP;
                GlobalPecuario.PASTOTROTIPOOCT = PASTOTROTIPOOCT;
                GlobalPecuario.PASTOTROTIPONOV = PASTOTROTIPONOV;
                GlobalPecuario.PASOTROTIPODIC = PASOTROTIPODIC;
                pastalimotrotipoalim();
                GlobalPecuario.PASTOTROTIPOCOS = PASTOTROTIPOCOS;

                agregarPecudieovicapali();
                startActivity(new Intent(PecuarioDietaOvinosCaprinosAlimentos.this, PecuarioEventosUnidadProduccion.class));
                finish();
            }
        });
    }



    //INSERCION DE DATOS
    public void agregarPecudieovicapali(){

        addPecudietovcapri();

    }




    ///Agregar pecuario caprino

    private void addPecudietovcapri(){
        boolean insertarData = baseBD.addPecuariocompdietaovicapri();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }




    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos concentrados comerciales
    public void clickPastalimconcomerc(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecuconccomenero:
                if (checked) {
                    PASTCONCOMENE = "Sí";

                }
                else{
                    PASTCONCOMENE = "No";
                }
                break;

            case R.id.checkPecuconccomfebrero:
                if (checked) {
                    PASTCONCOMFEB = "Sí";
                }
                else{
                    PASTCONCOMFEB = "No";
                }
                break;

            case R.id.checkPecuconccommarzo:
                if (checked) {
                    PASTCONCOMMAR = "Sí";

                }else{
                    PASTCONCOMMAR = "No";
                }
                break;

            case R.id.checkPecuconccomabril:
                if (checked) {
                    PASTCONCOMABR = "Sí";

                }else{
                    PASTCONCOMABR = "No";
                }
                break;

            case R.id.checkPecuconccommayo:
                if (checked) {
                    PASTCONCOMMAY = "Sí";

                }else{
                    PASTCONCOMMAY = "No";
                }
                break;

            case R.id.checkPecuconccomjunio:
                if (checked) {
                    PASTCONCOMJUN = "Sí";

                }else{
                    PASTCONCOMJUN = "No";
                }
                break;

            case R.id.checkPecuconccomjulio:
                if (checked) {
                    PASTCONCOMJUL = "Sí";

                }else{
                    PASTCONCOMJUL = "No";
                }
                break;

            case R.id.checkPecuconccomagosto:
                if (checked) {
                    PASTCONCOMAGO = "Sí";

                }else{
                    PASTCONCOMAGO = "No";
                }
                break;

            case R.id.checkPecuconccomsept:
                if (checked) {
                    PASTCONCOMSEP = "Sí";

                }else{
                    PASTCONCOMSEP = "No";
                }
                break;

            case R.id.checkPecuconccomoctubre:
                if (checked) {
                    PASTCONCOMOCT = "Sí";

                }else{
                    PASTCONCOMOCT = "No";
                }
                break;

            case R.id.checkPecuconccomnov:
                if (checked) {
                    PASTCONCOMNOV = "Sí";

                }else{
                    PASTCONCOMNOV = "No";
                }
                break;

            case R.id.checkPecuconccomdic:
                if (checked) {
                    PASTCONCOMDIC = "Sí";

                }else{
                    PASTCONCOMDIC = "No";
                }
                break;
        }
    }


    public void pastalimconcomerc(){
        if(!edtPecuconccomcosto.getText().toString().isEmpty()){
            PASTCONCOMCOS = edtPecuconccomcosto.getText().toString();
        } else{
            PASTCONCOMCOS = null;
        }

    }





    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos elaboracion propia
    public void clickPastalimelpropia(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecuelabpropiaenero:
                if (checked) {
                    PASTELPROPENE = "Sí";

                }
                else{
                    PASTELPROPENE = "No";
                }
                break;

            case R.id.checkPecuelabpropiafebrero:
                if (checked) {
                    PASTELPROPFEB = "Sí";
                }
                else{
                    PASTELPROPFEB = "No";
                }
                break;

            case R.id.checkPecuelabpropiamarzo:
                if (checked) {
                    PASTELPROPMAR = "Sí";

                }else{
                    PASTELPROPMAR = "No";
                }
                break;

            case R.id.checkPecuelabpropiaabril:
                if (checked) {
                    PASTELPROPABR = "Sí";

                }else{
                    PASTELPROPABR = "No";
                }
                break;

            case R.id.checkPecuelabpropiamayosi:
                if (checked) {
                    PASTELPROPMAY = "Sí";

                }else{
                    PASTELPROPMAY = "No";
                }
                break;

            case R.id.checkPecelabpropiajunio:
                if (checked) {
                    PASTELPROPJUN = "Sí";

                }else{
                    PASTELPROPJUN = "No";
                }
                break;

            case R.id.checkPecuelabpropiajulio:
                if (checked) {
                    PASTELPROPJUL = "Sí";

                }else{
                    PASTELPROPJUL = "No";
                }
                break;

            case R.id.checkPecuelabpropiaagosto:
                if (checked) {
                    PASTELPROPAGO = "Sí";

                }else{
                    PASTELPROPAGO = "No";
                }
                break;

            case R.id.checkPecuelabpropiasept:
                if (checked) {
                    PASTELPROPSEP = "Sí";

                }else{
                    PASTELPROPSEP = "No";
                }
                break;

            case R.id.checkPecuelabpropiaoct:
                if (checked) {
                    PASTELPROPOCT = "Sí";

                }else{
                    PASTELPROPOCT = "No";
                }
                break;

            case R.id.checkPecuelabpropianov:
                if (checked) {
                    PASTELPROPNOV = "Sí";

                }else{
                    PASTELPROPNOV = "No";
                }
                break;

            case R.id.checkPecuelabpropiadic:
                if (checked) {
                    PASTELPROPDIC = "Sí";

                }else{
                    PASTELPROPDIC = "No";
                }
                break;
        }
    }


    public void pastalimelpropia(){
        if(!edtPecuelabpropiacosto.getText().toString().isEmpty()){
            PASTELPROPCOS = edtPecuelabpropiacosto.getText().toString();
        } else{
            PASTELPROPCOS = null;
        }

    }



    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos bloques comerciales
    public void clickPastalimbcomerciales(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecubloqcomercenero:
                if (checked) {
                    PASTBLOQCOMENE = "Sí";

                }
                else{
                    PASTBLOQCOMENE = "No";
                }
                break;

            case R.id.checkPecubloqcomercfeb:
                if (checked) {
                    PASTBLOQCOMFEB = "Sí";
                }
                else{
                    PASTBLOQCOMFEB = "No";
                }
                break;

            case R.id.checkPecubloqcomercmarzo:
                if (checked) {
                    PASTBLOQCOMMAR = "Sí";

                }else{
                    PASTBLOQCOMMAR = "No";
                }
                break;

            case R.id.checkPecubloqcomercabril:
                if (checked) {
                    PASTBLOQCOMABR = "Sí";

                }else{
                    PASTBLOQCOMABR = "No";
                }
                break;

            case R.id.checkPecubloqcomercmayo:
                if (checked) {
                    PASTBLOQCOMMAY = "Sí";

                }else{
                    PASTBLOQCOMMAY = "No";
                }
                break;

            case R.id.checkPecubloqcomjunio:
                if (checked) {
                    PASTBLOQCOMJUN = "Sí";

                }else{
                    PASTBLOQCOMJUN = "No";
                }
                break;

            case R.id.checkPecubloqcomjulio:
                if (checked) {
                    PASTBLOQCOMJUL = "Sí";

                }else{
                    PASTBLOQCOMJUL = "No";
                }
                break;

            case R.id.checkPecubloqcomagosto:
                if (checked) {
                    PASTBLOQCOMAGO = "Sí";

                }else{
                    PASTBLOQCOMAGO = "No";
                }
                break;

            case R.id.checkPecubloqcomsept:
                if (checked) {
                    PASTBLOQCOMSEP = "Sí";

                }else{
                    PASTBLOQCOMSEP = "No";
                }
                break;

            case R.id.checkPecubloqcomoct:
                if (checked) {
                    PASTBLOQCOMOCT = "Sí";

                }else{
                    PASTBLOQCOMOCT = "No";
                }
                break;

            case R.id.checkPecubloqcomnoviemb:
                if (checked) {
                    PASTBLOQCOMNOV = "Sí";

                }else{
                    PASTBLOQCOMNOV = "No";
                }
                break;

            case R.id.checkPecubloqcomdic:
                if (checked) {
                    PASTBLOQCOMDIC = "Sí";

                }else{
                    PASTBLOQCOMDIC = "No";
                }
                break;
        }
    }


    public void pastalimbcomerc(){
        if(!edtPecubloqcomerccosto.getText().toString().isEmpty()){
            PASTBLOQCOMCOS = edtPecubloqcomerccosto.getText().toString();
        } else{
            PASTBLOQCOMCOS = null;
        }

    }


    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos bloques comerciales
    public void clickPastalimbelabpropia(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecubloqelabpropenero:
                if (checked) {
                    PASTBLOQELPRENE = "Sí";

                }
                else{
                    PASTBLOQELPRENE = "No";
                }
                break;

            case R.id.checkPecubloqelabpropiafeb:
                if (checked) {
                    PASTBLOQELPRFEB = "Sí";
                }
                else{
                    PASTBLOQELPRFEB = "No";
                }
                break;

            case R.id.checkPecubloqelabpropiamarzo:
                if (checked) {
                    PASTBLOQELPRMAR = "Sí";

                }else{
                    PASTBLOQELPRMAR = "No";
                }
                break;

            case R.id.checkPecubloqelabpropabril:
                if (checked) {
                    PASTBLOQELPRABR = "Sí";

                }else{
                    PASTBLOQELPRABR = "No";
                }
                break;

            case R.id.checkPecubloqelabpropmayo:
                if (checked) {
                    PASTBLOQELPRMAY = "Sí";

                }else{
                    PASTBLOQELPRMAY = "No";
                }
                break;

            case R.id.checkPecubloqelabpropjun:
                if (checked) {
                    PASTBLOQELPRJUN = "Sí";

                }else{
                    PASTBLOQELPRJUN = "No";
                }
                break;

            case R.id.checkPecubloqelabpropjul:
                if (checked) {
                    PASTBLOQELPRJUL = "Sí";

                }else{
                    PASTBLOQELPRJUL = "No";
                }
                break;

            case R.id.checkPecubloqelpropagost:
                if (checked) {
                    PASTBLOQELPRAGO = "Sí";

                }else{
                    PASTBLOQELPRAGO = "No";
                }
                break;

            case R.id.checkPecbloqelprosept:
                if (checked) {
                    PASTBLOQELPRSEP = "Sí";

                }else{
                    PASTBLOQELPRSEP = "No";
                }
                break;

            case R.id.checkPecbloqelprooct:
                if (checked) {
                    PASTBLOQELPROCT = "Sí";

                }else{
                    PASTBLOQELPROCT = "No";
                }
                break;

            case R.id.checkPecbloqelpronov:
                if (checked) {
                    PASTBLOQELPRNOV = "Sí";

                }else{
                    PASTBLOQELPRNOV = "No";
                }
                break;

            case R.id.checkPecbloqelprodic:
                if (checked) {
                    PASBLOQELPRDIC = "Sí";

                }else{
                    PASBLOQELPRDIC = "No";
                }
                break;
        }
    }


    public void pastalimbelaboracpropia(){
        if(!edtPecbloqelprocosto.getText().toString().isEmpty()){
            PASTBLOQELPRCOS = edtPecbloqelprocosto.getText().toString();
        } else{
            PASTBLOQELPRCOS = null;
        }

    }



    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos melaza - urea
    public void clickPastalimmelazaurea(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecmelureaenero:
                if (checked) {
                    PASTMELUREAENE = "Sí";

                }
                else{
                    PASTMELUREAENE = "No";
                }
                break;

            case R.id.checkPecmelureafeb:
                if (checked) {
                    PASTMELUREAFEB = "Sí";
                }
                else{
                    PASTMELUREAFEB = "No";
                }
                break;

            case R.id.checkPecmelureamar:
                if (checked) {
                    PASTMELUREAMAR = "Sí";

                }else{
                    PASTMELUREAMAR = "No";
                }
                break;

            case R.id.checkPecmelurabril:
                if (checked) {
                    PASTMELUREAABR = "Sí";

                }else{
                    PASTMELUREAABR = "No";
                }
                break;

            case R.id.checkPecmelureamay:
                if (checked) {
                    PASTMELUREAMAY = "Sí";

                }else{
                    PASTMELUREAMAY = "No";
                }
                break;

            case R.id.checkPecmelurjun:
                if (checked) {
                    PASTMELUREAJUN = "Sí";

                }else{
                    PASTMELUREAJUN = "No";
                }
                break;

            case R.id.checkPecmelurjul:
                if (checked) {
                    PASTMELUREAJUL = "Sí";

                }else{
                    PASTMELUREAJUL = "No";
                }
                break;

            case R.id.checkPecmeluragost:
                if (checked) {
                    PASTMELUREAAGO = "Sí";

                }else{
                    PASTMELUREAAGO = "No";
                }
                break;

            case R.id.checkPecmelursept:
                if (checked) {
                    PASTMELUREASEP = "Sí";

                }else{
                    PASTMELUREASEP = "No";
                }
                break;

            case R.id.checkPecmeluroct:
                if (checked) {
                    PASTMELUREAOCT = "Sí";

                }else{
                    PASTMELUREAOCT = "No";
                }
                break;

            case R.id.checkPecmelurnov:
                if (checked) {
                    PASTMELUREANOV = "Sí";

                }else{
                    PASTMELUREANOV = "No";
                }
                break;

            case R.id.checkPecmelurdic:
                if (checked) {
                    PASMELUREADIC = "Sí";

                }else{
                    PASMELUREADIC = "No";
                }
                break;
        }
    }


    public void pastalimmelazaurea(){
        if(!edtPecuariomelazaureacosto.getText().toString().isEmpty()){
            PASTMELUREACOS = edtPecuariomelazaureacosto.getText().toString();
        } else{
            PASTMELUREACOS = null;
        }

    }




    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos Granos y oleaginosas
    public void clickPastalimgranoleg(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecgraoleagiene:
                if (checked) {
                    PASTGRANOLEENE = "Sí";

                }
                else{
                    PASTGRANOLEENE = "No";
                }
                break;

            case R.id.checkPecgraoleagifeb:
                if (checked) {
                    PASTGRANOLEFEB = "Sí";
                }
                else{
                    PASTGRANOLEFEB = "No";
                }
                break;

            case R.id.checkPecgraoleagimarz:
                if (checked) {
                    PASTGRANOLEMAR = "Sí";

                }else{
                    PASTGRANOLEMAR = "No";
                }
                break;

            case R.id.checkPecgraoleagiabr:
                if (checked) {
                    PASTGRANOLEABR = "Sí";

                }else{
                    PASTGRANOLEABR = "No";
                }
                break;

            case R.id.checkPecgraoleagimay:
                if (checked) {
                    PASTGRANOLEMAY = "Sí";

                }else{
                    PASTGRANOLEMAY = "No";
                }
                break;

            case R.id.checkPecgraoleagijun:
                if (checked) {
                    PASTGRANOLEJUN = "Sí";

                }else{
                    PASTGRANOLEJUN = "No";
                }
                break;

            case R.id.checkPecgraoleagijul:
                if (checked) {
                    PASTGRANOLEJUL = "Sí";

                }else{
                    PASTGRANOLEJUL = "No";
                }
                break;

            case R.id.checkPecgraoleagiagost:
                if (checked) {
                    PASTGRANOLEAGO = "Sí";

                }else{
                    PASTGRANOLEAGO = "No";
                }
                break;

            case R.id.checkPecgraoleagisept:
                if (checked) {
                    PASTGRANOLESEP = "Sí";

                }else{
                    PASTGRANOLESEP = "No";
                }
                break;

            case R.id.checkPecugraoleagioct:
                if (checked) {
                    PASTGRANOLEOCT = "Sí";

                }else{
                    PASTGRANOLEOCT = "No";
                }
                break;

            case R.id.checkPecgraoleaginov:
                if (checked) {
                    PASTGRANOLENOV = "Sí";

                }else{
                    PASTGRANOLENOV = "No";
                }
                break;

            case R.id.checkPecgraoleagidic:
                if (checked) {
                    PASGRANOLEDIC = "Sí";

                }else{
                    PASGRANOLEDIC = "No";
                }
                break;
        }
    }


    public void pastalimgranoleg(){
        if(!edtPecgraoleagicosto.getText().toString().isEmpty()){
            PASTGRANOLECOS = edtPecgraoleagicosto.getText().toString();
        } else{
            PASTGRANOLECOS = null;
        }

    }




    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos sal comun
    public void clickPastalimsalcomun(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecsalcomunene:
                if (checked) {
                    PASTSALCOMENE = "Sí";

                }
                else{
                    PASTSALCOMENE = "No";
                }
                break;

            case R.id.checkPecsalcomunfeb:
                if (checked) {
                    PASTSALCOMFEB = "Sí";
                }
                else{
                    PASTSALCOMFEB = "No";
                }
                break;

            case R.id.checkPecsalcomunmar:
                if (checked) {
                    PASTSALCOMMAR = "Sí";

                }else{
                    PASTSALCOMMAR = "No";
                }
                break;

            case R.id.checkPecsalcomunabr:
                if (checked) {
                    PASTSALCOMABR = "Sí";

                }else{
                    PASTSALCOMABR = "No";
                }
                break;

            case R.id.checkPecsalcomunmay:
                if (checked) {
                    PASTSALCOMMAY = "Sí";

                }else{
                    PASTSALCOMMAY = "No";
                }
                break;

            case R.id.checkPecsalcomunjun:
                if (checked) {
                    PASTSALCOMJUN = "Sí";

                }else{
                    PASTSALCOMJUN = "No";
                }
                break;

            case R.id.checkPecsalcomunjul:
                if (checked) {
                    PASTSALCOMJUL = "Sí";

                }else{
                    PASTSALCOMJUL = "No";
                }
                break;

            case R.id.checkPecusalcomunagost:
                if (checked) {
                    PASTSALCOMAGO = "Sí";

                }else{
                    PASTSALCOMAGO = "No";
                }
                break;

            case R.id.checkPecsalcomunsept:
                if (checked) {
                    PASTSALCOMSEP = "Sí";

                }else{
                    PASTSALCOMSEP = "No";
                }
                break;

            case R.id.checkPecsalcomunoct:
                if (checked) {
                    PASTSALCOMOCT = "Sí";

                }else{
                    PASTSALCOMOCT = "No";
                }
                break;

            case R.id.checkPecsalcomunnov:
                if (checked) {
                    PASTSALCOMNOV = "Sí";

                }else{
                    PASTSALCOMNOV = "No";
                }
                break;

            case R.id.checkPecsalcomundic:
                if (checked) {
                    PASSALCOMDIC = "Sí";

                }else{
                    PASSALCOMDIC = "No";
                }
                break;
        }
    }


    public void pastalimsalcomun(){
        if(!edtPecsalcomuncosto.getText().toString().isEmpty()){
            PASTSALCOMCOS = edtPecsalcomuncosto.getText().toString();
        } else{
            PASTSALCOMCOS = null;
        }

    }


    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos sales minerales
    public void clickPastalimsalmineral(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecsalminene:
                if (checked) {
                    PASTSALMINENE = "Sí";

                }
                else{
                    PASTSALMINENE = "No";
                }
                break;

            case R.id.checkPecsalminfeb:
                if (checked) {
                    PASTSALMINFEB = "Sí";
                }
                else{
                    PASTSALMINFEB = "No";
                }
                break;

            case R.id.checkPecsalminmarz:
                if (checked) {
                    PASTSALMINMAR = "Sí";

                }else{
                    PASTSALMINMAR = "No";
                }
                break;

            case R.id.checkPecsalminabr:
                if (checked) {
                    PASTSALMINABR = "Sí";

                }else{
                    PASTSALMINABR = "No";
                }
                break;

            case R.id.checkPecsalminmay:
                if (checked) {
                    PASTSALMINMAY = "Sí";

                }else{
                    PASTSALMINMAY = "No";
                }
                break;

            case R.id.checkPecsalminjun:
                if (checked) {
                    PASTSALMINJUN = "Sí";

                }else{
                    PASTSALMINJUN = "No";
                }
                break;

            case R.id.checkPecsalminjul:
                if (checked) {
                    PASTSALMINJUL = "Sí";

                }else{
                    PASTSALMINJUL = "No";
                }
                break;

            case R.id.checkPecsalminagost:
                if (checked) {
                    PASTSALMINAGO = "Sí";

                }else{
                    PASTSALMINAGO = "No";
                }
                break;

            case R.id.checkPecsalminsept:
                if (checked) {
                    PASTSALMINSEP = "Sí";

                }else{
                    PASTSALMINSEP = "No";
                }
                break;

            case R.id.checkPecsalminoct:
                if (checked) {
                    PASTSALMINOCT = "Sí";

                }else{
                    PASTSALMINOCT = "No";
                }
                break;

            case R.id.checkPecsalminnov:
                if (checked) {
                    PASTSALMINNOV = "Sí";

                }else{
                    PASTSALMINNOV = "No";
                }
                break;

            case R.id.checkPecsalmindic:
                if (checked) {
                    PASSALMINDIC = "Sí";

                }else{
                    PASSALMINDIC = "No";
                }
                break;
        }
    }


    public void pastalimsalmineral(){
        if(!Pecuariosalmineralcosto.getText().toString().isEmpty()){
            PASTSALMINCOS = Pecuariosalmineralcosto.getText().toString();
        } else{
            PASTSALMINCOS = null;
        }

    }





    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos bloques minerales
    public void clickPastalimbloquemineral(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecbloqminene:
                if (checked) {
                    PASTBLOQMINENE = "Sí";

                }
                else{
                    PASTBLOQMINENE = "No";
                }
                break;

            case R.id.checkPecbloqminfeb:
                if (checked) {
                    PASTBLOQMINFEB = "Sí";
                }
                else{
                    PASTBLOQMINFEB = "No";
                }
                break;

            case R.id.checkPecbloqminmarz:
                if (checked) {
                    PASTBLOQMINMAR = "Sí";

                }else{
                    PASTBLOQMINMAR = "No";
                }
                break;

            case R.id.checkPecbloqminabr:
                if (checked) {
                    PASTBLOQMINABR = "Sí";

                }else{
                    PASTBLOQMINABR = "No";
                }
                break;

            case R.id.checkPecbloqminmay:
                if (checked) {
                    PASTBLOQMINMAY = "Sí";

                }else{
                    PASTBLOQMINMAY = "No";
                }
                break;

            case R.id.checkPecbloqminjun:
                if (checked) {
                    PASTBLOQMINJUN = "Sí";

                }else{
                    PASTBLOQMINJUN = "No";
                }
                break;

            case R.id.checkPecbloqminjul:
                if (checked) {
                    PASTBLOQMINJUL = "Sí";

                }else{
                    PASTBLOQMINJUL = "No";
                }
                break;

            case R.id.checkPecbloqminagost:
                if (checked) {
                    PASTBLOQMINAGO = "Sí";

                }else{
                    PASTBLOQMINAGO = "No";
                }
                break;

            case R.id.checkPecbloqminsept:
                if (checked) {
                    PASTSALMINSEP = "Sí";

                }else{
                    PASTSALMINSEP = "No";
                }
                break;

            case R.id.checkPecbloqminoct:
                if (checked) {
                    PASTBLOQMINOCT = "Sí";

                }else{
                    PASTBLOQMINOCT = "No";
                }
                break;

            case R.id.checkPecbloqminnov:
                if (checked) {
                    PASTBLOQMINNOV = "Sí";

                }else{
                    PASTBLOQMINNOV = "No";
                }
                break;

            case R.id.checkPecbloqmindic:
                if (checked) {
                    PASBLOQMINDIC = "Sí";

                }else{
                    PASBLOQMINDIC = "No";
                }
                break;
        }
    }


    public void pastalimbloquemineral(){
        if(!Pecuariobloquemineralcosto.getText().toString().isEmpty()){
            PASTBLOQMINCOS = Pecuariobloquemineralcosto.getText().toString();
        } else{
            PASTBLOQMINCOS = null;
        }

    }



    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos Vitaminas
    public void clickPastalimvitaminas(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecvitamene:
                if (checked) {
                    PASTVITAMINENE = "Sí";

                }
                else{
                    PASTVITAMINENE = "No";
                }
                break;

            case R.id.checkPecvitamfeb:
                if (checked) {
                    PASTVITAMINFEB = "Sí";
                }
                else{
                    PASTVITAMINFEB = "No";
                }
                break;

            case R.id.checkPecvitammarz:
                if (checked) {
                    PASTVITAMINMAR = "Sí";

                }else{
                    PASTVITAMINMAR = "No";
                }
                break;

            case R.id.checkPecvitamabr:
                if (checked) {
                    PASTVITAMINABR = "Sí";

                }else{
                    PASTVITAMINABR = "No";
                }
                break;

            case R.id.checkPecvitammay:
                if (checked) {
                    PASTVITAMINMAY = "Sí";

                }else{
                    PASTVITAMINMAY = "No";
                }
                break;

            case R.id.checkPecvitamjun:
                if (checked) {
                    PASTVITAMINJUN = "Sí";

                }else{
                    PASTVITAMINJUN = "No";
                }
                break;

            case R.id.checkPecvitamjul:
                if (checked) {
                    PASTVITAMINJUL = "Sí";

                }else{
                    PASTVITAMINJUL = "No";
                }
                break;

            case R.id.checkPecvitamagost:
                if (checked) {
                    PASTVITAMINAGO = "Sí";

                }else{
                    PASTVITAMINAGO = "No";
                }
                break;

            case R.id.checkPecvitamsept:
                if (checked) {
                    PASTVITAMINSEP = "Sí";

                }else{
                    PASTVITAMINSEP = "No";
                }
                break;

            case R.id.checkPecvitamoct:
                if (checked) {
                    PASTVITAMINOCT = "Sí";

                }else{
                    PASTVITAMINOCT = "No";
                }
                break;

            case R.id.checkPecvitamnov:
                if (checked) {
                    PASTVITAMINNOV = "Sí";

                }else{
                    PASTVITAMINNOV = "No";
                }
                break;

            case R.id.checkPecvitamdic:
                if (checked) {
                    PASVITAMINDIC = "Sí";

                }else{
                    PASVITAMINDIC = "No";
                }
                break;
        }
    }


    public void pastalimvitaminas(){
        if(!Pecuariovitaminascosto.getText().toString().isEmpty()){
            PASTVITAMINCOS = Pecuariovitaminascosto.getText().toString();
        } else{
            PASTVITAMINCOS = null;
        }

    }



    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos selenio
    public void clickPastalimselenio(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.chekPecselenene:
                if (checked) {
                    PASTSELENIOENE = "Sí";

                }
                else{
                    PASTSELENIOENE = "No";
                }
                break;

            case R.id.checkPecselenfeb:
                if (checked) {
                    PASTSELENIOFEB = "Sí";
                }
                else{
                    PASTSELENIOFEB = "No";
                }
                break;

            case R.id.checkPecselenmarz:
                if (checked) {
                    PASTSELENIOMAR = "Sí";

                }else{
                    PASTSELENIOMAR = "No";
                }
                break;

            case R.id.checkPecselenabr:
                if (checked) {
                    PASTSELENIOABR = "Sí";

                }else{
                    PASTSELENIOABR = "No";
                }
                break;

            case R.id.checkPecselenmay:
                if (checked) {
                    PASTSELENIOMAY = "Sí";

                }else{
                    PASTSELENIOMAY = "No";
                }
                break;

            case R.id.checkPecselenjun:
                if (checked) {
                    PASTSELENIOJUN = "Sí";

                }else{
                    PASTSELENIOJUN = "No";
                }
                break;

            case R.id.checkPecselenjul:
                if (checked) {
                    PASTSELENIOJUL = "Sí";

                }else{
                    PASTSELENIOJUL = "No";
                }
                break;

            case R.id.checkPecselenagost:
                if (checked) {
                    PASTSELENIOAGO = "Sí";

                }else{
                    PASTSELENIOAGO = "No";
                }
                break;

            case R.id.checkPecselensept:
                if (checked) {
                    PASTSELENIOSEP = "Sí";

                }else{
                    PASTSELENIOSEP = "No";
                }
                break;

            case R.id.checkPecselenoct:
                if (checked) {
                    PASTSELENIOOCT = "Sí";

                }else{
                    PASTSELENIOOCT = "No";
                }
                break;

            case R.id.checkPecselennov:
                if (checked) {
                    PASTSELENIONOV = "Sí";

                }else{
                    PASTSELENIONOV = "No";
                }
                break;

            case R.id.checkPecselendic:
                if (checked) {
                    PASSELENIODIC = "Sí";

                }else{
                    PASSELENIODIC = "No";
                }
                break;
        }
    }


    public void pastalimselenio(){
        if(!Pecuarioseleniocosto.getText().toString().isEmpty()){
            PASTSELENIOCOS = Pecuarioseleniocosto.getText().toString();
        } else{
            PASTSELENIOCOS = null;
        }

    }





    ////////////////////////////////////////////////////////////////////////////////
    //Meses para pastoreo alimentos otro tipo de alimento
    public void clickPastalimotrotipoalim(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkPecotroalimene:
                if (checked) {
                    PASTOTROTIPOENE = "Sí";

                }
                else{
                    PASTOTROTIPOENE = "No";
                }
                break;

            case R.id.checkPecotroalimfeb:
                if (checked) {
                    PASTOTROTIPOFEB = "Sí";
                }
                else{
                    PASTOTROTIPOFEB = "No";
                }
                break;

            case R.id.checkPecotroalimmarz:
                if (checked) {
                    PASTOTROTIPOMAR = "Sí";

                }else{
                    PASTOTROTIPOMAR = "No";
                }
                break;

            case R.id.checkPecotroalimabr:
                if (checked) {
                    PASTOTROTIPOABR = "Sí";

                }else{
                    PASTOTROTIPOABR = "No";
                }
                break;

            case R.id.checkPecotroalimmay:
                if (checked) {
                    PASTOTROTIPOMAY = "Sí";

                }else{
                    PASTOTROTIPOMAY = "No";
                }
                break;

            case R.id.checkPecotroalimjun:
                if (checked) {
                    PASTOTROTIPOJUN = "Sí";

                }else{
                    PASTOTROTIPOJUN = "No";
                }
                break;

            case R.id.checkPecotroalimjul:
                if (checked) {
                    PASTOTROTIPOJUL = "Sí";

                }else{
                    PASTOTROTIPOJUL = "No";
                }
                break;

            case R.id.checkPecotroalimagost:
                if (checked) {
                    PASTOTROTIPOAGO = "Sí";

                }else{
                    PASTOTROTIPOAGO = "No";
                }
                break;

            case R.id.checkPecotroalimsept:
                if (checked) {
                    PASTOTROTIPOSEP = "Sí";

                }else{
                    PASTOTROTIPOSEP = "No";
                }
                break;

            case R.id.checkPecotroalimoct:
                if (checked) {
                    PASTOTROTIPOOCT = "Sí";

                }else{
                    PASTOTROTIPOOCT = "No";
                }
                break;

            case R.id.checkPecotroalimnov:
                if (checked) {
                    PASTOTROTIPONOV = "Sí";

                }else{
                    PASTOTROTIPONOV = "No";
                }
                break;

            case R.id.checkPecotroalimdic:
                if (checked) {
                    PASOTROTIPODIC = "Sí";

                }else{
                    PASOTROTIPODIC = "No";
                }
                break;
        }
    }


    public void pastalimotrotipoalim(){
        if(!Pecuariootroalimentocosto.getText().toString().isEmpty()){
            PASTOTROTIPOCOS = Pecuariootroalimentocosto.getText().toString();
        } else{
            PASTOTROTIPOCOS = null;
        }

    }



    @Override
    public void onBackPressed() {

    }




}
