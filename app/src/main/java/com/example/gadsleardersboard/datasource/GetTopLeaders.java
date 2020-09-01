package com.example.gadsleardersboard.datasource;

import com.example.gadsleardersboard.model.Learners;
import com.example.gadsleardersboard.model.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetTopLeaders {
    @GET("/api/hours")
    Call<List<Learners>> getTopLearners();

    @GET("/api/skilliq")
    Call<List<SkillIQ>> getTopSkillIQ();

}
