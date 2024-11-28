package dad.CalculadoraHipoteca.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CalculaodraHipotecaInterface {

    @GET("hipoteca")
    Call<HipotecaResult> hipoteca(@Query("capital") Double capitalQuery ,@Query("interes") Double interesQuery ,@Query("años") Integer aniosQuery  );
}
