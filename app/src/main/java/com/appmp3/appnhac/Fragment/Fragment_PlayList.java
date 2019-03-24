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
import com.appmp3.appnhac.R;

public class Fragment_PlayList extends Fragment{
    View view;
    String[] items = new String[3];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        //CardView cardView = view.findViewById(R.id.cardViewPlayList1);
        final ListView listViewPlayList = view.findViewById(R.id.listViewPlayList);
        items[0] = "PlayList1";
        items[1] = "PlayList2";
        items[2] = "PlayList3";
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,items);
        listViewPlayList.setAdapter(arrayAdapter);
        listViewPlayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(items[position].equals("PlayList1")){
                    Intent intent = new Intent(view.getContext(), ListNhac.class);
                    startActivity(intent);
                }
            }
        });
        /*cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListNhac.class);
                startActivity(intent);
            }
        });*/

        return view;
    }
}
