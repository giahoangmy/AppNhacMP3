package com.appmp3.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appmp3.appnhac.Activity.PlayNhacActivity;
import com.appmp3.appnhac.Model.BaiHat;
import com.appmp3.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaiHatHotAdapter extends RecyclerView.Adapter<BaiHatHotAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public BaiHatHotAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_hot,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        BaiHat baiHat = baiHatArrayList.get(position);
        viewHolder.txtcasi.setText(baiHat.getCasi());
        viewHolder.txtten.setText(baiHat.getTenbaihat());
        Picasso.with(context).load(baiHat.getHinhbaihat()).into(viewHolder.imghinh);
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten,txtcasi;
        ImageView imghinh,imgluotthich;
        public ViewHolder(View itemView){
            super(itemView);
            txtten =  itemView.findViewById(R.id.textviewTenBaiHatHot);
            txtcasi = itemView.findViewById(R.id.textviewTenCaSiBaiHatHot);
            imghinh = itemView.findViewById(R.id.imageViewBaiHatHot);
            imgluotthich = itemView.findViewById(R.id.imageViewLuotThich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",baiHatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
