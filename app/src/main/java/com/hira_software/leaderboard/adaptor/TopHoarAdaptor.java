package com.hira_software.leaderboard.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hira_software.leaderboard.R;
import com.hira_software.leaderboard.model.Hoarse;

import java.util.ArrayList;
import java.util.List;

public class TopHoarAdaptor extends RecyclerView.Adapter<TopHoarAdaptor.TopHoarlyHolder> {
    private List<Hoarse> hoarseList=new ArrayList<>();
    public void setHoarseList(List<Hoarse> hoarseList) {
        this.hoarseList = hoarseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopHoarlyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_element_time,parent,false);
        return new TopHoarlyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopHoarlyHolder holder, int position) {
//        hoarseList.get(position)
        Hoarse hoarse=hoarseList.get(position);
        holder.studentName.setText(hoarse.getName());

        String concatData=String.format("%s ,Learning hours, %s ",hoarse.getHoarse(),hoarse.getCountry());
        holder.description.setText(concatData);
        holder.badgeUrl=hoarse.getBadgeUrl();

    }
    @Override
    public int getItemCount() {
        return hoarseList.size();
    }

    class TopHoarlyHolder extends RecyclerView.ViewHolder{

        private String name;
        private String hoarse;
        private String country;
        private String badgeUrl;

        private TextView studentName;
        private TextView description;
        private ImageView imageView;



        public TopHoarlyHolder(@NonNull View itemView) {
            super(itemView);
            studentName=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.iq_hour);
            imageView=itemView.findViewById(R.id.imageUrl);
        }
    }
}
