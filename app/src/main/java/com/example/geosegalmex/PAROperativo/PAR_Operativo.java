package com.example.geosegalmex.PAROperativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.Liconsa.Liconsa;
import com.example.geosegalmex.PGBeneficiarioGranos.PGBeneficiariosGranos;
import com.example.geosegalmex.R;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;

import java.util.Calendar;

public class PAR_Operativo extends AppCompatActivity {
    EditText fec, paret3, paret4, paret5, paret6, paret7, paret8, paret08, paret008, paret9, paret10, paret11, paret12, paret13, paret14, paret15, paret16, paret17, paret18, paret19,  paret20;

    //Variables de precios de los productos Liconsa (tabla de productos)
    EditText edadd, pprolic1, pprolic2, paret1119, pprolic3, pprolic4, pprolic5, pprolic6, pprolic7, pprolic8, pprolic9, pprolic10, pprolic11, pprolic12, pprolic13, pprolic14, pprolic15, pprolic16, pprolic17, pprolic18, pprolic19, pprolic20, pprolic21, pprolic22, pprolic23, pprolic24, pprolic25, pprolic26, pprolic27, pprolic28, pprolic29, pprolic30, pprolic31, pprolic32, pprolic33, pprolic34, pprolic35, pprolic36, pprolic37, pprolic38, pprolic39, pprolic40, pprolic41, pprolic42, pprolic43, pprolic44, pprolic45, pprolic46, pprolic47, pprolic48, pprolic49, pprolic50, pprolic51, pprolic52, pprolic53, pprolic54, pprolic55, pprolic56, pprolic57, pprolic58, pprolic59, pprolic60, pprolic61, pprolic62, pprolic63, pprolic64, pprolic65, pprolic66, pprolic67, pprolic68, pprolic69, pprolic70, pprolic71, pprolic72, pprolic73, pprolic74, pprolic75, pprolic76, pprolic77, pprolic78, pprolic79, pprolic80, pprolic81, pprolic82, pprolic83, pprolic84, pprolic85, pprolic86, pprolic87, pprolic88, pprolic89, pprolic90, pprolic91, pprolic92, pprolic93, pprolic94, pprolic95, pprolic96, pprolic97, pprolic98, pprolic99, pprolic100, pprolic101, pprolic102, pprolic103, pprolic104, pares3;

    RadioButton  parer1, parer2, parer3, parer4, parer5, parer6, parer7, parer8, parer9, parer10, parer11, parer12, parer13, parer14, parer15, parer16, parer17, parer18, parer19, parer20, parer21, parer22, parer23, parer24, parer25, parer26, parer27, parer28, parer29, parer30, parer31, parer32, parer33, parer34, parer35, parer36, parer37, parer38, parer39, parer40, parer41, parer42, parer43, parer44, parer45, parer46, parer47, parer48, parer49, parer50, parer51, parer52, parer53, parer54, parer55, parer56, parer57, parer58, parer59, parer60, parer61, parer62, parer63, parer64, parer65, parer66, parer67, parer68, parer69, parra0, parra1, parra2, parra3, parra4, parra5, parra6, parra7;
    Spinner pares1, pares2, hora, min, hora2, min2;
    CheckBox parec1, parec2, parec3, parec4, parec5, parec6, parec7, parec8, parec9, parec10, parec11, parec12, parec13, parec14, parec15, parec16, parec17, parec18, parec19, parec20, parec21, parec22, parec23, parec24, parec25, parec26, parec27, parec28, parec29, parec30, parec31, parec32, parec33, parec34, parec35, parec36, parec37, parec38, parec39, parec40, parec41, parec42, parec43, parec44, parec45, parec46, parec47, parec48, parec49, parec50, parec51, parec52, parec53, parec54, parec55, parec56, parec57, parec58, parec59, parec60, parec61, parec62, parec63, parec64, parec65, parec66, parec67, parec68, parec69, parec70, parec71, parec72, parec73, parec74, parec75, parec76, parec77, parec78, parec79, parec80, parec81, parec82, parec83, parec84, parec85, parec86, parec87, parec88, parec89, parec90, parec91, parec92, parec93, parec94, parec95, parec96, parec97, parec98, parec99, parec100, parec101, parec102, parec103, parec104, parec105, parec106, parec107, parec108, parec109, parec110, parec111, parec112, parec113, parec114, parec115, parec116, parec117, parec118, parec119, parec120, parec121, parec122, parec123, parec124, parec125, parec126, parec127, parec128, parec129, parec130, parec131, parec132, parec133, parec134, parec135, parec136, parec137, parec138, parec139, parec140, pa63_1, pa63_2, pa63_3, pa63_4, pa63_5, pa63_6, pa63_7, pa63_8, pa63_9, pa63_10, pa63_11, pa63_12, pa63_13, pa63_14, pa63_15, pa63_16, pa63_17, pa63_18, pa63_19, pa63_20, pa63_21, pa63_22, pa63_23, pa63_24, pa63_25, pa63_26, pa63_27, pa63_28, pa63_29, pa63_30, pa63_31, pa63_32, pa63_33, pa63_34, pa63_35, pa63_36, pa63_37, pa63_38, pa63_39, pa63_40, pa63_41, pa63_42, pa63_43, pa63_44, pa63_45, pa63_46, pa63_47, pa63_48, pa63_49, pa63_50, pa63_51, pa63_52, pa63_53, pa63_54, pa63_55, pa63_56, pa63_57, pa110_1, pa110_2, pa110_3, pa110_4, pa110_5, pa110_6, pa110_7, pa110_8, pa110_9, pa110_10, pa110_11, pa110_12, pa110_13, pa110_14, pa110_15, pa110_16, pa110_17, pa110_18, pa110_19, pa110_20, pa110_21, pa110_22, pa110_23, pa110_24, pa110_25, pa110_26, pa110_27, pa110_28, pa110_29, pa110_30, pa110_31, pa110_32, pa110_33, pa110_34, pa110_35, pa110_36, pa110_37, pa110_38, pa110_39, pa110_40, pa110_41, pa110_42, pa110_43, pa110_44, pa110_45, pa110_46, pa110_47, pa110_48, pa110_49, pa110_50, pa110_51, pa110_52, pa110_53, pa110_54, pa110_55, pa110_56, pa110_57;
    Button btnSiguiente, btnCamara;
    TextView textFecha;
    int dia, mes, anio;

    PAR_operativo_model model;

    String cveedo2 = "";
    String nomedo2 = "";
    String cvemun2 = "";
    String nommun2 = "";
    int[] idmunicipios = {R.array.Aguascalientes2021, R.array.BajaCalifornia2021, R.array.BajaCaliforniaSur2021, R.array.Campeche2021, R.array.CoahuiladeZaragoza2021, R.array.Colima2021, R.array.Chiapas2021, R.array.Chihuahua2021, R.array.CiudaddeMéxico2021
            , R.array.Durango2021, R.array.Guanajuato2021, R.array.Guerrero2021, R.array.Hidalgo2021, R.array.Jalisco2021, R.array.México2021, R.array.MichoacándeOcampo2021, R.array.Morelos2021, R.array.Nayarit2021, R.array.NuevoLeón2021, R.array.Oaxaca2021
            , R.array.Puebla2021, R.array.Querétaro2021, R.array.QuintanaRoo2021, R.array.SanLuisPotosí2021, R.array.Sinaloa2021, R.array.Sonora2021, R.array.Tabasco2021, R.array.Tamaulipas2021, R.array.Tlaxcala2021, R.array.VeracruzdeIgnaciodelaLlave2021
            , R.array.Yucatán2021, R.array.Zacatecas2021};
    int[] idcvemunicipios = {R.array.cveAguascalientes2021, R.array.cveBajaCalifornia2021, R.array.cveBajaCaliforniaSur2021, R.array.cveCampeche2021, R.array.cveCoahuiladeZaragoza2021, R.array.cveColima2021, R.array.cveChiapas2021, R.array.cveChihuahua2021, R.array.cveCiudaddeMéxico2021
            , R.array.cveDurango2021, R.array.cveGuanajuato2021, R.array.cveGuerrero2021, R.array.cveHidalgo2021, R.array.cveJalisco2021, R.array.cveMéxico2021, R.array.cveMichoacándeOcampo2021, R.array.cveMorelos2021, R.array.cveNayarit2021, R.array.cveNuevoLeón2021, R.array.cveOaxaca2021
            , R.array.cvePuebla2021, R.array.cveQuerétaro2021, R.array.cveQuintanaRoo2021, R.array.cveSanLuisPotosí2021, R.array.cveSinaloa2021, R.array.cveSonora2021, R.array.cveTabasco2021, R.array.cveTamaulipas2021, R.array.cveTlaxcala2021, R.array.cveVeracruzdeIgnaciodelaLlave2021
            , R.array.cveYucatán2021, R.array.cveZacatecas2021
    };
    String[] municipios;
    String[] cvemunicipios;

