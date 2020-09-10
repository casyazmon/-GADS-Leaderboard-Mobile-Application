package com.example.gadsleardersboard.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gadsleardersboard.R;
import com.example.gadsleardersboard.datasource.GetTopLeaders;
import com.example.gadsleardersboard.datasource.LeadersBoardClient;
import com.example.gadsleardersboard.model.Learners;
import com.example.gadsleardersboard.model.SkillIQ;
import com.example.gadsleardersboard.ui.learning.LearnerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillIQFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillIQFragment extends Fragment {
    ProgressBar progressBar;

    private View root;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView myRecyclerView;

    public SkillIQFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SkillIQFragment newInstance() {
        SkillIQFragment fragment = new SkillIQFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_skill_iq, container, false);
        progressBar = root.findViewById(R.id.progressBar);
        apiCall();
        return root;
    }

    public void apiCall() {
        progressBar.setVisibility(View.VISIBLE);
        GetTopLeaders topLeaders = LeadersBoardClient.getRetrofitInstance().create(GetTopLeaders.class);
        Call<List<SkillIQ>> call = topLeaders.getTopSkillIQ();

        call.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                loadTopLearners(response.body());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
                Toast.makeText(getContext(), "Api call failed", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void loadTopLearners(List<SkillIQ> learnersList) {
        myRecyclerView = root.findViewById(R.id.skill_rv);
        SkillIQAdapter myAdapter = new SkillIQAdapter(learnersList, getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setAdapter(myAdapter);
    }
}