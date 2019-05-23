package com.appmp3.appnhac.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appmp3.appnhac.Model.Album;
import com.appmp3.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHoder> {
    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album,viewGroup,false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int position) {
        Album album = mangalbum.get(position);
        viewHoder.txtCaSiAlbum.setText(album.getTencasiAlbum());
        viewHoder.txtTenAlbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhanhAlbum()).into(viewHoder.imgHinhAlbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public  class ViewHoder extends RecyclerView.ViewHolder{
        ImageView imgHinhAlbum;
        TextView txtTenAlbum, txtCaSiAlbum;
        public ViewHoder (View itemView){
            super(itemView);
            imgHinhAlbum = itemView.findViewById(R.id.imageviewalbum);
            txtTenAlbum = itemView.findViewById(R.id.textviewtenalbum);
            txtCaSiAlbum = itemView.findViewById(R.id.textViewTenCaSiAlbum);
        }
    }
}
