package com.appmp3.appnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.appmp3.appnhac.Activity.ListNhac;
import com.appmp3.appnhac.Activity.MainActivity;
import com.appmp3.appnhac.Activity.PlayerActivityNgocNga;
import com.appmp3.appnhac.R;

public class Fragment_PlayList extends Fragment{
    View view;
    String[] items = new String[4];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        //CardView cardView = view.findViewById(R.id.cardViewPlayList1);
        final ListView listViewPlayList = view.findViewById(R.id.listViewPlayList);
        items[0] = "Có thể bạn muốn nghe";
        items[1] = "Dành cho bạn";
        items[2] = "La cà nghe nhạc";
        items[3] = "Top 100";

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,items);
        listViewPlayList.setAdapter(arrayAdapter);
        listViewPlayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(items[position].equals("Có thể bạn muốn nghe")){
                    Intent intent = new Intent(view.getContext(), ListNhac.class);
                    startActivity(intent);
                }
                if(items[position].equals("Dành cho bạn")){
                    Intent intent = new Intent(view.getContext(), PlayerActivityNgocNga.class);
                    startActivity(intent);
                }
            }
        });
        onClickCardView();

        return view;
    }
    public void onClickCardView(){
        CardView cardView1 = view.findViewById(R.id.cardViewTheLoai1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
        CardView cardView2 = view.findViewById(R.id.cardViewTheLoai2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
        CardView cardView3 = view.findViewById(R.id.cardViewTheLoai3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
        CardView cardView4 = view.findViewById(R.id.cardViewTheLoai4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
        CardView cardView5 = view.findViewById(R.id.cardViewTheLoai5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
        CardView cardView6 = view.findViewById(R.id.cardViewTheLoai6);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
        CardView cardView7 = view.findViewById(R.id.cardViewTheLoai7);
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
        CardView cardView8 = view.findViewById(R.id.cardViewTheLoai8);
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });
    }
}
