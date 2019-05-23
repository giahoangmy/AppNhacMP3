package com.appmp3.appnhac.Service;

import com.appmp3.appnhac.Model.Album;
import com.appmp3.appnhac.Model.BaiHat;
import com.appmp3.appnhac.Model.PlayList;
import com.appmp3.appnhac.Model.Quangcao;
import com.appmp3.appnhac.Model.TheLoaiTrongNgay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    //Hàm lấy dữ liệu get từ phía server
    @GET("songbanner.php")
    //Hàm call nhận dữ liệu server trả về
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<PlayList>> GetPlayListCurrentDay();

    @GET("Chudevatheloaitrongngay.php")
    Call<TheLoaiTrongNgay> GetTheLoaiTrongNgay();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<BaiHat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

}

