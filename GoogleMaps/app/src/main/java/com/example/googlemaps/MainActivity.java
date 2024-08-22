package com.example.googlemaps;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.material.shape.MarkerEdgeTreatment;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        myMap = googleMap;

        LatLng sydney = new LatLng(-34, 151);

        MarkerOptions markerOptions = new MarkerOptions().position(sydney).title("Sydney");


        myMap.addMarker(markerOptions);

//        myMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16f));
        //zoom 16 to 20


        //Map Overlay
        //Circle
        myMap.addCircle(new CircleOptions()
                .center(sydney)
                .radius(1000)
                .fillColor(Color.RED)
                .strokeColor(Color.DKGRAY));
        //Polygon
        myMap.addPolygon(new PolygonOptions().add(new LatLng(0, 0),
                new LatLng(-34, 150),
                new LatLng(150, 100),
                new LatLng(100, -34),
                new LatLng(0, 120)).fillColor(Color.YELLOW).strokeColor(Color.BLUE));

        //Error
//        myMap.addGroundOverlay(new GroundOverlayOptions()
//                        .position(sydney, 1000f,1000f)
//                        .image(BitmapDescriptorFactory.fromResource(R.drawable.ic_android_black_24dp))
//                        .clickable(true));

        myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        myMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Clicked here");


                myMap.addMarker(markerOptions);
                Geocoder geocoder = new Geocoder(MainActivity.this);
                try {
                    ArrayList<Address> arrAdr = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    Log.d("Addr",arrAdr.get(0).getAddressLine(0));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });




    }


}