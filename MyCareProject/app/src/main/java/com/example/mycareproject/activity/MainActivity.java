package com.example.mycareproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
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
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    static RequestQueue requestQueue;
    Button checkList;
    TextView textView, setid;
    TextView[] tv = new TextView[3];

    int ids[] = {R.id.vitaminName, R.id.vitaminName1, R.id.vitaminName2};
    int imgids[] = {R.drawable.vitaminb, R.drawable.bacteria1,  R.drawable.calcum};
    int vitaminids[] = new int[3];

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
        setContentView(R.layout.activity_main);

        // nav 슬라이드 바 열기
        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ImageView iv = findViewById(R.id.imageMenu);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
                String id = sharedPreferences.getString("id","");

                setid = findViewById(R.id.setid);
                if(id!=null && id!="") setid.setText(id + "님 안녕하세요");
                else setid.setText("로그인이 필요합니다");

                // start에 지정된 Drawer 열기
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);

        // 네비게이션 view의 item 클릭 리스너
        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener(this);
        }
        // 이미지 아이콘
        navigationView.setItemIconTintList(null);


        // 배너 클릭시 홈으로 이동
        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



        // 상품명 클릭시 상세 상품으로 이동
        for(int i=0; i<tv.length; i++){
            final int idx = i;


            tv[i] = findViewById(ids[i]);
            tv[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, VitaminDetailActivity.class);

                    intent.putExtra("vitaminName", tv[idx].getText().toString());
                    intent.putExtra("img", imgids[idx]);
                    intent.putExtra("id", vitaminids[idx]);

                    startActivity(intent);
                }
            });
        }


        // 검색
        SearchView sv = findViewById(R.id.search);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                Log.i("search Key Word : ", query);
                intent.putExtra("search", query);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        // checklist 시작하기
        checkList = findViewById(R.id.checkList);
        checkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
                String id = sharedPreferences.getString("id","");
                String pw = sharedPreferences.getString("pw","");

                if(id!=null && id!="" && pw!=null && pw!=""){
                    Intent intent = new Intent(MainActivity.this, CheckListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);


                }
                else{
                    Toast.makeText(getApplicationContext(), "로그인이 필요한 서비스입니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });


        // 비타민 추천상품 리스트 출력
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }


        String url = "http://121.144.112.203:9097/ROOT/vitaminlist";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                      //  Log.i("response : " , response);
                       process(response);
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



    }


    private void process(String response){
        Gson gson = new Gson();
        String[] vitamins = gson.fromJson(response, String[].class);
        String vitaminString = "";

        for(int i=0; i<tv.length; i++){
            vitaminString += vitamins[i] + "&";
            String[] vitaminStrings = vitaminString.split("&");
            String[] vitaminsplit = vitaminStrings[i].split(",");

            for(int j=0; j<3; j++){
                tv[i].setText(vitaminsplit[1]);
                vitaminids[i] = Integer.parseInt(vitaminsplit[0]);
            }

        }
    }

    //item 클릭 이벤트
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();

        switch (id){
            case R.id.nav_home:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.eyes:
                Toast.makeText(this, "눈 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stomach:
                Toast.makeText(this, "위 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lungs:
                Toast.makeText(this, "폐 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.brain:
                Toast.makeText(this, "뇌 클릭", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    // 회원정보가 있을 시 메인화면에서 로그인 화면으로 back 안되도록
    @Override
    public void onBackPressed(){
        SharedPreferences sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
        String id = sharedPreferences.getString("id","");

        if(id!=null && id!=""){

        }
        else{
            super.onBackPressed();
        }
    }

}