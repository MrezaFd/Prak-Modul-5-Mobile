package com.example.mymaps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng smp = new LatLng(-2.158035, 115.3863936);
        mMap.addMarker(new MarkerOptions().position(smp).title("SMP NEGERI 2 TANJUNG"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(smp));

        LatLng smp1 = new LatLng( -2.158176, 115.388128);
        mMap.addMarker(new MarkerOptions().position(smp1).title("SMP NEGERI 1 TANJUNG"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(smp1));

        mMap.addPolyline(new PolylineOptions().add(
                smp,
                new LatLng(-2.158035, 115.3863936),
                new LatLng(-2.157781, 115.386696),
                new LatLng(-2.157961, 115.387591),
                new LatLng(-2.157747, 115.387620),
                new LatLng(-2.157824, 115.388192),
                new LatLng(-2.158176, 115.388128),
                smp1
        ).color(Color.RED)
        );
    }
}
