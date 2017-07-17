package mbrtechnology.com.mbrt_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import mbrtechnology.com.mbrt_app.R;

public class DetalleActivity extends AppCompatActivity {

    private static final String TAG = DetalleActivity.class.getSimpleName();

    private static final int MAIN_FORM_REQUEST = 100;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            id = bundle.getInt("ID");
            Log.d(TAG, "ID: " + id);
        }
    }

    public void callMainForm(View view) {
        startActivityForResult(new Intent(this, PrincipalActivity.class), MAIN_FORM_REQUEST);
    }

    public TextView estado;
    public TextView tecnico;
    public TextView area;

}
