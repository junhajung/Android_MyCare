package com.example.mycareproject.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
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
import com.example.mycareproject.dto.CheckList;
import com.example.mycareproject.dto.Recommend;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CheckListActivity extends AppCompatActivity {
    TextView checkdate, tv;
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년 MM월 dd일 체크리스트");
    static RequestQueue requestQueue;
    CheckBox[] ch = new CheckBox[9];
    Button submit;
    int ids[] = {R.id.ch1, R.id.ch2,R.id.ch3,R.id.ch4,R.id.ch5,R.id.ch6,R.id.ch7,R.id.ch8,R.id.ch9};
    CheckList[] checkLists;
    ImageButton btnToBack;



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

        setContentView(R.layout.activity_check_list);

        btnToBack = findViewById(R.id.btnToBack);
        btnToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 배너 클릭시 홈으로 이동
        tv = findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        for(int i=0; i<ch.length; i++){
            ch[i] = findViewById(ids[i]);
        }


        // 날짜 업데이트
        checkdate = findViewById(R.id.checkdate);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        String time = dateformat.format(date);
        checkdate.setText(time);

        // checkbox 선택 후 submit
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
                Intent intent = new Intent(CheckListActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });

        // web에서 안드로이드로 list값 받아오기
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        String url = "http://121.144.112.203:9097/ROOT/checklist";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("response : ", response);
                        process(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error : ", error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }

    // web에서 받아온 list값 입력
    private void process(String response){
        Gson gson = new Gson();
        checkLists = gson.fromJson(response, CheckList[].class);

        for(int i=0; i<9; i++){
            ch[i].setText(checkLists[i].getList());

        }
    }

    private void sendRequest() {
        String url = "http://121.144.112.203:9097/ROOT/checkPost";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("checkedResponse : ", response);

                        Gson gson = new Gson();
                        Recommend[] recommends = gson.fromJson(response, Recommend[].class);
                        Intent intent = new Intent(getApplicationContext(), RecommendActivity.class);

                        for(int i=0; i<recommends.length; i++){
                                String recommendlist1 = recommends[0].getRecommendlist();
                                intent.putExtra("recommendlist1", recommendlist1);

                                String recommendlist2 = recommends[1].getRecommendlist();
                                intent.putExtra("recommendlist2", recommendlist2);

                                String recommendlist3 = recommends[2].getRecommendlist();
                                intent.putExtra("recommendlist3", recommendlist3);
                        }
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Error : ", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                String checkString = "";

                for(int i=0; i<ch.length; i++){
                    if(ch[i].isChecked() == true){
                        //Log.i("aaaaaaaaaaaaaaaa", checkLists[i].getCheckid() + "");
                        checkString += checkLists[i].getCheckid() + " ";
                    }
                }
                Log.i("aaaaaaa", checkString);
                params.put("checked", checkString.trim());
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }

}