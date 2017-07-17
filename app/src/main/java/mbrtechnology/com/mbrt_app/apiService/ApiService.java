package mbrtechnology.com.mbrt_app.apiService;

import java.util.List;

import mbrtechnology.com.mbrt_app.models.Incidente;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASUS on 12/07/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://mbrt-gustavoch25.c9users.io";

    @GET("api/v1/incidente")
    Call<List<Incidente>> getIncidentes();

}
