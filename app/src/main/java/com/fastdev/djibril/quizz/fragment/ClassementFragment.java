package com.fastdev.djibril.quizz.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fastdev.djibril.quizz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassementFragment extends Fragment {


    public ClassementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_classement, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

}
