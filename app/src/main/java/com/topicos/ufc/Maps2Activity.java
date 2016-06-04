package com.topicos.ufc;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Maps2Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // define objetos de cada cidade
        LatLng mac = new LatLng(-9.638252, -35.722657);
        LatLng rio = new LatLng(-9.978546, -67.828697);
        LatLng ter = new LatLng(-5.076959, -42.761705);
        LatLng nat = new LatLng(-5.783162, -35.203785);
        LatLng joa = new LatLng(-7.126497, -34.846027);

        // posição da câmera e zoom
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom( new LatLng(-10.867955, -52.903767), 2));

        // Linhas de polígono são úteis para marcar caminhos e rotas no mapa.
        googleMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(-9.638252, -35.722657)) // Maceio - AL
                .add(new LatLng(-7.126497, -34.846027)) // João Pessoa - PB
                .add(new LatLng(-5.783162, -35.203785)) // Natal - RN
                .add(new LatLng(-5.076959, -42.761705)) // Teresina - PI
                .add(new LatLng(-9.978546, -67.828697)) // Rio Branco - AC
                .add(new LatLng(-9.638252, -35.722657)) // Maceio - AL
        );

        // define estilo de mapa
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // define os marcadores das cidades
        googleMap.addMarker(new MarkerOptions().title("Maceió")
                .snippet("1º Lugar").position(mac));
        googleMap.addMarker(new MarkerOptions().title("Rio Branco")
                .snippet("2º Lugar").position(rio));
        googleMap.addMarker(new MarkerOptions().title("Teresina")
                .snippet("3º Lugar").position(ter));
        googleMap.addMarker(new MarkerOptions().title("Natal")
                .snippet("4º Lugar").position(nat));
        googleMap.addMarker(new MarkerOptions().title("João Pessoa")
                .snippet("5º Lugar").position(joa));
    }
}
