package com.example.android.mymusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ElGreetly on 4/7/18.
 */
public class MyListView extends ArrayAdapter<Songs> {

    public MyListView(Activity context, ArrayList<Songs> songs) {
        super(context, 0, songs);

    }
    static class ViewHolder {
        TextView song;
        TextView artist;
        TextView cost;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }
        Songs data = getItem(position);
        ViewHolder holder = new ViewHolder();
        holder.song = (TextView) convertView.findViewById(R.id.songName);
        holder.artist = (TextView) convertView.findViewById(R.id.artistName);
        holder.cost = (TextView) convertView.findViewById(R.id.cost);
        convertView.setTag(holder);
        holder.song.setText(data.getName());
        holder.artist.setText(data.getArtist());
        holder.cost.setText(data.getCost());
        return convertView;
    }
}
