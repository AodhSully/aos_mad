package com.example.marvin.lotrmapnew;



        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.FragmentActivity;
        import android.widget.Toast;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.Marker;
        import com.google.android.gms.maps.model.MarkerOptions;


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

        // Add a marker in London
        LatLng KingsLanding = new LatLng(51.515419, -0.141099);
        // Marker KingsLandingMarker  =
        final Marker KingsLandingMarker = mMap.addMarker(new MarkerOptions().position(KingsLanding).title("Kings Landing"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(london));

        // Add a marker in Bath
        LatLng HighGarden = new LatLng(51.3801748, -2.3995494);
        final Marker HighGardenMarker = mMap.addMarker(new MarkerOptions().position(HighGarden).title("High Garden"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(bath));

        // Add a marker in Manchester
        LatLng Winterfell = new LatLng(53.9586419, -1.115611);
        final Marker Winterfell_Marker = mMap.addMarker(new MarkerOptions().position(Winterfell).title("Winterfell"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(rohan));

        // Add a marker in Scotland
        LatLng TheWall = new LatLng(54.9899016, -2.6717341);
        final Marker TheWallMarker = mMap.addMarker(new MarkerOptions().position(TheWall).title("The Wall"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TheWall));

        // Add a marker in Wales
        LatLng riverrunMarker = new LatLng(52.477564, -2.003715);
        final Marker RiverrunMarker = mMap.addMarker(new MarkerOptions().position(riverrunMarker).title("Riverrun"));


        LatLng britain = new LatLng(55.3781, -3.4360);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(britain, 5));

        mMap.setOnMarkerClickListener( new GoogleMap.OnMarkerClickListener(){


            public boolean onMarkerClick(final Marker marker) {

                if (marker.equals(KingsLandingMarker))
                {
                    Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                    startActivity(i);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(MapsActivity.this,
                            "Kings Landing is your favourite place in Westeros", Toast.LENGTH_SHORT).show();
                }

                if (marker.equals(HighGardenMarker))
                {
                    Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                    startActivity(i);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(MapsActivity.this,
                            "High Garden is your favourite location in Westeros", Toast.LENGTH_SHORT).show();
                }

                if (marker.equals(Winterfell_Marker))
                {
                    Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                    startActivity(i);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(MapsActivity.this,
                            "Winterfell is your favourite location in Westeros", Toast.LENGTH_SHORT).show();
                }

                if (marker.equals(TheWallMarker))
                {

                    Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                    startActivity(i);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(MapsActivity.this,
                            "The Wall is your favourite location in Westeros", Toast.LENGTH_SHORT).show();
                }

                if (marker.equals(RiverrunMarker))
                {

                    Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                    startActivity(i);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(MapsActivity.this,
                            "Riverrun is your favourite location in Middle Earth", Toast.LENGTH_SHORT).show();
                }

                return false;
            }



        });
    }
}










