package com.appmp3.appnhac.Login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.appmp3.appnhac.Activity.MainActivity;
import com.appmp3.appnhac.Adapter.MainViewPaperAdapter;
import com.appmp3.appnhac.R;
import com.appmp3.appnhac.Signup.SignUp;

public class LoginActivity extends AppCompatActivity {

    EditText userName, password;
    TextView register;
    CardView cardView;
    Button buttonView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cardView = (CardView) findViewById(R.id.cardView);
        userName = (EditText) findViewById(R.id.editTextUser);
        password = (EditText) findViewById(R.id.editTextPass);
        register = (TextView) findViewById(R.id.textViewRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRegister();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openMainActivity();
                onLogin();
            }
        });

    }

    public void  gotoRegister(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void onLogin(){
        String username = userName.getText().toString();
        String pass = password.getText().toString();
        String type = "login";
        LoginWorker lw = new LoginWorker(this);
        lw.execute(type,username,pass);
    }


    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
