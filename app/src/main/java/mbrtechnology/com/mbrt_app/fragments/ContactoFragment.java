package mbrtechnology.com.mbrt_app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.models.Usuario;
import mbrtechnology.com.mbrt_app.service.ApiService;
import mbrtechnology.com.mbrt_app.service.ApiServiceGenerator;
import mbrtechnology.com.mbrt_app.util.PreferencesManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContactoFragment extends Fragment {

    private static final String TAG = ContactoFragment.class.getSimpleName();

    private int id;

    public TextView nombreText;
    public TextView rucDniText;
    public TextView telefonoText;
    public TextView direccionText;

    public ContactoFragment() {
    }

    //add
    public static ContactoFragment newInstance() {
        ContactoFragment fragment = new ContactoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //fin add

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(R.string.title_contacto);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contacto, container, false);

        // ProgressBar Gone
        getActivity().findViewById(R.id.main_progress).setVisibility(View.GONE);

        id = Integer.parseInt(PreferencesManager.getInstance().get(PreferencesManager.PREF_ID));

        nombreText = (TextView)view.findViewById(R.id.nombre_text);
        rucDniText = (TextView)view.findViewById(R.id.rucDni_text);
        telefonoText = (TextView)view.findViewById(R.id.telefono_text);
        direccionText = (TextView)view.findViewById(R.id.direccion_text);

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<Usuario> call = service.showUsuario(id);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        Usuario usuario = response.body();
                        Log.d(TAG, "usuario: " + usuario);

                        nombreText.setText(usuario.getNombre());
                        rucDniText.setText(Integer.toString(usuario.getLogin()));
                        telefonoText.setText(usuario.getTelefono());
                        direccionText.setText(usuario.getDireccion());

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
