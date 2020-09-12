package com.hira_software.leaderboard.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hira_software.leaderboard.R;
import com.hira_software.leaderboard.model.PersonIQ;

import java.util.ArrayList;
import java.util.List;

public class TopIQAdaptor extends RecyclerView.Adapter<TopIQAdaptor.IqViewHolder> {

    private List<PersonIQ> personIQList=new ArrayList<>();


    public void setPersonIQList(List<PersonIQ> personIQList) {
        this.personIQList = personIQList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_element_iq,parent,false);
        return new IqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IqViewHolder holder, int position) {

        PersonIQ topIq=personIQList.get(position);
        holder.studentName.setText(topIq.getName());
        holder.description.setText(topIq.getScore()+" Skill IQ Score, "+topIq.getCountry());
        holder.imageUrl= topIq.getBadgeUrl();
    }

    @Override
    public int getItemCount() {
        return personIQList.size();
    }

    public class IqViewHolder extends RecyclerView.ViewHolder {

        private TextView studentName;
        private TextView description;
        private String imageUrl;
        private ImageView imageView;

        
        public IqViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.iq_hour);
            imageView=itemView.findViewById(R.id.imageUrl);
        }
    }
}
