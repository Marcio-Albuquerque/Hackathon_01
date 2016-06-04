package com.topicos.ufc;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Maps1Activity extends FragmentActivity implements OnMapReadyCallback {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-15.667121, -47.731388), 4));
        // Linhas de polígono são úteis para marcar caminhos e rotas no mapa.
        googleMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(-23.624569, -46.561561)) // São Caetano do Sul - SP
                .add(new LatLng(-22.599343, -47.875579)) // Águas de São Pedro - SP
                .add(new LatLng(-26.998223, -48.630546)) // Balneário de Camboriú - SC
                .add(new LatLng(-27.573603, -48.480727)) // Florianópolis - SC
                .add(new LatLng(-20.287502, -40.296204)) // Vitória - ES
                .add(new LatLng(-23.624569, -46.561561)) // São Caetano do Sul - SP
        );

        LatLng scs = new LatLng(-23.624569, -46.561561); // São Caetano do Sul - SP
        LatLng asp = new LatLng(-22.599343, -47.875579); // Águas de São Pedro - SP
        LatLng bdc = new LatLng(-26.998223, -48.630546); // Balneário de Camboriú - SC
        LatLng flr = new LatLng(-27.573603, -48.480727); // Florianópolis - SC
        LatLng vtr = new LatLng(-20.287502, -40.296204); // Vitória - ES

        googleMap.addMarker(new MarkerOptions().title("São Caetano do Sul")
                .snippet("1º Lugar").position(scs));
        googleMap.addMarker(new MarkerOptions().title("Águas de São Pedro")
                .snippet("2º Lugar").position(asp));
        googleMap.addMarker(new MarkerOptions().title("Florianópolis")
                .snippet("3º Lugar").position(flr));
        googleMap.addMarker(new MarkerOptions().title("Balneário de Camboriú")
                .snippet("4º Lugar").position(bdc));
        googleMap.addMarker(new MarkerOptions().title("Vitória")
                .snippet("5º Lugar").position(vtr));
    }
}