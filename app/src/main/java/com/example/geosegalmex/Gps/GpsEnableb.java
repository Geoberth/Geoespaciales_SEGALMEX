package com.example.geosegalmex.Gps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.General;
import com.example.geosegalmex.NewCamara;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GpsEnableb extends AppCompatActivity {
    private int verificarConexionGps = 0;
    LocationManager locationManager;
    double longitudeBest, latitudeBest;
    double longitudeGPS, latitudeGPS;
    double longitudeNetwork, latitudeNetwork;
    TextView longitudeValueBest, latitudeValueBest;
    public TextView longitudeValueGPS, latitudeValueGPS;
    TextView longitudeValueNetwork, latitudeValueNetwork;
    Button botonStop;
    Button btnGPsEna;
    TextView txtlat, txtlon;
    TextView bertbeth, bertbeth2, lizlatit, lizlongi;
    TextView textid;

    private DatabaseHelper db;
    private List<Trayectoria> trayectoriaList;
    Boolean chekGetGPs;

    private int dia, mes, anio, hora, minutos, segundos;
    String fechaActual;
    String horaActual;
    Spinner proyecto;
    public String folioo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_enableb);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        trayectoriaList = new ArrayList<>();
        db         = new DatabaseHelper(this);

        longitudeValueGPS = (TextView) findViewById(R.id.longitudeValueGPS);
        latitudeValueGPS = (TextView) findViewById(R.id.latitudeValueGPS);
        botonStop = findViewById(R.id.locationControllerGPS);
        btnGPsEna = findViewById(R.id.btn_ena_gps);

        txtlat = (TextView) findViewById(R.id.textlat);
        txtlon = (TextView) findViewById(R.id.textlon);

        bertbeth = (TextView) findViewById(R.id.bertbethgps);
        bertbeth2 = (TextView) findViewById(R.id.bertbeth2gps);
        lizlatit = (TextView) findViewById(R.id.textlati);
        lizlongi = (TextView) findViewById(R.id.textlongi);

        bertbeth.setVisibility(View.VISIBLE);
        bertbeth2.setVisibility(View.GONE);
        lizlatit.setVisibility(View.GONE);
        lizlongi.setVisibility(View.GONE);

        textid = (TextView) findViewById(R.id.textMuestrafolioo);

        //+++++++++++++++++++++Fecha +++++++++++++++++++++++

        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);

        String an = String.valueOf(anio);
        String anior = an.substring(2,4);

        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);

        //SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();

        fechaActual = format1.format(date);

        String hor;

        if (hora < 10) {
            hor = "0" + hora;
        }else
            hor = "" + hora;


        if(minutos < 10 ){
            String min = "0" + minutos;
            if (segundos < 10){
                String seg = "0" + segundos;
                horaActual=(String.format(hor+":"+min+":"+seg));
            }else
                horaActual=(String.format(hor+":"+min+":"+segundos));
        }else
        if (segundos < 10) {
            String seg = "0" + segundos;
            horaActual=(String.format(hor + ":" + minutos + ":" + seg));
        }else
            horaActual=(String.format(hor+":"+minutos+":"+segundos));

        //horaActual= (String.format("%d:%d:%d", hora, minutos, segundos));

        obtenFoliodos();
        textid.setText("FA"+folioo);
        proyecto = (Spinner)findViewById(R.id.spiproyectogeo);
        proyecto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        textid.setText("FA"+folioo);
                        break;
                    case 1:
                        textid.setText("ES"+folioo);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnGPsEna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager.removeUpdates(locationListenerGPS);
                if (chekGetGPs == true) {
                    General.Foliocuestion=textid.getText().toString();
                    aggTrayectoriaGps();
                    General.Proyecto = proyecto.getSelectedItem().toString();
                    startActivity(new Intent(getApplication(), NewCamara.class));
                }
            }
        });

        autoMatico();

    }



    public void obtenFoliodos(){
        //String cveMunicipio = General.Municipioaguasc;

        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);

        String an = String.valueOf(anio);
        String anior = an.substring(2,4);

        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);

        String hor;
        String horaID;


        String mesid, diaid;

        //FECHA NORMALIZACION
        if (mes < 10) {
            mesid = "0" + (mes+1);
        }else
            mesid = "" + (mes+1);

        if (dia < 10) {
            diaid = "0" + dia;
        }else
            diaid = "" + dia;

        //HORA NORMALIZACION
        if (hora < 10) {
            hor = "0" + hora;
        }else
            hor = "" + hora;


        if(minutos < 10 ){
            String min = "0" + minutos;
            if (segundos < 10){
                String seg = "0" + segundos;
                horaID = hor+min+seg;
            }else
                horaID = hor+min+segundos;
        }else
        if (segundos < 10) {
            String seg = "0" + segundos;
            horaID = hor  + minutos + seg;
        }else
            horaID = hor+minutos+segundos;


        //foli = "DR" +"01"+"777"+dia+(mes+1)+anior+hora+minutos+segundos;
            //folioo = "FA" +dia+(mes+1)+anior+hora+minutos+segundos;
        folioo = ""+diaid+mesid+anior+horaID;
            //General.Foliocuestion = folioo;
            //   General.banderaFolio = true;

            //System.out.println("Folio1 ==>>" + General.Foliocuestion.toString());

        //textid.setText(General.Foliocuestion);
           // System.out.println("Folio2 ==>>" + General.Foliocuestion.toString());
            //Toast.makeText(getApplicationContext(), "ID generado", Toast.LENGTH_SHORT).show();

    }



    private void aggTrayectoriaGps() {
        int i;
        String folioPro;
        String folioBrig;
        String longGpsSave;
        String latiGpsSave;
        String horaActualDos;
        for(i=0; i < trayectoriaList.size(); i++){

            folioPro = trayectoriaList.get(i).getFolioproductor();
            folioBrig = trayectoriaList.get(i).getFoliotecnico();
            longGpsSave = trayectoriaList.get(i).getLongitud();
            latiGpsSave = trayectoriaList.get(i).getLatitud();
            horaActualDos = trayectoriaList.get(i).getHoraTrayectoria();

            aggTrayectoriaGpsSave(folioPro, folioBrig, longGpsSave, latiGpsSave, horaActualDos, fechaActual );
        }
    }

    private void aggTrayectoriaGpsSave(String folioPro, String folioBrig, String longGpsSave, String latiGpsSave, String horaActl, String fechaActl) {

        boolean insertarData = db.addTrayectoriaS(folioPro, folioBrig, longGpsSave, latiGpsSave, horaActl, fechaActl);
        //boolean insertarData = db.addTrayectoriaS(folioPro, folioBrig, latiGpsSave,longGpsSave, horaActl, fechaActl);
        db.close();
        if(insertarData == true) {
            // Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            // Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    private boolean checkLocation() {
        if (!isLocationEnabled()) {
//            verificarConexionGps = 1;
            showAlert();
            Toast.makeText(this, "DatosDosss:", Toast.LENGTH_SHORT).show();

            /*
            GpsTrayectoria actividad;
            public GpsTrayectoria getActividad {
                return  actividad;
            }

             */
            //startActivity(new Intent(GpsTrayectoria.this, GpsTrayectoria.class));
            //do{
            //isLocationEnabled();
            //autoMatico();
            despuesGps();
            Log.i("texto","ciclo, ciclo");
            //}while (isLocationEnabled() == false);



            return isLocationEnabled();
            /*
            Boolean chekk = checkIfLocationOpened();
            if (chekk == true){
                return isLocationEnabled();
            }


             */

            // if(verificarConexionGps == 1){
            //     return isLocationEnabled();
            // }
            /*
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
                return isLocationEnabled();
            }

             */

        }

        return isLocationEnabled();
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Su ubicación esta desactivada.\npor favor active su ubicación " +
                        "usa esta app")
                .setPositiveButton("Configuración de ubicación", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });

        verificarConexionGps = 1;
        dialog.show();
        Toast.makeText(this, "Datos:", Toast.LENGTH_SHORT).show();
    }


    private boolean checkIfLocationOpened() {
        String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        System.out.println("Provider contains=> " + provider);
        if (provider.contains("gps") || provider.contains("network")){
            Toast.makeText(this, "Datos:", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    public void despuesGps(){

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListenerGPS);

    }

    public void autoMatico() {
        if (!checkLocation())
            return;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2 * 20 * 1000, 10, locationListenerGPS);

       /*
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }

        */
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, locationListenerGPS);

    }

    public static String lizlati, lizlong;


    private final LocationListener locationListenerGPS = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitudeGPS = location.getLongitude();
            latitudeGPS = location.getLatitude();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    bertbeth.setVisibility(View.GONE);
                    bertbeth2.setVisibility(View.VISIBLE);
                    lizlatit.setVisibility(View.VISIBLE);
                    lizlongi.setVisibility(View.VISIBLE);



                    txtlat.setText(latitudeGPS + "");
                    txtlon.setText(longitudeGPS + "");


                    lizlati = txtlat.getText().toString();
                    lizlong = txtlon.getText().toString();

                    //longitudeValueGPS.setText(longitudeGPS + "");
                    //latitudeValueGPS.setText(latitudeGPS + "");
                    //Aqui se obtiene el valor de las latitudes
                    int horados, minutosdos, segundosdos;

                    if(longitudeGPS != 0 && latitudeGPS != 0){
                        btnGPsEna.setEnabled(true);
                        String lonGpsSt = String.valueOf(longitudeGPS);
                        String latiGpsSt = String.valueOf(latitudeGPS);

                        //Hora 11/12/2019
                        String horaActualDos;
                        Calendar fechados = Calendar.getInstance();
                        horados = fechados.get(Calendar.HOUR_OF_DAY);
                        minutosdos = fechados.get(Calendar.MINUTE);
                        segundosdos = fechados.get(Calendar.SECOND);


                        String hor;

                        if (hora < 10) {
                            hor = "0" + hora;
                        }else
                            hor = "" + hora;


                        if(minutos < 10 ){
                            String min = "0" + minutos;
                            if (segundos < 10){
                                String seg = "0" + segundos;
                                horaActualDos=(String.format(hor+":"+min+":"+seg));
                            }else
                                horaActualDos=(String.format(hor+":"+min+":"+segundos));
                        }else
                        if (segundos < 10) {
                            String seg = "0" + segundos;
                            horaActualDos=(String.format(hor + ":" + minutos + ":" + seg));
                        }else
                            horaActualDos=(String.format(hor+":"+minutos+":"+segundos));


                       // horaActualDos= (String.format("%d:%d:%d", horados, minutosdos, segundosdos));

                        //Trayectoria trayectoria = new Trayectoria("folioPrueba","foliotecnio",lonGpsSt,latiGpsSt, horaActual, fechaActual);
                        Trayectoria trayectoria = new Trayectoria("folioPrueba","foliotecnio",lonGpsSt,latiGpsSt, horaActualDos, fechaActual);
                        trayectoriaList.add(trayectoria);
                        chekGetGPs = true;
                    }
                    Toast.makeText(getApplication(), "Longitud:"+longitudeGPS +"Latitud:"+ latitudeGPS, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
            /*
            switch (i) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }

             */
        }


        @Override
        public void onProviderEnabled(String s) {
            //autoMatico();
        }
        @Override
        public void onProviderDisabled(String s) {
        }
    };

    @Override
    public void onBackPressed() {
      //  locationManager.removeUpdates(locationListenerGPS);
     //   startActivity(new Intent(getApplication(), IdentificacionCuestionario.class));
    }
}