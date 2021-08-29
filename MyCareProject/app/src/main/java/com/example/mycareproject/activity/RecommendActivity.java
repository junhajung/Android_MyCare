package com.example.mycareproject.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mycareproject.R;
import com.example.mycareproject.dto.CheckList;
import com.example.mycareproject.dto.Recommend;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class RecommendActivity extends AppCompatActivity {
    TextView recommendvitamin1, recommendvitamin2, recommendvitamin3 ,tv;

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

        setContentView(R.layout.activity_recommend);

        // 배너 클릭시 홈으로 이동
        tv = findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        recommendvitamin1 = findViewById(R.id.recommendvitamin1);
        recommendvitamin2 = findViewById(R.id.recommendvitamin2);
        recommendvitamin3 = findViewById(R.id.recommendvitamin3);

        Intent intent = getIntent();
        String recommendlist1 = intent.getStringExtra("recommendlist1");
        String recommendlist2 = intent.getStringExtra("recommendlist2");
        String recommendlist3 = intent.getStringExtra("recommendlist3");

        recommendvitamin1.setText("1. " + recommendlist1);
        recommendvitamin2.setText("2. " + recommendlist2);
        recommendvitamin3.setText("3. " + recommendlist3);

    }
}