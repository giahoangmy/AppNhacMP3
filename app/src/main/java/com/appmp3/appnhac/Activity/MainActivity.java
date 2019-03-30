package com.appmp3.appnhac.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.appmp3.appnhac.Adapter.MainViewPaperAdapter;
import com.appmp3.appnhac.Fragment.Fragment_Profile;
import com.appmp3.appnhac.Fragment.Fragment_Tim_Kiem;
import com.appmp3.appnhac.Fragment.Fragment_Trang_Chu;
import com.appmp3.appnhac.Login.LoginActivity;
import com.appmp3.appnhac.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    String userName;
    Integer tan = 1;
    Integer my = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent iUser = getIntent();
        Bundle b = iUser.getExtras();
        userName = (String) b.get("USER");
        anhxa();
        init();

    }

    private void init(){
        MainViewPaperAdapter mainViewPaperAdapter = new MainViewPaperAdapter(getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("USERNAME", userName);
        // set Fragmentclass Arguments, chuyền dữ liệu userName cho Fragment_Profile
        Fragment_Profile fragmentProfile = new Fragment_Profile();
        fragmentProfile.setArguments(bundle);
        //-------------------------------

        //Gắn những trang Fragment vào ViewPaper
        mainViewPaperAdapter.addFragment(new Fragment_Trang_Chu(),"Trang Chu");
        mainViewPaperAdapter.addFragment(fragmentProfile,"Profile");
        mainViewPaperAdapter.addFragment(new Fragment_Tim_Kiem(),"Tim Kiem");
        viewPager.setAdapter(mainViewPaperAdapter);
        //setup ViewPaper vào TabLayout, số trang VỉewPaper tương ứng với số TabLayout
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_account_circle);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_search);

    }
    private  void anhxa(){
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPaper);
    }
}
