package com.example.freemeal2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.freemeal2.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class VolunteerResisterActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button menu_btn_volunteer_resister;

    Button location_btn_volunteer_resister, check_btn_volunteer_resister;
    EditText editText_volunteer_resister;

    MarkerOptions myMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_resister);

        menu_btn_volunteer_resister = findViewById(R.id.menu_btn_volunteer_resister);
        menu_btn_volunteer_resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolunteerResisterActivity.this, UserMenuActivity.class);
                startActivity(intent);
            }
        });


        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_volunteer_resister);
        supportMapFragment.getMapAsync(this);


        //객체 초기화
        editText_volunteer_resister = findViewById(R.id.editText_volunteer_resister);
        location_btn_volunteer_resister = findViewById(R.id.location_btn_volunteer_resister);
        check_btn_volunteer_resister = findViewById(R.id.check_btn_volunteer_resister);

        //위치 확인 버튼 기능 추가
        location_btn_volunteer_resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestMyLocation();
            }
        });

        check_btn_volunteer_resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_volunteer_resister.getText().toString().length() > 0) {
                    Location location = getLocationFromAddress(getApplicationContext(), editText_volunteer_resister.getText().toString());

                    showCurrentLocation(location);
                }
            }
        });
    }



    private Location getLocationFromAddress(Context context, String address) {
        Geocoder geocoder = new Geocoder(context);
        List<Address> addresses;
        Location resLocation = new Location("");
        try {
            addresses = geocoder.getFromLocationName(address, 5);
            if ((addresses == null) || (addresses.size() == 0)) {
                return null;
            }
            Address addressLoc = addresses.get(0);

            resLocation.setLatitude(addressLoc.getLatitude());
            resLocation.setLongitude(addressLoc.getLongitude());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resLocation;
    }

    private void requestMyLocation() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            long minTime = 1000;    //갱신 시간
            float minDistance = 0;  //갱신에 필요한 최소 거리

            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    showCurrentLocation(location);
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void showCurrentLocation(Location location) {
        LatLng curPoint = new LatLng(location.getLatitude(), location.getLongitude());
        String msg = "Latitutde : " + curPoint.latitude
                + "\nLongitude : " + curPoint.longitude;
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        //화면 확대, 숫자가 클수록 확대
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));


    }




    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;


        LatLng location = new LatLng(37.559845, 126.905996);//보릿고개
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("무료급식소 보릿고개");
        markerOptions.snippet("서울시 종로구");
//        markerOptions.snippet("일시: 0월 0일 00시");
        markerOptions.position(location);
        mMap.addMarker(markerOptions);



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));


        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker){
                Intent intent = new Intent(getBaseContext(), VolunteerDetailPopup.class);

                String title=marker.getTitle();
                String address=marker.getSnippet();
                String date="2021.12.31";
                String person="0/3명";

                intent.putExtra("title", title);
                intent.putExtra("address", address);
                intent.putExtra("date", date);
                intent.putExtra("person", person);

                startActivity(intent);
            }

        });


    }

}