package com.example.geosegalmex.Georeferencia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.dbstorage.Georreferencia;
import com.example.geosegalmex.drawer.DrawerActivity;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GeoreferenciaActivity extends AppCompatActivity  implements OnMapReadyCallback {

    //17-10-2019

    public static final int     NAME_SYNCED_WITH_SERVER     = 1;
    public static final int     NAME_NOT_SYNCED_WITH_SERVER = 0;

    private com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper db;
    private List<Georreferencia> georreferenciaList;

    String longitudGeo;
    String latitudGeo;
    //---------

    Location mlocationBeta;
    FusedLocationProviderClient fusedLocationProviderClientBeta;
    private static final int Request_Code = 101;
    Button geoReferenciaSalirGuardarBeta;
    ExtendedFloatingActionButton fabGeoMapa;

    private int dia, mes, anio, hora, minutos, segundos;
    String fechaActual;
    String horaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_georeferencia);

        fusedLocationProviderClientBeta = LocationServices.getFusedLocationProviderClient(this);
        GetlastLocationBeta();

        fabGeoMapa = findViewById(R.id.fab_geomapa);
        db         = new DatabaseHelper(this);

        fabGeoMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplication(), DrawerActivity.class));
            }
        });


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

        /*
        geoReferenciaSalirGuardarBeta = findViewById(R.id.guardar_desde_georeferencia_beta);

        geoReferenciaSalirGuardarBeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplication(), Segunda.class));
                startActivity(new Intent(getApplication(), DrawerActivity.class));
                finish();
            }
        });

         */
    }

    private void GetlastLocationBeta() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_Code);
            return;
        }
        Task<Location> task = fusedLocationProviderClientBeta.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    mlocationBeta = location;
                    Toast.makeText(getApplicationContext(), "Georreferencia guardada"+"\nLongitud:" +mlocationBeta.getLongitude()+"\nLatitud:" + mlocationBeta.getLatitude(), Toast.LENGTH_LONG).show();
                    SupportMapFragment supportMapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapasdos_beta);

                    supportMapFragment.getMapAsync(GeoreferenciaActivity.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(mlocationBeta.getLatitude(), mlocationBeta.getLongitude());

        //17-10-2019
        longitudGeo = String.valueOf(mlocationBeta.getLongitude());
        latitudGeo = String.valueOf(mlocationBeta.getLatitude());

        if(longitudGeo.length()!=0 && latitudGeo.length()!=0){
            agregarGoerreferencia("BrigadistaGeo","ProductorGeo" , longitudGeo, latitudGeo, horaActual, fechaActual,NAME_NOT_SYNCED_WITH_SERVER);
        }else {
            Toast.makeText(getBaseContext(), "Verifica los Datos", Toast.LENGTH_LONG).show();
        }
        //
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Estoy aqui");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,18));
        googleMap.addMarker(markerOptions);


    }

    private void agregarGoerreferencia(String brigadistaGeo, String productorGeo, String longitudGeoGeo, String latitudGeoGeo, String horaActual, String fechaActual, int status) {
        boolean insertarData = db.addGoerreferenciaDos(brigadistaGeo, productorGeo, longitudGeoGeo, latitudGeoGeo, horaActual, fechaActual, status);
        if(insertarData == true) {
           // Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
           // Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case Request_Code:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    GetlastLocationBeta();
                }
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }


}
