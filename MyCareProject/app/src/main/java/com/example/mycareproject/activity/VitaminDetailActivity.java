package com.example.mycareproject.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mycareproject.R;
import com.example.mycareproject.dto.Vitamin;
import com.example.mycareproject.dto.Vitaminday;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class VitaminDetailActivity extends AppCompatActivity implements Serializable {
    TextView vitaminName, tv, nutrition, add, nutritions;
    static RequestQueue requestQueue;
    ImageView imageView;
    ImageButton btnToBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_detail);


        imageView = findViewById(R.id.imageView);
        nutrition = findViewById(R.id.nutrition);
        add = findViewById(R.id.add);
        nutritions = findViewById(R.id.nutritions);

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
                Intent intent = new Intent(VitaminDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 상품 상세 화면 MainActivity에서 값 받아오기
        vitaminName  = findViewById(R.id.vitaminName);

        String vitamins = getIntent().getStringExtra("vitaminName");
        int img = getIntent().getIntExtra("img", 0);
        int id = getIntent().getIntExtra("id", 0);

        vitaminName.setText(vitamins);
        imageView.setImageResource(img);



        // web에서 안드로이드로 list값 받아오기
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }



        String url = "http://121.144.112.203:9097/ROOT/nutrition?vitaminid=" + id;
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){

                        Gson gson = new Gson();
                        Vitamin[] vitamin = gson.fromJson(response, Vitamin[].class);


                        for(int i=0; i<vitamin.length; i++){
                            String[] v = vitamin[i].toString().split(",");

                            for(int j=2; j<v.length-1; j++){
                               // Log.i("response : " , v[j]);
                                String[] vi = v[j].split("=");
                                if(!vi[1].equals("0")){
                                    nutrition.append(vi[0] + "\n\n");
                                    add.append(vi[1] + "\n\n");
                                 // Log.i("aaaaaaaaa", v[j]);
                                }
                            }
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

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




        String url1 = "http://121.144.112.203:9097/ROOT/vitaminday";
        StringRequest request1 = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){

                        Gson gson = new Gson();
                        Vitaminday[] vitaminday = gson.fromJson(response, Vitaminday[].class);

                        String[] ai= nutrition.getText().toString().split("\n\n");
                        String[] as = add.getText().toString().split("\n\n");



                        for(int i=0; i<vitaminday.length; i++){
                            for(int j=0; j<ai.length; j++){
                                if(vitaminday[i].getVitamin().trim().contains(ai[j].trim())){

                                    if(vitaminday[i].getMaxnum() < Integer.parseInt(as[j])) {
                                        nutritions.append("초과" + "\n\n");
                                    }
                                    if(vitaminday[i].getMinnum() > Integer.parseInt(as[j])){
                                        nutritions.append("부족"+ "\n\n");
                                    }
                                    if((vitaminday[i].getMinnum() < Integer.parseInt(as[j])) && (Integer.parseInt(as[j]) < vitaminday[i].getMaxnum())){
                                        nutritions.append("적정"+ "\n\n");
                                    }
                                }
                            }

                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        request1.setShouldCache(false);
        requestQueue.add(request1);
    }


}