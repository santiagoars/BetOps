package com.santiagoaragon.statops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private GridLayoutManager glm;
    private GameAdapter mGameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rv = findViewById(R.id.rvgames);
        this.rv.setNestedScrollingEnabled(false);
        this.rv.setItemViewCacheSize(5);
        this.rv.setHasFixedSize(true);
        this.glm = new GridLayoutManager(this, 1);
        this.rv.setLayoutManager(glm);
        this.mGameAdapter = new GameAdapter(dataSet());
        this.rv.setAdapter(mGameAdapter);

    }

    private ArrayList<Game> dataSet(){
        ArrayList<Game> data = new ArrayList<>();
        data.add(new Game(R.drawable.col, R.drawable.bos, "Rockies", "Red Sox", "59-74", "71-62", 39, 61));
        data.add(new Game(R.drawable.sea, R.drawable.nyy, "Mariners", "Yankees", "56-77", "87-47", 31, 69));
        data.add(new Game(R.drawable.phi, R.drawable.pit, "Phillies", "Pirates", "68-63", "56-76", 56, 44));
        data.add(new Game(R.drawable.wsh, R.drawable.bal, "Nationals", "Orioles", "73-58", "44-88", 63, 37));
        data.add(new Game(R.drawable.tor, R.drawable.atl, "Blue Jays", "Braves", "54-80", "80-54", 30, 70));
        data.add(new Game(R.drawable.nym, R.drawable.chc, "Mets", "Cubs", "67-64", "70-61", 49, 51));
        data.add(new Game(R.drawable.mia, R.drawable.cin, "Marlins", "Reds", "47-84", "62-69", 25, 75));
        data.add(new Game(R.drawable.det, R.drawable.cle, "Tigers", "Indians", "39-90", "77-55", 21, 79));
        data.add(new Game(R.drawable.hou, R.drawable.tb, "Astros", "Rays", "86-47", "76-57", 56, 44));
        data.add(new Game(R.drawable.chw, R.drawable.min, "White Sox", "Twins", "60-71", "80-51", 32, 68));
        data.add(new Game(R.drawable.kc, R.drawable.oak, "Royals", "Athletics", "76-55", "46-87", 34, 66));
        data.add(new Game(R.drawable.sd, R.drawable.lad, "Padres", "Dodgers", "61-70", "87-47", 30, 70));
        data.add(new Game(R.drawable.laa, R.drawable.tex, "Angels", "Texans", "64-70", "64-69", 48, 52));
        data.add(new Game(R.drawable.tor, R.drawable.atl, "Blue Jays", "Braves", "54-80", "80-54", 30, 70));

        return data;
    }
}
