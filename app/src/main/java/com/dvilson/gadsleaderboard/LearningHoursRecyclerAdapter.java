package com.dvilson.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.dvilson.gadsleaderboard.models.User;

public class LearningHoursRecyclerAdapter extends RecyclerView.Adapter <LearningHoursRecyclerAdapter.LearningHoursViewHolder> {

    ArrayList<User> mUsers;
    Context mContext;

    public LearningHoursRecyclerAdapter(Context context,ArrayList<User> users) {
        mUsers = users;
        mContext = context;
    }

    @NonNull
    @Override
    public LearningHoursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hours,parent,false);

        return new LearningHoursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningHoursViewHolder holder, int position) {

        holder.name.setText(mUsers.get(position).getName());
        holder.hoursCountry.setText(mUsers.get(position).getHours()+" learning hours"+", "+mUsers.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class LearningHoursViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageBadge;
        TextView name ;
        TextView hoursCountry;

        public LearningHoursViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageBadge = itemView.findViewById(R.id.image_badge);
            name = itemView.findViewById(R.id.tv_name_hours);
            hoursCountry = itemView.findViewById(R.id.tv_hours_country);

        }
    }
}
