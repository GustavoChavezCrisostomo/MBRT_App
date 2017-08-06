package mbrtechnology.com.mbrt_app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.models.Tecnico;
import mbrtechnology.com.mbrt_app.service.ApiService;
import mbrtechnology.com.mbrt_app.service.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CambioFragment extends Fragment {

    private  Integer id;

    private Spinner spinner_tec;
    private ArrayAdapter<String> spinnerAdapter_tec;

    public CambioFragment() {
        // Required empty public constructor
    }

    public static CambioFragment newInstance() {
        CambioFragment fragment = new CambioFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_cambio, container, false);

        // ProgressBar Gone
        getActivity().findViewById(R.id.main_progress).setVisibility(View.GONE);

        // Spinner Estado
        Spinner spinner_est = (Spinner) view.findViewById(R.id.estado_spinner);
        List<String> list_est = Arrays.asList(getResources().getStringArray(R.array.estado));

        ArrayAdapter<String> spinnerAdapter_est = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list_est);
        spinnerAdapter_est.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_est.setAdapter(spinnerAdapter_est);

        String estado = spinner_est.getSelectedItem().toString();

        //Spinner Tecnico
        spinner_tec = (Spinner) view.findViewById(R.id.tecnico_spinner);
        List<String> list_tec = Arrays.asList(getResources().getStringArray(R.array.tecnico));

        spinnerAdapter_tec = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list_tec);
        spinnerAdapter_tec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tec.setAdapter(spinnerAdapter_tec);

        initialize();

//        spinnerAdapter_tec.add("DELHI");
//        spinnerAdapter_tec.notifyDataSetChanged();

        return view;
    }

    private  void initialize(){
        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<List<Tecnico>> call = service.getTecnico();

        call.enqueue(new Callback<List<Tecnico>>() {
            @Override
            public void onResponse(Call<List<Tecnico>> call, Response<List<Tecnico>> response) {
                List<Tecnico> tecnicos = response.body();
                for (Tecnico tecnico :
                        tecnicos) {
                    spinnerAdapter_tec.add(tecnico.getId().toString());
                }
                 spinnerAdapter_tec.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Tecnico>> call, Throwable t) {

            }
        });
    }

}
