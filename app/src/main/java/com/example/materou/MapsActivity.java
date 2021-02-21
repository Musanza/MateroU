package com.example.materou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_maps);
        getSupportActionBar().setTitle((CharSequence) getIntent().getStringExtra("actionBarTitle"));
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        Intent intent = getIntent();
        LatLng kapata = new LatLng(Double.parseDouble(intent.getStringExtra("latitudeTv")), Double.parseDouble(intent.getStringExtra("longitudeTv")));
        this.mMap.addMarker(new MarkerOptions().position(kapata).title(intent.getStringExtra("actionBarTitle")));
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(kapata));
        this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kapata, 16.0f));
    }
}