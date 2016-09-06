package id.kulina.exercise.kulinaexecise.Activity.Fragment_Detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.kulina.exercise.kulinaexecise.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailPagerFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static DetailPagerFragment newInstance(int sectionNumber) {
        DetailPagerFragment fragment = new DetailPagerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_pager, container, false);
    }

}
