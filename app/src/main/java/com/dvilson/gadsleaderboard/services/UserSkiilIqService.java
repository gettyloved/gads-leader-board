package com.dvilson.gadsleaderboard.services;

import com.dvilson.gadsleaderboard.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserSkiilIqService {

    @GET("/api/skilliq")
    Call<List<User>> getUserSkillIq();

}
