package nl.uva.mobile.crowddetector.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by joannaroczniak on 13/03/2018.
 */

public class ServiceGenerator {

    private static String API_BASE_URL = "http://demo0268217.mockable.io/"; // ground

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create());

    private static Retrofit retrofit =
            builder
                    .client(httpClient.build())
                    .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
