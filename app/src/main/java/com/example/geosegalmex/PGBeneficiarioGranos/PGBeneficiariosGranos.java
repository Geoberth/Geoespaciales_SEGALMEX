package com.example.geosegalmex.PGBeneficiarioGranos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.geosegalmex.General;
import com.example.geosegalmex.R;

public class PGBeneficiariosGranos extends AppCompatActivity {


    EditText fec, pgbt2, pgbt3, pgbt4, pgbt5, pgbt6, pgbt7, pgbt8, pgbt9, pgbt10, pgbt11, pgbt12, pgbt13, pgbt14, pgbt15, pgbt16, pgbt17, pgbt18, pgbt19, pgbt20, pgbt21, pgbt22, pgbt23, pgbt24, pgbt25, pgbt26, pgbt27, pgbt28, pgbt29, pgbt30;
    RadioButton propeq, promed, pgbr1, pgbr2, pgbr3, pgbr4, pgbr5, pgbr6, pgbr7, pgbr8, pgbr9, pgbr10, pgbr11, pgbr12, pgbr13, pgbr14, pgbr15, pgbr16, pgbr17, pgbr18, pgbr19, pgbr20, pgbr21, pgbr22, pgbr23, pgbr24, pgbr25, pgbr26, pgbr27, pgbr28, pgbr29, pgbr30, pgbr31, pgbr32, pgbr33, pgbr34, pgbr35, pgbr36, pgbr37, pgbr38, pgbr39, pgbr40, pgbr41, pgbr42, pgbr43, pgbr44, pgbr45, pgbr46, pgbr47, pgbr48, pgbr49, pgbr50, pgbr51, pgbr52, pgbr53, pgbr54, pgbr55, pgbr56, pgbr57, pgbr58, pgbr59, pgbr60, pgbr61, pgbr62, pgbr63, pgbr64, pgbr65, pgbr66, pgbr67, pgbr68, pgbr69, pgbr70, pgbr71, pgbr72, pgbr73, pgbr74, pgbr75, pgbr76, pgbr77, pgbr78, pgbr79, pgbr80, pgbr81, pgbr82, pgbr83, pgbr84, pgbr85, pgbr86, pgbr87, pgbr88;
    Spinner pgbs1, pgbs2, pgbs3, pgbs4;
    CheckBox pgbc1, pgbc2, pgbc3, pgbc4, pgbc5, pgbc6, pgbc7, pgbc8, pgbc9, pgbc10, pgbc11, pgbc12, pgbc13, pgbc14, pgbc15, pgbc16, pgbc17, pgbc18, pgbc19;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgbeneficiarios_granos);

       fec = (EditText)findViewById(R.id.pre_garan_granos_txt1);
       pgbt2 = (EditText)findViewById(R.id.pre_garan_granos_txt2);
       pgbt3 = (EditText)findViewById(R.id.pre_garan_granos_txt3);
        pgbt4 = (EditText)findViewById(R.id.pre_garan_granos_txt4);
        pgbt5 = (EditText)findViewById(R.id.pre_garan_granos_txt5);

        //proyecto
        propeq = (RadioButton)findViewById(R.id.pre_garan_granos_ra1);
        promed = (RadioButton)findViewById(R.id.pre_garan_granos_ra2);

        pgbt6 = (EditText)findViewById(R.id.pre_garan_granos_txt6);
        pgbt7 = (EditText)findViewById(R.id.pre_garan_granos_txt7);
        pgbt8 = (EditText)findViewById(R.id.pre_garan_granos_txt8);
        pgbt9 = (EditText)findViewById(R.id.pre_garan_granos_txt9);
        pgbt10 = (EditText)findViewById(R.id.pre_garan_granos_txt10);

        pgbs1 = (Spinner)findViewById(R.id.pgb_o_spiEstado);
        pgbt11 = (EditText)findViewById(R.id.pre_garan_granos_txt11);

        pgbs2 = (Spinner)findViewById(R.id.pgb_o_spiMunicipio);
        pgbt12 = (EditText)findViewById(R.id.pre_garan_granos_txt12);

        //Dirección producción
        pgbt13 = (EditText)findViewById(R.id.pre_garan_granos_txt13);
        pgbt14 = (EditText)findViewById(R.id.pre_garan_granos_txt14);
        pgbt15 = (EditText)findViewById(R.id.pre_garan_granos_txt15);
        pgbt16 = (EditText)findViewById(R.id.pre_garan_granos_txt16);
        pgbt17 = (EditText)findViewById(R.id.pre_garan_granos_txt17);

        pgbs3 = (Spinner)findViewById(R.id.pgb_o_spiEstado2);
        pgbt18 = (EditText)findViewById(R.id.pre_garan_granos_txt18);

        pgbs4 = (Spinner)findViewById(R.id.pgb_o_spiMunicipio2);
        pgbt19 = (EditText)findViewById(R.id.pre_garan_granos_txt19);

        //sexo
        pgbr1 = (RadioButton)findViewById(R.id.pre_garan_granos_ra2_1);
        pgbr2 = (RadioButton)findViewById(R.id.pre_garan_granos_ra2_2);
        pgbt20 = (EditText)findViewById(R.id.pre_garan_granos_txt20);

        pgbr3 = (RadioButton)findViewById(R.id.pre_garan_granos_ra3);
        pgbr4 = (RadioButton)findViewById(R.id.pre_garan_granos_ra4);

        //ESTUDIOS
        pgbr5 = (RadioButton)findViewById(R.id.pre_garan_granos_ra5);
        pgbr6 = (RadioButton)findViewById(R.id.pre_garan_granos_ra6);
        pgbr7 = (RadioButton)findViewById(R.id.pre_garan_granos_ra7);
        pgbr8 = (RadioButton)findViewById(R.id.pre_garan_granos_ra8);
        pgbr9 = (RadioButton)findViewById(R.id.pre_garan_granos_ra9);
        pgbr10 = (RadioButton)findViewById(R.id.pre_garan_granos_ra10);
        pgbr11 = (RadioButton)findViewById(R.id.pre_garan_granos_ra11);
        pgbr12 = (RadioButton)findViewById(R.id.pre_garan_granos_ra12);
        pgbr13 = (RadioButton)findViewById(R.id.pre_garan_granos_ra13);
        pgbr14 = (RadioButton)findViewById(R.id.pre_garan_granos_ra14);
        pgbr15 = (RadioButton)findViewById(R.id.pre_garan_granos_ra15);
        pgbr16 = (RadioButton)findViewById(R.id.pre_garan_granos_ra16);

        pgbt21 = (EditText)findViewById(R.id.pre_garan_granos_txt21);

        //Producto
        pgbr17 = (RadioButton)findViewById(R.id.pre_garan_granos_ra17);
        pgbr18 = (RadioButton)findViewById(R.id.pre_garan_granos_ra18);
        pgbr19 = (RadioButton)findViewById(R.id.pre_garan_granos_ra19);
        pgbr20 = (RadioButton)findViewById(R.id.pre_garan_granos_ra20);

        pgbt22 = (EditText)findViewById(R.id.pre_garan_granos_tx22);
        pgbt23 = (EditText)findViewById(R.id.pre_garan_granos_tx23);
        pgbt24 = (EditText)findViewById(R.id.pre_garan_granos_tx24);

        //info. apoyo
        pgbc1 = (CheckBox)findViewById(R.id.pre_garan_granos_ch1);
        pgbc2 = (CheckBox)findViewById(R.id.pre_garan_granos_ch2);
        pgbc3 = (CheckBox)findViewById(R.id.pre_garan_granos_ch3);
        pgbc4 = (CheckBox)findViewById(R.id.pre_garan_granos_ch4);
        pgbc5 = (CheckBox)findViewById(R.id.pre_garan_granos_ch5);
        pgbc6 = (CheckBox)findViewById(R.id.pre_garan_granos_ch6);
        pgbc7 = (CheckBox)findViewById(R.id.pre_garan_granos_ch7);
        pgbc8 = (CheckBox)findViewById(R.id.pre_garan_granos_ch8);
        pgbc9 = (CheckBox)findViewById(R.id.pre_garan_granos_ch9);
        pgbc10 = (CheckBox)findViewById(R.id.pre_garan_granos_ch10);


        pgbr21 = (RadioButton)findViewById(R.id.pre_garan_granos_ra21);
        pgbr22 = (RadioButton)findViewById(R.id.pre_garan_granos_ra22);

        pgbr23 = (RadioButton)findViewById(R.id.pre_garan_granos_ra23);
        pgbr24 = (RadioButton)findViewById(R.id.pre_garan_granos_ra24);

        pgbr25 = (RadioButton)findViewById(R.id.pre_garan_granos_ra25);
        pgbr26 = (RadioButton)findViewById(R.id.pre_garan_granos_ra26);

        pgbr27 = (RadioButton)findViewById(R.id.pre_garan_granos_ra27);
        pgbr28 = (RadioButton)findViewById(R.id.pre_garan_granos_ra28);

        pgbr29 = (RadioButton)findViewById(R.id.pre_garan_granos_ra29);
        pgbr30 = (RadioButton)findViewById(R.id.pre_garan_granos_ra30);

        pgbr31 = (RadioButton)findViewById(R.id.pre_garan_granos_ra31);
        pgbr32 = (RadioButton)findViewById(R.id.pre_garan_granos_ra32);

        pgbr33 = (RadioButton)findViewById(R.id.pre_garan_granos_ra33);
        pgbr34 = (RadioButton)findViewById(R.id.pre_garan_granos_ra34);

        pgbr35 = (RadioButton)findViewById(R.id.pre_garan_granos_ra35);
        pgbr36 = (RadioButton)findViewById(R.id.pre_garan_granos_ra36);

        pgbr37 = (RadioButton)findViewById(R.id.pre_garan_granos_ra37);
        pgbr38 = (RadioButton)findViewById(R.id.pre_garan_granos_ra38);

        pgbr39 = (RadioButton)findViewById(R.id.pre_garan_granos_ra39);
        pgbr40 = (RadioButton)findViewById(R.id.pre_garan_granos_ra40);

        pgbr41 = (RadioButton)findViewById(R.id.pre_garan_granos_ra41);
        pgbr42 = (RadioButton)findViewById(R.id.pre_garan_granos_ra42);

        pgbr43 = (RadioButton)findViewById(R.id.pre_garan_granos_ra43);
        pgbr44 = (RadioButton)findViewById(R.id.pre_garan_granos_ra44);

        pgbr45 = (RadioButton)findViewById(R.id.pre_garan_granos_ra45);
        pgbr46 = (RadioButton)findViewById(R.id.pre_garan_granos_ra46);

        pgbr47 = (RadioButton)findViewById(R.id.pre_garan_granos_ra47);
        pgbr48 = (RadioButton)findViewById(R.id.pre_garan_granos_ra48);

        pgbr49 = (RadioButton)findViewById(R.id.pre_garan_granos_ra49);
        pgbr50 = (RadioButton)findViewById(R.id.pre_garan_granos_ra50);

        pgbr51 = (RadioButton)findViewById(R.id.pre_garan_granos_ra51);
        pgbr52 = (RadioButton)findViewById(R.id.pre_garan_granos_ra52);

        pgbr53 = (RadioButton)findViewById(R.id.pre_garan_granos_ra53);
        pgbr54 = (RadioButton)findViewById(R.id.pre_garan_granos_ra54);
        pgbr55 = (RadioButton)findViewById(R.id.pre_garan_granos_ra55);

        pgbr56 = (RadioButton)findViewById(R.id.pre_garan_granos_ra56);
        pgbr57 = (RadioButton)findViewById(R.id.pre_garan_granos_ra57);
        pgbr58 = (RadioButton)findViewById(R.id.pre_garan_granos_ra58);


        pgbr59 = (RadioButton)findViewById(R.id.pre_garan_granos_ra59);
        pgbr60 = (RadioButton)findViewById(R.id.pre_garan_granos_ra60);
        pgbr61 = (RadioButton)findViewById(R.id.pre_garan_granos_ra61);
        pgbr62 = (RadioButton)findViewById(R.id.pre_garan_granos_ra62);
        pgbr63 = (RadioButton)findViewById(R.id.pre_garan_granos_ra63);
        pgbr64 = (RadioButton)findViewById(R.id.pre_garan_granos_ra64);
        pgbr65 = (RadioButton)findViewById(R.id.pre_garan_granos_ra65);
        pgbr66 = (RadioButton)findViewById(R.id.pre_garan_granos_ra66);
        pgbr67 = (RadioButton)findViewById(R.id.pre_garan_granos_ra67);
        pgbr68 = (RadioButton)findViewById(R.id.pre_garan_granos_ra68);
        pgbr69 = (RadioButton)findViewById(R.id.pre_garan_granos_ra69);
        pgbr70 = (RadioButton)findViewById(R.id.pre_garan_granos_ra70);
        pgbr71 = (RadioButton)findViewById(R.id.pre_garan_granos_ra71);
        pgbr72 = (RadioButton)findViewById(R.id.pre_garan_granos_ra72);
        pgbr73 = (RadioButton)findViewById(R.id.pre_garan_granos_ra73);
        pgbr74 = (RadioButton)findViewById(R.id.pre_garan_granos_ra74);
        pgbr75 = (RadioButton)findViewById(R.id.pre_garan_granos_ra75);
        pgbr76 = (RadioButton)findViewById(R.id.pre_garan_granos_ra76);
        pgbr77 = (RadioButton)findViewById(R.id.pre_garan_granos_ra77);
        pgbr78 = (RadioButton)findViewById(R.id.pre_garan_granos_ra78);
        pgbr79 = (RadioButton)findViewById(R.id.pre_garan_granos_ra79);
        pgbr80 = (RadioButton)findViewById(R.id.pre_garan_granos_ra80);
        pgbr81 = (RadioButton)findViewById(R.id.pre_garan_granos_ra81);
        pgbr82 = (RadioButton)findViewById(R.id.pre_garan_granos_ra82);
        pgbr83 = (RadioButton)findViewById(R.id.pre_garan_granos_ra83);
        pgbr84 = (RadioButton)findViewById(R.id.pre_garan_granos_ra84);
        pgbr85 = (RadioButton)findViewById(R.id.pre_garan_granos_ra85);
        pgbr86 = (RadioButton)findViewById(R.id.pre_garan_granos_ra86);
        pgbr87 = (RadioButton)findViewById(R.id.pre_garan_granos_ra87);
        pgbr88 = (RadioButton)findViewById(R.id.pre_garan_granos_ra88);

        pgbc11 = (CheckBox)findViewById(R.id.pre_garan_granos_ch11);
        pgbc12 = (CheckBox)findViewById(R.id.pre_garan_granos_ch12);
        pgbc13 = (CheckBox)findViewById(R.id.pre_garan_granos_ch13);
        pgbc14 = (CheckBox)findViewById(R.id.pre_garan_granos_ch14);
        pgbc15 = (CheckBox)findViewById(R.id.pre_garan_granos_ch15);
        pgbc16 = (CheckBox)findViewById(R.id.pre_garan_granos_ch16);
        pgbc17 = (CheckBox)findViewById(R.id.pre_garan_granos_ch17);
        pgbc18 = (CheckBox)findViewById(R.id.pre_garan_granos_ch18);
        pgbc19 = (CheckBox)findViewById(R.id.pre_garan_granos_ch19);

        pgbt25 = (EditText)findViewById(R.id.pre_garan_granos_tx25);

        pgbt26 = (EditText)findViewById(R.id.pre_garan_granos_txt26);
        pgbt27 = (EditText)findViewById(R.id.pre_garan_granos_txt27);
        pgbt28 = (EditText)findViewById(R.id.pre_garan_granos_txt28);
        pgbt29 = (EditText)findViewById(R.id.pre_garan_granos_txt29);

        btnSiguiente = findViewById(R.id.pre_garan_granos_sig);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

          if (validar()){
              String folio = General.Foliocuestion;
              String pgbtt2 = pgbt2.getText().toString();
           String pgbtt3 = pgbt3.getText().toString();
           String pgbtt4 = pgbt4.getText().toString();
           String pgbtt5 = pgbt5.getText().toString();
           String tprodu = obtenerRadio(promed,propeq);
           String pgbtt6 = pgbt6.getText().toString();
              String pgbtt7 = pgbt7.getText().toString();
              String pgbtt8 = pgbt8.getText().toString();
              String pgbtt9 = pgbt9.getText().toString();
              String pgbtt13 = pgbt13.getText().toString();
              String pgbtt14= pgbt14.getText().toString();
              String pgbtt15 = pgbt15.getText().toString();
              String pgbtt16 = pgbt16.getText().toString();
              String pgbtt17 = pgbt17.getText().toString();
              String nomedo = pgbs1.getSelectedItem().toString();
              String cveedo = pgbt11.getText().toString();
              String nommun = pgbs2.getSelectedItem().toString();
              String cvemun = pgbt12.getText().toString();
              String pgr1 = obtenerRadio(pgbr1, pgbr2);
              String pgbtt20 = pgbt20.getText().toString();
              String pgr2 = obtenerRadio(pgbr3, pgbr4);
              String pgr3 = obtenerRadioo(pgbr5,pgbr6,pgbr7,pgbr8,pgbr9, pgbr10, pgbr11, pgbr12, pgbr13, pgbr14, pgbr15, pgbr16);

          }
         }
        });





