package com.example.geosegalmex.PAROperativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PGBeneficiarioGranos.PGBeneficiariosGranos;
import com.example.geosegalmex.R;
import android.os.Bundle;

import com.example.geosegalmex.R;

public class PAR_Operativo extends AppCompatActivity {
    EditText folio, fec, paret3, paret4, paret5, paret6, paret7, paret8, paret08, paret008, paret9, paret10, paret11, paret12, paret13, paret14, paret15, paret16, paret17, paret18, paret19,  paret20;

    //Variables de precios de los productos Liconsa (tabla de productos)
    EditText pprolic1, pprolic2, paret1119, pprolic3, pprolic4, pprolic5, pprolic6, pprolic7, pprolic8, pprolic9, pprolic10, pprolic11, pprolic12, pprolic13, pprolic14, pprolic15, pprolic16, pprolic17, pprolic18, pprolic19, pprolic20, pprolic21, pprolic22, pprolic23, pprolic24, pprolic25, pprolic26, pprolic27, pprolic28, pprolic29, pprolic30, pprolic31, pprolic32, pprolic33, pprolic34, pprolic35, pprolic36, pprolic37, pprolic38, pprolic39, pprolic40, pprolic41, pprolic42, pprolic43, pprolic44, pprolic45, pprolic46, pprolic47, pares3;

    RadioButton parer1, parer2, parer3, parer4, parer5, parer6, parer7, parer8, parer9, parer10, parer11, parer12, parer13, parer14, parer15, parer16, parer17, parer18, parer19, parer20, parer21, parer22, parer23, parer24, parer25, parer26, parer27, parer28, parer29, parer30, parer31, parer32, parer33, parer34, parer35, parer36, parer37, parer38, parer39, parer40, parer41, parer42, parer43, parer44, parer45, parer46, parer47, parer48, parer49, parer50, parer51, parer52, parer53, parer54, parer55, parer56, parer57, parer58, parer59, parer60, parer61, parer62, parer63, parer64, parer65, parer66, parer67, parer68, parer69;
    Spinner pares1, pares2;
    CheckBox parec1, parec2, parec3, parec4, parec5, parec6, parec7, parec8, parec9, parec10, parec11, parec12, parec13, parec14, parec15, parec16, parec17, parec18, parec19, parec20, parec21, parec22, parec23, parec24, parec25, parec26, parec27, parec28, parec29, parec30, parec31, parec32, parec33, parec34, parec35, parec36, parec37, parec38, parec39, parec40, parec41, parec42, parec43, parec44, parec45, parec46, parec47, parec48, parec49, parec50, parec51, parec52, parec53, parec54, parec55, parec56, parec57, parec58, parec59, parec60, parec61, parec62, parec63, parec64, parec65, parec66, parec67, parec68, parec69, parec70, parec71, parec72, parec73, parec74, parec75, parec76, parec77, parec78, parec79, parec80, parec81, parec82, parec83, parec84, parec85, parec86, parec87, parec88, parec89, parec90, parec91, parec92, parec93, parec94, parec95, parec96, parec97, parec98, parec99, parec100, parec101, parec102, parec103, parec104, parec105, parec106, parec107, parec108, parec109, parec110, parec111, parec112, parec113, parec114, parec115, parec116, parec117, parec118, parec119, parec120, parec121, parec122, parec123, parec124, parec125, parec126, parec127, parec128, parec129, parec130, parec131, parec132, parec133, parec134, parec135, parec136, parec137, parec138, parec139, parec140;
    Button btnSiguiente, btnCamara;

