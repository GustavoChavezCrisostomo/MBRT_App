package mbrtechnology.com.mbrt_app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.ResponseMessage;
import mbrtechnology.com.mbrt_app.service.ApiService;
import mbrtechnology.com.mbrt_app.service.ApiServiceGenerator;
import mbrtechnology.com.mbrt_app.util.PreferencesManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClienteFragment extends Fragment {

    private static final String TAG = ClienteFragment.class.getSimpleName();

    private EditText contactoInput;
    private EditText descripcionInput;
    private Spinner spinner;
    private Button button;

    public ClienteFragment() {
        // Required empty public constructor
    }

    //add
    public static ClienteFragment newInstance() {
        ClienteFragment fragment = new ClienteFragment();
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

        getActivity().setTitle(R.string.title_nuevaAtencion);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cliente, container, false);


        // ProgressBar Gone
        getActivity().findViewById(R.id.main_progress).setVisibility(View.GONE);


        spinner = (Spinner) view.findViewById(R.id.area_spinner);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.area));

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        contactoInput = (EditText) view.findViewById(R.id.contacto_Input);
        // Seteando el usuario logueado
        String nombres = PreferencesManager.getInstance().get(PreferencesManager.PREF_FULLNAME);
        contactoInput.setText(nombres);


        descripcionInput = (EditText) view.findViewById(R.id.descripcion_input);

        button = (Button) view.findViewById(R.id.btn_enviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String contacto = contactoInput.getText().toString();
                String contacto = PreferencesManager.getInstance().get(PreferencesManager.PREF_ID);
                String area = spinner.getSelectedItem().toString();
                String descripcion = descripcionInput.getText().toString();

                if(contacto.isEmpty() || area.isEmpty() || descripcion.isEmpty()){
                    Toast.makeText(getActivity(), "Completar los campos requeridos", Toast.LENGTH_SHORT).show();
                    return;
                }

                ApiService service = ApiServiceGenerator.createService(ApiService.class);

                Call<ResponseMessage> call = null;

                call = service.createIncidente(contacto, area, descripcion);

                call.enqueue(new Callback<ResponseMessage>() {
                    @Override
                    public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                        try {

                            int statusCode = response.code();
                            Log.d(TAG, "HTTP status code: " + statusCode);

                            if (response.isSuccessful()) {

                                ResponseMessage responseMessage = response.body();
                                Log.d(TAG, "responseMessage: " + responseMessage);

                                Toast.makeText(getActivity(), responseMessage.getMessage(), Toast.LENGTH_LONG).show();
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content,MenuFragment.newInstance()).commit();

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
                    public void onFailure(Call<ResponseMessage> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.toString());
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });

            }
        });

        return view;
    }


}
