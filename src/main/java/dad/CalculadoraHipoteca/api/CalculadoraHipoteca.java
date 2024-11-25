package dad.CalculadoraHipoteca.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CalculadoraHipoteca {
    private static final String BASE_URL = "http://localhost:3000/";

    private Gson gson;

    private final CalculaodraHipotecaInterface service;

    public CalculadoraHipoteca(){

        ConnectionPool pool = new ConnectionPool(1 , 5 , TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder().connectionPool(pool).build();

        gson = new GsonBuilder().setPrettyPrinting().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();

        service = retrofit.create(CalculaodraHipotecaInterface.class);
    }

    public HipotecaResult getCuotas(Double capitalQuery , Double interesQuery , Integer aniosQuery) throws IOException {
        Response<HipotecaResult> result =  service.hipoteca(capitalQuery, interesQuery, aniosQuery).execute();
        if (result.isSuccessful()){
            return result.body();
        }
        return null;
    }
}