    PAR_operativo_model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_operativo);

        folio=(EditText)findViewById(R.id.par_et_txt1);
        fec=(EditText)findViewById(R.id.par_et_txt2);

        //DATOS DE LA TIENDA DICONSA (PRE-LLENADO)

        pares1=(Spinner)findViewById(R.id.pgb_o_spiEstado1); //Estado
        pares2=(Spinner)findViewById(R.id.pgb_o_spiMunicipio1); //Municipio
        pares3=(EditText)findViewById(R.id.localidadpar); //Localidad/colonia

        //DATOS DE ENCARGADO DE TIENDA

        paret3=(EditText)findViewById(R.id.par_et_txt3);
        paret4=(EditText)findViewById(R.id.par_et_txt4);
        paret5=(EditText)findViewById(R.id.par_et_txt5);

        //Sexo
        parer1=(RadioButton)findViewById(R.id.par_et_ra1);
        parer2=(RadioButton)findViewById(R.id.par_et_ra2);

        paret6=(EditText)findViewById(R.id.par_et_txt6);
        paret7=(EditText)findViewById(R.id.par_et_txt7);

        //PREGUNTAS SOBRE LA OPERACIÓN DE LA TIENDA

        parer3=(RadioButton)findViewById(R.id.par_et_ra3);
        parer4=(RadioButton)findViewById(R.id.par_et_ra4);

        parer5=(RadioButton)findViewById(R.id.par_et_ra5);
        parer6=(RadioButton)findViewById(R.id.par_et_ra6);

        parer7=(RadioButton)findViewById(R.id.par_et_ra7);
        parer8=(RadioButton)findViewById(R.id.par_et_ra8);

        parer9=(RadioButton)findViewById(R.id.par_et_ra9);
        parer10=(RadioButton)findViewById(R.id.par_et_ra10);

        parer11=(RadioButton)findViewById(R.id.par_et_ra11);
        parer12=(RadioButton)findViewById(R.id.par_et_ra12);

        parer13=(RadioButton)findViewById(R.id.par_et_ra13);
        parer14=(RadioButton)findViewById(R.id.par_et_ra14);

        paret8=(EditText)findViewById(R.id.par_et_txt8);
        paret08=(EditText)findViewById(R.id.par_et_txt08);
        paret008=(EditText)findViewById(R.id.par_et_txt008);

        parec1=(CheckBox)findViewById(R.id.par_et_ch1);
        parec2=(CheckBox)findViewById(R.id.par_et_ch2);
        parec3=(CheckBox)findViewById(R.id.par_et_ch3);
        parec4=(CheckBox)findViewById(R.id.par_et_ch4);
        parec5=(CheckBox)findViewById(R.id.par_et_ch5);
        parec6=(CheckBox)findViewById(R.id.par_et_ch6);
        parec7=(CheckBox)findViewById(R.id.par_et_ch7);
        //parec8=(CheckBox)findViewById(R.id.par_et_ch8);

        parec9=(CheckBox)findViewById(R.id.par_et_ch9);
        parec10=(CheckBox)findViewById(R.id.par_et_ch10);
        parec11=(CheckBox)findViewById(R.id.par_et_ch11);
        parec12=(CheckBox)findViewById(R.id.par_et_ch12);
        parec13=(CheckBox)findViewById(R.id.par_et_ch13);
        parec14=(CheckBox)findViewById(R.id.par_et_ch14);
        parec15=(CheckBox)findViewById(R.id.par_et_ch15);
        parec16=(CheckBox)findViewById(R.id.par_et_ch16);

        parer15=(RadioButton)findViewById(R.id.par_et_ra15);
        parer16=(RadioButton)findViewById(R.id.par_et_ra16);
        parer17=(RadioButton)findViewById(R.id.par_et_ra17);
        parer18=(RadioButton)findViewById(R.id.par_et_ra18);
        parer19=(RadioButton)findViewById(R.id.par_et_ra19);
        parer20=(RadioButton)findViewById(R.id.par_et_ra20);
        parer21=(RadioButton)findViewById(R.id.par_et_ra21);
        parer22=(RadioButton)findViewById(R.id.par_et_ra22);

        paret9=(EditText)findViewById(R.id.par_et_txt9);

        parer23=(RadioButton)findViewById(R.id.par_et_ra23);
        parer24=(RadioButton)findViewById(R.id.par_et_ra24);
        parer25=(RadioButton)findViewById(R.id.par_et_ra25);
        parer26=(RadioButton)findViewById(R.id.par_et_ra26);
        parer27=(RadioButton)findViewById(R.id.par_et_ra27);
        parer28=(RadioButton)findViewById(R.id.par_et_ra28);
        parer29=(RadioButton)findViewById(R.id.par_et_ra29);

        paret10=(EditText)findViewById(R.id.par_et_txt10);

        //15. ¿Cuáles son los productos que más fallan en surtir?

        parec17=(CheckBox)findViewById(R.id.par_et_ch17);
        parec18=(CheckBox)findViewById(R.id.par_et_ch18);
        parec19=(CheckBox)findViewById(R.id.par_et_ch19);
        parec20=(CheckBox)findViewById(R.id.par_et_ch20);
        parec21=(CheckBox)findViewById(R.id.par_et_ch21);
        parec22=(CheckBox)findViewById(R.id.par_et_ch22);
        parec23=(CheckBox)findViewById(R.id.par_et_ch23);
        parec24=(CheckBox)findViewById(R.id.par_et_ch24);
        parec25=(CheckBox)findViewById(R.id.par_et_ch25);
        parec26=(CheckBox)findViewById(R.id.par_et_ch26);
        parec27=(CheckBox)findViewById(R.id.par_et_ch27);
        parec28=(CheckBox)findViewById(R.id.par_et_ch28);
        parec29=(CheckBox)findViewById(R.id.par_et_ch29);
        parec30=(CheckBox)findViewById(R.id.par_et_ch30);
        parec31=(CheckBox)findViewById(R.id.par_et_ch31);
        parec32=(CheckBox)findViewById(R.id.par_et_ch32);
        parec33=(CheckBox)findViewById(R.id.par_et_ch33);
        parec34=(CheckBox)findViewById(R.id.par_et_ch34);
        parec35=(CheckBox)findViewById(R.id.par_et_ch35);
        parec36=(CheckBox)findViewById(R.id.par_et_ch36);
        parec37=(CheckBox)findViewById(R.id.par_et_ch37);
        parec38=(CheckBox)findViewById(R.id.par_et_ch38);
        parec39=(CheckBox)findViewById(R.id.par_et_ch39);
        parec40=(CheckBox)findViewById(R.id.par_et_ch40);
        parec41=(CheckBox)findViewById(R.id.par_et_ch41);
        parec42=(CheckBox)findViewById(R.id.par_et_ch42);
        parec43=(CheckBox)findViewById(R.id.par_et_ch43);
        parec44=(CheckBox)findViewById(R.id.par_et_ch44);
        parec45=(CheckBox)findViewById(R.id.par_et_ch45);
        parec46=(CheckBox)findViewById(R.id.par_et_ch46);
        parec47=(CheckBox)findViewById(R.id.par_et_ch47);
        parec48=(CheckBox)findViewById(R.id.par_et_ch48);
        parec49=(CheckBox)findViewById(R.id.par_et_ch49);
        parec50=(CheckBox)findViewById(R.id.par_et_ch50);
        parec51=(CheckBox)findViewById(R.id.par_et_ch51);
        parec52=(CheckBox)findViewById(R.id.par_et_ch52);
        parec53=(CheckBox)findViewById(R.id.par_et_ch53);
        parec54=(CheckBox)findViewById(R.id.par_et_ch54);
        parec55=(CheckBox)findViewById(R.id.par_et_ch55);
        parec56=(CheckBox)findViewById(R.id.par_et_ch56);
        parec57=(CheckBox)findViewById(R.id.par_et_ch57);
        parec58=(CheckBox)findViewById(R.id.par_et_ch58);
        parec59=(CheckBox)findViewById(R.id.par_et_ch59);
        parec60=(CheckBox)findViewById(R.id.par_et_ch60);
        parec61=(CheckBox)findViewById(R.id.par_et_ch61);
        parec62=(CheckBox)findViewById(R.id.par_et_ch62);
        parec63=(CheckBox)findViewById(R.id.par_et_ch63);

        //16. ¿Cuáles son los cinco productos de la canasta básica DICONSA que más se venden en la tienda?

        //Checkboxes
        parec64=(CheckBox)findViewById(R.id.par_et_ch64);
        parec65=(CheckBox)findViewById(R.id.par_et_ch65);
        parec66=(CheckBox)findViewById(R.id.par_et_ch66);
        parec67=(CheckBox)findViewById(R.id.par_et_ch67);
        parec68=(CheckBox)findViewById(R.id.par_et_ch68);
        parec69=(CheckBox)findViewById(R.id.par_et_ch69);
        parec70=(CheckBox)findViewById(R.id.par_et_ch70);
        parec71=(CheckBox)findViewById(R.id.par_et_ch71);
        parec72=(CheckBox)findViewById(R.id.par_et_ch72);
        parec73=(CheckBox)findViewById(R.id.par_et_ch73);
        parec74=(CheckBox)findViewById(R.id.par_et_ch74);
        parec75=(CheckBox)findViewById(R.id.par_et_ch75);
        parec76=(CheckBox)findViewById(R.id.par_et_ch76);
        parec77=(CheckBox)findViewById(R.id.par_et_ch77);
        parec78=(CheckBox)findViewById(R.id.par_et_ch78);
        parec79=(CheckBox)findViewById(R.id.par_et_ch79);
        parec80=(CheckBox)findViewById(R.id.par_et_ch80);
        parec81=(CheckBox)findViewById(R.id.par_et_ch81);
        parec82=(CheckBox)findViewById(R.id.par_et_ch82);
        parec83=(CheckBox)findViewById(R.id.par_et_ch83);
        parec84=(CheckBox)findViewById(R.id.par_et_ch84);
        parec85=(CheckBox)findViewById(R.id.par_et_ch85);
        parec86=(CheckBox)findViewById(R.id.par_et_ch86);
        parec87=(CheckBox)findViewById(R.id.par_et_ch87);
        parec88=(CheckBox)findViewById(R.id.par_et_ch88);
        parec89=(CheckBox)findViewById(R.id.par_et_ch89);
        parec90=(CheckBox)findViewById(R.id.par_et_ch90);
        parec91=(CheckBox)findViewById(R.id.par_et_ch91);
        parec92=(CheckBox)findViewById(R.id.par_et_ch92);
        parec93=(CheckBox)findViewById(R.id.par_et_ch93);
        parec94=(CheckBox)findViewById(R.id.par_et_ch94);
        parec95=(CheckBox)findViewById(R.id.par_et_ch95);
        parec96=(CheckBox)findViewById(R.id.par_et_ch96);
        parec97=(CheckBox)findViewById(R.id.par_et_ch97);
        parec98=(CheckBox)findViewById(R.id.par_et_ch98);
        parec99=(CheckBox)findViewById(R.id.par_et_ch99);
        parec100=(CheckBox)findViewById(R.id.par_et_ch100);
        parec101=(CheckBox)findViewById(R.id.par_et_ch101);
        parec102=(CheckBox)findViewById(R.id.par_et_ch102);
        parec103=(CheckBox)findViewById(R.id.par_et_ch103);
        parec104=(CheckBox)findViewById(R.id.par_et_ch104);
        parec105=(CheckBox)findViewById(R.id.par_et_ch105);
        parec106=(CheckBox)findViewById(R.id.par_et_ch106);
        parec107=(CheckBox)findViewById(R.id.par_et_ch107);
        parec108=(CheckBox)findViewById(R.id.par_et_ch108);
        parec109=(CheckBox)findViewById(R.id.par_et_ch109);
        parec110=(CheckBox)findViewById(R.id.par_et_ch110);
        //Fin checkboxes

        parer30=(RadioButton)findViewById(R.id.par_et_ra30);
        parer31=(RadioButton)findViewById(R.id.par_et_ra31);
        parer32=(RadioButton)findViewById(R.id.par_et_ra32);
        parer33=(RadioButton)findViewById(R.id.par_et_ra33);
        parer34=(RadioButton)findViewById(R.id.par_et_ra34);
        parer35=(RadioButton)findViewById(R.id.par_et_ra35);
        parer36=(RadioButton)findViewById(R.id.par_et_ra36);
        parer37=(RadioButton)findViewById(R.id.par_et_ra37);
        parer38=(RadioButton)findViewById(R.id.par_et_ra38);
        parer39=(RadioButton)findViewById(R.id.par_et_ra39);
        parer40=(RadioButton)findViewById(R.id.par_et_ra40);
        parer41=(RadioButton)findViewById(R.id.par_et_ra41);
        parer42=(RadioButton)findViewById(R.id.par_et_ra42);
        parer43=(RadioButton)findViewById(R.id.par_et_ra43);
        parer44=(RadioButton)findViewById(R.id.par_et_ra44);

        paret11=(EditText)findViewById(R.id.par_et_txt11);
        paret12=(EditText)findViewById(R.id.par_et_txt12);
        paret13=(EditText)findViewById(R.id.par_et_txt13);
        paret14=(EditText)findViewById(R.id.par_et_txt14);
        paret15=(EditText)findViewById(R.id.par_et_txt15);

        parer45=(RadioButton)findViewById(R.id.par_et_ra45);
        parer46=(RadioButton)findViewById(R.id.par_et_ra46);
        parer47=(RadioButton)findViewById(R.id.par_et_ra47);
        parer48=(RadioButton)findViewById(R.id.par_et_ra48);

        paret16=(EditText)findViewById(R.id.par_et_txt16);
        paret17=(EditText)findViewById(R.id.par_et_txt17);
        paret18=(EditText)findViewById(R.id.par_et_txt18);

        parec111=(CheckBox)findViewById(R.id.par_et_ch111);
        parec112=(CheckBox)findViewById(R.id.par_et_ch112);
        parec113=(CheckBox)findViewById(R.id.par_et_ch113);
        parec114=(CheckBox)findViewById(R.id.par_et_ch114);
        parec115=(CheckBox)findViewById(R.id.par_et_ch115);
        parec116=(CheckBox)findViewById(R.id.par_et_ch116);
        parec117=(CheckBox)findViewById(R.id.par_et_ch117);

        parec118=(CheckBox)findViewById(R.id.par_et_ch118);
        parec119=(CheckBox)findViewById(R.id.par_et_ch119);
        parec120=(CheckBox)findViewById(R.id.par_et_ch120);
        parec121=(CheckBox)findViewById(R.id.par_et_ch121);
        parec122=(CheckBox)findViewById(R.id.par_et_ch122);

        paret1119=(EditText)findViewById(R.id.par_et_txt1119);


        parer49=(RadioButton)findViewById(R.id.par_et_ra49);
        parer50=(RadioButton)findViewById(R.id.par_et_ra50);

        paret19=(EditText)findViewById(R.id.par_et_txt19);

        parer51=(RadioButton)findViewById(R.id.par_et_ra51);
        parer52=(RadioButton)findViewById(R.id.par_et_ra52);

        parec123=(CheckBox)findViewById(R.id.par_et_ch123);
        parec124=(CheckBox)findViewById(R.id.par_et_ch124);
        parec125=(CheckBox)findViewById(R.id.par_et_ch125);
        parec126=(CheckBox)findViewById(R.id.par_et_ch126);
        parec127=(CheckBox)findViewById(R.id.par_et_ch127);
        parec128=(CheckBox)findViewById(R.id.par_et_ch128);
        parec129=(CheckBox)findViewById(R.id.par_et_ch129);
        parec130=(CheckBox)findViewById(R.id.par_et_ch130);
        parec131=(CheckBox)findViewById(R.id.par_et_ch131);

        parec132=(CheckBox)findViewById(R.id.par_et_ch132);
        parec133=(CheckBox)findViewById(R.id.par_et_ch133);
        parec134=(CheckBox)findViewById(R.id.par_et_ch134);
        parec135=(CheckBox)findViewById(R.id.par_et_ch135);
        parec136=(CheckBox)findViewById(R.id.par_et_ch136);
        parec137=(CheckBox)findViewById(R.id.par_et_ch137);
        parec138=(CheckBox)findViewById(R.id.par_et_ch138);
        parec139=(CheckBox)findViewById(R.id.par_et_ch139);
        parec140=(CheckBox)findViewById(R.id.par_et_ch140);

        //ENCUESTA DE OPINIÓN AL ENCARGADO DE TIENDA

        parer53=(RadioButton)findViewById(R.id.par_et_ra53);
        parer54=(RadioButton)findViewById(R.id.par_et_ra54);
        parer55=(RadioButton)findViewById(R.id.par_et_ra55);
        parer56=(RadioButton)findViewById(R.id.par_et_ra56);
        parer57=(RadioButton)findViewById(R.id.par_et_ra57);
        parer58=(RadioButton)findViewById(R.id.par_et_ra58);
        parer59=(RadioButton)findViewById(R.id.par_et_ra59);

        paret20=(EditText)findViewById(R.id.par_et_txt20);

        //GUÍA DE OBERVACIÓN (A VERIFICAR POR EL SUPERVISOR DE LA IAS)

        parer60=(RadioButton)findViewById(R.id.par_et_ra60);
        parer61=(RadioButton)findViewById(R.id.par_et_ra61);

        //BOTON CAMARA

        btnCamara = findViewById(R.id.par_et_btnCamara);


        parer62=(RadioButton)findViewById(R.id.par_et_ra62);
        parer63=(RadioButton)findViewById(R.id.par_et_ra63);
        parer64=(RadioButton)findViewById(R.id.par_et_ra64);
        parer65=(RadioButton)findViewById(R.id.par_et_ra65);
        parer66=(RadioButton)findViewById(R.id.par_et_ra66);
        parer67=(RadioButton)findViewById(R.id.par_et_ra67);
        parer68=(RadioButton)findViewById(R.id.par_et_ra68);
        parer69=(RadioButton)findViewById(R.id.par_et_ra69);

        //Asignacion de variables tabla de precios - productos LICONSA

        pprolic1=(EditText)findViewById(R.id.dic_pre_1);
        pprolic2=(EditText)findViewById(R.id.dic_pre_2);
        pprolic3=(EditText)findViewById(R.id.dic_pre_3);
        pprolic4=(EditText)findViewById(R.id.dic_pre_4);
        pprolic5=(EditText)findViewById(R.id.dic_pre_5);
        pprolic6=(EditText)findViewById(R.id.dic_pre_6);
        pprolic7=(EditText)findViewById(R.id.dic_pre_7);
        pprolic8=(EditText)findViewById(R.id.dic_pre_8);
        pprolic9=(EditText)findViewById(R.id.dic_pre_9);
        pprolic10=(EditText)findViewById(R.id.dic_pre_10);
        pprolic11=(EditText)findViewById(R.id.dic_pre_11);
        pprolic12=(EditText)findViewById(R.id.dic_pre_12);
        pprolic13=(EditText)findViewById(R.id.dic_pre_13);
        pprolic14=(EditText)findViewById(R.id.dic_pre_14);
        pprolic15=(EditText)findViewById(R.id.dic_pre_15);
        pprolic16=(EditText)findViewById(R.id.dic_pre_16);
        pprolic17=(EditText)findViewById(R.id.dic_pre_17);
        pprolic18=(EditText)findViewById(R.id.dic_pre_18);
        pprolic19=(EditText)findViewById(R.id.dic_pre_19);
        pprolic20=(EditText)findViewById(R.id.dic_pre_20);
        pprolic21=(EditText)findViewById(R.id.dic_pre_21);
        pprolic22=(EditText)findViewById(R.id.dic_pre_22);
        pprolic23=(EditText)findViewById(R.id.dic_pre_23);
        pprolic24=(EditText)findViewById(R.id.dic_pre_24);
        pprolic25=(EditText)findViewById(R.id.dic_pre_25);
        pprolic26=(EditText)findViewById(R.id.dic_pre_26);
        pprolic27=(EditText)findViewById(R.id.dic_pre_27);
        pprolic28=(EditText)findViewById(R.id.dic_pre_28);
        pprolic29=(EditText)findViewById(R.id.dic_pre_29);
        pprolic30=(EditText)findViewById(R.id.dic_pre_30);
        pprolic31=(EditText)findViewById(R.id.dic_pre_31);
        pprolic32=(EditText)findViewById(R.id.dic_pre_32);
        pprolic33=(EditText)findViewById(R.id.dic_pre_33);
        pprolic34=(EditText)findViewById(R.id.dic_pre_34);
        pprolic35=(EditText)findViewById(R.id.dic_pre_35);
        pprolic36=(EditText)findViewById(R.id.dic_pre_36);
        pprolic37=(EditText)findViewById(R.id.dic_pre_37);
        pprolic38=(EditText)findViewById(R.id.dic_pre_38);
        pprolic39=(EditText)findViewById(R.id.dic_pre_39);
        pprolic40=(EditText)findViewById(R.id.dic_pre_40);
        pprolic41=(EditText)findViewById(R.id.dic_pre_41);
        pprolic42=(EditText)findViewById(R.id.dic_pre_42);
        pprolic43=(EditText)findViewById(R.id.dic_pre_43);
        pprolic44=(EditText)findViewById(R.id.dic_pre_44);
        pprolic45=(EditText)findViewById(R.id.dic_pre_45);
        pprolic46=(EditText)findViewById(R.id.dic_pre_46);
        pprolic47=(EditText)findViewById(R.id.dic_pre_47);

        //BOTON SIGUIENTE

        btnSiguiente = findViewById(R.id.par_et_sig);

        btnSiguiente.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String folio = General.Foliocuestion;
                General.fechaenc = fec.getText().toString();
                String noment = "";
                String cveedo = "";
                String nommun = "";
                String cvemun = "";
                //nombre
                String parnom = paret3.getText().toString();
                String parape = paret4.getText().toString();
                String parapem = paret5.getText().toString();
                String parrad1 = obtenerRadio(parer1, parer2);
                String pare6 = paret6.getText().toString();
                String pare7 = paret7.getText().toString();
                String parrad2 = obtenerRadio(parer3, parer4);
                String parrad3 = obtenerRadio(parer5, parer6);
                String parrad4 = obtenerRadio(parer7, parer8);
                String parrad5 = obtenerRadio(parer9, parer10);
                String parrad6 = obtenerRadio(parer11, parer12);
                String parrad7 = obtenerRadio(parer13, parer14);
                String pare8 = paret8.getText().toString();
                //Checkbox
                String pare9 = capa();
                String pare10 = paret08.getText().toString();
                //Checkbox
                String pare11 = capa2();
                String pare12 = paret008.getText().toString();
                //
                String pare13 = obtenerRadio(parer15, parer16);
                String pare14 = obtenerRadio(parer17, parer18);
                String pare15 = obtenerRadio4(parer19, parer20, parer21, parer22);
                String pare16 = obtenerRadio3(parer23, parer24, parer25);
                String pare17 = obtenerRadio4(parer26, parer27, parer28, parer29);
                String pare18 = capa3();
                String pare19 = capa4();
                String pare20 = obtenerRadio3(parer30, parer31, parer32);
                String pare21 = obtenerRadio4(parer33, parer34, parer35, parer36);
                String pare22 = obtenerRadio4(parer37, parer38, parer39, parer40);
                String pare23 = obtenerRadio4(parer41, parer42, parer43, parer44);
                String pare24 = paret11.getText().toString();
                String pare25 = paret12.getText().toString();
                String pare26 = paret13.getText().toString();
                String pare27 = paret14.getText().toString();
                String pare28 = paret15.getText().toString();
                String pare29 = obtenerRadio4(parer45, parer46, parer47, parer48);
                String pare30 = paret16.getText().toString();
                String pare31 = paret17.getText().toString();
                String pare32 = paret18.getText().toString();
                String pare33 = capa5();
                String pare34 = capa6();
                String pare35 = paret1119.getText().toString();
                String pare36 = obtenerRadio(parer49, parer50);
                String pare37 = paret19.getText().toString();
                String pare38 = obtenerRadio(parer51, parer52);
                String pare39 = capa7();
                String pare40 = capa8();
                String pare41 = obtenerRadio4(parer53, parer54, parer55, parer56);
                String pare42 = obtenerRadio3(parer57, parer58, parer59);
                String pare43 = paret20.getText().toString();
                String pare44 = obtenerRadio(parer60, parer61);
                String pare45 = obtenerRadio(parer62, parer63);
                String pare46 = obtenerRadio(parer64, parer65);
                String pare47 = obtenerRadio(parer66, parer67);
                String pare48 = obtenerRadio(parer68, parer69);
                //Productos
                String pare49 = pprolic1.getText().toString();
                String pare50 = pprolic2.getText().toString();
                String pare51 = pprolic3.getText().toString();
                String pare52 = pprolic4.getText().toString();
                String pare53 = pprolic5.getText().toString();
                String pare54 = pprolic7.getText().toString();
                String pare55 = pprolic8.getText().toString();
                String pare56 = pprolic9.getText().toString();
                String pare57 = pprolic10.getText().toString();
                String pare58 = pprolic11.getText().toString();
                String pare59 = pprolic12.getText().toString();
                String pare60 = pprolic13.getText().toString();
                String pare61 = pprolic14.getText().toString();
                String pare62 = pprolic15.getText().toString();
                String pare63 = pprolic16.getText().toString();
                String pare64 = pprolic17.getText().toString();
                String pare65 = pprolic18.getText().toString();
                String pare66 = pprolic19.getText().toString();
                String pare67 = pprolic20.getText().toString();
                String pare68 = pprolic21.getText().toString();
                String pare69 = pprolic22.getText().toString();
                String pare70 = pprolic23.getText().toString();
                String pare71 = pprolic24.getText().toString();
                String pare72 = pprolic25.getText().toString();
                String pare73 = pprolic26.getText().toString();
                String pare74 = pprolic27.getText().toString();
                String pare75 = pprolic28.getText().toString();
                String pare76 = pprolic29.getText().toString();
                String pare77 = pprolic30.getText().toString();
                String pare78 = pprolic31.getText().toString();
                String pare79 = pprolic32.getText().toString();
                String pare80 = pprolic33.getText().toString();
                String pare81 = pprolic34.getText().toString();
                String pare82 = pprolic35.getText().toString();
                String pare84 = pprolic36.getText().toString();
                String pare85 = pprolic37.getText().toString();
                String pare86 = pprolic38.getText().toString();
                String pare87 = pprolic39.getText().toString();
                String pare88 = pprolic40.getText().toString();
                String pare89 = pprolic41.getText().toString();
                String pare90 = pprolic42.getText().toString();
                String pare91 = pprolic43.getText().toString();
                String pare92 = pprolic44.getText().toString();
                String pare93 = pprolic45.getText().toString();
                String pare94 = pprolic46.getText().toString();
                String pare95 = pprolic47.getText().toString();

                model = new PAR_operativo_model(folio, General.fechaenc, noment, cveedo, nommun, cvemun, parnom, parape, parapem, parrad1, pare6, pare7, parrad2, parrad3, parrad4, parrad5, parrad6, parrad7, pare8, pare9, pare10, pare11, pare12, pare13, pare14, pare15, pare16, pare17, pare18, pare19, pare20, pare21, pare22, pare23, pare24, pare25, pare26, pare27, pare28, pare29, pare30, pare31, pare32, pare33, pare34, pare35, pare36, pare37, pare38, pare39, pare40, pare41, pare42, pare43, pare44, pare45, pare46, pare47, pare48, pare49, pare50, pare51, pare52, pare53, pare54, pare55, pare56, pare57, pare58, pare59, pare60, pare61, pare62, pare63, pare64, pare65, pare66, pare67, pare68, pare69, pare70, pare71, pare72, pare73, pare74, pare75, pare76, pare77, pare78, pare79, pare80, pare81, pare82, pare84, pare85, pare86, pare87, pare88, pare89, pare90, pare91, pare92, pare93, pare94);
                Intent in = new Intent(PAR_Operativo.this, GeoreferenciaActivity.class);
                in.putExtra("model", model);
                startActivity(in);

            }
        });

        btnCamara.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {



            }
        });


