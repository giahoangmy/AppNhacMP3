package com.appmp3.appnhac.Signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appmp3.appnhac.Login.LoginWorker;
import com.appmp3.appnhac.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    Button btnSignUp;
    EditText eName,eUsername,ePassword,eEmail;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = (Button) findViewById(R.id.buttonSignUp);
        eName = (EditText) findViewById(R.id.editHoVaTen);
        eUsername = (EditText) findViewById(R.id.editUserName);
        ePassword = (EditText) findViewById(R.id.editPass);
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
        Log.d("a111",name.toString());
        Log.d("a222",email.toString());
        Log.d("a333",username.toString());
        Log.d("a444",pass.toString());

        //Kiểm tra chuỗi email
        pattern = Pattern.compile(EMAIL_PATTERN);
        boolean checkEmail = validate(email);
        //------------------------------------

        if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(name)){
            Toast.makeText(this, "All fileds are required", Toast.LENGTH_SHORT).show();
        }else if(!checkEmail) {
            Toast.makeText(this, "Email is Invalid", Toast.LENGTH_SHORT).show();
        }else if(pass.length()<6){
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        }else{
            String type = "signup";
            SignUpWorker sw = new SignUpWorker(this);
            sw.execute(type,name,email,username,pass);
        }

    }
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
}
