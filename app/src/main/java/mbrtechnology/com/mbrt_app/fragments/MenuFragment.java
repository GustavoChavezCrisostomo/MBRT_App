package mbrtechnology.com.mbrt_app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mbrtechnology.com.mbrt_app.R;

public class MenuFragment extends Fragment {
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
