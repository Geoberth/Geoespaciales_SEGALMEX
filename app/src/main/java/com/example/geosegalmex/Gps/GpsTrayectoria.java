package com.example.geosegalmex.Gps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;

public class GpsTrayectoria extends AppCompatActivity {

    private int verificarConexionGps = 0;
    LocationManager locationManager;
    double longitudeBest, latitudeBest;
    double longitudeGPS, latitudeGPS;
    double longitudeNetwork, latitudeNetwork;
    TextView longitudeValueBest, latitudeValueBest;
    TextView longitudeValueGPS, latitudeValueGPS;
    TextView longitudeValueNetwork, latitudeValueNetwork;
    Button botonStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_trayectoria);

        //verificarConexionGps = 0;

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        longitudeValueGPS = (TextView) findViewById(R.id.longitudeValueGPS);
        latitudeValueGPS = (TextView) findViewById(R.id.latitudeValueGPS);
        botonStop = findViewById(R.id.locationControllerGPS);



        botonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager.removeUpdates(locationListenerGPS);
            }
        });

        autoMatico();

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
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, locationListenerGPS);

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
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListenerGPS);

    }




    private final LocationListener locationListenerGPS = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitudeGPS = location.getLongitude();
            latitudeGPS = location.getLatitude();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    longitudeValueGPS.setText(longitudeGPS + "");
                    latitudeValueGPS.setText(latitudeGPS + "");
                    //Toast.makeText(getApplication(), "GPS Provider update", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplication(), "Datos:"+longitudeGPS +"Latitud:"+ latitudeGPS, Toast.LENGTH_LONG).show();
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
}
