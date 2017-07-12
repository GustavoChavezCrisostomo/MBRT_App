package mbrtechnology.com.mbrt_app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mbrtechnology.com.mbrt_app.R;

public class MenuFragment extends Fragment {

    private static final String TAG = MenuFragment.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        incidentesList = (RecyclerView) incidentesList.findViewById(R.id.incidente_list);
    }
    //fin add

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);


        // ProgressBar Gone
        getActivity().findViewById(R.id.main_progress).setVisibility(View.GONE);


        return view;
    }
}
