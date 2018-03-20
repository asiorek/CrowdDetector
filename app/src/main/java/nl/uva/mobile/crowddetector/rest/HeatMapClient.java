package nl.uva.mobile.crowddetector.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by joannaroczniak on 13/03/2018.
 */

public interface HeatMapClient {

    @Streaming //annotation to get large files
    @GET("/ground")
    Call<String> downloadFileWithCrowdData();
}

