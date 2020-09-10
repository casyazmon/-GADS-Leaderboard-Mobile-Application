package com.example.gadsleardersboard.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleardersboard.R;
import com.example.gadsleardersboard.model.SkillIQ;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.SkillViewHolder> {
    private List<SkillIQ> skillIQList = new ArrayList<>();
    private Context context;

    public SkillIQAdapter(List<SkillIQ> skillIQList, Context context) {
        this.skillIQList = skillIQList;
        this.context = context;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.skilliq_list_item, parent,false);
        return new SkillViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        SkillIQ skillIQ = skillIQList.get(position);
        holder.tv_name.setText(skillIQ.getName());
        holder.skill_country.setText(skillIQ.getScore() + " Skill IQ Score, " + skillIQ.getCountry());

        Picasso.get()
                .load(skillIQ.getBadgeUrl())
                .fit()
                .centerInside()
                .into(holder.batchUrl);
    }

    @Override
    public int getItemCount() {
        return skillIQList.size();
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView skill_country;
        ImageView batchUrl;
        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            skill_country = itemView.findViewById(R.id.skill_country);
            batchUrl = itemView.findViewById(R.id.batch_url);
        }
    }
}
