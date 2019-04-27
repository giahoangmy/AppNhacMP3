package com.appmp3.appnhac.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appmp3.appnhac.Model.PlayList;
import com.appmp3.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<PlayList> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<PlayList> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txtTenPlaylist;
        ImageView imgBackgroundlaylist,imgPlaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Function này dùng để gán layout vào trong listview playlist
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.dong_playlist,null);
            viewHolder = new ViewHolder();
            viewHolder.txtTenPlaylist = convertView.findViewById(R.id.txtTenPlayList);
            viewHolder.imgPlaylist = convertView.findViewById(R.id.imageViewPlayList);
            viewHolder.imgBackgroundlaylist = convertView.findViewById(R.id.imageViewBackgroundPlaylist);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PlayList playList = getItem(position);
        Picasso.with(getContext()).load(playList.getHinhNen()).into(viewHolder.imgBackgroundlaylist);
        Picasso.with(getContext()).load(playList.getHinhIcon()).into(viewHolder.imgPlaylist);
        viewHolder.txtTenPlaylist.setText(playList.getTen());
        return convertView;
    }
}
