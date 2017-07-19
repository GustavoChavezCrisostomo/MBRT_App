package mbrtechnology.com.mbrt_app.apiService;

import java.util.List;

import mbrtechnology.com.mbrt_app.ResponseMessage;
import mbrtechnology.com.mbrt_app.models.Incidente;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ASUS on 12/07/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://mbrt-gustavoch25.c9users.io";

    @GET("api/v1/incidente")
    Call<List<Incidente>> getIncidentes();

    @FormUrlEncoded
    @POST("/api/v1/incidente")
    Call<ResponseMessage> createIncidente(
            @Field("contacto") String contacto,
            @Field("area") String area,
            @Field("descripcion") String descripcion
    );

    @GET("api/v1/incidente/{id}")
    Call<Incidente> showIncidente(@Path("id") Integer id);

}
