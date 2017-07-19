package mbrtechnology.com.mbrt_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.apiService.ApiService;
import mbrtechnology.com.mbrt_app.apiService.ApiServiceGenerator;
import mbrtechnology.com.mbrt_app.models.Incidente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleActivity extends AppCompatActivity {

    private static final String TAG = DetalleActivity.class.getSimpleName();

    private static final int MAIN_FORM_REQUEST = 100;

    private int id;

    public TextView estadoText;
    public TextView tecnicoText;
    public TextView areaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            id = bundle.getInt("ID");
            Log.d(TAG, "ID: " + id);
        }

        estadoText = (TextView)findViewById(R.id.estado_text);
        tecnicoText = (TextView)findViewById(R.id.tecnico_text);
        areaText = (TextView)findViewById(R.id.area_text);

        initialize();

    }

    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<Incidente> call = service.showIncidente(id);

        call.enqueue(new Callback<Incidente>() {
            @Override
            public void onResponse(Call<Incidente> call, Response<Incidente> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        Incidente incidente = response.body();
                        Log.d(TAG, "incidente: " + incidente);

                        estadoText.setText(incidente.getEstado());
                        tecnicoText.setText(incidente.getTecnico());
                        areaText.setText(incidente.getArea());

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(DetalleActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<Incidente> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(DetalleActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

            });
        }


    public void callMainForm(View view) {
        startActivityForResult(new Intent(this, PrincipalActivity.class), MAIN_FORM_REQUEST);
    }



}
