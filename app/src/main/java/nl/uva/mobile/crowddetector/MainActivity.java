package nl.uva.mobile.crowddetector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.IOException;

import nl.uva.mobile.crowddetector.rest.HeatMapClient;
import nl.uva.mobile.crowddetector.rest.ServiceGenerator;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO: Create buttons for getting information for each floor
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
        String[] cities = new String[]{"Amsterdam", "Rotterdam", "Utrecht"};
        String[] unis = new String[]{"UvA", "VU", "HvA"};
        String[] floors = new String[]{"Ground floor", "1st floor", "2nd floor"};

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cities);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unis);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, floors);

        //set the spinners adapter to the previously created one.
        ddcity.setAdapter(adapter);
        dduni.setAdapter(adapter2);
        ddfloor.setAdapter(adapter3);
    }
}