//TERMINA ONCREATE
    }

    public String obtenerRadio(RadioButton radio1, RadioButton radio2){
        String respuesta = "";
        if (radio1.isChecked()==true){
            respuesta = radio1.getText().toString();
        }
        else if (radio2.isChecked()==true){
            respuesta = radio2.getText().toString();
        }
        return respuesta;
    }

    public String obtenerRadio3(RadioButton radio01, RadioButton radio02, RadioButton radio03){
        String respuesta3 = "";
        if (radio01.isChecked()==true){
            respuesta3 = radio01.getText().toString();
        }
        else if (radio02.isChecked()==true){
            respuesta3 = radio02.getText().toString();
        }
        else if (radio03.isChecked()==true){
            respuesta3 = radio03.getText().toString();
        }
        return respuesta3;
    }

    public String obtenerRadio4(RadioButton radio001, RadioButton radio002, RadioButton radio003, RadioButton radio004){
        String respuesta4 = "";
        if (radio001.isChecked()==true){
            respuesta4 = radio001.getText().toString();
        }
        else if (radio002.isChecked()==true){
            respuesta4 = radio002.getText().toString();
        }
        else if (radio003.isChecked()==true){
            respuesta4 = radio003.getText().toString();
        }
        else if (radio004.isChecked()==true){
            respuesta4 = radio004.getText().toString();
        }
        return respuesta4;
    }

    public String capa(){
        String cadena = "";
        String resultado1 = "";

        if (parec1.isChecked()){
            cadena = "1-";
        }
        if (parec2.isChecked()){
            cadena = "2-";
        }
        if (parec3.isChecked()){
            cadena = "3-";
        }
        if (parec4.isChecked()){
            cadena = "4-";
        }
        if (parec5.isChecked()){
            cadena = "5-";
        }
        if (parec6.isChecked()){
            cadena = "6-";
        }
        if (parec7.isChecked()){
            cadena = "7-";
        }
        resultado1 = cadena.substring(0, cadena.length()-1);
        return resultado1;
    }

    public String capa2(){
        String cadena = "";
        String resultado1 = "";

        if (parec9.isChecked()){
            cadena = "1-";
        }
        if (parec10.isChecked()){
            cadena = "2-";
        }
        if (parec11.isChecked()){
            cadena = "3-";
        }
        if (parec12.isChecked()){
            cadena = "4-";
        }
        if (parec13.isChecked()){
            cadena = "5-";
        }
        if (parec14.isChecked()){
            cadena = "6-";
        }
        if (parec15.isChecked()){
            cadena = "7-";
        }
        resultado1 = cadena.substring(0, cadena.length()-1);
        return resultado1;
    }

    public String capa5(){
        String cadena5 = "";
        String resultado5 = "";

        if (parec111.isChecked()){
            cadena5 = "Lunes-";
        }
        if (parec112.isChecked()){
            cadena5 = "Martes-";
        }
        if (parec113.isChecked()){
            cadena5 = "Miércoles-";
        }
        if (parec114.isChecked()){
            cadena5 = "Jueves-";
        }
        if (parec115.isChecked()){
            cadena5 = "Viernes-";
        }
        if (parec116.isChecked()){
            cadena5 = "Sábado-";
        }
        if (parec117.isChecked()){
            cadena5 = "Domingo-";
        }

        resultado5 = cadena5.substring(0, cadena5.length()-1);
        return resultado5;
    }

    public String capa6(){
        String cadena6 = "";
        String resultado6 = "";

        if (parec118.isChecked()){
            cadena6 = "Sismos-";
        }
        if (parec119.isChecked()){
            cadena6 = "Ciclones-";
        }
        if (parec120.isChecked()){
            cadena6 = "Violencia-";
        }
        if (parec121.isChecked()){
            cadena6 = "Otro-";
        }
        if (parec122.isChecked()){
            cadena6 = "Ninguno-";
        }

        resultado6 = cadena6.substring(0, cadena6.length()-1);
        return resultado6;

    }


    public String capa7(){
        String cadena7 = "";
        String resultado7 = "";

        if (parec123.isChecked()){
            cadena7 = "Sismos-";
        }
        if (parec124.isChecked()){
            cadena7 = "Caseta de telefonía-";
        }
        if (parec125.isChecked()){
            cadena7 = "Tiempo aire-";
        }
        if (parec126.isChecked()){
            cadena7 = "Internet-";
        }
        if (parec127.isChecked()){
            cadena7 = "Pago de servicios-";
        }
        if (parec128.isChecked()){
            cadena7 = "Pago de apoyos-";
        }
        if (parec129.isChecked()){
            cadena7 = "Distribución de leche Liconsa-";
        }
        if (parec130.isChecked()){
            cadena7 = "Papelería-";
        }
        if (parec131.isChecked()){
            cadena7 = "Otros-";
        }

        resultado7 = cadena7.substring(0, cadena7.length()-1);
        return resultado7;
    }




    public String capa8(){
        String cadena8 = "";
        String resultado8 = "";

        if (parec132.isChecked()){
            cadena8 = "Sismos-";
        }
        if (parec133.isChecked()){
            cadena8 = "Caseta de telefonía-";
        }
        if (parec134.isChecked()){
            cadena8 = "Tiempo aire-";
        }
        if (parec135.isChecked()){
            cadena8 = "Internet-";
        }
        if (parec136.isChecked()){
            cadena8 = "Pago de servicios-";
        }
        if (parec137.isChecked()){
            cadena8 = "Pago de apoyos-";
        }
        if (parec138.isChecked()){
            cadena8 = "Distribución de leche Liconsa-";
        }
        if (parec139.isChecked()){
            cadena8 = "Papelería-";
        }
        if (parec140.isChecked()){
            cadena8 = "Otros-";
        }
        resultado8 = cadena8.substring(0, cadena8.length()-1);
        return resultado8;
    }




    public String capa3() {
        String cadena3 = "";
        String resultado3 = "";

        if (parec17.isChecked()) {
            cadena3 = "1-Aceite comestible cristal.";
        }
        if (parec18.isChecked()) {
            cadena3 = "2-Aceite mixto Patrona.";
        }
        if (parec19.isChecked()) {
            cadena3 = "3-Arroz super extra.";
        }
        if (parec20.isChecked()) {
            cadena3 = "4-Arroz Quebrado (1/2 grano).";
        }
        if (parec21.isChecked()) {
            cadena3 = "5-Arroz Comercial.";
        }
        if (parec22.isChecked()) {
            cadena3 = "6-Atún en Agua.";
        }
        if (parec23.isChecked()) {
            cadena3 = "7-Atún en Aceite.";
        }
        if (parec24.isChecked()) {
            cadena3 = "8-Avena.";
        }
        if (parec25.isChecked()) {
            cadena3 = "9-Azúcar estandar.";
        }
        if (parec26.isChecked()) {
            cadena3 = "10-Café soluble.";
        }
        if (parec27.isChecked()) {
            cadena3 = "11-Arroz Comercial.";
        }
        if (parec28.isChecked()) {
            cadena3 = "12-Chiles jalapeños enteros.";
        }
        if (parec29.isChecked()) {
            cadena3 = "13-Chocolate en polvo.";
        }
        if (parec30.isChecked()) {
            cadena3 = "14-Crema dental.";
        }
        if (parec31.isChecked()) {
            cadena3 = "15-Detergente en polvo.";
        }
        if (parec32.isChecked()) {
            cadena3 = "16-Frijol Negro San luis.";
        }
        if (parec33.isChecked()) {
            cadena3 = "17-Galletas animalitos.";
        }
        if (parec34.isChecked()) {
            cadena3 = "18-Galletas Marías.";
        }
        if (parec35.isChecked()) {
            cadena3 = "19-Galletas Saladas.";
        }
        if (parec36.isChecked()) {
            cadena3 = "20-Harina de Maíz.";
        }
        if (parec37.isChecked()) {
            cadena3 = "21-Harina de Trigo.";
        }
        if (parec38.isChecked()) {
            cadena3 = "22-Jabón de lavandería.";
        }
        if (parec39.isChecked()) {
            cadena3 = "23-Jabón de tocador.";
        }
        if (parec40.isChecked()) {
            cadena3 = "24-Leche Entera.";
        }
        if (parec41.isChecked()) {
            cadena3 = "25-Leche Semidescremada.";
        }
        if (parec42.isChecked()) {
            cadena3 = "26-Leche Descremada.";
        }
        if (parec43.isChecked()) {
            cadena3 = "27-Leche Semideslactosada.";
        }
        if (parec44.isChecked()) {
            cadena3 = "28-Leche Entera en Polvo Fortificada.";
        }
        if (parec45.isChecked()) {
            cadena3 = "29-Maíz.";
        }
        if (parec46.isChecked()) {
            cadena3 = "30-Leche Entera UGT en Bolsa Aséptica";
        }

        if (parec47.isChecked()) {
            cadena3 = "31-Gelatina.";
        }
        if (parec48.isChecked()) {
            cadena3 = "32-Leche Semidescremada UHT en Bolsa Aséptica.";
        }
        if (parec49.isChecked()) {
            cadena3 = "33-Leche Descremada UHT en Bolsa Aséptica.";
        }
        if (parec50.isChecked()) {
            cadena3 = "34-Leche Semidescremada Sabor Chocolate.";
        }
        if (parec51.isChecked()) {
            cadena3 = "35-Leche Semidescremada Sabor Fresa.";
        }
        if (parec52.isChecked()) {
            cadena3 = "36-Miel.";
        }
        if (parec53.isChecked()) {
            cadena3 = "37-Leche Semidescremada Sabor Vainilla.";
        }
        if (parec54.isChecked()) {
            cadena3 = "38-Papel Higiénico 200 H.D.";
        }
        if (parec55.isChecked()) {
            cadena3 = "39-Sal de mesa.";
        }
        if (parec56.isChecked()) {
            cadena3 = "40-Sardina en Salsa de Tomate.";
        }
        if (parec57.isChecked()) {
            cadena3 = "41-Lenteja.";
        }
        if (parec58.isChecked()) {
            cadena3 = "42-Puré de Tomate.";
        }
        if (parec59.isChecked()) {
            cadena3 = "43-Garrafón 20 Lt. Agua.";
        }
        if (parec60.isChecked()) {
            cadena3 = "44-Chícharos con Zanahoria (LA COSTEÑA).";
        }
        if (parec61.isChecked()) {
            cadena3 = "45-Chícharos con Zanahoria (CLEMENTE JACQUES).";
        }
        if (parec62.isChecked()) {
            cadena3 = "46-Huevo.";
        }
        if (parec63.isChecked()) {
            cadena3 = "47-Soya Texturizada (NUTRICASA).";
        }

        resultado3 = cadena3.substring(0, cadena3.length()-1);
        return resultado3;
    }

    public String capa4() {
        String cadena4 = "";
        String resultado4 = "";

        if (parec64.isChecked()) {
            cadena4 = "1-Aceite comestible cristal.";
        }
        if (parec65.isChecked()) {
            cadena4 = "2-Aceite mixto Patrona.";
        }
        if (parec66.isChecked()) {
            cadena4 = "3-Arroz super extra.";
        }
        if (parec67.isChecked()) {
            cadena4 = "4-Arroz Quebrado (1/2 grano).";
        }
        if (parec68.isChecked()) {
            cadena4 = "5-Arroz Comercial.";
        }
        if (parec69.isChecked()) {
            cadena4 = "6-Atún en Agua.";
        }
        if (parec70.isChecked()) {
            cadena4 = "7-Atún en Aceite.";
        }
        if (parec71.isChecked()) {
            cadena4 = "8-Avena.";
        }
        if (parec72.isChecked()) {
            cadena4 = "9-Azúcar estandar.";
        }
        if (parec73.isChecked()) {
            cadena4 = "10-Café soluble.";
        }
        if (parec74.isChecked()) {
            cadena4 = "11-Arroz Comercial.";
        }
        if (parec75.isChecked()) {
            cadena4 = "12-Chiles jalapeños enteros.";
        }
        if (parec76.isChecked()) {
            cadena4 = "13-Chocolate en polvo.";
        }
        if (parec77.isChecked()) {
            cadena4 = "14-Crema dental.";
        }
        if (parec78.isChecked()) {
            cadena4 = "15-Detergente en polvo.";
        }
        if (parec79.isChecked()) {
            cadena4 = "16-Frijol Negro San luis.";
        }
        if (parec80.isChecked()) {
            cadena4 = "17-Galletas animalitos.";
        }
        if (parec81.isChecked()) {
            cadena4 = "18-Galletas Marías.";
        }
        if (parec82.isChecked()) {
            cadena4 = "19-Galletas Saladas.";
        }
        if (parec83.isChecked()) {
            cadena4 = "20-Harina de Maíz.";
        }
        if (parec84.isChecked()) {
            cadena4 = "21-Harina de Trigo.";
        }
        if (parec85.isChecked()) {
            cadena4 = "22-Jabón de lavandería.";
        }
        if (parec86.isChecked()) {
            cadena4 = "23-Jabón de tocador.";
        }
        if (parec87.isChecked()) {
            cadena4 = "24-Leche Entera.";
        }
        if (parec88.isChecked()) {
            cadena4 = "25-Leche Semidescremada.";
        }
        if (parec89.isChecked()) {
            cadena4 = "26-Leche Descremada.";
        }
        if (parec90.isChecked()) {
            cadena4 = "27-Leche Semideslactosada.";
        }
        if (parec91.isChecked()) {
            cadena4 = "28-Leche Entera en Polvo Fortificada.";
        }
        if (parec92.isChecked()) {
            cadena4 = "29-Maíz.";
        }
        if (parec93.isChecked()) {
            cadena4 = "30-Leche Entera UGT en Bolsa Aséptica";
        }
        if (parec94.isChecked()) {
            cadena4 = "31-Gelatina.";
        }
        if (parec95.isChecked()) {
            cadena4 = "32-Leche Semidescremada UHT en Bolsa Aséptica.";
        }
        if (parec96.isChecked()) {
            cadena4 = "33-Leche Descremada UHT en Bolsa Aséptica.";
        }
        if (parec97.isChecked()) {
            cadena4 = "34-Leche Semidescremada Sabor Chocolate.";
        }
        if (parec98.isChecked()) {
            cadena4 = "35-Leche Semidescremada Sabor Fresa.";
        }
        if (parec99.isChecked()) {
            cadena4 = "36-Miel";
        }
        if (parec100.isChecked()) {
            cadena4 = "37-Leche Semidescremada Sabor Vainilla.";
        }
        if (parec101.isChecked()) {
            cadena4 = "38-Papel Higiénico 200 H.D.";
        }
        if (parec102.isChecked()) {
            cadena4 = "39-Sal de mesa.";
        }
        if (parec103.isChecked()) {
            cadena4 = "40-Sardina en Salsa de Tomate.";
        }
        if (parec104.isChecked()) {
            cadena4 = "41-Lenteja.";
        }
        if (parec105.isChecked()) {
            cadena4 = "42-Puré de Tomate.";
        }
        if (parec106.isChecked()) {
            cadena4 = "43-Garrafón 20 Lt. Agua.";
        }
        if (parec107.isChecked()) {
            cadena4 = "44-Chícharos con Zanahoria (LA COSTEÑA).";
        }
        if (parec108.isChecked()) {
            cadena4 = "45-Chícharos con Zanahoria (CLEMENTE JACQUES).";
        }
        if (parec109.isChecked()) {
            cadena4 = "46-Huevo.";
        }
        if (parec110.isChecked()) {
            cadena4 = "47-Soya Texturizada (NUTRICASA).";
        }

        resultado4 = cadena4.substring(0, cadena4.length() - 1);
        return resultado4;

    }
}