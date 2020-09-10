package com.example.gadsleardersboard.ui.learning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleardersboard.R;
import com.example.gadsleardersboard.model.Learners;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.ViewHolder> {
    private List<Learners> learners = new ArrayList<>();
    private Context context;

    public LearnerAdapter(List<Learners> learners, Context context) {
        this.learners = learners;
        this.context = context;
    }

    @NonNull
    @Override
    public LearnerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.learners_list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LearnerAdapter.ViewHolder holder, int position) {
        Learners learner = learners.get(position);
        holder.name.setText(learner.getName());
        holder.country.setText(learner.getHours() + " Learning hours , " + learner.getCountry());
        Picasso.get()
                .load(learner.getBadgeUrl())
                .fit()
                .centerInside()
                .into(holder.learnerImg);

    }

    @Override
    public int getItemCount() {
        return learners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView country;
        ImageView learnerImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.country);
            learnerImg = itemView.findViewById(R.id.learnerImg);
        }
    }
}
