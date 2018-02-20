package nl.uva.mobile.crowddetector;

import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Map;
import java.util.Random;

import ca.hss.heatmaplib.HeatMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    Button mybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton = findViewById(R.id.button);

        mybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.d(TAG, "onClick: Button clicked");
            }
        });

        HeatMap heatMap = (HeatMap) findViewById(R.id.heatmap);

        heatMap.setMinimum(0.0);
        heatMap.setMaximum(100.0);

        //make the colour gradient from pink to yellow
        Map<Float, Integer> colors = new ArrayMap<>();
        colors.put(1.0f, ContextCompat.getColor(getBaseContext(), R.color.heatMapMax));
        colors.put(0.0f, ContextCompat.getColor(getBaseContext(), R.color.heatMapMin));
        heatMap.setColorStops(colors);

        heatMap.setRadius(500);

        //set the opacity, min = 0, max = 255
        heatMap.setOpacity(127);

        //add random data to the map
        Random rand = new Random();
        for (int i = 0; i < 200; i++) {
            HeatMap.DataPoint point = new HeatMap.DataPoint(rand.nextFloat(), rand.nextFloat(), rand.nextDouble() * 100.0);
            heatMap.addData(point);
        }
    }

}
