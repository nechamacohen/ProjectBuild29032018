package cohen.nechama.projectbuild.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cohen.nechama.projectbuild.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommitteeFragment extends Fragment {


    public CommitteeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_committee, container, false);
    }

}
