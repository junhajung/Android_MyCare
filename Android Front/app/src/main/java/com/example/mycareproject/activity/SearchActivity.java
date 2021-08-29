package com.example.mycareproject.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mycareproject.R;
import com.example.mycareproject.dto.Recommend;
import com.example.mycareproject.dto.Symptom;
import com.example.mycareproject.dto.Vitamin;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {
    TextView searchtext, vitamin1, tv, symptoms;
    static RequestQueue requestQueue;


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



        setContentView(R.layout.activity_search);

        vitamin1 = findViewById(R.id.vitamin1);
        symptoms = findViewById(R.id.symptoms);

        // 배너 클릭시 홈으로 이동
        tv = findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String search = intent.getStringExtra("search");
        searchtext = findViewById(R.id.searchtext);
        searchtext.setText(search + "");

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        String url = "http://121.144.112.203:9097/ROOT/search";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      //  Log.i("SearchPost : ", response);

                        Gson gson = new Gson();
                        Vitamin[] vitamin = gson.fromJson(response, Vitamin[].class);

                        if(response.equals("[]")) {
                            vitamin1.append("검색결과가 없습니다");
                        }
                        else{
                            for(int i=0; i<vitamin.length; i++) {
                                String[] v = vitamin[i].toString().split(",");
                                String[] vi = v[1].split("=");

                                vitamin1.append(vi[1] + '\n' + '\n');
                            }
                        }
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

                params.put("search", search);
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);



        String url1 = "http://121.144.112.203:9097/ROOT/symptomlist?vitaminsearch=" + search;
        StringRequest request1 = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Symptom : ", response);

                        Gson gson = new Gson();
                        Symptom[] symptom = gson.fromJson(response, Symptom[].class);

                        if(response.equals("[]")) {
                            symptoms.append("검색결과가 없습니다");
                        }
                        else {
                            for (int i = 0; i < symptom.length; i++) {
                                String[] a = symptom[i].toString().split(",");
                                String[] splita = a[1].split("=");

                                symptoms.append(splita[1]);
                            }
                        }
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
                return params;
            }
        };
        request1.setShouldCache(false);
        requestQueue.add(request1);
    }
}