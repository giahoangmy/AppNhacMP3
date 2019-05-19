package com.appmp3.appnhac.Signup;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.appmp3.appnhac.Activity.MainActivity;
import com.appmp3.appnhac.Login.LoginActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SignUpWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    SignUpWorker (Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        Log.d("hoangmy1",type);
        String login_url = "http://10.0.2.2:8081/PhpAppNhac/Service/signup.php";
        if(type.equals("signup")) {
            try {
                String name = params[1];
                String email = params[2];
                String user_name = params[3];
                String password = params[4];
                Log.d("a111",name);
                Log.d("a222",email);
                Log.d("a333",user_name);
                Log.d("a444",password);
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode(
                        "name","UTF-8")
                        +"="
                        +URLEncoder.encode(name,"UTF-8")
                        +"&"
                        +URLEncoder.encode(
                        "email","UTF-8")
                        +"="
                        +URLEncoder.encode(email,"UTF-8")
                        +"&"
                        +URLEncoder.encode(
                        "user_name","UTF-8")
                        +"="
                        +URLEncoder.encode(user_name,"UTF-8")
                        +"&"
                        +URLEncoder.encode("password","UTF-8")
                        +"="
                        +URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("SignUp");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
        if(result.contains("success")){
            Intent intent = new Intent();
            intent.setClass(context.getApplicationContext(), LoginActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
