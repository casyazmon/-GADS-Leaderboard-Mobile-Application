package com.example.gadsleardersboard.ui.learning;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleardersboard.R;
import com.example.gadsleardersboard.datasource.GetTopLeaders;
import com.example.gadsleardersboard.datasource.LeadersBoardClient;
import com.example.gadsleardersboard.model.Learners;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearnersFragment extends Fragment {
    private RecyclerView myRecyclerView;
    private View root;
    private ProgressBar mProgressBar;
    public LearnersFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static LearnersFragment newInstance() {
        LearnersFragment fragment = new LearnersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_learners, container, false);
        mProgressBar = root.findViewById(R.id.lProgressBar);
        apiCall();

        return root;
    }

    public void apiCall() {
        mProgressBar.setVisibility(View.VISIBLE);
        GetTopLeaders topLeaders = LeadersBoardClient.getRetrofitInstance().create(GetTopLeaders.class);
        Call<List<Learners>> call = topLeaders.getTopLearners();

        call.enqueue(new Callback<List<Learners>>() {
            @Override
            public void onResponse(Call<List<Learners>> call, Response<List<Learners>> response) {
                loadTopLearners(response.body());
                Log.d("API Response", "onResponse: "+response.body());
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Learners>> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Unable to Load Leaders board", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void loadTopLearners(List<Learners> learnersList) {
        myRecyclerView = root.findViewById(R.id.myRecyclerView);
        LearnerAdapter myAdapter = new LearnerAdapter(learnersList, getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setAdapter(myAdapter);
    }

}
