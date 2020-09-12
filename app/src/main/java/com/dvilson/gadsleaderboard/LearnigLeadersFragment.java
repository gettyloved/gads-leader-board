package com.dvilson.gadsleaderboard;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.dvilson.gadsleaderboard.models.User;
import com.dvilson.gadsleaderboard.services.ServiceBuilder;
import com.dvilson.gadsleaderboard.services.UserLearningHoursService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LearnigLeadersFragment extends Fragment {

    ArrayList<User> mUsers;
    private RecyclerView mRecyclerView;
    Context mContext;
    ProgressBar mProgressBar;
    TextView mTextView;



    public LearnigLeadersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_learnig_leaders, container, false);

        return result;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getContext();
        mRecyclerView =view.findViewById(R.id.recycler_view_learning);
        mProgressBar = (ProgressBar) view.findViewById(R.id.fragment_hours_progressbar);
        mTextView = (TextView) view.findViewById(R.id.fragment_hours_tv_error);

        retrieveData();


    }

    public void retrieveData(){

        UserLearningHoursService taskService = ServiceBuilder.buildService(UserLearningHoursService.class);
        Call<List<User>> call  = taskService.getUserLearningHours();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                mUsers = (ArrayList<User>) response.body();
                mProgressBar.setVisibility(View.GONE);
                initRecyclerView();

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                mTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    public void setData(){

        mUsers = new ArrayList<>();

        mUsers.add(new User("Kissi Camara","300","Guinea"));
        mUsers.add(new User("Mohamed Camara","200","Mauritania"));
        mUsers.add(new User("Dvilson Camara","160","Senegal"));
        mUsers.add(new User("Pabliito Camara","50","Marocco"));
        mUsers.add(new User("Sidiki Camara","500","Guinea"));
    }

    public void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        LearningHoursRecyclerAdapter adapter = new LearningHoursRecyclerAdapter(mContext,mUsers);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

}
