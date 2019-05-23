package com.appmp3.appnhac.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.appmp3.appnhac.Login.LoginActivity;
import com.appmp3.appnhac.R;

public class ManHinhChaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhchao_layout);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                }catch(Exception e){

                }finally {
                    Intent iLogin=new Intent(ManHinhChaoActivity.this, LoginActivity.class);
                    startActivity(iLogin);
                    finish();

                }
            }
        });
        thread.start();
    }
}
