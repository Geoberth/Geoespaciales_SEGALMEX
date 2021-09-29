package com.example.geosegalmex.Geo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.dbstorage.Coordenadas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class GeoFotos extends AppCompatActivity {


    Button botonFoto1;
    Button botonFoto2;
    Button botonSalir;
    Button botonGeo;

    //---------Ruta
    String gpsDireccion;
    String longitud;
    String latitud;
    public static final int     NAME_NOT_SYNCED_WITH_SERVER = 0;
    ArrayList<Coordenadas> coordenadasArrayList;
    final Handler handler = new Handler();
    public static Timer timer;
    TimerTask timerTask;
    View vista;

    //-------------

    Toast toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_fotos);
        botonFoto1 = findViewById(R.id.boton_foto1);
        //sbotonFoto2 = findViewById(R.id.boton_foto2);

        /*
        botonGeo = findViewById(R.id.boton_goe_gps);
        botonSalir = findViewById(R.id.boton_save_datos);

         */

        coordenadasArrayList = new ArrayList<>();


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            localizacionStart();
        }

        startTimer();

        botonFoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toastMessage.cancel();
                startActivity(new Intent(getApplication(), FotoActivityUno.class));
                //finish();
            }
        });


        /*
        botonFoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), FotoActivityDos.class));
                finish();
            }
        });

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), Segunda.class));
                finish();
            }
        });

         */
    }

    @Override
    public void onBackPressed() {
       //toastMessage = Toast.makeText(getApplicationContext(), "Antes de Salir Guarda los Datos", Toast.LENGTH_SHORT);
       //toastMessage.show();
    }

    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        //timer.schedule(timerTask, 1000, 10000); //
        timer.schedule(timerTask, 500, 5000); //
    }

    public void stoptimertask(View vista) {
        //stop the timer, if it's not already null
        //if (timer != null) {
        timer.cancel();
        //  timer = null;
        //}
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {
                        agregarTimeLocal();

                    }
                });
            }
        };
    }

    public void agregarTimeLocal(){
        Toast.makeText(this, "Datos:"+longitud +"Latitud:"+ latitud, Toast.LENGTH_SHORT).show();
    }

    private void localizacionStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
        Local.setMainActivity(this);
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
       // mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);
        //gpsDireccion.setText("Localización agregada");
    }

    public class Localizacion implements LocationListener {
        GeoFotos mainActivity;
        public GeoFotos getMainActivity() {
            return mainActivity;
        }
        public void setMainActivity(GeoFotos mainActivity) {
            this.mainActivity = mainActivity;
        }
        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            loc.getLatitude();
            loc.getLongitude();


            this.mainActivity.setLocation(loc);
        }
        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            // gpsDireccion.setText("GPS Desactivado");
        }

        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            //gpsDireccion.setText("GPS Activado");
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {


            switch (status) {
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
        }
    }

    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    String  textLatitud;
                    String  textLongitud;

                    /*
                    gpsDireccion.setText("Mi direccion es: "
                            + DirCalle.getAddressLine(0) + "\n Longitud: " + loc.getLongitude() + "\n Latitud: " + loc.getLatitude());

                    textLatitud     = String.valueOf(loc.getLatitude());
                    textLongitud    = String.valueOf(loc.getLongitude());

                    latitud.setText(textLatitud);
                    longitud.setText(textLongitud);

                     */
                    longitud = String.valueOf(loc.getLongitude());
                    latitud = String.valueOf(loc.getLatitude());


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
