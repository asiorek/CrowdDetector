package nl.uva.mobile.crowddetector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//TODO: Create buttons for getting information for each floor
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    Button mybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton = findViewById(R.id.button);

        final Intent intent = new Intent(this, HeatMapWebViewActivity.class);

        mybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);

                Log.d(TAG, "onClick: Button clicked");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
