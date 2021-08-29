package com.example.mycareproject.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mycareproject.R;
import com.pedro.library.AutoPermissionsListener;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements AutoPermissionsListener {
    Button login, btnJoin;
    EditText edid, edpw, edJoinid, edJoinname, edJoinpw;
    static RequestQueue requestQueue;
    TextView join, btnToJoin, btnGuest;
    LinearLayout LoginLayout, JoinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 상단 상태바 없애기
        if(Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else{
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }

        setContentView(R.layout.activity_login);

        login = findViewById(R.id.Login);
        edid = findViewById(R.id.edid);
        edpw = findViewById(R.id.edpw);
        join = findViewById(R.id.join);
        btnToJoin = findViewById(R.id.btnToLogin);
        LoginLayout = findViewById(R.id.LoginLayout);
        JoinLayout = findViewById(R.id.JoinLayout);
        edJoinid = findViewById(R.id.edJoinid);
        edJoinname = findViewById(R.id.edJoinname);
        edJoinpw = findViewById(R.id.edJoinpw);
        btnJoin = findViewById(R.id.btnJoin);
        btnGuest = findViewById(R.id.btnGuest);

        SharedPreferences sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = edid.getText().toString();
                String pw = edpw.getText().toString();
                String url = "http://121.144.112.203:9097/ROOT/login";


                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("login", response);
                        Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                        edid.setText("");
                        edpw.setText("");

                        SharedPreferences sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("id", id);
                        editor.putString("pw", pw);
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                        return;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }
                }
                ){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String , String> params = new HashMap<String, String>();

                        params.put("id", id);
                        params.put("pw", pw);

                        return params;
                    }
                };
                request.setShouldCache(false);
                requestQueue.add(request);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    String id = edJoinid.getText().toString();
                    String pw = edJoinpw.getText().toString();
                    String name = edJoinname.getText().toString();

                    String url = "http://121.144.112.203:9097/ROOT/join";
                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(LoginActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                    ){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String , String>();
                            params.put("id", id);
                            params.put("pw", pw);
                            params.put("name", name);

                            edJoinid.setText("");
                            edJoinpw.setText("");
                            edJoinname.setText("");

                            return params;
                        }
                    };
                    request.setShouldCache(false);
                    requestQueue.add(request);


            }
        });
    }

    @Override
    public void onDenied(int i, String[] strings) {

    }

    @Override
    public void onGranted(int i, String[] strings) {

    }

    public void frontTextClicked(View view){
        switch(view.getId()){
            case R.id.join:
                LoginLayout.setVisibility(View.GONE);
                JoinLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.btnToLogin:
                JoinLayout.setVisibility(View.GONE);
                LoginLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.btnGuest:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }
}