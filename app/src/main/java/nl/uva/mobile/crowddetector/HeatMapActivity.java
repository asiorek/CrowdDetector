package nl.uva.mobile.crowddetector;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ScaleGestureDetector;

import com.jsibbold.zoomage.ZoomageView;

import java.util.Map;
import java.util.Random;

import ca.hss.heatmaplib.HeatMap;

public class HeatMapActivity extends AppCompatActivity {

    private static final String TAG = HeatMapActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_map);

        final HeatMap heatMap = (HeatMap) findViewById(R.id.heatmap);

        heatMap.setMinimum(0.0);
        heatMap.setMaximum(100.0);

        //make the colour gradient from pink to yellow
        Map<Float, Integer> colors = new ArrayMap<>();
        colors.put(1.0f, ContextCompat.getColor(getBaseContext(), R.color.heatMapMax));
        colors.put(0.0f, ContextCompat.getColor(getBaseContext(), R.color.heatMapMin));
        heatMap.setColorStops(colors);

        heatMap.setRadius(200);

//        ZoomageView zoomageView = findViewById(R.id.mapZoomageView);
//        zoomageView.getHeight();
//        zoomageView.getWidth();

//        zoomageView.onScale(new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {
//
//            @Override
//            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
//                Log.d(TAG, "onScale: " + scaleGestureDetector.getCurrentSpan());
//                return false;
//            }
//
//            @Override
//            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
//                Log.d(TAG, "onScaleBegin: " + scaleGestureDetector.getCurrentSpan());
//                return false;
//            }
//
//            @Override
//            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
//                Log.d(TAG, "onScaleEnd: " + scaleGestureDetector.getCurrentSpan());
//            }
//        }));

        // Code here executes on main thread after user presses button

        //draw a dark violet circle at the location of each data point
//        heatMap.setMarkerCallback(new HeatMapMarkerCallback.CircleHeatMapMarker(0xff9400D3));

        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            //add random data to the map
            HeatMap.DataPoint point = new HeatMap.DataPoint(rand.nextFloat(), rand.nextFloat(), rand.nextDouble() * 100.0);
            heatMap.addData(point);
        }

//        After changing an option after the heat map has been rendered force a refresh.
//        heatMap.forceRefresh();

//        Drawable drawable = zoomageView.getDrawable();
//        Rect imageBounds = drawable.getBounds();


//original height and width of the bitmap
//        int intrinsicHeight = drawable.getIntrinsicHeight();
//        int intrinsicWidth = drawable.getIntrinsicWidth();
//        Log.d(TAG, "onCreate: drawable height " + intrinsicHeight + " width " + intrinsicWidth);
//
////height and width of the visible (scaled) image
//        int scaledHeight = imageBounds.height();
//        int scaledWidth = imageBounds.width();
//        Log.d(TAG, "onCreate: scaled image height " + scaledHeight + " width " + scaledWidth);


//Find the ratio of the original image to the scaled image
//Should normally be equal unless a disproportionate scaling
//(e.g. fitXY) is used.
//        float heightRatio = intrinsicHeight / scaledHeight;
//        float widthRatio = intrinsicWidth / scaledWidth;
    }
}