    int bandera = 0, bandera2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_operativo);


        //folio=(EditText)findViewById(R.id.par_et_txt1);
        textFecha = (TextView)findViewById(R.id.pg_leche_txtFecha);

        //DATOS DE LA TIENDA DICONSA (PRE-LLENADO)

        pares1=(Spinner)findViewById(R.id.pgb_o_spiEstado1); //Estado
        pares2=(Spinner)findViewById(R.id.pgb_o_spiMunicipio1); //Municipio
        pares3=(EditText)findViewById(R.id.localidadpar); //Localidad/colonia

        hora=(Spinner)findViewById(R.id.sphora);
        min=(Spinner)findViewById(R.id.spmin);
        hora2=(Spinner)findViewById(R.id.sphora2);
        min2=(Spinner)findViewById(R.id.spmin2);

        //DATOS DE ENCARGADO DE TIENDA

        paret3=(EditText)findViewById(R.id.par_et_txt3);
        paret4=(EditText)findViewById(R.id.par_et_txt4);
        paret5=(EditText)findViewById(R.id.par_et_txt5);

        //Sexo
        parer1=(RadioButton)findViewById(R.id.par_et_ra1);
        parer2=(RadioButton)findViewById(R.id.par_et_ra2);

        edadd =(EditText)findViewById(R.id.par_et_txtedad);

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
        pa63_1=(CheckBox)findViewById(R.id.par_et_ch63_1);
        pa63_2=(CheckBox)findViewById(R.id.par_et_ch63_2);
        pa63_3=(CheckBox)findViewById(R.id.par_et_ch63_3);
        pa63_4=(CheckBox)findViewById(R.id.par_et_ch63_4);
        pa63_5=(CheckBox)findViewById(R.id.par_et_ch63_5);
        pa63_6=(CheckBox)findViewById(R.id.par_et_ch63_6);
        pa63_7=(CheckBox)findViewById(R.id.par_et_ch63_7);
        pa63_8=(CheckBox)findViewById(R.id.par_et_ch63_8);
        pa63_9=(CheckBox)findViewById(R.id.par_et_ch63_9);
        pa63_10=(CheckBox)findViewById(R.id.par_et_ch63_10);
        pa63_11=(CheckBox)findViewById(R.id.par_et_ch63_11);
        pa63_12=(CheckBox)findViewById(R.id.par_et_ch63_12);
        pa63_13=(CheckBox)findViewById(R.id.par_et_ch63_13);
        pa63_14=(CheckBox)findViewById(R.id.par_et_ch63_14);
        pa63_15=(CheckBox)findViewById(R.id.par_et_ch63_15);
        pa63_16=(CheckBox)findViewById(R.id.par_et_ch63_16);
        pa63_17=(CheckBox)findViewById(R.id.par_et_ch63_17);
        pa63_18=(CheckBox)findViewById(R.id.par_et_ch63_18);
        pa63_19=(CheckBox)findViewById(R.id.par_et_ch63_19);
        pa63_20=(CheckBox)findViewById(R.id.par_et_ch63_20);
        pa63_21=(CheckBox)findViewById(R.id.par_et_ch63_21);
        pa63_22=(CheckBox)findViewById(R.id.par_et_ch63_22);
        pa63_23=(CheckBox)findViewById(R.id.par_et_ch63_23);
        pa63_24=(CheckBox)findViewById(R.id.par_et_ch63_24);
        pa63_25=(CheckBox)findViewById(R.id.par_et_ch63_25);
        pa63_26=(CheckBox)findViewById(R.id.par_et_ch63_26);
        pa63_27=(CheckBox)findViewById(R.id.par_et_ch63_27);
        pa63_28=(CheckBox)findViewById(R.id.par_et_ch63_28);
        pa63_29=(CheckBox)findViewById(R.id.par_et_ch63_29);
        pa63_30=(CheckBox)findViewById(R.id.par_et_ch63_30);
        pa63_31=(CheckBox)findViewById(R.id.par_et_ch63_31);
        pa63_32=(CheckBox)findViewById(R.id.par_et_ch63_32);
        pa63_33=(CheckBox)findViewById(R.id.par_et_ch63_33);
        pa63_34=(CheckBox)findViewById(R.id.par_et_ch63_34);
        pa63_35=(CheckBox)findViewById(R.id.par_et_ch63_35);
        pa63_36=(CheckBox)findViewById(R.id.par_et_ch63_36);
        pa63_37=(CheckBox)findViewById(R.id.par_et_ch63_37);
        pa63_38=(CheckBox)findViewById(R.id.par_et_ch63_38);
        pa63_39=(CheckBox)findViewById(R.id.par_et_ch63_39);
        pa63_40=(CheckBox)findViewById(R.id.par_et_ch63_40);
        pa63_41=(CheckBox)findViewById(R.id.par_et_ch63_41);
        pa63_42=(CheckBox)findViewById(R.id.par_et_ch63_42);
        pa63_43=(CheckBox)findViewById(R.id.par_et_ch63_43);
        pa63_44=(CheckBox)findViewById(R.id.par_et_ch63_44);
        pa63_45=(CheckBox)findViewById(R.id.par_et_ch63_45);
        pa63_46=(CheckBox)findViewById(R.id.par_et_ch63_46);
        pa63_47=(CheckBox)findViewById(R.id.par_et_ch63_47);
        pa63_48=(CheckBox)findViewById(R.id.par_et_ch63_48);
        pa63_49=(CheckBox)findViewById(R.id.par_et_ch63_49);
        pa63_50=(CheckBox)findViewById(R.id.par_et_ch63_50);
        pa63_51=(CheckBox)findViewById(R.id.par_et_ch63_51);
        pa63_52=(CheckBox)findViewById(R.id.par_et_ch63_52);
        pa63_53=(CheckBox)findViewById(R.id.par_et_ch63_53);
        pa63_54=(CheckBox)findViewById(R.id.par_et_ch63_54);
        pa63_55=(CheckBox)findViewById(R.id.par_et_ch63_55);
        pa63_56=(CheckBox)findViewById(R.id.par_et_ch63_56);
        pa63_57=(CheckBox)findViewById(R.id.par_et_ch63_57);

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

        pa110_1=(CheckBox)findViewById(R.id.par_et_ch110_1);
        pa110_2=(CheckBox)findViewById(R.id.par_et_ch110_2);
        pa110_3=(CheckBox)findViewById(R.id.par_et_ch110_3);
        pa110_4=(CheckBox)findViewById(R.id.par_et_ch110_4);
        pa110_5=(CheckBox)findViewById(R.id.par_et_ch110_5);
        pa110_6=(CheckBox)findViewById(R.id.par_et_ch110_6);
        pa110_7=(CheckBox)findViewById(R.id.par_et_ch110_7);
        pa110_8=(CheckBox)findViewById(R.id.par_et_ch110_8);
        pa110_9=(CheckBox)findViewById(R.id.par_et_ch110_9);
        pa110_10=(CheckBox)findViewById(R.id.par_et_ch110_10);
        pa110_11=(CheckBox)findViewById(R.id.par_et_ch110_11);
        pa110_12=(CheckBox)findViewById(R.id.par_et_ch110_12);
        pa110_13=(CheckBox)findViewById(R.id.par_et_ch110_13);
        pa110_14=(CheckBox)findViewById(R.id.par_et_ch110_14);
        pa110_15=(CheckBox)findViewById(R.id.par_et_ch110_15);
        pa110_16=(CheckBox)findViewById(R.id.par_et_ch110_16);
        pa110_17=(CheckBox)findViewById(R.id.par_et_ch110_17);
        pa110_18=(CheckBox)findViewById(R.id.par_et_ch110_18);
        pa110_19=(CheckBox)findViewById(R.id.par_et_ch110_19);
        pa110_20=(CheckBox)findViewById(R.id.par_et_ch110_20);
        pa110_21=(CheckBox)findViewById(R.id.par_et_ch110_21);
        pa110_22=(CheckBox)findViewById(R.id.par_et_ch110_22);
        pa110_23=(CheckBox)findViewById(R.id.par_et_ch110_23);
        pa110_24=(CheckBox)findViewById(R.id.par_et_ch110_24);
        pa110_25=(CheckBox)findViewById(R.id.par_et_ch110_25);
        pa110_26=(CheckBox)findViewById(R.id.par_et_ch110_26);
        pa110_27=(CheckBox)findViewById(R.id.par_et_ch110_27);
        pa110_28=(CheckBox)findViewById(R.id.par_et_ch110_28);
        pa110_29=(CheckBox)findViewById(R.id.par_et_ch110_29);
        pa110_30=(CheckBox)findViewById(R.id.par_et_ch110_30);
        pa110_31=(CheckBox)findViewById(R.id.par_et_ch110_31);
        pa110_32=(CheckBox)findViewById(R.id.par_et_ch110_32);
        pa110_33=(CheckBox)findViewById(R.id.par_et_ch110_33);
        pa110_34=(CheckBox)findViewById(R.id.par_et_ch110_34);
        pa110_35=(CheckBox)findViewById(R.id.par_et_ch110_35);
        pa110_36=(CheckBox)findViewById(R.id.par_et_ch110_36);
        pa110_37=(CheckBox)findViewById(R.id.par_et_ch110_37);
        pa110_38=(CheckBox)findViewById(R.id.par_et_ch110_38);
        pa110_39=(CheckBox)findViewById(R.id.par_et_ch110_39);
        pa110_40=(CheckBox)findViewById(R.id.par_et_ch110_40);
        pa110_41=(CheckBox)findViewById(R.id.par_et_ch110_41);
        pa110_42=(CheckBox)findViewById(R.id.par_et_ch110_42);
        pa110_43=(CheckBox)findViewById(R.id.par_et_ch110_43);
        pa110_44=(CheckBox)findViewById(R.id.par_et_ch110_44);
        pa110_45=(CheckBox)findViewById(R.id.par_et_ch110_45);
        pa110_46=(CheckBox)findViewById(R.id.par_et_ch110_46);
        pa110_47=(CheckBox)findViewById(R.id.par_et_ch110_47);
        pa110_48=(CheckBox)findViewById(R.id.par_et_ch110_48);
        pa110_49=(CheckBox)findViewById(R.id.par_et_ch110_49);
        pa110_50=(CheckBox)findViewById(R.id.par_et_ch110_50);
        pa110_51=(CheckBox)findViewById(R.id.par_et_ch110_51);
        pa110_52=(CheckBox)findViewById(R.id.par_et_ch110_52);
        pa110_53=(CheckBox)findViewById(R.id.par_et_ch110_53);
        pa110_54=(CheckBox)findViewById(R.id.par_et_ch110_54);
        pa110_55=(CheckBox)findViewById(R.id.par_et_ch110_55);
        pa110_56=(CheckBox)findViewById(R.id.par_et_ch110_56);
        pa110_57=(CheckBox)findViewById(R.id.par_et_ch110_57);


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
        pprolic48=(EditText)findViewById(R.id.dic_pre_48);
        pprolic49=(EditText)findViewById(R.id.dic_pre_49);
        pprolic50=(EditText)findViewById(R.id.dic_pre_50);
        pprolic51=(EditText)findViewById(R.id.dic_pre_51);
        pprolic52=(EditText)findViewById(R.id.dic_pre_52);
        pprolic53=(EditText)findViewById(R.id.dic_pre_53);
        pprolic54=(EditText)findViewById(R.id.dic_pre_54);
        pprolic55=(EditText)findViewById(R.id.dic_pre_55);
        pprolic56=(EditText)findViewById(R.id.dic_pre_56);
        pprolic57=(EditText)findViewById(R.id.dic_pre_57);
        pprolic58=(EditText)findViewById(R.id.dic_pre_58);
        pprolic59=(EditText)findViewById(R.id.dic_pre_59);
        pprolic60=(EditText)findViewById(R.id.dic_pre_60);
        pprolic61=(EditText)findViewById(R.id.dic_pre_61);
        pprolic62=(EditText)findViewById(R.id.dic_pre_62);
        pprolic63=(EditText)findViewById(R.id.dic_pre_63);
        pprolic64=(EditText)findViewById(R.id.dic_pre_64);
        pprolic65=(EditText)findViewById(R.id.dic_pre_65);
        pprolic66=(EditText)findViewById(R.id.dic_pre_66);
        pprolic67=(EditText)findViewById(R.id.dic_pre_67);
        pprolic68=(EditText)findViewById(R.id.dic_pre_68);
        pprolic69=(EditText)findViewById(R.id.dic_pre_69);
        pprolic70=(EditText)findViewById(R.id.dic_pre_70);
        pprolic71=(EditText)findViewById(R.id.dic_pre_71);
        pprolic72=(EditText)findViewById(R.id.dic_pre_72);
        pprolic73=(EditText)findViewById(R.id.dic_pre_73);
        pprolic74=(EditText)findViewById(R.id.dic_pre_74);
        pprolic75=(EditText)findViewById(R.id.dic_pre_75);
        pprolic76=(EditText)findViewById(R.id.dic_pre_76);
        pprolic77=(EditText)findViewById(R.id.dic_pre_77);
        pprolic78=(EditText)findViewById(R.id.dic_pre_78);
        pprolic79=(EditText)findViewById(R.id.dic_pre_79);
        pprolic80=(EditText)findViewById(R.id.dic_pre_80);
        pprolic81=(EditText)findViewById(R.id.dic_pre_81);
        pprolic82=(EditText)findViewById(R.id.dic_pre_82);
        pprolic83=(EditText)findViewById(R.id.dic_pre_83);
        pprolic84=(EditText)findViewById(R.id.dic_pre_84);
        pprolic85=(EditText)findViewById(R.id.dic_pre_85);
        pprolic86=(EditText)findViewById(R.id.dic_pre_86);
        pprolic87=(EditText)findViewById(R.id.dic_pre_87);
        pprolic88=(EditText)findViewById(R.id.dic_pre_88);
        pprolic89=(EditText)findViewById(R.id.dic_pre_89);
        pprolic90=(EditText)findViewById(R.id.dic_pre_90);
        pprolic91=(EditText)findViewById(R.id.dic_pre_91);
        pprolic92=(EditText)findViewById(R.id.dic_pre_92);
        pprolic93=(EditText)findViewById(R.id.dic_pre_93);
        pprolic94=(EditText)findViewById(R.id.dic_pre_94);
        pprolic95=(EditText)findViewById(R.id.dic_pre_95);
        pprolic96=(EditText)findViewById(R.id.dic_pre_96);
        pprolic97=(EditText)findViewById(R.id.dic_pre_97);
        pprolic98=(EditText)findViewById(R.id.dic_pre_98);
        pprolic99=(EditText)findViewById(R.id.dic_pre_99);
        pprolic100=(EditText)findViewById(R.id.dic_pre_100);
        pprolic101=(EditText)findViewById(R.id.dic_pre_101);
        pprolic102=(EditText)findViewById(R.id.dic_pre_102);
        pprolic103=(EditText)findViewById(R.id.dic_pre_103);
        pprolic104=(EditText)findViewById(R.id.dic_pre_104);

        parra0 =(RadioButton)findViewById(R.id.parrad0);
        parra1 =(RadioButton)findViewById(R.id.parrad1);
        parra2 =(RadioButton)findViewById(R.id.parrad2);
        parra3 =(RadioButton)findViewById(R.id.parrad3);
        parra4 =(RadioButton)findViewById(R.id.parrad4);
        parra5 =(RadioButton)findViewById(R.id.parrad5);
        parra6 =(RadioButton)findViewById(R.id.parrad6);
        parra7 =(RadioButton)findViewById(R.id.parrad7);

        //BOTON SIGUIENTE

        btnSiguiente = findViewById(R.id.par_et_sig);
        muestrafecha();
        eventos33();
        eventos34();
        //eventos35();
        //eventos36();
        eventos44();
        eventos38();
        //eventos39();
        eventos40();
        eventos41();
        eventos42();
        eventos43();
        Eventos_Hora();


        pares1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo2 = cveestados[position];
                nomedo2 = estados[position];

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PAR_Operativo.this, android.R.layout.simple_spinner_item, municipios);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pares2.setAdapter(adapter);
                pares2.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pares2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun2 = municipios[position];
                cvemun2 = cvemunicipios[position];
                //Toast.makeText(getApplicationContext(), "cveEdo: " + cveedo + "\n Edo: " + nomedo + "\n cveMun: " + nommun + "\n Mun: " + cvemun,Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });



        btnSiguiente.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                capacitaciones();

                if(validar()) {
                   /*
                    if(validarcapa1()) {
                        if (validarcapa2()) {
                            if (validarcapa3()) {
                                if (validarcapa4()) {
                                */

                                    String folio = General.Foliocuestion;
                                    General.fechaenc = textFecha.getText().toString();
                                    String noment = nomedo2;
                                    String cveedo = cveedo2;
                                    String nommun = nommun2;
                                    String cvemun = cvemun2;
                                    String locali = pares3.getText().toString();
                                    String cveloca = "";
                                    //nombre
                                    String parnom = paret3.getText().toString();
                                    String parape = paret4.getText().toString();
                                    String parapem = paret5.getText().toString();
                                    String parrad1 = obtenerRadio(parer1, parer2);
                                    String edad = edadd.getText().toString();
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
                                    String pareo15 = paret9.getText().toString();
                                    String pare16 = obtenerRadio3(parer23, parer24, parer25);
                                    String pare17 = obtenerRadio4(parer26, parer27, parer28, parer29);
                                    String pareo17 = paret10.getText().toString();
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
                                    String pare96 = pprolic48.getText().toString();
                                    String pare97 = pprolic49.getText().toString();
                                    String pare98 = pprolic50.getText().toString();
                                    String pare99 = pprolic51.getText().toString();
                                    String pare100 = pprolic52.getText().toString();
                                    String pare101 = pprolic53.getText().toString();
                                    String pare102 = pprolic54.getText().toString();
                                    String pare103 = pprolic55.getText().toString();
                                    String pare104 = pprolic56.getText().toString();
                                    String pare105 = pprolic57.getText().toString();
                                    String pare106 = pprolic58.getText().toString();
                                    String pare107 = pprolic59.getText().toString();
                                    String pare108 = pprolic60.getText().toString();
                                    String pare109 = pprolic61.getText().toString();
                                    String pare110 = pprolic62.getText().toString();
                                    String pare111 = pprolic63.getText().toString();
                                    String pare112 = pprolic64.getText().toString();
                                    String pare113 = pprolic65.getText().toString();
                                    String pare114 = pprolic66.getText().toString();
                                    String pare115 = pprolic67.getText().toString();
                                    String pare116 = pprolic68.getText().toString();
                                    String pare117 = pprolic69.getText().toString();
                                    String pare118 = pprolic70.getText().toString();
                                    String pare119 = pprolic71.getText().toString();
                                    String pare120 = pprolic72.getText().toString();
                                    String pare121 = pprolic73.getText().toString();
                                    String pare122 = pprolic74.getText().toString();
                                    String pare123 = pprolic75.getText().toString();
                                    String pare124 = pprolic76.getText().toString();
                                    String pare125 = pprolic77.getText().toString();
                                    String pare126 = pprolic78.getText().toString();
                                    String pare127 = pprolic79.getText().toString();
                                    String pare128 = pprolic80.getText().toString();
                                    String pare129 = pprolic81.getText().toString();
                                    String pare130 = pprolic82.getText().toString();
                                    String pare131 = pprolic83.getText().toString();
                                    String pare132 = pprolic84.getText().toString();
                                    String pare133 = pprolic85.getText().toString();
                                    String pare134 = pprolic86.getText().toString();
                                    String pare135 = pprolic87.getText().toString();
                                    String pare136 = pprolic88.getText().toString();
                                    String pare137 = pprolic89.getText().toString();
                                    String pare138 = pprolic90.getText().toString();
                                    String pare139 = pprolic91.getText().toString();
                                    String pare140 = pprolic92.getText().toString();
                                    String pare141 = pprolic93.getText().toString();
                                    String pare142 = pprolic94.getText().toString();
                                    String pare143 = pprolic95.getText().toString();
                                    String pare144 = pprolic96.getText().toString();
                                    String pare145 = pprolic97.getText().toString();
                                    String pare146 = pprolic98.getText().toString();
                                    String pare147 = pprolic99.getText().toString();
                                    String pare148 = pprolic100.getText().toString();
                                    String pare149 = pprolic101.getText().toString();
                                    String pare150 = pprolic102.getText().toString();
                                    String pare151 = pprolic103.getText().toString();
                                    String pare152 = pprolic104.getText().toString();
                                    String f1 = General.Foto1;
                                    String f2 = General.Foto2;

                                    model = new PAR_operativo_model(folio, General.fechaenc, noment, cveedo, nommun, cvemun, locali, cveloca, parnom, parape, parapem, parrad1, edad, pare6, pare7, parrad2, parrad3, parrad4, parrad5, parrad6, parrad7, pare8, pare9, pare10, pare11, pare12, pare13, pare14, pare15, pareo15, pare16, pare17, pareo17, pare18, pare19, pare20, pare21, pare22, pare23, pare24, pare25, pare26, pare27, pare28, pare29, pare30, pare31, pare32, pare33, pare34, pare35, pare36, pare37, pare38, pare39, pare40, pare41, pare42, pare43, pare44, pare45, pare46, pare47, pare48, pare49, pare50, pare51, pare52, pare53, pare54, pare55, pare56, pare57, pare58, pare59, pare60, pare61, pare62, pare63, pare64, pare65, pare66, pare67, pare68, pare69, pare70, pare71, pare72, pare73, pare74, pare75, pare76, pare77, pare78, pare79, pare80, pare81, pare82, pare84, pare85, pare86, pare87, pare88, pare89, pare90, pare91, pare92, pare93, pare94, pare95, pare96, pare97, pare98, pare99, pare100, pare101, pare102, pare103, pare104, pare105, pare106, pare107, pare108, pare109, pare110, pare111, pare112, pare113, pare114, pare115, pare116, pare117, pare118, pare119, pare120, pare121, pare122, pare123, pare124, pare125, pare126, pare127, pare128, pare129, pare130, pare131, pare132, pare133, pare134, pare135, pare136, pare137, pare138, pare139, pare140, pare141, pare142, pare143, pare144, pare145, pare146, pare147, pare148, pare149, pare150, pare151, pare152, f1, f2, "", "");
                                    Intent in = new Intent(PAR_Operativo.this, GeoreferenciaActivity.class);
                                    in.putExtra("model", model);
                                    startActivity(in);
                              /*
                                } else {
                                    Toast.makeText(getApplicationContext(), "Maximo puede seleccionar cinco opciones", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Maximo puede seleccionar tres opciones",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Maximo puede seleccionar cinco opciones",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Maximo puede seleccionar cinco opciones",Toast.LENGTH_SHORT).show();
                    }
*/

                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }
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



    public void itemClicked(View v){
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) {
            bandera = bandera + 1;
        } else {
            bandera = bandera - 1;
        }

        if (bandera >= 5) {
            if(parec17.isChecked()){parec17.setEnabled(true);}else{parec17.setEnabled(false);}
            if(parec18.isChecked()){parec18.setEnabled(true);}else{parec18.setEnabled(false);}
            if(parec19.isChecked()){parec19.setEnabled(true);}else{parec19.setEnabled(false);}
            if(parec20.isChecked()){parec20.setEnabled(true);}else{parec20.setEnabled(false);}
            if(parec21.isChecked()){parec21.setEnabled(true);}else{parec21.setEnabled(false);}
            if(parec22.isChecked()){parec22.setEnabled(true);}else{parec22.setEnabled(false);}
            if(parec23.isChecked()){parec23.setEnabled(true);}else{parec23.setEnabled(false);}
            if(parec24.isChecked()){parec24.setEnabled(true);}else{parec24.setEnabled(false);}
            if(parec25.isChecked()){parec25.setEnabled(true);}else{parec25.setEnabled(false);}
            if(parec26.isChecked()){parec26.setEnabled(true);}else{parec26.setEnabled(false);}
            if(parec27.isChecked()){parec27.setEnabled(true);}else{parec27.setEnabled(false);}
            if(parec28.isChecked()){parec28.setEnabled(true);}else{parec28.setEnabled(false);}
            if(parec29.isChecked()){parec29.setEnabled(true);}else{parec29.setEnabled(false);}
            if(parec30.isChecked()){parec30.setEnabled(true);}else{parec30.setEnabled(false);}
            if(parec31.isChecked()){parec31.setEnabled(true);}else{parec31.setEnabled(false);}
            if(parec32.isChecked()){parec32.setEnabled(true);}else{parec32.setEnabled(false);}
            if(parec33.isChecked()){parec33.setEnabled(true);}else{parec33.setEnabled(false);}
            if(parec34.isChecked()){parec34.setEnabled(true);}else{parec34.setEnabled(false);}
            if(parec35.isChecked()){parec35.setEnabled(true);}else{parec35.setEnabled(false);}
            if(parec36.isChecked()){parec36.setEnabled(true);}else{parec36.setEnabled(false);}
            if(parec37.isChecked()){parec37.setEnabled(true);}else{parec37.setEnabled(false);}
            if(parec38.isChecked()){parec38.setEnabled(true);}else{parec38.setEnabled(false);}
            if(parec39.isChecked()){parec39.setEnabled(true);}else{parec39.setEnabled(false);}
            if(parec40.isChecked()){parec40.setEnabled(true);}else{parec40.setEnabled(false);}
            if(parec41.isChecked()){parec41.setEnabled(true);}else{parec41.setEnabled(false);}
            if(parec42.isChecked()){parec42.setEnabled(true);}else{parec42.setEnabled(false);}
            if(parec43.isChecked()){parec43.setEnabled(true);}else{parec43.setEnabled(false);}
            if(parec44.isChecked()){parec44.setEnabled(true);}else{parec44.setEnabled(false);}
            if(parec45.isChecked()){parec45.setEnabled(true);}else{parec45.setEnabled(false);}
            if(parec46.isChecked()){parec46.setEnabled(true);}else{parec46.setEnabled(false);}
            if(parec47.isChecked()){parec47.setEnabled(true);}else{parec47.setEnabled(false);}
            if(parec48.isChecked()){parec48.setEnabled(true);}else{parec48.setEnabled(false);}
            if(parec49.isChecked()){parec49.setEnabled(true);}else{parec49.setEnabled(false);}
            if(parec50.isChecked()){parec50.setEnabled(true);}else{parec50.setEnabled(false);}
            if(parec51.isChecked()){parec51.setEnabled(true);}else{parec51.setEnabled(false);}
            if(parec52.isChecked()){parec52.setEnabled(true);}else{parec52.setEnabled(false);}
            if(parec53.isChecked()){parec53.setEnabled(true);}else{parec53.setEnabled(false);}
            if(parec54.isChecked()){parec54.setEnabled(true);}else{parec54.setEnabled(false);}
            if(parec55.isChecked()){parec55.setEnabled(true);}else{parec55.setEnabled(false);}
            if(parec56.isChecked()){parec56.setEnabled(true);}else{parec56.setEnabled(false);}
            if(parec57.isChecked()){parec57.setEnabled(true);}else{parec57.setEnabled(false);}
            if(parec58.isChecked()){parec58.setEnabled(true);}else{parec58.setEnabled(false);}
            if(parec59.isChecked()){parec59.setEnabled(true);}else{parec59.setEnabled(false);}
            if(parec60.isChecked()){parec60.setEnabled(true);}else{parec60.setEnabled(false);}
            if(parec61.isChecked()){parec61.setEnabled(true);}else{parec61.setEnabled(false);}
            if(parec62.isChecked()){parec62.setEnabled(true);}else{parec62.setEnabled(false);}
            if(parec63.isChecked()){parec63.setEnabled(true);}else{parec63.setEnabled(false);}
            if(pa63_1.isChecked()){pa63_1.setEnabled(true);}else{pa63_1.setEnabled(false);}
            if(pa63_2.isChecked()){pa63_2.setEnabled(true);}else{pa63_2.setEnabled(false);}
            if(pa63_3.isChecked()){pa63_3.setEnabled(true);}else{pa63_3.setEnabled(false);}
            if(pa63_4.isChecked()){pa63_4.setEnabled(true);}else{pa63_4.setEnabled(false);}
            if(pa63_5.isChecked()){pa63_5.setEnabled(true);}else{pa63_5.setEnabled(false);}
            if(pa63_6.isChecked()){pa63_6.setEnabled(true);}else{pa63_6.setEnabled(false);}
            if(pa63_7.isChecked()){pa63_7.setEnabled(true);}else{pa63_7.setEnabled(false);}
            if(pa63_8.isChecked()){pa63_8.setEnabled(true);}else{pa63_8.setEnabled(false);}
            if(pa63_9.isChecked()){pa63_9.setEnabled(true);}else{pa63_9.setEnabled(false);}
            if(pa63_10.isChecked()){pa63_10.setEnabled(true);}else{pa63_10.setEnabled(false);}
            if(pa63_11.isChecked()){pa63_11.setEnabled(true);}else{pa63_11.setEnabled(false);}
            if(pa63_12.isChecked()){pa63_12.setEnabled(true);}else{pa63_12.setEnabled(false);}
            if(pa63_13.isChecked()){pa63_13.setEnabled(true);}else{pa63_13.setEnabled(false);}
            if(pa63_14.isChecked()){pa63_14.setEnabled(true);}else{pa63_14.setEnabled(false);}
            if(pa63_15.isChecked()){pa63_15.setEnabled(true);}else{pa63_15.setEnabled(false);}
            if(pa63_16.isChecked()){pa63_16.setEnabled(true);}else{pa63_16.setEnabled(false);}
            if(pa63_17.isChecked()){pa63_17.setEnabled(true);}else{pa63_17.setEnabled(false);}
            if(pa63_18.isChecked()){pa63_18.setEnabled(true);}else{pa63_18.setEnabled(false);}
            if(pa63_19.isChecked()){pa63_19.setEnabled(true);}else{pa63_19.setEnabled(false);}
            if(pa63_20.isChecked()){pa63_20.setEnabled(true);}else{pa63_20.setEnabled(false);}
            if(pa63_21.isChecked()){pa63_21.setEnabled(true);}else{pa63_21.setEnabled(false);}
            if(pa63_22.isChecked()){pa63_22.setEnabled(true);}else{pa63_22.setEnabled(false);}
            if(pa63_23.isChecked()){pa63_23.setEnabled(true);}else{pa63_23.setEnabled(false);}
            if(pa63_24.isChecked()){pa63_24.setEnabled(true);}else{pa63_24.setEnabled(false);}
            if(pa63_25.isChecked()){pa63_25.setEnabled(true);}else{pa63_25.setEnabled(false);}
            if(pa63_26.isChecked()){pa63_26.setEnabled(true);}else{pa63_26.setEnabled(false);}
            if(pa63_27.isChecked()){pa63_27.setEnabled(true);}else{pa63_27.setEnabled(false);}
            if(pa63_28.isChecked()){pa63_28.setEnabled(true);}else{pa63_28.setEnabled(false);}
            if(pa63_29.isChecked()){pa63_29.setEnabled(true);}else{pa63_29.setEnabled(false);}
            if(pa63_30.isChecked()){pa63_30.setEnabled(true);}else{pa63_30.setEnabled(false);}
            if(pa63_31.isChecked()){pa63_31.setEnabled(true);}else{pa63_31.setEnabled(false);}
            if(pa63_32.isChecked()){pa63_32.setEnabled(true);}else{pa63_32.setEnabled(false);}
            if(pa63_33.isChecked()){pa63_33.setEnabled(true);}else{pa63_33.setEnabled(false);}
            if(pa63_34.isChecked()){pa63_34.setEnabled(true);}else{pa63_34.setEnabled(false);}
            if(pa63_35.isChecked()){pa63_35.setEnabled(true);}else{pa63_35.setEnabled(false);}
            if(pa63_36.isChecked()){pa63_36.setEnabled(true);}else{pa63_36.setEnabled(false);}
            if(pa63_37.isChecked()){pa63_37.setEnabled(true);}else{pa63_37.setEnabled(false);}
            if(pa63_38.isChecked()){pa63_38.setEnabled(true);}else{pa63_38.setEnabled(false);}
            if(pa63_39.isChecked()){pa63_39.setEnabled(true);}else{pa63_39.setEnabled(false);}
            if(pa63_40.isChecked()){pa63_40.setEnabled(true);}else{pa63_40.setEnabled(false);}
            if(pa63_41.isChecked()){pa63_41.setEnabled(true);}else{pa63_41.setEnabled(false);}
            if(pa63_42.isChecked()){pa63_42.setEnabled(true);}else{pa63_42.setEnabled(false);}
            if(pa63_43.isChecked()){pa63_43.setEnabled(true);}else{pa63_43.setEnabled(false);}
            if(pa63_44.isChecked()){pa63_44.setEnabled(true);}else{pa63_44.setEnabled(false);}
            if(pa63_45.isChecked()){pa63_45.setEnabled(true);}else{pa63_45.setEnabled(false);}
            if(pa63_46.isChecked()){pa63_46.setEnabled(true);}else{pa63_46.setEnabled(false);}
            if(pa63_47.isChecked()){pa63_47.setEnabled(true);}else{pa63_47.setEnabled(false);}
            if(pa63_48.isChecked()){pa63_48.setEnabled(true);}else{pa63_48.setEnabled(false);}
            if(pa63_49.isChecked()){pa63_49.setEnabled(true);}else{pa63_49.setEnabled(false);}
            if(pa63_50.isChecked()){pa63_50.setEnabled(true);}else{pa63_50.setEnabled(false);}
            if(pa63_51.isChecked()){pa63_51.setEnabled(true);}else{pa63_51.setEnabled(false);}
            if(pa63_52.isChecked()){pa63_52.setEnabled(true);}else{pa63_52.setEnabled(false);}
            if(pa63_53.isChecked()){pa63_53.setEnabled(true);}else{pa63_53.setEnabled(false);}
            if(pa63_54.isChecked()){pa63_54.setEnabled(true);}else{pa63_54.setEnabled(false);}
            if(pa63_55.isChecked()){pa63_55.setEnabled(true);}else{pa63_55.setEnabled(false);}
            if(pa63_56.isChecked()){pa63_56.setEnabled(true);}else{pa63_56.setEnabled(false);}
            if(pa63_57.isChecked()){pa63_57.setEnabled(true);}else{pa63_57.setEnabled(false);}
        }
        else{
            parec17.setEnabled(true);
            parec18.setEnabled(true);
            parec19.setEnabled(true);
            parec20.setEnabled(true);
            parec21.setEnabled(true);
            parec22.setEnabled(true);
            parec23.setEnabled(true);
            parec24.setEnabled(true);
            parec25.setEnabled(true);
            parec26.setEnabled(true);
            parec27.setEnabled(true);
            parec28.setEnabled(true);
            parec29.setEnabled(true);
            parec30.setEnabled(true);
            parec31.setEnabled(true);
            parec32.setEnabled(true);
            parec33.setEnabled(true);
            parec34.setEnabled(true);
            parec35.setEnabled(true);
            parec36.setEnabled(true);
            parec37.setEnabled(true);
            parec38.setEnabled(true);
            parec39.setEnabled(true);
            parec40.setEnabled(true);
            parec41.setEnabled(true);
            parec42.setEnabled(true);
            parec43.setEnabled(true);
            parec44.setEnabled(true);
            parec45.setEnabled(true);
            parec46.setEnabled(true);
            parec47.setEnabled(true);
            parec48.setEnabled(true);
            parec49.setEnabled(true);
            parec50.setEnabled(true);
            parec51.setEnabled(true);
            parec52.setEnabled(true);
            parec53.setEnabled(true);
            parec54.setEnabled(true);
            parec55.setEnabled(true);
            parec56.setEnabled(true);
            parec57.setEnabled(true);
            parec58.setEnabled(true);
            parec59.setEnabled(true);
            parec60.setEnabled(true);
            parec61.setEnabled(true);
            parec62.setEnabled(true);
            parec63.setEnabled(true);
             pa63_1.setEnabled(true);
             pa63_2.setEnabled(true);
             pa63_3.setEnabled(true);
             pa63_4.setEnabled(true);
             pa63_5.setEnabled(true);
             pa63_6.setEnabled(true);
             pa63_7.setEnabled(true);
             pa63_8.setEnabled(true);
             pa63_9.setEnabled(true);
        pa63_10.setEnabled(true);
        pa63_11.setEnabled(true);
        pa63_12.setEnabled(true);
        pa63_13.setEnabled(true);
        pa63_14.setEnabled(true);
        pa63_15.setEnabled(true);
        pa63_16.setEnabled(true);
        pa63_17.setEnabled(true);
        pa63_18.setEnabled(true);
        pa63_19.setEnabled(true);
        pa63_20.setEnabled(true);
        pa63_21.setEnabled(true);
        pa63_22.setEnabled(true);
        pa63_23.setEnabled(true);
        pa63_24.setEnabled(true);
        pa63_25.setEnabled(true);
        pa63_26.setEnabled(true);
        pa63_27.setEnabled(true);
        pa63_28.setEnabled(true);
        pa63_29.setEnabled(true);
        pa63_30.setEnabled(true);
        pa63_31.setEnabled(true);
        pa63_32.setEnabled(true);
        pa63_33.setEnabled(true);
        pa63_34.setEnabled(true);
        pa63_35.setEnabled(true);
        pa63_36.setEnabled(true);
        pa63_37.setEnabled(true);
        pa63_38.setEnabled(true);
        pa63_39.setEnabled(true);
        pa63_40.setEnabled(true);
        pa63_41.setEnabled(true);
        pa63_42.setEnabled(true);
        pa63_43.setEnabled(true);
        pa63_44.setEnabled(true);
        pa63_45.setEnabled(true);
        pa63_46.setEnabled(true);
        pa63_47.setEnabled(true);
        pa63_48.setEnabled(true);
        pa63_49.setEnabled(true);
        pa63_50.setEnabled(true);
        pa63_51.setEnabled(true);
        pa63_52.setEnabled(true);
        pa63_53.setEnabled(true);
        pa63_54.setEnabled(true);
        pa63_55.setEnabled(true);
        pa63_56.setEnabled(true);
        pa63_57.setEnabled(true);
        }
    }



    public void itemClicked2(View v){
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) {
            bandera2 = bandera2 + 1;
        } else {
            bandera2 = bandera2 - 1;
        }

        if (bandera2 >= 5) {
            if(parec64.isChecked()){parec64.setEnabled(true);}else{parec64.setEnabled(false);}
            if(parec65.isChecked()){parec65.setEnabled(true);}else{parec65.setEnabled(false);}
            if(parec66.isChecked()){parec66.setEnabled(true);}else{parec66.setEnabled(false);}
            if(parec67.isChecked()){parec67.setEnabled(true);}else{parec67.setEnabled(false);}
            if(parec68.isChecked()){parec68.setEnabled(true);}else{parec68.setEnabled(false);}
            if(parec69.isChecked()){parec69.setEnabled(true);}else{parec69.setEnabled(false);}
            if(parec70.isChecked()){parec70.setEnabled(true);}else{parec70.setEnabled(false);}
            if(parec71.isChecked()){parec71.setEnabled(true);}else{parec71.setEnabled(false);}
            if(parec72.isChecked()){parec72.setEnabled(true);}else{parec72.setEnabled(false);}
            if(parec73.isChecked()){parec73.setEnabled(true);}else{parec73.setEnabled(false);}
            if(parec74.isChecked()){parec74.setEnabled(true);}else{parec74.setEnabled(false);}
            if(parec75.isChecked()){parec75.setEnabled(true);}else{parec75.setEnabled(false);}
            if(parec76.isChecked()){parec76.setEnabled(true);}else{parec76.setEnabled(false);}
            if(parec77.isChecked()){parec77.setEnabled(true);}else{parec77.setEnabled(false);}
            if(parec78.isChecked()){parec78.setEnabled(true);}else{parec78.setEnabled(false);}
            if(parec79.isChecked()){parec79.setEnabled(true);}else{parec79.setEnabled(false);}
            if(parec80.isChecked()){parec80.setEnabled(true);}else{parec80.setEnabled(false);}
            if(parec81.isChecked()){parec81.setEnabled(true);}else{parec81.setEnabled(false);}
            if(parec82.isChecked()){parec82.setEnabled(true);}else{parec82.setEnabled(false);}
            if(parec83.isChecked()){parec83.setEnabled(true);}else{parec83.setEnabled(false);}
            if(parec84.isChecked()){parec84.setEnabled(true);}else{parec84.setEnabled(false);}
            if(parec85.isChecked()){parec85.setEnabled(true);}else{parec85.setEnabled(false);}
            if(parec86.isChecked()){parec86.setEnabled(true);}else{parec86.setEnabled(false);}
            if(parec87.isChecked()){parec87.setEnabled(true);}else{parec87.setEnabled(false);}
            if(parec88.isChecked()){parec88.setEnabled(true);}else{parec88.setEnabled(false);}
            if(parec89.isChecked()){parec89.setEnabled(true);}else{parec89.setEnabled(false);}
            if(parec90.isChecked()){parec90.setEnabled(true);}else{parec90.setEnabled(false);}
            if(parec91.isChecked()){parec91.setEnabled(true);}else{parec91.setEnabled(false);}
            if(parec92.isChecked()){parec92.setEnabled(true);}else{parec92.setEnabled(false);}
            if(parec93.isChecked()){parec93.setEnabled(true);}else{parec93.setEnabled(false);}
            if(parec94.isChecked()){parec94.setEnabled(true);}else{parec94.setEnabled(false);}
            if(parec95.isChecked()){parec95.setEnabled(true);}else{parec95.setEnabled(false);}
            if(parec96.isChecked()){parec96.setEnabled(true);}else{parec96.setEnabled(false);}
            if(parec97.isChecked()){parec97.setEnabled(true);}else{parec97.setEnabled(false);}
            if(parec98.isChecked()){parec98.setEnabled(true);}else{parec98.setEnabled(false);}
            if(parec99.isChecked()){parec99.setEnabled(true);}else{parec99.setEnabled(false);}
            if(parec100.isChecked()){parec100.setEnabled(true);}else{parec100.setEnabled(false);}
            if(parec101.isChecked()){parec101.setEnabled(true);}else{parec101.setEnabled(false);}
            if(parec102.isChecked()){parec102.setEnabled(true);}else{parec102.setEnabled(false);}
            if(parec103.isChecked()){parec103.setEnabled(true);}else{parec103.setEnabled(false);}
            if(parec104.isChecked()){parec104.setEnabled(true);}else{parec104.setEnabled(false);}
            if(parec105.isChecked()){parec105.setEnabled(true);}else{parec105.setEnabled(false);}
            if(parec106.isChecked()){parec106.setEnabled(true);}else{parec106.setEnabled(false);}
            if(parec107.isChecked()){parec107.setEnabled(true);}else{parec107.setEnabled(false);}
            if(parec108.isChecked()){parec108.setEnabled(true);}else{parec108.setEnabled(false);}
            if(parec109.isChecked()){parec109.setEnabled(true);}else{parec109.setEnabled(false);}
            if(parec110.isChecked()){parec110.setEnabled(true);}else{parec110.setEnabled(false);}
            if(pa110_1.isChecked()){pa110_1.setEnabled(true);}else{pa110_1.setEnabled(false);}
            if(pa110_2.isChecked()){pa110_2.setEnabled(true);}else{pa110_2.setEnabled(false);}
            if(pa110_3.isChecked()){pa110_3.setEnabled(true);}else{pa110_3.setEnabled(false);}
            if(pa110_4.isChecked()){pa110_4.setEnabled(true);}else{pa110_4.setEnabled(false);}
            if(pa110_5.isChecked()){pa110_5.setEnabled(true);}else{pa110_5.setEnabled(false);}
            if(pa110_6.isChecked()){pa110_6.setEnabled(true);}else{pa110_6.setEnabled(false);}
            if(pa110_7.isChecked()){pa110_7.setEnabled(true);}else{pa110_7.setEnabled(false);}
            if(pa110_8.isChecked()){pa110_8.setEnabled(true);}else{pa110_8.setEnabled(false);}
            if(pa110_9.isChecked()){pa110_9.setEnabled(true);}else{pa110_9.setEnabled(false);}
            if(pa110_10.isChecked()){pa110_10.setEnabled(true);}else{pa110_10.setEnabled(false);}
            if(pa110_11.isChecked()){pa110_11.setEnabled(true);}else{pa110_11.setEnabled(false);}
            if(pa110_12.isChecked()){pa110_12.setEnabled(true);}else{pa110_12.setEnabled(false);}
            if(pa110_13.isChecked()){pa110_13.setEnabled(true);}else{pa110_13.setEnabled(false);}
            if(pa110_14.isChecked()){pa110_14.setEnabled(true);}else{pa110_14.setEnabled(false);}
            if(pa110_15.isChecked()){pa110_15.setEnabled(true);}else{pa110_15.setEnabled(false);}
            if(pa110_16.isChecked()){pa110_16.setEnabled(true);}else{pa110_16.setEnabled(false);}
            if(pa110_17.isChecked()){pa110_17.setEnabled(true);}else{pa110_17.setEnabled(false);}
            if(pa110_18.isChecked()){pa110_18.setEnabled(true);}else{pa110_18.setEnabled(false);}
            if(pa110_19.isChecked()){pa110_19.setEnabled(true);}else{pa110_19.setEnabled(false);}
            if(pa110_20.isChecked()){pa110_20.setEnabled(true);}else{pa110_20.setEnabled(false);}
            if(pa110_21.isChecked()){pa110_21.setEnabled(true);}else{pa110_21.setEnabled(false);}
            if(pa110_22.isChecked()){pa110_22.setEnabled(true);}else{pa110_22.setEnabled(false);}
            if(pa110_23.isChecked()){pa110_23.setEnabled(true);}else{pa110_23.setEnabled(false);}
            if(pa110_24.isChecked()){pa110_24.setEnabled(true);}else{pa110_24.setEnabled(false);}
            if(pa110_25.isChecked()){pa110_25.setEnabled(true);}else{pa110_25.setEnabled(false);}
            if(pa110_26.isChecked()){pa110_26.setEnabled(true);}else{pa110_26.setEnabled(false);}
            if(pa110_27.isChecked()){pa110_27.setEnabled(true);}else{pa110_27.setEnabled(false);}
            if(pa110_28.isChecked()){pa110_28.setEnabled(true);}else{pa110_28.setEnabled(false);}
            if(pa110_29.isChecked()){pa110_29.setEnabled(true);}else{pa110_29.setEnabled(false);}
            if(pa110_30.isChecked()){pa110_30.setEnabled(true);}else{pa110_30.setEnabled(false);}
            if(pa110_31.isChecked()){pa110_31.setEnabled(true);}else{pa110_31.setEnabled(false);}
            if(pa110_32.isChecked()){pa110_32.setEnabled(true);}else{pa110_32.setEnabled(false);}
            if(pa110_33.isChecked()){pa110_33.setEnabled(true);}else{pa110_33.setEnabled(false);}
            if(pa110_34.isChecked()){pa110_34.setEnabled(true);}else{pa110_34.setEnabled(false);}
            if(pa110_35.isChecked()){pa110_35.setEnabled(true);}else{pa110_35.setEnabled(false);}
            if(pa110_36.isChecked()){pa110_36.setEnabled(true);}else{pa110_36.setEnabled(false);}
            if(pa110_37.isChecked()){pa110_37.setEnabled(true);}else{pa110_37.setEnabled(false);}
            if(pa110_38.isChecked()){pa110_38.setEnabled(true);}else{pa110_38.setEnabled(false);}
            if(pa110_39.isChecked()){pa110_39.setEnabled(true);}else{pa110_39.setEnabled(false);}
            if(pa110_40.isChecked()){pa110_40.setEnabled(true);}else{pa110_40.setEnabled(false);}
            if(pa110_41.isChecked()){pa110_41.setEnabled(true);}else{pa110_41.setEnabled(false);}
            if(pa110_42.isChecked()){pa110_42.setEnabled(true);}else{pa110_42.setEnabled(false);}
            if(pa110_43.isChecked()){pa110_43.setEnabled(true);}else{pa110_43.setEnabled(false);}
            if(pa110_44.isChecked()){pa110_44.setEnabled(true);}else{pa110_44.setEnabled(false);}
            if(pa110_45.isChecked()){pa110_45.setEnabled(true);}else{pa110_45.setEnabled(false);}
            if(pa110_46.isChecked()){pa110_46.setEnabled(true);}else{pa110_46.setEnabled(false);}
            if(pa110_47.isChecked()){pa110_47.setEnabled(true);}else{pa110_47.setEnabled(false);}
            if(pa110_48.isChecked()){pa110_48.setEnabled(true);}else{pa110_48.setEnabled(false);}
            if(pa110_49.isChecked()){pa110_49.setEnabled(true);}else{pa110_49.setEnabled(false);}
            if(pa110_50.isChecked()){pa110_50.setEnabled(true);}else{pa110_50.setEnabled(false);}
            if(pa110_51.isChecked()){pa110_51.setEnabled(true);}else{pa110_51.setEnabled(false);}
            if(pa110_52.isChecked()){pa110_52.setEnabled(true);}else{pa110_52.setEnabled(false);}
            if(pa110_53.isChecked()){pa110_53.setEnabled(true);}else{pa110_53.setEnabled(false);}
            if(pa110_54.isChecked()){pa110_54.setEnabled(true);}else{pa110_54.setEnabled(false);}
            if(pa110_55.isChecked()){pa110_55.setEnabled(true);}else{pa110_55.setEnabled(false);}
            if(pa110_56.isChecked()){pa110_56.setEnabled(true);}else{pa110_56.setEnabled(false);}
            if(pa110_57.isChecked()){pa110_57.setEnabled(true);}else{pa110_57.setEnabled(false);}


        }
        else{
        parec64.setEnabled(true);
        parec65.setEnabled(true);
        parec66.setEnabled(true);
        parec67.setEnabled(true);
        parec68.setEnabled(true);
        parec69.setEnabled(true);
        parec70.setEnabled(true);
        parec71.setEnabled(true);
        parec72.setEnabled(true);
        parec73.setEnabled(true);
        parec74.setEnabled(true);
        parec75.setEnabled(true);
        parec76.setEnabled(true);
        parec77.setEnabled(true);
        parec78.setEnabled(true);
        parec79.setEnabled(true);
        parec80.setEnabled(true);
        parec81.setEnabled(true);
        parec82.setEnabled(true);
        parec83.setEnabled(true);
        parec84.setEnabled(true);
        parec85.setEnabled(true);
        parec86.setEnabled(true);
        parec87.setEnabled(true);
        parec88.setEnabled(true);
        parec89.setEnabled(true);
        parec90.setEnabled(true);
        parec91.setEnabled(true);
        parec92.setEnabled(true);
        parec93.setEnabled(true);
        parec94.setEnabled(true);
        parec95.setEnabled(true);
        parec96.setEnabled(true);
        parec97.setEnabled(true);
        parec98.setEnabled(true);
        parec99.setEnabled(true);
        parec100.setEnabled(true);
        parec101.setEnabled(true);
        parec102.setEnabled(true);
        parec103.setEnabled(true);
        parec104.setEnabled(true);
        parec105.setEnabled(true);
        parec106.setEnabled(true);
        parec107.setEnabled(true);
        parec108.setEnabled(true);
        parec109.setEnabled(true);
        parec110.setEnabled(true);
        pa110_1.setEnabled(true);
        pa110_2.setEnabled(true);
        pa110_3.setEnabled(true);
        pa110_4.setEnabled(true);
        pa110_5.setEnabled(true);
        pa110_6.setEnabled(true);
        pa110_7.setEnabled(true);
        pa110_8.setEnabled(true);
        pa110_9.setEnabled(true);
        pa110_10.setEnabled(true);
        pa110_11.setEnabled(true);
        pa110_12.setEnabled(true);
        pa110_13.setEnabled(true);
        pa110_14.setEnabled(true);
        pa110_15.setEnabled(true);
        pa110_16.setEnabled(true);
        pa110_17.setEnabled(true);
        pa110_18.setEnabled(true);
        pa110_19.setEnabled(true);
        pa110_20.setEnabled(true);
        pa110_21.setEnabled(true);
        pa110_22.setEnabled(true);
        pa110_23.setEnabled(true);
        pa110_24.setEnabled(true);
        pa110_25.setEnabled(true);
        pa110_26.setEnabled(true);
        pa110_27.setEnabled(true);
        pa110_28.setEnabled(true);
        pa110_29.setEnabled(true);
        pa110_30.setEnabled(true);
        pa110_31.setEnabled(true);
        pa110_32.setEnabled(true);
        pa110_33.setEnabled(true);
        pa110_34.setEnabled(true);
        pa110_35.setEnabled(true);
        pa110_36.setEnabled(true);
        pa110_37.setEnabled(true);
        pa110_38.setEnabled(true);
        pa110_39.setEnabled(true);
        pa110_40.setEnabled(true);
        pa110_41.setEnabled(true);
        pa110_42.setEnabled(true);
        pa110_43.setEnabled(true);
        pa110_44.setEnabled(true);
        pa110_45.setEnabled(true);
        pa110_46.setEnabled(true);
        pa110_47.setEnabled(true);
        pa110_48.setEnabled(true);
        pa110_49.setEnabled(true);
        pa110_50.setEnabled(true);
        pa110_51.setEnabled(true);
        pa110_52.setEnabled(true);
        pa110_53.setEnabled(true);
        pa110_54.setEnabled(true);
        pa110_55.setEnabled(true);
        pa110_56.setEnabled(true);
        pa110_57.setEnabled(true);
        }
    }

    public boolean validar(){
        boolean retorno=true;

        if (paret3.getText().toString().isEmpty()){
            paret3.setError("Debe registrar su nombre");
            retorno = false;
        }
        else if (paret4.getText().toString().isEmpty()){
            paret4.setError("Debe registrar su apellido");
            retorno = false;
        }
        else if (paret5.getText().toString().isEmpty()){
            paret5.setError("Debe registrar su apellido");
            retorno = false;
        }
        else if(!parer1.isChecked() && !parer2.isChecked()){
            parer2.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if (paret6.getText().toString().isEmpty()){
            paret6.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (edadd.getText().toString().isEmpty()){
            edadd.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(Float.parseFloat(paret6.getText().toString()) > 30){
            paret6.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(Float.parseFloat(paret7.getText().toString()) > 13){
            paret7.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(Float.parseFloat(paret7.getText().toString()) < 0){
            paret7.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(Float.parseFloat(edadd.getText().toString()) > 100){
            edadd.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(Float.parseFloat(edadd.getText().toString()) < 10){
            edadd.setError("No es un rango aceptable");
            retorno=false;
        }
        else if (paret7.getText().toString().isEmpty()){
            paret7.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(!parer3.isChecked() && !parer4.isChecked()){
            parer4.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer5.isChecked() && !parer6.isChecked()){
            parer6.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer7.isChecked() && !parer8.isChecked()){
            parer8.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer9.isChecked() && !parer10.isChecked()){
            parer10.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer11.isChecked() && !parer12.isChecked()){
            parer12.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer13.isChecked() && !parer14.isChecked()){
            parer14.setError("Debes seleccionar una opción");
            retorno=false;
        }


        else if(validarcapa5_5() == 0){
            parec117.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }
        else if(validarcapa6_6() == 0){
            parec122.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }
        else if(validarcapa7_7() == 0){
            parec123.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }
        else if(validarcapa8_8() == 0){
            parec132.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }
/*
        else if(validarcapa1_1() == 0){
            parec1.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }
        else if(validarcapa2_2() == 0){
            parec14.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }

 */
        else if(validarcapa3_3() == 0){
            parec63.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }
        else if(validarcapa4_4() == 0){
            parec119.setError("Debe seleccionar cuando menos una opción");
            retorno=false;
        }
        else if(!parer15.isChecked() && !parer16.isChecked()){
            parer16.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer17.isChecked() && !parer18.isChecked()){
            parer18.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer19.isChecked() && !parer20.isChecked() && !parer21.isChecked() && !parer22.isChecked()){
            parer22.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer23.isChecked() && !parer24.isChecked() && !parer25.isChecked()){
            parer25.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer26.isChecked() && !parer27.isChecked() && !parer28.isChecked() && !parer29.isChecked()){
            parer29.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer30.isChecked() && !parer31.isChecked() && !parer32.isChecked()){
            parer32.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer33.isChecked() && !parer34.isChecked() && !parer35.isChecked() && !parer36.isChecked()){
            parer36.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer37.isChecked() && !parer38.isChecked() && !parer39.isChecked() && !parer40.isChecked()){
            parer40.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer41.isChecked() && !parer42.isChecked() && !parer43.isChecked() && !parer44.isChecked()){
            parer44.setError("Debes seleccionar una opción");
            retorno=false;
        }
        /*
        else if (paret11.getText().toString().isEmpty()){
            paret11.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (paret12.getText().toString().isEmpty()){
            paret12.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (paret13.getText().toString().isEmpty()){
            paret13.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (paret14.getText().toString().isEmpty()){
            paret14.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (paret15.getText().toString().isEmpty()){
            paret15.setError("No puede quedar vacio");
            retorno = false;
        }
         */

        else if(!parer45.isChecked() && !parer46.isChecked() && !parer47.isChecked() && !parer48.isChecked()){
            parer48.setError("Debes seleccionar una opción");
            retorno=false;
        }

        /*
        else if (paret16.getText().toString().isEmpty()){
            paret16.setError("No puede quedar vacio");
            retorno = false;
        }
        */

        else if (paret17.getText().toString().isEmpty()){
            paret17.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (paret18.getText().toString().isEmpty()){
            paret18.setError("No puede quedar vacio");
            retorno = false;
        }

/*
        else if (paret1119.getText().toString().isEmpty()){
            paret1119.setError("No puede quedar vacio");
            retorno = false;
        }
        */

        else if(!parer49.isChecked() && !parer50.isChecked()){
            parer50.setError("Debes seleccionar una opción");
            retorno=false;
        }
        /*
        else if (paret19.getText().toString().isEmpty()){
            paret19.setError("No puede quedar vacio");
            retorno = false;
        }
        */
        else if(!parer51.isChecked() && !parer52.isChecked()){
            parer52.setError("Debes seleccionar una opción");
            retorno=false;
        }




        else if(!parer53.isChecked() && !parer54.isChecked() && !parer55.isChecked() && !parer56.isChecked()){
            parer56.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer57.isChecked() && !parer58.isChecked() && !parer59.isChecked()){
            parer59.setError("Debes seleccionar una opción");
            retorno=false;
        }

        /*
        else if (paret20.getText().toString().isEmpty()){
            paret20.setError("No puede quedar vacio");
            retorno = false;
        }
        */

        else if(!parer60.isChecked() && !parer61.isChecked()){
            parer61.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer62.isChecked() && !parer63.isChecked()){
            parer63.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer64.isChecked() && !parer65.isChecked()){
            parer65.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer66.isChecked() && !parer67.isChecked()){
            parer67.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!parer68.isChecked() && !parer69.isChecked()){
            parer69.setError("Debes seleccionar una opción");
            retorno=false;
        }



        return retorno;
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




    public boolean validarcapa1(){
        boolean retorno=true;
        int count=0;

        if(parec1.isChecked()){count = count + 1;}
        if(parec2.isChecked()){count = count + 1;}
        if(parec3.isChecked()){count = count + 1;}
        if(parec4.isChecked()){count = count + 1;}
        if(parec5.isChecked()){count = count + 1;}
        if(parec6.isChecked()){count = count + 1;}
        if(parec7.isChecked()){count = count + 1;}

        if(count<=7) {
            retorno = true;
        }
        else{
            retorno=false;
        }
        return retorno;
    }

    public int validarcapa1_1(){

        int count=0;

        if(parec1.isChecked()){count = count + 1;}
        if(parec2.isChecked()){count = count + 1;}
        if(parec3.isChecked()){count = count + 1;}
        if(parec4.isChecked()){count = count + 1;}
        if(parec5.isChecked()){count = count + 1;}
        if(parec6.isChecked()){count = count + 1;}
        if(parec7.isChecked()){count = count + 1;}


        return count;
    }


    public boolean validarcapa2(){
        boolean retorno=true;
        int count=0;

        if(parec9.isChecked()){count = count + 1;}
        if(parec10.isChecked()){count = count + 1;}
        if(parec11.isChecked()){count = count + 1;}
        if(parec12.isChecked()){count = count + 1;}
        if(parec13.isChecked()){count = count + 1;}
        if(parec14.isChecked()){count = count + 1;}

        if(count<=3) {
            retorno = true;
        }
        else{
            retorno=false;
        }
        return retorno;
    }

    public int validarcapa2_2(){

        int count=0;

        if(parec9.isChecked()){count = count + 1;}
        if(parec10.isChecked()){count = count + 1;}
        if(parec11.isChecked()){count = count + 1;}
        if(parec12.isChecked()){count = count + 1;}
        if(parec13.isChecked()){count = count + 1;}
        if(parec14.isChecked()){count = count + 1;}

        return count;
    }



    public boolean validarcapa3(){
        boolean retorno=true;

        int count=0;

        if(parec17.isChecked()){count = count + 1;}
        if(parec18.isChecked()){count = count + 1;}
        if(parec19.isChecked()){count = count + 1;}
        if(parec20.isChecked()){count = count + 1;}
        if(parec21.isChecked()){count = count + 1;}
        if(parec22.isChecked()){count = count + 1;}
        if(parec23.isChecked()){count = count + 1;}
        if(parec24.isChecked()){count = count + 1;}
        if(parec25.isChecked()){count = count + 1;}
        if(parec26.isChecked()){count = count + 1;}
        if(parec27.isChecked()){count = count + 1;}
        if(parec28.isChecked()){count = count + 1;}
        if(parec29.isChecked()){count = count + 1;}
        if(parec30.isChecked()){count = count + 1;}
        if(parec31.isChecked()){count = count + 1;}
        if(parec32.isChecked()){count = count + 1;}
        if(parec33.isChecked()){count = count + 1;}
        if(parec34.isChecked()){count = count + 1;}
        if(parec35.isChecked()){count = count + 1;}
        if(parec36.isChecked()){count = count + 1;}
        if(parec37.isChecked()){count = count + 1;}
        if(parec38.isChecked()){count = count + 1;}
        if(parec39.isChecked()){count = count + 1;}
        if(parec40.isChecked()){count = count + 1;}
        if(parec41.isChecked()){count = count + 1;}
        if(parec42.isChecked()){count = count + 1;}
        if(parec43.isChecked()){count = count + 1;}
        if(parec44.isChecked()){count = count + 1;}
        if(parec45.isChecked()){count = count + 1;}
        if(parec46.isChecked()){count = count + 1;}
        if(parec47.isChecked()){count = count + 1;}
        if(parec48.isChecked()){count = count + 1;}
        if(parec49.isChecked()){count = count + 1;}
        if(parec50.isChecked()){count = count + 1;}
        if(parec51.isChecked()){count = count + 1;}
        if(parec52.isChecked()){count = count + 1;}
        if(parec53.isChecked()){count = count + 1;}
        if(parec54.isChecked()){count = count + 1;}
        if(parec55.isChecked()){count = count + 1;}
        if(parec56.isChecked()){count = count + 1;}
        if(parec57.isChecked()){count = count + 1;}
        if(parec58.isChecked()){count = count + 1;}
        if(parec59.isChecked()){count = count + 1;}
        if(parec60.isChecked()){count = count + 1;}
        if(parec61.isChecked()){count = count + 1;}
        if(parec62.isChecked()){count = count + 1;}
        if(parec63.isChecked()){count = count + 1;}
        if(pa63_1.isChecked()){count = count + 1;}
        if(pa63_2.isChecked()){count = count + 1;}
        if(pa63_3.isChecked()){count = count + 1;}
        if(pa63_4.isChecked()){count = count + 1;}
        if(pa63_5.isChecked()){count = count + 1;}
        if(pa63_6.isChecked()){count = count + 1;}
        if(pa63_7.isChecked()){count = count + 1;}
        if(pa63_8.isChecked()){count = count + 1;}
        if(pa63_9.isChecked()){count = count + 1;}
        if(pa63_10.isChecked()){count = count + 1;}
        if(pa63_11.isChecked()){count = count + 1;}
        if(pa63_12.isChecked()){count = count + 1;}
        if(pa63_13.isChecked()){count = count + 1;}
        if(pa63_14.isChecked()){count = count + 1;}
        if(pa63_15.isChecked()){count = count + 1;}
        if(pa63_16.isChecked()){count = count + 1;}
        if(pa63_17.isChecked()){count = count + 1;}
        if(pa63_18.isChecked()){count = count + 1;}
        if(pa63_19.isChecked()){count = count + 1;}
        if(pa63_20.isChecked()){count = count + 1;}
        if(pa63_21.isChecked()){count = count + 1;}
        if(pa63_22.isChecked()){count = count + 1;}
        if(pa63_23.isChecked()){count = count + 1;}
        if(pa63_24.isChecked()){count = count + 1;}
        if(pa63_25.isChecked()){count = count + 1;}
        if(pa63_26.isChecked()){count = count + 1;}
        if(pa63_27.isChecked()){count = count + 1;}
        if(pa63_28.isChecked()){count = count + 1;}
        if(pa63_29.isChecked()){count = count + 1;}
        if(pa63_30.isChecked()){count = count + 1;}
        if(pa63_31.isChecked()){count = count + 1;}
        if(pa63_32.isChecked()){count = count + 1;}
        if(pa63_33.isChecked()){count = count + 1;}
        if(pa63_34.isChecked()){count = count + 1;}
        if(pa63_35.isChecked()){count = count + 1;}
        if(pa63_36.isChecked()){count = count + 1;}
        if(pa63_37.isChecked()){count = count + 1;}
        if(pa63_38.isChecked()){count = count + 1;}
        if(pa63_39.isChecked()){count = count + 1;}
        if(pa63_40.isChecked()){count = count + 1;}
        if(pa63_41.isChecked()){count = count + 1;}
        if(pa63_42.isChecked()){count = count + 1;}
        if(pa63_43.isChecked()){count = count + 1;}
        if(pa63_44.isChecked()){count = count + 1;}
        if(pa63_45.isChecked()){count = count + 1;}
        if(pa63_46.isChecked()){count = count + 1;}
        if(pa63_47.isChecked()){count = count + 1;}
        if(pa63_48.isChecked()){count = count + 1;}
        if(pa63_49.isChecked()){count = count + 1;}
        if(pa63_50.isChecked()){count = count + 1;}
        if(pa63_51.isChecked()){count = count + 1;}
        if(pa63_52.isChecked()){count = count + 1;}
        if(pa63_53.isChecked()){count = count + 1;}
        if(pa63_54.isChecked()){count = count + 1;}
        if(pa63_55.isChecked()){count = count + 1;}
        if(pa63_56.isChecked()){count = count + 1;}
        if(pa63_57.isChecked()){count = count + 1;}

        if(count<=5) {
            retorno = true;
        }
        else{
            retorno=false;
        }
        return retorno;
    }

    public int validarcapa3_3(){

        int count=0;
        if(parec17.isChecked()){count = count + 1;}
        if(parec18.isChecked()){count = count + 1;}
        if(parec19.isChecked()){count = count + 1;}
        if(parec20.isChecked()){count = count + 1;}
        if(parec21.isChecked()){count = count + 1;}
        if(parec22.isChecked()){count = count + 1;}
        if(parec23.isChecked()){count = count + 1;}
        if(parec24.isChecked()){count = count + 1;}
        if(parec25.isChecked()){count = count + 1;}
        if(parec26.isChecked()){count = count + 1;}
        if(parec27.isChecked()){count = count + 1;}
        if(parec28.isChecked()){count = count + 1;}
        if(parec29.isChecked()){count = count + 1;}
        if(parec30.isChecked()){count = count + 1;}
        if(parec31.isChecked()){count = count + 1;}
        if(parec32.isChecked()){count = count + 1;}
        if(parec33.isChecked()){count = count + 1;}
        if(parec34.isChecked()){count = count + 1;}
        if(parec35.isChecked()){count = count + 1;}
        if(parec36.isChecked()){count = count + 1;}
        if(parec37.isChecked()){count = count + 1;}
        if(parec38.isChecked()){count = count + 1;}
        if(parec39.isChecked()){count = count + 1;}
        if(parec40.isChecked()){count = count + 1;}
        if(parec41.isChecked()){count = count + 1;}
        if(parec42.isChecked()){count = count + 1;}
        if(parec43.isChecked()){count = count + 1;}
        if(parec44.isChecked()){count = count + 1;}
        if(parec45.isChecked()){count = count + 1;}
        if(parec46.isChecked()){count = count + 1;}
        if(parec47.isChecked()){count = count + 1;}
        if(parec48.isChecked()){count = count + 1;}
        if(parec49.isChecked()){count = count + 1;}
        if(parec50.isChecked()){count = count + 1;}
        if(parec51.isChecked()){count = count + 1;}
        if(parec52.isChecked()){count = count + 1;}
        if(parec53.isChecked()){count = count + 1;}
        if(parec54.isChecked()){count = count + 1;}
        if(parec55.isChecked()){count = count + 1;}
        if(parec56.isChecked()){count = count + 1;}
        if(parec57.isChecked()){count = count + 1;}
        if(parec58.isChecked()){count = count + 1;}
        if(parec59.isChecked()){count = count + 1;}
        if(parec60.isChecked()){count = count + 1;}
        if(parec61.isChecked()){count = count + 1;}
        if(parec62.isChecked()){count = count + 1;}
        if(parec63.isChecked()){count = count + 1;}
        if(pa63_1.isChecked()){count = count + 1;}
        if(pa63_2.isChecked()){count = count + 1;}
        if(pa63_3.isChecked()){count = count + 1;}
        if(pa63_4.isChecked()){count = count + 1;}
        if(pa63_5.isChecked()){count = count + 1;}
        if(pa63_6.isChecked()){count = count + 1;}
        if(pa63_7.isChecked()){count = count + 1;}
        if(pa63_8.isChecked()){count = count + 1;}
        if(pa63_9.isChecked()){count = count + 1;}
        if(pa63_10.isChecked()){count = count + 1;}
        if(pa63_11.isChecked()){count = count + 1;}
        if(pa63_12.isChecked()){count = count + 1;}
        if(pa63_13.isChecked()){count = count + 1;}
        if(pa63_14.isChecked()){count = count + 1;}
        if(pa63_15.isChecked()){count = count + 1;}
        if(pa63_16.isChecked()){count = count + 1;}
        if(pa63_17.isChecked()){count = count + 1;}
        if(pa63_18.isChecked()){count = count + 1;}
        if(pa63_19.isChecked()){count = count + 1;}
        if(pa63_20.isChecked()){count = count + 1;}
        if(pa63_21.isChecked()){count = count + 1;}
        if(pa63_22.isChecked()){count = count + 1;}
        if(pa63_23.isChecked()){count = count + 1;}
        if(pa63_24.isChecked()){count = count + 1;}
        if(pa63_25.isChecked()){count = count + 1;}
        if(pa63_26.isChecked()){count = count + 1;}
        if(pa63_27.isChecked()){count = count + 1;}
        if(pa63_28.isChecked()){count = count + 1;}
        if(pa63_29.isChecked()){count = count + 1;}
        if(pa63_30.isChecked()){count = count + 1;}
        if(pa63_31.isChecked()){count = count + 1;}
        if(pa63_32.isChecked()){count = count + 1;}
        if(pa63_33.isChecked()){count = count + 1;}
        if(pa63_34.isChecked()){count = count + 1;}
        if(pa63_35.isChecked()){count = count + 1;}
        if(pa63_36.isChecked()){count = count + 1;}
        if(pa63_37.isChecked()){count = count + 1;}
        if(pa63_38.isChecked()){count = count + 1;}
        if(pa63_39.isChecked()){count = count + 1;}
        if(pa63_40.isChecked()){count = count + 1;}
        if(pa63_41.isChecked()){count = count + 1;}
        if(pa63_42.isChecked()){count = count + 1;}
        if(pa63_43.isChecked()){count = count + 1;}
        if(pa63_44.isChecked()){count = count + 1;}
        if(pa63_45.isChecked()){count = count + 1;}
        if(pa63_46.isChecked()){count = count + 1;}
        if(pa63_47.isChecked()){count = count + 1;}
        if(pa63_48.isChecked()){count = count + 1;}
        if(pa63_49.isChecked()){count = count + 1;}
        if(pa63_50.isChecked()){count = count + 1;}
        if(pa63_51.isChecked()){count = count + 1;}
        if(pa63_52.isChecked()){count = count + 1;}
        if(pa63_53.isChecked()){count = count + 1;}
        if(pa63_54.isChecked()){count = count + 1;}
        if(pa63_55.isChecked()){count = count + 1;}
        if(pa63_56.isChecked()){count = count + 1;}
        if(pa63_57.isChecked()){count = count + 1;}


        return count;
    }

    public boolean validarcapa4(){
        boolean retorno=true;
        /*
        int counte=0;

        if(parec64.isChecked()){counte = counte + 1;}
        if(parec65.isChecked()){counte = counte + 1;}
        if(parec66.isChecked()){counte = counte + 1;}
        if(parec67.isChecked()){counte = counte + 1;}
        if(parec68.isChecked()){counte = counte + 1;}
        if(parec69.isChecked()){counte = counte + 1;}
        if(parec70.isChecked()){counte = counte + 1;}
        if(parec71.isChecked()){counte = counte + 1;}
        if(parec72.isChecked()){counte = counte + 1;}
        if(parec73.isChecked()){counte = counte + 1;}
        if(parec74.isChecked()){counte = counte + 1;}
        if(parec75.isChecked()){counte = counte + 1;}
        if(parec76.isChecked()){counte = counte + 1;}
        if(parec77.isChecked()){counte = counte + 1;}
        if(parec78.isChecked()){counte = counte + 1;}
        if(parec79.isChecked()){counte = counte + 1;}
        if(parec80.isChecked()){counte = counte + 1;}
        if(parec81.isChecked()){counte = counte + 1;}
        if(parec82.isChecked()){counte = counte + 1;}
        if(parec83.isChecked()){counte = counte + 1;}
        if(parec84.isChecked()){counte = counte + 1;}
        if(parec85.isChecked()){counte = counte + 1;}
        if(parec86.isChecked()){counte = counte + 1;}
        if(parec87.isChecked()){counte = counte + 1;}
        if(parec88.isChecked()){counte = counte + 1;}
        if(parec89.isChecked()){counte = counte + 1;}
        if(parec90.isChecked()){counte = counte + 1;}
        if(parec91.isChecked()){counte = counte + 1;}
        if(parec92.isChecked()){counte = counte + 1;}
        if(parec93.isChecked()){counte = counte + 1;}
        if(parec94.isChecked()){counte = counte + 1;}
        if(parec95.isChecked()){counte = counte + 1;}
        if(parec96.isChecked()){counte = counte + 1;}
        if(parec97.isChecked()){counte = counte + 1;}
        if(parec98.isChecked()){counte = counte + 1;}
        if(parec99.isChecked()){counte = counte + 1;}
        if(parec100.isChecked()){counte = counte + 1;}
        if(parec101.isChecked()){counte = counte + 1;}
        if(parec102.isChecked()){counte = counte + 1;}
        if(parec103.isChecked()){counte = counte + 1;}
        if(parec104.isChecked()){counte = counte + 1;}
        if(parec105.isChecked()){counte = counte + 1;}
        if(parec106.isChecked()){counte = counte + 1;}
        if(parec107.isChecked()){counte = counte + 1;}
        if(parec108.isChecked()){counte = counte + 1;}
        if(parec109.isChecked()){counte = counte + 1;}
        if(parec110.isChecked()){counte = counte + 1;}
        if(parec111.isChecked()){counte = counte + 1;}
        if(parec112.isChecked()){counte = counte + 1;}
        if(parec113.isChecked()){counte = counte + 1;}
        if(parec114.isChecked()){counte = counte + 1;}
        if(parec115.isChecked()){counte = counte + 1;}
        if(parec116.isChecked()){counte = counte + 1;}
        if(parec117.isChecked()){counte = counte + 1;}
        if(parec118.isChecked()){counte = counte + 1;}
        if(parec119.isChecked()){counte = counte + 1;}

        if(pa110_1.isChecked()){count = count + 1;}
if(pa110_2.isChecked()){count = count + 1;}
if(pa110_3.isChecked()){count = count + 1;}
if(pa110_4.isChecked()){count = count + 1;}
if(pa110_5.isChecked()){count = count + 1;}
if(pa110_6.isChecked()){count = count + 1;}
if(pa110_7.isChecked()){count = count + 1;}
if(pa110_8.isChecked()){count = count + 1;}
if(pa110_9.isChecked()){count = count + 1;}
if(pa110_10.isChecked()){count = count + 1;}
if(pa110_11.isChecked()){count = count + 1;}
if(pa110_12.isChecked()){count = count + 1;}
if(pa110_13.isChecked()){count = count + 1;}
if(pa110_14.isChecked()){count = count + 1;}
if(pa110_15.isChecked()){count = count + 1;}
if(pa110_16.isChecked()){count = count + 1;}
if(pa110_17.isChecked()){count = count + 1;}
if(pa110_18.isChecked()){count = count + 1;}
if(pa110_19.isChecked()){count = count + 1;}
if(pa110_20.isChecked()){count = count + 1;}
if(pa110_21.isChecked()){count = count + 1;}
if(pa110_22.isChecked()){count = count + 1;}
if(pa110_23.isChecked()){count = count + 1;}
if(pa110_24.isChecked()){count = count + 1;}
if(pa110_25.isChecked()){count = count + 1;}
if(pa110_26.isChecked()){count = count + 1;}
if(pa110_27.isChecked()){count = count + 1;}
if(pa110_28.isChecked()){count = count + 1;}
if(pa110_29.isChecked()){count = count + 1;}
if(pa110_30.isChecked()){count = count + 1;}
if(pa110_31.isChecked()){count = count + 1;}
if(pa110_32.isChecked()){count = count + 1;}
if(pa110_33.isChecked()){count = count + 1;}
if(pa110_34.isChecked()){count = count + 1;}
if(pa110_35.isChecked()){count = count + 1;}
if(pa110_36.isChecked()){count = count + 1;}
if(pa110_37.isChecked()){count = count + 1;}
if(pa110_38.isChecked()){count = count + 1;}
if(pa110_39.isChecked()){count = count + 1;}
if(pa110_40.isChecked()){count = count + 1;}
if(pa110_41.isChecked()){count = count + 1;}
if(pa110_42.isChecked()){count = count + 1;}
if(pa110_43.isChecked()){count = count + 1;}
if(pa110_44.isChecked()){count = count + 1;}
if(pa110_45.isChecked()){count = count + 1;}
if(pa110_46.isChecked()){count = count + 1;}
if(pa110_47.isChecked()){count = count + 1;}
if(pa110_48.isChecked()){count = count + 1;}
if(pa110_49.isChecked()){count = count + 1;}
if(pa110_50.isChecked()){count = count + 1;}
if(pa110_51.isChecked()){count = count + 1;}
if(pa110_52.isChecked()){count = count + 1;}
if(pa110_53.isChecked()){count = count + 1;}
if(pa110_54.isChecked()){count = count + 1;}
if(pa110_55.isChecked()){count = count + 1;}
if(pa110_56.isChecked()){count = count + 1;}
if(pa110_57.isChecked()){count = count + 1;}

        if(counte<=5) {
            retorno = true;
        }
        else{
            retorno=false;
        }

         */
        return retorno;
    }



    public int validarcapa4_4(){

        int count=0;

        if(parec64.isChecked()){count = count + 1;}
        if(parec65.isChecked()){count = count + 1;}
        if(parec66.isChecked()){count = count + 1;}
        if(parec67.isChecked()){count = count + 1;}
        if(parec68.isChecked()){count = count + 1;}
        if(parec69.isChecked()){count = count + 1;}
        if(parec70.isChecked()){count = count + 1;}
        if(parec71.isChecked()){count = count + 1;}
        if(parec72.isChecked()){count = count + 1;}
        if(parec73.isChecked()){count = count + 1;}
        if(parec74.isChecked()){count = count + 1;}
        if(parec75.isChecked()){count = count + 1;}
        if(parec76.isChecked()){count = count + 1;}
        if(parec77.isChecked()){count = count + 1;}
        if(parec78.isChecked()){count = count + 1;}
        if(parec79.isChecked()){count = count + 1;}
        if(parec80.isChecked()){count = count + 1;}
        if(parec81.isChecked()){count = count + 1;}
        if(parec82.isChecked()){count = count + 1;}
        if(parec83.isChecked()){count = count + 1;}
        if(parec84.isChecked()){count = count + 1;}
        if(parec85.isChecked()){count = count + 1;}
        if(parec86.isChecked()){count = count + 1;}
        if(parec87.isChecked()){count = count + 1;}
        if(parec88.isChecked()){count = count + 1;}
        if(parec89.isChecked()){count = count + 1;}
        if(parec90.isChecked()){count = count + 1;}
        if(parec91.isChecked()){count = count + 1;}
        if(parec92.isChecked()){count = count + 1;}
        if(parec93.isChecked()){count = count + 1;}
        if(parec94.isChecked()){count = count + 1;}
        if(parec95.isChecked()){count = count + 1;}
        if(parec96.isChecked()){count = count + 1;}
        if(parec97.isChecked()){count = count + 1;}
        if(parec98.isChecked()){count = count + 1;}
        if(parec99.isChecked()){count = count + 1;}
        if(parec100.isChecked()){count = count + 1;}
        if(parec101.isChecked()){count = count + 1;}
        if(parec102.isChecked()){count = count + 1;}
        if(parec103.isChecked()){count = count + 1;}
        if(parec104.isChecked()){count = count + 1;}
        if(parec105.isChecked()){count = count + 1;}
        if(parec106.isChecked()){count = count + 1;}
        if(parec107.isChecked()){count = count + 1;}
        if(parec108.isChecked()){count = count + 1;}
        if(parec109.isChecked()){count = count + 1;}
        if(parec110.isChecked()){count = count + 1;}

        if(pa110_1.isChecked()){count = count + 1;}
        if(pa110_2.isChecked()){count = count + 1;}
        if(pa110_3.isChecked()){count = count + 1;}
        if(pa110_4.isChecked()){count = count + 1;}
        if(pa110_5.isChecked()){count = count + 1;}
        if(pa110_6.isChecked()){count = count + 1;}
        if(pa110_7.isChecked()){count = count + 1;}
        if(pa110_8.isChecked()){count = count + 1;}
        if(pa110_9.isChecked()){count = count + 1;}
        if(pa110_10.isChecked()){count = count + 1;}
        if(pa110_11.isChecked()){count = count + 1;}
        if(pa110_12.isChecked()){count = count + 1;}
        if(pa110_13.isChecked()){count = count + 1;}
        if(pa110_14.isChecked()){count = count + 1;}
        if(pa110_15.isChecked()){count = count + 1;}
        if(pa110_16.isChecked()){count = count + 1;}
        if(pa110_17.isChecked()){count = count + 1;}
        if(pa110_18.isChecked()){count = count + 1;}
        if(pa110_19.isChecked()){count = count + 1;}
        if(pa110_20.isChecked()){count = count + 1;}
        if(pa110_21.isChecked()){count = count + 1;}
        if(pa110_22.isChecked()){count = count + 1;}
        if(pa110_23.isChecked()){count = count + 1;}
        if(pa110_24.isChecked()){count = count + 1;}
        if(pa110_25.isChecked()){count = count + 1;}
        if(pa110_26.isChecked()){count = count + 1;}
        if(pa110_27.isChecked()){count = count + 1;}
        if(pa110_28.isChecked()){count = count + 1;}
        if(pa110_29.isChecked()){count = count + 1;}
        if(pa110_30.isChecked()){count = count + 1;}
        if(pa110_31.isChecked()){count = count + 1;}
        if(pa110_32.isChecked()){count = count + 1;}
        if(pa110_33.isChecked()){count = count + 1;}
        if(pa110_34.isChecked()){count = count + 1;}
        if(pa110_35.isChecked()){count = count + 1;}
        if(pa110_36.isChecked()){count = count + 1;}
        if(pa110_37.isChecked()){count = count + 1;}
        if(pa110_38.isChecked()){count = count + 1;}
        if(pa110_39.isChecked()){count = count + 1;}
        if(pa110_40.isChecked()){count = count + 1;}
        if(pa110_41.isChecked()){count = count + 1;}
        if(pa110_42.isChecked()){count = count + 1;}
        if(pa110_43.isChecked()){count = count + 1;}
        if(pa110_44.isChecked()){count = count + 1;}
        if(pa110_45.isChecked()){count = count + 1;}
        if(pa110_46.isChecked()){count = count + 1;}
        if(pa110_47.isChecked()){count = count + 1;}
        if(pa110_48.isChecked()){count = count + 1;}
        if(pa110_49.isChecked()){count = count + 1;}
        if(pa110_50.isChecked()){count = count + 1;}
        if(pa110_51.isChecked()){count = count + 1;}
        if(pa110_52.isChecked()){count = count + 1;}
        if(pa110_53.isChecked()){count = count + 1;}
        if(pa110_54.isChecked()){count = count + 1;}
        if(pa110_55.isChecked()){count = count + 1;}
        if(pa110_56.isChecked()){count = count + 1;}
        if(pa110_57.isChecked()){count = count + 1;}

        return count;
    }

    public String capa(){
        String cadena = "";
        String resultado1 = "";

        if(parec1.isChecked()){cadena += "" + parec1.getText().toString() + "-";}
        if(parec2.isChecked()){cadena += "" + parec2.getText().toString() + "-";}
        if(parec3.isChecked()){cadena += "" + parec3.getText().toString() + "-";}
        if(parec4.isChecked()){cadena += "" + parec4.getText().toString() + "-";}
        if(parec5.isChecked()){cadena += "" + parec5.getText().toString() + "-";}
        if(parec6.isChecked()){cadena += "" + parec6.getText().toString() + "-";}
        if(parec7.isChecked()){cadena += "" + parec7.getText().toString() + "-";}

        if (!parec7.isChecked() && !parec6.isChecked() && !parec5.isChecked() && !parec4.isChecked() && !parec3.isChecked() && !parec2.isChecked() && !parec1.isChecked()){
            cadena = "No aplica";
        }
        resultado1 = cadena.substring(0, cadena.length()-1);
        return resultado1;
    }

    public int validarcapa_(){

        int count=0;

        if(parec1.isChecked()){count = count + 1;}
        if(parec2.isChecked()){count = count + 1;}
        if(parec3.isChecked()){count = count + 1;}
        if(parec4.isChecked()){count = count + 1;}
        if(parec5.isChecked()){count = count + 1;}
        if(parec6.isChecked()){count = count + 1;}
        if(parec7.isChecked()){count = count + 1;}

        return count;
    }

    public String capa2(){
        String cadena = "";
        String resultado1 = "";

        if(parec9.isChecked()){cadena += "" + parec9.getText().toString() + "-";}
        if(parec10.isChecked()){cadena += "" + parec10.getText().toString() + "-";}
        if(parec11.isChecked()){cadena += "" + parec11.getText().toString() + "-";}
        if(parec12.isChecked()){cadena += "" + parec12.getText().toString() + "-";}
        if(parec13.isChecked()){cadena += "" + parec13.getText().toString() + "-";}
        if(parec14.isChecked()){cadena += "" + parec14.getText().toString() + "-";}
        if(parec15.isChecked()){cadena += "" + parec15.getText().toString() + "-";}

        if (!parec9.isChecked() && !parec10.isChecked() && !parec11.isChecked() && !parec12.isChecked() && !parec13.isChecked() && !parec14.isChecked() && !parec15.isChecked()){
            cadena = "No aplica";
        }
        resultado1 = cadena.substring(0, cadena.length()-1);
        return resultado1;
    }



    public String capa5(){
        String cadena5 = "";
        String resultado5 = "";

        if(parec111.isChecked()){cadena5 += "" + parec111.getText().toString() + "-";}
        if(parec112.isChecked()){cadena5 += "" + parec112.getText().toString() + "-";}
        if(parec113.isChecked()){cadena5 += "" + parec113.getText().toString() + "-";}
        if(parec114.isChecked()){cadena5 += "" + parec114.getText().toString() + "-";}
        if(parec115.isChecked()){cadena5 += "" + parec115.getText().toString() + "-";}
        if(parec116.isChecked()){cadena5 += "" + parec116.getText().toString() + "-";}
        if(parec117.isChecked()){cadena5 += "" + parec117.getText().toString() + "-";}

        resultado5 = cadena5.substring(0, cadena5.length()-1);
        return resultado5;
    }

    public int validarcapa5_5(){

        int count=0;

        if(parec111.isChecked()){count = count + 1;}
        if(parec112.isChecked()){count = count + 1;}
        if(parec113.isChecked()){count = count + 1;}
        if(parec114.isChecked()){count = count + 1;}
        if(parec115.isChecked()){count = count + 1;}
        if(parec116.isChecked()){count = count + 1;}
        if(parec117.isChecked()){count = count + 1;}

        return count;
    }

    public String capa6(){
        String cadena6 = "";
        String resultado6 = "";


        if(parec118.isChecked()){cadena6 += "" + parec118.getText().toString() + "-";}
        if(parec119.isChecked()){cadena6 += "" + parec119.getText().toString() + "-";}
        if(parec120.isChecked()){cadena6 += "" + parec120.getText().toString() + "-";}
        if(parec121.isChecked()){cadena6 += "" + parec121.getText().toString() + "-";}
        if(parec122.isChecked()){cadena6 += "" + parec122.getText().toString() + "-";}
        
        resultado6 = cadena6.substring(0, cadena6.length()-1);
        return resultado6;

    }

    public int validarcapa6_6(){

        int count=0;

        if(parec118.isChecked()){count = count + 1;}
        if(parec119.isChecked()){count = count + 1;}
        if(parec120.isChecked()){count = count + 1;}
        if(parec121.isChecked()){count = count + 1;}
        if(parec122.isChecked()){count = count + 1;}

        return count;
    }


    public String capa7(){
        String cadena7 = "";
        String resultado7 = "";

        if(parec123.isChecked()){cadena7 += "" + parec123.getText().toString() + "-";}
        if(parec124.isChecked()){cadena7 += "" + parec124.getText().toString() + "-";}
        if(parec125.isChecked()){cadena7 += "" + parec125.getText().toString() + "-";}
        if(parec126.isChecked()){cadena7 += "" + parec126.getText().toString() + "-";}
        if(parec127.isChecked()){cadena7 += "" + parec127.getText().toString() + "-";}
        if(parec128.isChecked()){cadena7 += "" + parec128.getText().toString() + "-";}
        if(parec129.isChecked()){cadena7 += "" + parec129.getText().toString() + "-";}
        if(parec130.isChecked()){cadena7 += "" + parec130.getText().toString() + "-";}
        if(parec131.isChecked()){cadena7 += "" + parec131.getText().toString() + "-";}

        resultado7 = cadena7.substring(0, cadena7.length()-1);
        return resultado7;
    }

    public int validarcapa7_7(){

        int count=0;

        if(parec123.isChecked()){count = count + 1;}
        if(parec124.isChecked()){count = count + 1;}
        if(parec125.isChecked()){count = count + 1;}
        if(parec126.isChecked()){count = count + 1;}
        if(parec127.isChecked()){count = count + 1;}
        if(parec128.isChecked()){count = count + 1;}
        if(parec129.isChecked()){count = count + 1;}
        if(parec130.isChecked()){count = count + 1;}
        if(parec131.isChecked()){count = count + 1;}

        return count;
    }




    public String capa8(){
        String cadena8 = "";
        String resultado8 = "";

        if(parec132.isChecked()){cadena8 += "" + parec132.getText().toString() + "-";}
        if(parec133.isChecked()){cadena8 += "" + parec133.getText().toString() + "-";}
        if(parec134.isChecked()){cadena8 += "" + parec134.getText().toString() + "-";}
        if(parec135.isChecked()){cadena8 += "" + parec135.getText().toString() + "-";}
        if(parec136.isChecked()){cadena8 += "" + parec136.getText().toString() + "-";}
        if(parec137.isChecked()){cadena8 += "" + parec137.getText().toString() + "-";}
        if(parec138.isChecked()){cadena8 += "" + parec138.getText().toString() + "-";}
        if(parec139.isChecked()){cadena8 += "" + parec139.getText().toString() + "-";}
        if(parec140.isChecked()){cadena8 += "" + parec140.getText().toString() + "-";}

        resultado8 = cadena8.substring(0, cadena8.length()-1);
        return resultado8;
    }

    public int validarcapa8_8(){

        int count=0;

        if(parec132.isChecked()){count = count + 1;}
        if(parec133.isChecked()){count = count + 1;}
        if(parec134.isChecked()){count = count + 1;}
        if(parec135.isChecked()){count = count + 1;}
        if(parec136.isChecked()){count = count + 1;}
        if(parec137.isChecked()){count = count + 1;}
        if(parec138.isChecked()){count = count + 1;}
        if(parec139.isChecked()){count = count + 1;}
        if(parec140.isChecked()){count = count + 1;}

        return count;
    }



    public String capa3() {
        String cadena = "";
        String resultado3 = "";

        if(parec17.isChecked()){cadena += "" + parec17.getText().toString() + "-";}
        if(parec18.isChecked()){cadena += "" + parec18.getText().toString() + "-";}
        if(parec19.isChecked()){cadena += "" + parec19.getText().toString() + "-";}
        if(parec20.isChecked()){cadena += "" + parec20.getText().toString() + "-";}
        if(parec21.isChecked()){cadena += "" + parec21.getText().toString() + "-";}
        if(parec22.isChecked()){cadena += "" + parec22.getText().toString() + "-";}
        if(parec23.isChecked()){cadena += "" + parec23.getText().toString() + "-";}
        if(parec24.isChecked()){cadena += "" + parec24.getText().toString() + "-";}
        if(parec25.isChecked()){cadena += "" + parec25.getText().toString() + "-";}
        if(parec26.isChecked()){cadena += "" + parec26.getText().toString() + "-";}
        if(parec27.isChecked()){cadena += "" + parec27.getText().toString() + "-";}
        if(parec28.isChecked()){cadena += "" + parec28.getText().toString() + "-";}
        if(parec29.isChecked()){cadena += "" + parec29.getText().toString() + "-";}
        if(parec30.isChecked()){cadena += "" + parec30.getText().toString() + "-";}
        if(parec31.isChecked()){cadena += "" + parec31.getText().toString() + "-";}
        if(parec32.isChecked()){cadena += "" + parec32.getText().toString() + "-";}
        if(parec33.isChecked()){cadena += "" + parec33.getText().toString() + "-";}
        if(parec34.isChecked()){cadena += "" + parec34.getText().toString() + "-";}
        if(parec35.isChecked()){cadena += "" + parec35.getText().toString() + "-";}
        if(parec36.isChecked()){cadena += "" + parec36.getText().toString() + "-";}
        if(parec37.isChecked()){cadena += "" + parec37.getText().toString() + "-";}
        if(parec38.isChecked()){cadena += "" + parec38.getText().toString() + "-";}
        if(parec39.isChecked()){cadena += "" + parec39.getText().toString() + "-";}
        if(parec40.isChecked()){cadena += "" + parec40.getText().toString() + "-";}
        if(parec41.isChecked()){cadena += "" + parec41.getText().toString() + "-";}
        if(parec42.isChecked()){cadena += "" + parec42.getText().toString() + "-";}
        if(parec43.isChecked()){cadena += "" + parec43.getText().toString() + "-";}
        if(parec44.isChecked()){cadena += "" + parec44.getText().toString() + "-";}
        if(parec45.isChecked()){cadena += "" + parec45.getText().toString() + "-";}
        if(parec46.isChecked()){cadena += "" + parec46.getText().toString() + "-";}
        if(parec47.isChecked()){cadena += "" + parec47.getText().toString() + "-";}
        if(parec48.isChecked()){cadena += "" + parec48.getText().toString() + "-";}
        if(parec49.isChecked()){cadena += "" + parec49.getText().toString() + "-";}
        if(parec50.isChecked()){cadena += "" + parec50.getText().toString() + "-";}
        if(parec51.isChecked()){cadena += "" + parec51.getText().toString() + "-";}
        if(parec52.isChecked()){cadena += "" + parec52.getText().toString() + "-";}
        if(parec53.isChecked()){cadena += "" + parec53.getText().toString() + "-";}
        if(parec54.isChecked()){cadena += "" + parec54.getText().toString() + "-";}
        if(parec55.isChecked()){cadena += "" + parec55.getText().toString() + "-";}
        if(parec56.isChecked()){cadena += "" + parec56.getText().toString() + "-";}
        if(parec57.isChecked()){cadena += "" + parec57.getText().toString() + "-";}
        if(parec58.isChecked()){cadena += "" + parec58.getText().toString() + "-";}
        if(parec59.isChecked()){cadena += "" + parec59.getText().toString() + "-";}
        if(parec60.isChecked()){cadena += "" + parec60.getText().toString() + "-";}
        if(parec61.isChecked()){cadena += "" + parec61.getText().toString() + "-";}
        if(parec62.isChecked()){cadena += "" + parec62.getText().toString() + "-";}
        if(parec63.isChecked()){cadena += "" + parec63.getText().toString() + "-";}
        if(pa63_1.isChecked()){cadena += "" + pa63_1.getText().toString() + "-";}
        if(pa63_2.isChecked()){cadena += "" + pa63_2.getText().toString() + "-";}
        if(pa63_3.isChecked()){cadena += "" + pa63_3.getText().toString() + "-";}
        if(pa63_4.isChecked()){cadena += "" + pa63_4.getText().toString() + "-";}
        if(pa63_5.isChecked()){cadena += "" + pa63_5.getText().toString() + "-";}
        if(pa63_6.isChecked()){cadena += "" + pa63_6.getText().toString() + "-";}
        if(pa63_7.isChecked()){cadena += "" + pa63_7.getText().toString() + "-";}
        if(pa63_8.isChecked()){cadena += "" + pa63_8.getText().toString() + "-";}
        if(pa63_9.isChecked()){cadena += "" + pa63_9.getText().toString() + "-";}
        if(pa63_10.isChecked()){cadena += "" + pa63_10.getText().toString() + "-";}
        if(pa63_11.isChecked()){cadena += "" + pa63_11.getText().toString() + "-";}
        if(pa63_12.isChecked()){cadena += "" + pa63_12.getText().toString() + "-";}
        if(pa63_13.isChecked()){cadena += "" + pa63_13.getText().toString() + "-";}
        if(pa63_14.isChecked()){cadena += "" + pa63_14.getText().toString() + "-";}
        if(pa63_15.isChecked()){cadena += "" + pa63_15.getText().toString() + "-";}
        if(pa63_16.isChecked()){cadena += "" + pa63_16.getText().toString() + "-";}
        if(pa63_17.isChecked()){cadena += "" + pa63_17.getText().toString() + "-";}
        if(pa63_18.isChecked()){cadena += "" + pa63_18.getText().toString() + "-";}
        if(pa63_19.isChecked()){cadena += "" + pa63_19.getText().toString() + "-";}
        if(pa63_20.isChecked()){cadena += "" + pa63_20.getText().toString() + "-";}
        if(pa63_21.isChecked()){cadena += "" + pa63_21.getText().toString() + "-";}
        if(pa63_22.isChecked()){cadena += "" + pa63_22.getText().toString() + "-";}
        if(pa63_23.isChecked()){cadena += "" + pa63_23.getText().toString() + "-";}
        if(pa63_24.isChecked()){cadena += "" + pa63_24.getText().toString() + "-";}
        if(pa63_25.isChecked()){cadena += "" + pa63_25.getText().toString() + "-";}
        if(pa63_26.isChecked()){cadena += "" + pa63_26.getText().toString() + "-";}
        if(pa63_27.isChecked()){cadena += "" + pa63_27.getText().toString() + "-";}
        if(pa63_28.isChecked()){cadena += "" + pa63_28.getText().toString() + "-";}
        if(pa63_29.isChecked()){cadena += "" + pa63_29.getText().toString() + "-";}
        if(pa63_30.isChecked()){cadena += "" + pa63_30.getText().toString() + "-";}
        if(pa63_31.isChecked()){cadena += "" + pa63_31.getText().toString() + "-";}
        if(pa63_32.isChecked()){cadena += "" + pa63_32.getText().toString() + "-";}
        if(pa63_33.isChecked()){cadena += "" + pa63_33.getText().toString() + "-";}
        if(pa63_34.isChecked()){cadena += "" + pa63_34.getText().toString() + "-";}
        if(pa63_35.isChecked()){cadena += "" + pa63_35.getText().toString() + "-";}
        if(pa63_36.isChecked()){cadena += "" + pa63_36.getText().toString() + "-";}
        if(pa63_37.isChecked()){cadena += "" + pa63_37.getText().toString() + "-";}
        if(pa63_38.isChecked()){cadena += "" + pa63_38.getText().toString() + "-";}
        if(pa63_39.isChecked()){cadena += "" + pa63_39.getText().toString() + "-";}
        if(pa63_40.isChecked()){cadena += "" + pa63_40.getText().toString() + "-";}
        if(pa63_41.isChecked()){cadena += "" + pa63_41.getText().toString() + "-";}
        if(pa63_42.isChecked()){cadena += "" + pa63_42.getText().toString() + "-";}
        if(pa63_43.isChecked()){cadena += "" + pa63_43.getText().toString() + "-";}
        if(pa63_44.isChecked()){cadena += "" + pa63_44.getText().toString() + "-";}
        if(pa63_45.isChecked()){cadena += "" + pa63_45.getText().toString() + "-";}
        if(pa63_46.isChecked()){cadena += "" + pa63_46.getText().toString() + "-";}
        if(pa63_47.isChecked()){cadena += "" + pa63_47.getText().toString() + "-";}
        if(pa63_48.isChecked()){cadena += "" + pa63_48.getText().toString() + "-";}
        if(pa63_49.isChecked()){cadena += "" + pa63_49.getText().toString() + "-";}
        if(pa63_50.isChecked()){cadena += "" + pa63_50.getText().toString() + "-";}
        if(pa63_51.isChecked()){cadena += "" + pa63_51.getText().toString() + "-";}
        if(pa63_52.isChecked()){cadena += "" + pa63_52.getText().toString() + "-";}
        if(pa63_53.isChecked()){cadena += "" + pa63_53.getText().toString() + "-";}
        if(pa63_54.isChecked()){cadena += "" + pa63_54.getText().toString() + "-";}
        if(pa63_55.isChecked()){cadena += "" + pa63_55.getText().toString() + "-";}
        if(pa63_56.isChecked()){cadena += "" + pa63_56.getText().toString() + "-";}
        if(pa63_57.isChecked()){cadena += "" + pa63_57.getText().toString() + "-";}



        resultado3 = cadena.substring(0, cadena.length()-1);
        return resultado3;
    }

    public String capa4() {
        String cadena = "";
        String resultado4 = "";

        if(parec64.isChecked()){cadena += "" + parec64.getText().toString() + "-";}
        if(parec65.isChecked()){cadena += "" + parec65.getText().toString() + "-";}
        if(parec66.isChecked()){cadena += "" + parec66.getText().toString() + "-";}
        if(parec67.isChecked()){cadena += "" + parec67.getText().toString() + "-";}
        if(parec68.isChecked()){cadena += "" + parec68.getText().toString() + "-";}
        if(parec69.isChecked()){cadena += "" + parec69.getText().toString() + "-";}
        if(parec70.isChecked()){cadena += "" + parec70.getText().toString() + "-";}
        if(parec71.isChecked()){cadena += "" + parec71.getText().toString() + "-";}
        if(parec72.isChecked()){cadena += "" + parec72.getText().toString() + "-";}
        if(parec73.isChecked()){cadena += "" + parec73.getText().toString() + "-";}
        if(parec74.isChecked()){cadena += "" + parec74.getText().toString() + "-";}
        if(parec75.isChecked()){cadena += "" + parec75.getText().toString() + "-";}
        if(parec76.isChecked()){cadena += "" + parec76.getText().toString() + "-";}
        if(parec77.isChecked()){cadena += "" + parec77.getText().toString() + "-";}
        if(parec78.isChecked()){cadena += "" + parec78.getText().toString() + "-";}
        if(parec79.isChecked()){cadena += "" + parec79.getText().toString() + "-";}
        if(parec80.isChecked()){cadena += "" + parec80.getText().toString() + "-";}
        if(parec81.isChecked()){cadena += "" + parec81.getText().toString() + "-";}
        if(parec82.isChecked()){cadena += "" + parec82.getText().toString() + "-";}
        if(parec83.isChecked()){cadena += "" + parec83.getText().toString() + "-";}
        if(parec84.isChecked()){cadena += "" + parec84.getText().toString() + "-";}
        if(parec85.isChecked()){cadena += "" + parec85.getText().toString() + "-";}
        if(parec86.isChecked()){cadena += "" + parec86.getText().toString() + "-";}
        if(parec87.isChecked()){cadena += "" + parec87.getText().toString() + "-";}
        if(parec88.isChecked()){cadena += "" + parec88.getText().toString() + "-";}
        if(parec89.isChecked()){cadena += "" + parec89.getText().toString() + "-";}
        if(parec90.isChecked()){cadena += "" + parec90.getText().toString() + "-";}
        if(parec91.isChecked()){cadena += "" + parec91.getText().toString() + "-";}
        if(parec92.isChecked()){cadena += "" + parec92.getText().toString() + "-";}
        if(parec93.isChecked()){cadena += "" + parec93.getText().toString() + "-";}
        if(parec94.isChecked()){cadena += "" + parec94.getText().toString() + "-";}
        if(parec95.isChecked()){cadena += "" + parec95.getText().toString() + "-";}
        if(parec96.isChecked()){cadena += "" + parec96.getText().toString() + "-";}
        if(parec97.isChecked()){cadena += "" + parec97.getText().toString() + "-";}
        if(parec98.isChecked()){cadena += "" + parec98.getText().toString() + "-";}
        if(parec99.isChecked()){cadena += "" + parec99.getText().toString() + "-";}
        if(parec100.isChecked()){cadena += "" + parec100.getText().toString() + "-";}
        if(parec101.isChecked()){cadena += "" + parec101.getText().toString() + "-";}
        if(parec102.isChecked()){cadena += "" + parec102.getText().toString() + "-";}
        if(parec103.isChecked()){cadena += "" + parec103.getText().toString() + "-";}
        if(parec104.isChecked()){cadena += "" + parec104.getText().toString() + "-";}
        if(parec105.isChecked()){cadena += "" + parec105.getText().toString() + "-";}
        if(parec106.isChecked()){cadena += "" + parec106.getText().toString() + "-";}
        if(parec107.isChecked()){cadena += "" + parec107.getText().toString() + "-";}
        if(parec108.isChecked()){cadena += "" + parec108.getText().toString() + "-";}
        if(parec109.isChecked()){cadena += "" + parec109.getText().toString() + "-";}
        if(parec110.isChecked()){cadena += "" + parec110.getText().toString() + "-";}
        if(pa110_1.isChecked()){cadena += "" + pa110_1.getText().toString() + "-";}
        if(pa110_2.isChecked()){cadena += "" + pa110_2.getText().toString() + "-";}
        if(pa110_3.isChecked()){cadena += "" + pa110_3.getText().toString() + "-";}
        if(pa110_4.isChecked()){cadena += "" + pa110_4.getText().toString() + "-";}
        if(pa110_5.isChecked()){cadena += "" + pa110_5.getText().toString() + "-";}
        if(pa110_6.isChecked()){cadena += "" + pa110_6.getText().toString() + "-";}
        if(pa110_7.isChecked()){cadena += "" + pa110_7.getText().toString() + "-";}
        if(pa110_8.isChecked()){cadena += "" + pa110_8.getText().toString() + "-";}
        if(pa110_9.isChecked()){cadena += "" + pa110_9.getText().toString() + "-";}
        if(pa110_10.isChecked()){cadena += "" + pa110_10.getText().toString() + "-";}
        if(pa110_11.isChecked()){cadena += "" + pa110_11.getText().toString() + "-";}
        if(pa110_12.isChecked()){cadena += "" + pa110_12.getText().toString() + "-";}
        if(pa110_13.isChecked()){cadena += "" + pa110_13.getText().toString() + "-";}
        if(pa110_14.isChecked()){cadena += "" + pa110_14.getText().toString() + "-";}
        if(pa110_15.isChecked()){cadena += "" + pa110_15.getText().toString() + "-";}
        if(pa110_16.isChecked()){cadena += "" + pa110_16.getText().toString() + "-";}
        if(pa110_17.isChecked()){cadena += "" + pa110_17.getText().toString() + "-";}
        if(pa110_18.isChecked()){cadena += "" + pa110_18.getText().toString() + "-";}
        if(pa110_19.isChecked()){cadena += "" + pa110_19.getText().toString() + "-";}
        if(pa110_20.isChecked()){cadena += "" + pa110_20.getText().toString() + "-";}
        if(pa110_21.isChecked()){cadena += "" + pa110_21.getText().toString() + "-";}
        if(pa110_22.isChecked()){cadena += "" + pa110_22.getText().toString() + "-";}
        if(pa110_23.isChecked()){cadena += "" + pa110_23.getText().toString() + "-";}
        if(pa110_24.isChecked()){cadena += "" + pa110_24.getText().toString() + "-";}
        if(pa110_25.isChecked()){cadena += "" + pa110_25.getText().toString() + "-";}
        if(pa110_26.isChecked()){cadena += "" + pa110_26.getText().toString() + "-";}
        if(pa110_27.isChecked()){cadena += "" + pa110_27.getText().toString() + "-";}
        if(pa110_28.isChecked()){cadena += "" + pa110_28.getText().toString() + "-";}
        if(pa110_29.isChecked()){cadena += "" + pa110_29.getText().toString() + "-";}
        if(pa110_30.isChecked()){cadena += "" + pa110_30.getText().toString() + "-";}
        if(pa110_31.isChecked()){cadena += "" + pa110_31.getText().toString() + "-";}
        if(pa110_32.isChecked()){cadena += "" + pa110_32.getText().toString() + "-";}
        if(pa110_33.isChecked()){cadena += "" + pa110_33.getText().toString() + "-";}
        if(pa110_34.isChecked()){cadena += "" + pa110_34.getText().toString() + "-";}
        if(pa110_35.isChecked()){cadena += "" + pa110_35.getText().toString() + "-";}
        if(pa110_36.isChecked()){cadena += "" + pa110_36.getText().toString() + "-";}
        if(pa110_37.isChecked()){cadena += "" + pa110_37.getText().toString() + "-";}
        if(pa110_38.isChecked()){cadena += "" + pa110_38.getText().toString() + "-";}
        if(pa110_39.isChecked()){cadena += "" + pa110_39.getText().toString() + "-";}
        if(pa110_40.isChecked()){cadena += "" + pa110_40.getText().toString() + "-";}
        if(pa110_41.isChecked()){cadena += "" + pa110_41.getText().toString() + "-";}
        if(pa110_42.isChecked()){cadena += "" + pa110_42.getText().toString() + "-";}
        if(pa110_43.isChecked()){cadena += "" + pa110_43.getText().toString() + "-";}
        if(pa110_44.isChecked()){cadena += "" + pa110_44.getText().toString() + "-";}
        if(pa110_45.isChecked()){cadena += "" + pa110_45.getText().toString() + "-";}
        if(pa110_46.isChecked()){cadena += "" + pa110_46.getText().toString() + "-";}
        if(pa110_47.isChecked()){cadena += "" + pa110_47.getText().toString() + "-";}
        if(pa110_48.isChecked()){cadena += "" + pa110_48.getText().toString() + "-";}
        if(pa110_49.isChecked()){cadena += "" + pa110_49.getText().toString() + "-";}
        if(pa110_50.isChecked()){cadena += "" + pa110_50.getText().toString() + "-";}
        if(pa110_51.isChecked()){cadena += "" + pa110_51.getText().toString() + "-";}
        if(pa110_52.isChecked()){cadena += "" + pa110_52.getText().toString() + "-";}
        if(pa110_53.isChecked()){cadena += "" + pa110_53.getText().toString() + "-";}
        if(pa110_54.isChecked()){cadena += "" + pa110_54.getText().toString() + "-";}
        if(pa110_55.isChecked()){cadena += "" + pa110_55.getText().toString() + "-";}
        if(pa110_56.isChecked()){cadena += "" + pa110_56.getText().toString() + "-";}
        if(pa110_57.isChecked()){cadena += "" + pa110_57.getText().toString() + "-";}

        resultado4 = cadena.substring(0, cadena.length() - 1);
        return resultado4;
    }



    public void eventos34(){
        findViewById(R.id.par_et_ch15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parec15.isChecked()==true){
                    paret008.setVisibility(View.VISIBLE);
                }else{
                    paret008.setVisibility(View.GONE);
                    paret008.setText("");
                }
            }
        });
    }

    public void eventos33(){
        findViewById(R.id.par_et_ch7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parec7.isChecked()==true){
                    paret08.setVisibility(View.VISIBLE);
                }else{
                    paret08.setVisibility(View.GONE);
                    paret08.setText("");
                }
            }
        });
    }

    public void eventos35(){
        findViewById(R.id.par_et_ra22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parer22.isChecked()==true){
                    paret9.setVisibility(View.VISIBLE);
                }else{
                    paret9.setVisibility(View.GONE);
                    paret9.setText("");
                }
            }
        });
    }

    public void eventos36(){
        findViewById(R.id.par_et_ra29).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parer29.isChecked()==true){
                    paret10.setVisibility(View.VISIBLE);
                }
                if(parer29.isChecked()==false){
                    paret10.setVisibility(View.GONE);
                    paret10.setText("");
                }
            }
        });
    }


    public void eventos38(){
        findViewById(R.id.par_et_ch121).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parec121.isChecked()==true){
                    paret1119.setVisibility(View.VISIBLE);
                }else{
                    paret1119.setVisibility(View.GONE);
                    paret1119.setText("");
                }
            }
        });
    }

    public void eventos39(){
        findViewById(R.id.par_et_ra50).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parer50.isChecked()==true){
                    paret19.setVisibility(View.VISIBLE);
                }else{
                    paret19.setVisibility(View.GONE);
                    paret19.setText("");
                }
            }
        });
    }

    public void eventos40() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (parer22.isChecked() == true) {
                    paret9.setVisibility(View.VISIBLE);
                } else {
                    paret9.setVisibility(View.GONE);
                    paret9.setText("");
                }
            }
        });
    }


    public void eventos41() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (parer29.isChecked() == true) {
                    paret10.setVisibility(View.VISIBLE);
                } else {
                    paret10.setVisibility(View.GONE);
                    paret10.setText("");
                }
            }
        });
    }

    public void eventos42() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group3);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (parer50.isChecked() == true) {
                    paret19.setVisibility(View.VISIBLE);
                } else {
                    paret19.setVisibility(View.GONE);
                    paret19.setText("");
                }
            }
        });
    }

    public void eventos43() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group7);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (parra0.isChecked() == true) {
                    layout.setVisibility(View.GONE);
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    public void eventos44() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group8);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (parer48.isChecked() == true) {
                    paret16.setVisibility(View.VISIBLE);
                } else {
                    paret16.setVisibility(View.GONE);
                    paret16.setText("");
                }
            }
        });
    }



    public void capacitaciones(){
       String nocapa = "0";
       if (parra0.isChecked()){
           nocapa = "0";
           paret8.setText(nocapa);
       }
        if (parra1.isChecked()){
            nocapa = "1";
            paret8.setText(nocapa);
        }
        if (parra2.isChecked()){
            nocapa = "2";
            paret8.setText(nocapa);
        }
        if (parra3.isChecked()){
            nocapa = "3";
            paret8.setText(nocapa);
        }
        if (parra4.isChecked()){
            nocapa = "4";
            paret8.setText(nocapa);
        }
        if (parra5.isChecked()){
            nocapa = "5";
            paret8.setText(nocapa);
        }
        if (parra6.isChecked()){
            nocapa = "6";
            paret8.setText(nocapa);
        }
        if (parra7.isChecked()){
            nocapa = "7";
            paret8.setText(nocapa);
        }

    }





    //Metodo para extraer la fecha actual
    public void muestrafecha(){
        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);
        textFecha.setText(""+dia+"/"+(mes+1)+"/"+anio);
    }

    public void Eventos_Hora(){

        hora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paret17.setText(hora.getSelectedItem().toString() + ":" + min.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        min.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paret17.setText(hora.getSelectedItem().toString() + ":" + min.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hora2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paret18.setText(hora2.getSelectedItem().toString() + ":" + min2.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        min2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paret18.setText(hora2.getSelectedItem().toString() + ":" + min2.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onBackPressed() {

    }



}