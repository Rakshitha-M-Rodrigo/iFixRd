package com.kmap.mobileaccelerometer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TravelingModeSelection extends Activity implements View.OnClickListener {


    private ImageButton driver;
    private ImageButton passenger;
    private ImageButton walker;
    private int travelmode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_traveling_mode_selection);

        driver= (ImageButton) findViewById(R.id.driver);
        passenger= (ImageButton) findViewById(R.id.passenger);
        walker= (ImageButton) findViewById(R.id.walker);


        driver.setOnClickListener(this);
        passenger.setOnClickListener(this);
        walker.setOnClickListener(this);

    }


    public void onClick(View v){
        ImageButton clicked = (ImageButton) v;
        int btnId = clicked.getId();
        switch (btnId) {
            case R.id.driver:
                    Toast toastdriver = Toast.makeText(this,"You have chosen Driver mode",
                            Toast.LENGTH_SHORT);
                    this.travelmode=1;
                    toastdriver.show();
                    onFire();

                break;
            case R.id.passenger:

                    Toast toastpassenger = Toast.makeText(this, "You have chosen Passenger mode" ,
                            Toast.LENGTH_SHORT);
                    toastpassenger.show();
                    this.travelmode=2;
                    onFire();

                break;

            case R.id.walker:

                    Toast toastwalker = Toast.makeText(this, "You have chosen Walker mode" ,
                            Toast.LENGTH_SHORT);
                    toastwalker.show();
                    this.travelmode=3;
                    onFire();

                break;
            default:



        }
    }
    public void onFire() {

            Intent intent= new Intent(this,MapActivity.class); // should mention the current activity
            intent.putExtra("selectedMode",travelmode); // carrying result to next activity
            startActivity(intent);

    }



}
