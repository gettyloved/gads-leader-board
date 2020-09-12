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

public class SkillIQRecyclerAdapter  extends  RecyclerView.Adapter<SkillIQRecyclerAdapter.SkillIQViewHolder> {

    ArrayList<User> mUsers;
    Context mContext;

    public SkillIQRecyclerAdapter(Context context,ArrayList<User> users) {
        mUsers = users;
        mContext = context;
    }

    @NonNull
    @Override
    public SkillIQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_skill_iq,parent,false);
        return new SkillIQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQViewHolder holder, int position) {
        holder.nameIq.setText(mUsers.get(position).getName());
        holder.scoreCountry.setText(mUsers.get(position).getScore()+" skill IQ score"+", "+mUsers.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class SkillIQViewHolder extends RecyclerView.ViewHolder{

        ImageView imageBadgeIq;
        TextView nameIq;
        TextView scoreCountry;


        public SkillIQViewHolder(@NonNull View itemView) {
            super(itemView);

            imageBadgeIq = itemView.findViewById(R.id.image_badge_iq);
            nameIq = itemView.findViewById(R.id.tv_name_iq);
            scoreCountry = itemView.findViewById(R.id.tv_score_country);

        }
    }
}
