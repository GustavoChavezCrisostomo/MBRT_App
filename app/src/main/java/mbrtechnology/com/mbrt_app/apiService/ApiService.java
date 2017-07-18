package mbrtechnology.com.mbrt_app.apiService;

import java.util.List;

import mbrtechnology.com.mbrt_app.ResponseMessage;
import mbrtechnology.com.mbrt_app.models.Incidente;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by ASUS on 12/07/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://mbrt-gustavoch25.c9users.io";

    @GET("api/v1/incidente")
    Call<List<Incidente>> getIncidentes();

    @Multipart
    @POST("/api/v1/productos")
    Call<ResponseMessage> createIncidente(
            @Part("contacto") String contacto,
            @Part("area") String area,
            @Part("descripcion") String descripcion
            );

}
