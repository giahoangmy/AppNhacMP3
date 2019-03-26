package com.appmp3.appnhac.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.appmp3.appnhac.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class ListNhac extends AppCompatActivity {
    ListView myListViewForSong;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nhac);
        myListViewForSong = (ListView) findViewById(R.id.mySongListView);
        runtimePermission();
    }
    public void runtimePermission(){

        Dexter.withActivity(this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {

                display();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    public ArrayList<File> findSong(File file){
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){

                arrayList.addAll(findSong(singleFile));
            }
            else {
                //Lấy ra những file có đuôi .mp3 hoặc .wav
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                    arrayList.add(singleFile);
                }
            }
        }
        return arrayList;
    }

    void display(){
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());//lấy danh sách file nhạc trong hệ thống
        items = new String[mySongs.size()];
        for(int i =0;i<mySongs.size();i++){
            //lấy tên của nhạc, thay đổi ký tự .mp3 và . wav thành ký tự trắng ""
            items[i] = mySongs.get(i).getName().replace(".mp3","").replace(".wav","");
        }
        //tạo mảng ArrayAdapter kieu String, đưa mảng danh sach nhạc tên items vào mảng ArrayAdapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        //setAdapter vào ListView để hiển thị
        myListViewForSong.setAdapter(myAdapter);
        //Bắt sự kiện click cho ListView
        myListViewForSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String songName = myListViewForSong.getItemAtPosition(position).toString();
                startActivity(new Intent(getApplicationContext(),PlayerActivity.class)
                        .putExtra("songs",mySongs).putExtra("songname",songName).putExtra("pos",position));
            }
        });
    }
}
