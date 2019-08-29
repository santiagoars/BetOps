package com.santiagoaragon.statops;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder>{

    private ArrayList<Game> gameList;

    public GameAdapter(ArrayList<Game> gameList){
        this.gameList = gameList;
    }


    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GameViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        holder.homeLogo.setImageResource(game.getHomeLogo());
        holder.awayLogo.setImageResource(game.getAwayLogo());
        holder.homeTeam.setText(game.getHomeTeam());
        holder.awayTeam.setText(game.getAwayTeam());
        holder.homeRecord.setText(game.getHomeRecord());
        holder.awayRecord.setText(game.getAwayRecord());
        holder.homeProbability.setText(String.valueOf(game.getHomeProbability()));
        holder.awayProbability.setText(String.valueOf(game.getAwayProbability()));
    }


    @Override
    public int getItemCount() {
        return gameList.size();
    }

    class GameViewHolder extends RecyclerView.ViewHolder{

        ImageView homeLogo, awayLogo;
        TextView homeTeam, awayTeam;
        TextView homeRecord, awayRecord;
        TextView homeProbability, awayProbability;


        public GameViewHolder(View itemView) {
            super(itemView);
            homeLogo = itemView.findViewById(R.id.home_team_img);
            awayLogo = itemView.findViewById(R.id.away_team_img);
            homeTeam = itemView.findViewById(R.id.home_team);
            awayTeam = itemView.findViewById(R.id.away_team);
            homeRecord = itemView.findViewById(R.id.home_record);
            awayRecord = itemView.findViewById(R.id.away_record);
            homeProbability = itemView.findViewById((R.id.home_probability));
            awayProbability = itemView.findViewById(R.id.away_probability);
        }
    }

}
