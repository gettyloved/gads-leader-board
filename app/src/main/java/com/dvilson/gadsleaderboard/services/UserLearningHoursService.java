package com.dvilson.gadsleaderboard.services;

import com.dvilson.gadsleaderboard.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserLearningHoursService {

    @GET("api/hours")
    Call<List<User>> getUserLearningHours();
}
