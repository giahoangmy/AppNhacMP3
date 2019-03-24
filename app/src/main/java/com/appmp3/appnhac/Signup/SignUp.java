package com.appmp3.appnhac.Signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.appmp3.appnhac.Login.LoginWorker;
import com.appmp3.appnhac.R;

public class SignUp extends AppCompatActivity {
    Button btnSignUp;
    EditText eName,eUsername,ePassword,eEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = (Button) findViewById(R.id.buttonSignUp);
        eName = (EditText) findViewById(R.id.editHoVaTen);
        eUsername = (EditText) findViewById(R.id.editHoVaTen);
        ePassword = (EditText) findViewById(R.id.editHoVaTen);
        eEmail = (EditText) findViewById(R.id.editEmail);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignup();
            }
        });
    }

    public void onSignup(){
        String name = eName.getText().toString();
        String email = eEmail.getText().toString();
        String username = eUsername.getText().toString();
        String pass = ePassword.getText().toString();
        String type = "signup";
        SignUpWorker sw = new SignUpWorker(this);
        sw.execute(type,name,email,username,pass);
    }
}
