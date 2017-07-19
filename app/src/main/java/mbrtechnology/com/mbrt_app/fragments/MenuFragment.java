package mbrtechnology.com.mbrt_app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.adapters.IncidenteAdapter;
import mbrtechnology.com.mbrt_app.service.ApiService;
import mbrtechnology.com.mbrt_app.service.ApiServiceGenerator;
import mbrtechnology.com.mbrt_app.models.Incidente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuFragment extends Fragment {

    private static final String TAG = MenuFragment.class.getSimpleName();
    private RecyclerView incidentesList;

    public MenuFragment() {
        // Required empty public constructor
    }

    //add
    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }
    //fin add

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(R.string.title_menu);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);
        // ProgressBar Gone
        getActivity().findViewById(R.id.main_progress).setVisibility(View.GONE);

        incidentesList = (RecyclerView)view.findViewById(R.id.incidente_list);
        incidentesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        incidentesList.setAdapter(new IncidenteAdapter(getActivity()));

        initialize();

        return view;
    }

    private  void initialize(){
        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<List<Incidente>> call = service.getIncidentes();

        call.enqueue(new Callback<List<Incidente>>() {
            @Override
            public void onResponse(Call<List<Incidente>> call, Response<List<Incidente>> response) {
                try{
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()){
                        List<Incidente> incidentes = response.body();
                        Log.d(TAG, "incidentes: " + incidentes);

                        IncidenteAdapter adapter = (IncidenteAdapter) incidentesList.getAdapter();
                        adapter.setIncidentes(incidentes);
                        adapter.notifyDataSetChanged();
                    }else{
                        Log.e(TAG, "onError" + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                }catch (Throwable t){
                    try{
                        Log.e(TAG, "onThrowable" + t.toString(), t);
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Incidente>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                if (getActivity()!=null) Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
