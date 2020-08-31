package com.example.gadsleardersboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.gadsleardersboard.ui.learners.LearnerFragment;

public class LearnersFragment extends Fragment {
    public LearnersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearnerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearnerFragment newInstance() {
        LearnerFragment fragment = new LearnerFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learners, container, false);
    }

}
