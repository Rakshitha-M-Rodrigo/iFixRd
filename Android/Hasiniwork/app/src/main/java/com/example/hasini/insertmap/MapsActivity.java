package com.example.hasini.insertmap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.InputStream;

public class MapsActivity extends AppCompatActivity implements GoogleMap.OnMapLongClickListener, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.OnMarkerClickListener, OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks {


    private GoogleMap mMap;
    Marker marker;

    FloatingActionButton fab_mainmenu, fab_settings, fab_bomb, fab_profilepic, fab_flag, fab_beacon, fab_app, fab_bombtype, fab_map, fab_landminetype, fab_blocktype, fab_tire, fab_accident, fab_medical, fab_repair, fab_solved, fab_found, fab_notfound;
    Animation fab_close, fab_open, rotate_clockwise, rotate_anticlockwise, fab_close1, fab_open1, rotate_clockwise1, rotate_anticlockwise1, fab_open2, fab_close2, fab_open3, fab_close3, rotate_clockwise2,
            rotate_anticlockwise2, rotate_clockwise3, rotate_anticlockwise3;
    boolean isOpen, isOpen1, isOpen2, isOpen3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // Create an icon

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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);
        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);



        CameraPosition INIT =
                new CameraPosition.Builder()
                        .target(new LatLng(7.8731, 80.7718))
                        .zoom(20F)
                        .bearing(300F) // orientation
                        .tilt(50F) // viewing angle
                        .build();
        //Initialize Google Play Services


        // use map to move camera into position
        //  mMap.moveCamera( CameraUpdateFactory.newCameraPosition(INIT) );

        //create initial marker
        //    mMap.addMarker( new MarkerOptions()
        // .position( new LatLng(19.0216, 72.8646) )
        //   .title("Location")
        //    .snippet("First Marker")).showInfoWindow();

        fab_mainmenu=(FloatingActionButton)findViewById(R.id.fab_mainmenu);
        fab_map=(FloatingActionButton)findViewById(R.id.fab_map);
        fab_settings=(FloatingActionButton)findViewById(R.id.fab_settings);
        fab_bomb=(FloatingActionButton)findViewById(R.id.fab_bomb);
        fab_app=(FloatingActionButton)findViewById(R.id.fab_app);
        fab_profilepic=(FloatingActionButton)findViewById(R.id.fab_profilepic);
        fab_flag=(FloatingActionButton)findViewById(R.id.fab_flag);
        fab_beacon=(FloatingActionButton)findViewById(R.id.fab_beacon);
        fab_bombtype=(FloatingActionButton)findViewById(R.id.fab_bombtype);
        fab_landminetype=(FloatingActionButton)findViewById(R.id.fab_landminetype);
        fab_blocktype=(FloatingActionButton)findViewById(R.id.fab_blocktype);
        fab_beacon=(FloatingActionButton)findViewById(R.id.fab_beacon);
        fab_accident=(FloatingActionButton)findViewById(R.id.fab_accident);
        fab_tire=(FloatingActionButton)findViewById(R.id.fab_tire);
        fab_medical=(FloatingActionButton)findViewById(R.id.fab_medical);
        fab_found=(FloatingActionButton)findViewById(R.id.fab_found);
        fab_repair=(FloatingActionButton)findViewById(R.id.fab_repair);
        fab_notfound=(FloatingActionButton)findViewById(R.id.fab_notfound);
        fab_solved=(FloatingActionButton)findViewById(R.id.fab_solved);
        fab_open= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fab_open1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open1);
        fab_open2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open2);
        fab_close2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close2);
        fab_close1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close1);
        fab_open3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open3);
        fab_close3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close3);
        rotate_clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_clockwise);
        rotate_anticlockwise=AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_anticlockwise);
        rotate_clockwise1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_clockwise1);
        rotate_anticlockwise1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_anticlockwise1);
        rotate_clockwise2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_clockwise1);
        rotate_anticlockwise2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_anticlockwise1);
        rotate_clockwise3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_clockwise1);
        rotate_anticlockwise3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim. rotate_anticlockwise1);
        fab_mainmenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab_settings.startAnimation(fab_close1);
                    fab_profilepic.startAnimation(fab_close1);
                    fab_app.startAnimation(fab_close1);
                    fab_map.startAnimation(fab_close1);
                    fab_mainmenu.startAnimation(rotate_anticlockwise);
                    fab_settings.setClickable(false);
                    fab_profilepic.setClickable(false);
                    fab_app.setClickable(false);
                    isOpen=false;
                }
                else {
                    fab_settings.startAnimation(fab_open1);
                    fab_profilepic.startAnimation(fab_open1);
                    fab_app.startAnimation(fab_open1);
                    fab_map.startAnimation(fab_open1);
                    fab_mainmenu.startAnimation(rotate_clockwise);
                    fab_settings.setClickable(true);
                    fab_profilepic.setClickable(true);
                    fab_app.setClickable(true);
                    isOpen=true;
                }
            }
        });


        fab_bomb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v1) {
                if(isOpen1){
                    fab_bombtype.startAnimation(fab_close);
                    fab_landminetype.startAnimation(fab_close);
                    fab_blocktype.startAnimation(fab_close);
                    fab_bomb.startAnimation(rotate_anticlockwise1);
                    fab_landminetype.setClickable(false);
                    fab_blocktype.setClickable(false);
                    fab_bombtype.setClickable(false);
                    isOpen1=false;
                }
                else {
                    fab_bombtype.startAnimation(fab_open);
                    fab_landminetype.startAnimation(fab_open);
                    fab_blocktype.startAnimation(fab_open);
                    fab_mainmenu.startAnimation(rotate_clockwise1);
                    fab_bombtype.setClickable(true);
                    fab_blocktype.setClickable(true);
                    fab_bombtype.setClickable(true);
                    isOpen1=true;
                }
            }
        });
        fab_beacon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v1) {
                if(isOpen2){
                    fab_accident.startAnimation(fab_close2);
                    fab_tire.startAnimation(fab_close2);
                    fab_medical.startAnimation(fab_close2);
                    fab_beacon.startAnimation(rotate_anticlockwise2);
                    fab_accident.setClickable(false);
                    fab_tire.setClickable(false);
                    fab_medical.setClickable(false);
                    isOpen2=false;
                }
                else {
                    fab_accident.startAnimation(fab_open2);
                    fab_tire.startAnimation(fab_open2);
                    fab_medical.startAnimation(fab_open2);
                    fab_beacon.startAnimation(rotate_clockwise2);
                    fab_accident.setClickable(true);
                    fab_tire.setClickable(true);
                    fab_medical.setClickable(true);
                    isOpen2=true;
                }
            }
        });
        fab_flag.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v3) {
                if(isOpen3){
                    fab_found.startAnimation(fab_close3);
                    fab_notfound.startAnimation(fab_close3);
                    fab_solved.startAnimation(fab_close3);
                    fab_repair.startAnimation(fab_close3);
                    fab_flag.startAnimation(rotate_anticlockwise3);
                    fab_solved.setClickable(false);
                    fab_repair.setClickable(false);
                    fab_notfound.setClickable(false);
                    fab_medical.setClickable(false);
                    isOpen3=false;
                }
                else {
                    fab_found.startAnimation(fab_open3);
                    fab_notfound.startAnimation(fab_open3);
                    fab_solved.startAnimation(fab_open3);
                    fab_repair.startAnimation(fab_open3);
                    fab_flag.startAnimation(rotate_clockwise3);
                    fab_found.setClickable(true);
                    fab_notfound.setClickable(true);
                    fab_solved.setClickable(true);
                    fab_repair.setClickable(true);
                    isOpen3=true;
                }
            }
        });
        fab_bombtype.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v1) {
                Toast.makeText(MapsActivity.this,
                        "BombType selected", Toast.LENGTH_LONG).show();
            }
         });
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (marker != null) {
            marker.remove();
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        //create new marker when user long clicks
        if (marker != null) {
            marker.remove();
        }
        String description = latLng.toString();
        double entry1 = latLng.longitude;
        double entry2 = latLng.latitude;
        marker=mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true)
                .title(description));
        new Async(entry1, entry2).execute();
        //  Intent intent = new Intent(MapsActivity.this, DisplayLocationActivity.class);
        // startActivity(intent);

        //Intent intent = new Intent(MapsActivity.this, AsyncAccRead.class);
        //startActivity(intent);

        //  showPopup(View v);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker != null) {
            marker.remove();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if (marker != null) {
            marker.remove();
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker != null) {
            marker.remove();
        }
        LatLng dragPosition = marker.getPosition();
        double dragLat = dragPosition.latitude;
        double dragLong = dragPosition.longitude;
        Log.i("info", "on drag end :" + dragLat + " dragLong :" + dragLong);
        Toast.makeText(getApplicationContext(), "Marker Dragged..!", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1 :
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.item2 :
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.item3 :
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.item4 :
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            default :
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    public class Async extends AsyncTask<Void, Void, Void> {
        double entry1;
        double entry2;


        public Async(double entry1, double entry2) {
            this.entry1 = entry1;
            this.entry2 = entry2;

        }

        @Override
        protected Void doInBackground(Void... params) {


            InputStream inputStream = null;
            String result = "";
            try {

                // 1. create HttpClient
                HttpClient httpclient = new DefaultHttpClient();
                String url = "http://192.168.8.100:3000/insert";
                // 2. make POST request to the given URL
                HttpPost httpPost = new HttpPost(url);

                String json = "";

                // 3. build jsonObject
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("Latitude", entry1);
                jsonObject.accumulate("Longitude", entry2);


                // 4. convert JSONObject to JSON to String
                json = jsonObject.toString();

                // ** Alternative way to convert Person object to JSON string usin Jackson Lib
                // ObjectMapper mapper = new ObjectMapper();
                // json = mapper.writeValueAsString(person);

                // 5. set json to StringEntity
                StringEntity se = new StringEntity(json);

                // 6. set httpPost Entity
                httpPost.setEntity(se);

                // 7. Set some headers to inform server about the type of the content
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");

                // 8. Execute POST request to the given URL
                HttpResponse httpResponse = httpclient.execute(httpPost);

                // 9. receive response as inputStream
                inputStream = httpResponse.getEntity().getContent();

                // 10. convert inputstream to string
                if (inputStream != null)
                    Log.d("Result", "POST Success!");

                else
                    Log.d("Result", "Did not work!");
            } catch (Exception e) {
                Log.d("InputStream Exception", e.getLocalizedMessage());
            }

            // 11. return result
            return null;

        }


    }



    }