//finaliza el oncreate
        }

 public String obtenerRadio(RadioButton rbtt1, RadioButton rbtt2){
    //, RadioButton rbtt3, RadioButton rbtt4, RadioButton rbtt5, RadioButton rbtt6, RadioButton rbtt7, RadioButton rbtt8, RadioButton rbtt9, RadioButton rbtt10, RadioButton rbtt11){
String respuesta = "";
if (rbtt1.isChecked()==true){
 respuesta = rbtt1.getText().toString();
}
else if (rbtt2.isChecked()==true){
 respuesta = rbtt2.getText().toString();
}
  return respuesta;
 }


    public String obtenerRadioo(RadioButton rbtt5, RadioButton rbtt6, RadioButton rbtt7, RadioButton rbtt8, RadioButton rbtt9, RadioButton rbtt10, RadioButton rbtt11, RadioButton rbtt12, RadioButton rbtt13, RadioButton rbtt14, RadioButton rbtt15, RadioButton rbtt16){

        String respuesta = "";
        if (rbtt5.isChecked()==true){
            respuesta = rbtt5.getText().toString();
        }
        else if (rbtt6.isChecked()==true){
            respuesta = rbtt6.getText().toString();
        }
        else if (rbtt7.isChecked()==true){
            respuesta = rbtt7.getText().toString();
        }
        else if (rbtt8.isChecked()==true){
            respuesta = rbtt8.getText().toString();
        }
        else if (rbtt9.isChecked()==true){
            respuesta = rbtt9.getText().toString();
        }
        else if (rbtt10.isChecked()==true){
            respuesta = rbtt10.getText().toString();
        }
        else if (rbtt11.isChecked()==true){
            respuesta = rbtt11.getText().toString();
        }
        else if (rbtt12.isChecked()==true){
            respuesta = rbtt12.getText().toString();
        }
        else if (rbtt13.isChecked()==true){
            respuesta = rbtt13.getText().toString();
        }
        else if (rbtt13.isChecked()==true){
            respuesta = rbtt14.getText().toString();
        }
        else if (rbtt13.isChecked()==true){
            respuesta = rbtt15.getText().toString();
        }
        else if (rbtt13.isChecked()==true){
            respuesta = rbtt16.getText().toString();
        }

        return respuesta;
    }

        public boolean validar() {
     boolean retorno = true;

     if (pgbt2.getText().toString().isEmpty()){
      pgbt2.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt3.getText().toString().isEmpty()){
      pgbt3.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt4.getText().toString().isEmpty()){
      pgbt4.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt5.getText().toString().isEmpty()){
      pgbt5.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (!propeq.isChecked() && !promed.isChecked()) {
      promed.setError("Debes seleccionar una opción");
      retorno = false;
     }
     else if (pgbt6.getText().toString().isEmpty()){
      pgbt6.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt7.getText().toString().isEmpty()){
      pgbt7.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt8.getText().toString().isEmpty()){
      pgbt8.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt9.getText().toString().isEmpty()){
      pgbt9.setError("No puede quedar vacío");
      retorno = false;
     }

     else if (pgbt13.getText().toString().isEmpty()){
      pgbt13.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt14.getText().toString().isEmpty()){
      pgbt14.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt15.getText().toString().isEmpty()){
      pgbt15.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt16.getText().toString().isEmpty()){
      pgbt16.setError("No puede quedar vacío");
      retorno = false;
     }
     else if (pgbt17.getText().toString().isEmpty()){
      pgbt17.setError("No puede quedar vacío");
      retorno = false;
     }

     else if (!pgbr1.isChecked() && !pgbr2.isChecked()) {
      pgbr2.setError("Debes seleccionar una opción");
      retorno = false;
     }
     else if (!pgbr3.isChecked() && !pgbr4.isChecked()) {
         pgbr4.setError("Debes seleccionar una opción");
         retorno = false;
     }
     else if (!pgbr5.isChecked() && !pgbr6.isChecked() && !pgbr7.isChecked() && !pgbr8.isChecked() && !pgbr9.isChecked() && !pgbr10.isChecked() && !pgbr11.isChecked() && !pgbr12.isChecked() && !pgbr13.isChecked() && !pgbr14.isChecked() && !pgbr15.isChecked() && !pgbr16.isChecked()) {
        pgbr16.setError("Debes seleccionar una opción");
        retorno = false;
    }


     return retorno;
        }







        @Override
        public void onBackPressed() {

    }
}