package com.appmp3.appnhac.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appmp3.appnhac.Adapter.BannerAdapter;
import com.appmp3.appnhac.Model.Quangcao;
import com.appmp3.appnhac.R;
import com.appmp3.appnhac.Service.APIService;
import com.appmp3.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment {

    View view;//sử dụng để ánh sạ những view bên trong layout này vào
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    //Tao thuoc tinh tu dong chuyen doi banner
    Runnable runnable;
    Handler handler;
    int currentItem;
    //onCreateView hàm để gắng view layout vào
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);
        //getdata() dùng để đọc dữ liệu
        GetData();
        anhxa();
        return view;
        //sau đó gắn view vào trang chủ

    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.viewpaper);
        circleIndicator = view.findViewById(R.id.indicatordefault);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Quangcao>> callback = dataservice.GetDataBanner();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                //Trả về dưới dạng mảng object
                ArrayList<Quangcao> banners = (ArrayList<Quangcao>) response.body();
                //Chuyen du lieu cho BannerAdapter
                bannerAdapter = new BannerAdapter(getActivity(),banners);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        //set vi tri hien tai
                        currentItem = viewPager.getCurrentItem();
                        //hien tai la 1, cho tang len 2
                        currentItem++;
                        //vi tri vuot qua so trang cua viewpaper, set = 0
                        if(currentItem >= viewPager.getAdapter().getCount()){
                            currentItem = 0;
                        }
                        viewPager.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);
            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {
                Log.d("sss1","Hoangmy12");
            }
        });
    }
}
