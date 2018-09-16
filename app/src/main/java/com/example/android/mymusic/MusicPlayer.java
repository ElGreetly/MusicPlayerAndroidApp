package com.example.android.mymusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicPlayer extends AppCompatActivity {
    private String name;
    private String artist;
    private Bundle bundle;
    private ImageView play;
    private ImageView pause;
    private int position;
    private MediaPlayer mediaPlayer;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        bundle = getIntent().getExtras();
        TextView nameText = (TextView) findViewById(R.id.player_name);
        TextView artistText = (TextView) findViewById(R.id.player_artist);
        info = (TextView) findViewById(R.id.info);
        play = (ImageView) findViewById(R.id.play);
        pause = (ImageView) findViewById(R.id.pause);
        name = bundle.getString("Name");
        artist = bundle.getString("Artist");
        position = bundle.getInt("Position");
        nameText.setText(name);
        artistText.setText(artist);

            pause.setVisibility(View.VISIBLE);
            if(position == 1)
            { mediaPlayer = MediaPlayer.create(this, R.raw.song1);
            info.setText("While best known for her thoughtful slacker rock, Courtney Barnett often switches it up with a few more somber tracks on each album. She’s slowed down on highlights like “Anonymous Club” and “Depreston,” but “Need a Little Time” represents her most fully realized part of her catalog. Having evolved as one of our most promising new songwriters, “Need a Little Time” proves to be a mature and dynamic step for Barnett, one that will likely be the stepping point for her more mainstream success.");}
            else{
                mediaPlayer = MediaPlayer.create(this, R.raw.song2);
                info.setText("If you played someone “High Horse,” it might take a few guesses before they identified it as a country song. That four-to-the-floor beat with the funky, Nile Rodgers guitar, that popping bass—none of these are elements of country that should be on a hit from one of the genre’s brightest stars. But the elements are all there: the middle-American lyrical imagery and references, the light slide guitar solo, the banjo, the background acoustic strings. It’s like a winking scrambling of genres that creates a sound entirely Musgraves’ own. Some often compare her to Taylor Swift as a country artist with major crossover potential. But less a brand than her uber-famous counterpart, Musgraves has more in common with the likes of Sturgill Simpson or Chris Stapleton, who are crossing over based on musical ability alone.");}
            mediaPlayer.start();
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    play.setVisibility(View.GONE);
                    pause.setVisibility(View.VISIBLE);
                }
            });
            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.pause();
                    pause.setVisibility(View.GONE);
                    play.setVisibility(View.VISIBLE);
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null)
        mediaPlayer.stop();
    }
}
