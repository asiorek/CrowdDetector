package nl.uva.mobile.crowddetector;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    Button mybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton = findViewById(R.id.button);
        Spinner ddcity = findViewById(R.id.city);
        Spinner dduni = findViewById(R.id.university);
        Spinner ddfloor = findViewById(R.id.floor);

        final Intent intent = new Intent(this, HeatMapWebViewActivity.class);

        mybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);

                Log.d(TAG, "onClick: Button clicked");
            }
        });

        //get the spinner from the xml.

        //create a list of items for the spinner.
        String[] cities = new String[]{"Choose a city","Amstedam", "Rotterdam", "Utrecht"};
        String[] unis = new String[]{"Choose a university", "UvA", "VU", "HvA"};
        String[] floors = new String[]{"Choose a floor","Ground floor", "1st floor", "2nd floor"};

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cities) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 1) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 1){
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                }
                else {
                    tv.setTextColor(Color.GRAY);
                }
                return view;
            }
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, unis){
            @Override
            public boolean isEnabled(int position) {
                if (position == 1) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 1){
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                }
                else {
                    tv.setTextColor(Color.GRAY);
                }
                return view;
            }
        };
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, floors){
            @Override
            public boolean isEnabled(int position) {
                if (position == 1) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 1){
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                }
                else {
                    tv.setTextColor(Color.GRAY);
                }
                return view;
            }
        };

        //set the spinners adapter to the previously created one.
        ddcity.setAdapter(adapter);
        dduni.setAdapter(adapter2);
        ddfloor.setAdapter(adapter3);
    }
}
