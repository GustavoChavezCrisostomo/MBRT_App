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
import mbrtechnology.com.mbrt_app.util.PreferencesManager;

public class CambioFragment extends Fragment {

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

        Spinner spinner = (Spinner) view.findViewById(R.id.estado_spinner);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.estado));

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        String estado = spinner.getSelectedItem().toString();

        String role = PreferencesManager.getInstance().get(PreferencesManager.PREF_ROLE);
        if("ROLE_SUPER".equalsIgnoreCase(role)){
            getActivity().findViewById(R.id.tecnico_text).setVisibility(View.INVISIBLE);
            getActivity().findViewById(R.id.tecnico_input).setVisibility(View.INVISIBLE);
        }

        return view;
    }
}
