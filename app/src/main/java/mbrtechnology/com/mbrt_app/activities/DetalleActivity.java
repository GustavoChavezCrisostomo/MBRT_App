package mbrtechnology.com.mbrt_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.fragments.MenuFragment;

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
        startActivityForResult(new Intent(this, MenuFragment.class), MAIN_FORM_REQUEST);
    }
}
