package nl.uva.mobile.crowddetector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import java.io.IOException;

import nl.uva.mobile.crowddetector.rest.HeatMapClient;
import nl.uva.mobile.crowddetector.rest.ServiceGenerator;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeatMapWebViewActivity extends AppCompatActivity {

    private static final String TAG = HeatMapWebViewActivity.class.getCanonicalName();
    private String postUrlHeatMap = "file:///android_asset/heatmap.html";
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_map_web_view);

        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(postUrlHeatMap);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setVerticalScrollBarEnabled(true);

        /**
         * Enabling zoom-in controls
         * */
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);

        getCrowdData();
    }


    public void getCrowdData() {
        Log.d(TAG, "getCrowdData: ");
        HeatMapClient downloadService = ServiceGenerator.createService(HeatMapClient.class);

        Call<ResponseBody> call = downloadService.downloadFileWithCrowdData();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        Log.d(TAG, "server contacted" + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.d(TAG, "server contact failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "error");
            }
        });
    }

}