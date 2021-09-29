package com.example.geosegalmex.drawer.fragment_drawer;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geosegalmex.Gps.GpsEnableb;
import com.example.geosegalmex.Principal;
import com.example.geosegalmex.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment  implements OnMapReadyCallback {

    private GoogleMap mMap;

    private int MY_REQUEST_PERMISSION_ACCESS_FINE_LOCATION = 1;

    ExtendedFloatingActionButton fabExt;

    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mapa, container, false);
        View vistaMapaDrawer = inflater.inflate(R.layout.fragment_mapa, container, false);

        fabExt = vistaMapaDrawer.findViewById(R.id.fab_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_drawer);
        mapFragment.getMapAsync(this);

        getPermissions();


        if(Principal.checkUser == 1){
            fabExt.setEnabled(false);
        }else if(Principal.checkUser == 2){
            fabExt.setEnabled(true);
        }


        fabExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GpsEnableb.class));
            }
        });
        return vistaMapaDrawer;
    }


    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // LatLng mexico = new LatLng(22.4830037,-120.9296288 );
        LatLng mexico = new LatLng(20.6691817,-106.0287192);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));



        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_REQUEST_PERMISSION_ACCESS_FINE_LOCATION) {
            if (permissions.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
    }




}
