package com.example.android.mymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] musicNames = new String[] {"PRISTINE", "NEED A LITTLE TIME", "TIL IT’S OVER",
            "BAD BAD NEWS", "HIGH HORSE", "MAKE ME FEEL", "WHAT A TIME TO BE ALIVE"};
    private String[] musicArtist = new String[] {"SNAIL MAIL", "COURTNEY BARNETT", "ANDERSON .PAAK", "LEON BRIDGES",
            "KACEY MUSGRAVES", "JANELLE MONAE", "SUPERCHUNK"};
    private ListView listView;
    private Intent intent;
    private MyListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Songs> songs = new ArrayList<Songs>();
        songs.add(new Songs("PRISTINE", "SNAIL MAIL", "$"));
        songs.add(new Songs("NEED A LITTLE TIME", "COURTNEY BARNETT", "FREE"));
        songs.add(new Songs("TIL IT’S OVER", "ANDERSON .PAAK", "$"));
        songs.add(new Songs("BAD BAD NEWS", "LEON BRIDGES", "$"));
        songs.add(new Songs("HIGH HORSE", "KACEY MUSGRAVES", "FREE"));
        songs.add(new Songs("MAKE ME FEEL", "JANELLE MONAE", "$"));
        songs.add(new Songs("WHAT A TIME TO BE ALIVE", "SUPERCHUNK", "$"));
        myListView = new MyListView(this, songs);
        listView = (ListView) findViewById(R.id.my_list);
        listView.setAdapter(myListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1 || i == 4) {
                    intent = new Intent(MainActivity.this, MusicPlayer.class);
                    intent.putExtra("Name",musicNames[i]);
                    intent.putExtra("Artist", musicArtist[i]);
                    intent.putExtra("Position", i);}
                else
                    intent = new Intent(MainActivity.this, Payment.class);
                startActivity(intent);
            }
        });
    }
}
