package com.example.freemeal2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button btn_user;
    private final String URL = "http://18.190.33.132:8081/location/";

    MyAPI myAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_user = findViewById(R.id.btn_user);
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnGet:
                        Intent intent = new Intent(MainActivity.this, GetActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnPost:
                        PostDialog postDialog = new PostDialog(MainActivity.this);
                        postDialog.setCancelable(false);
                        postDialog.show();

                }


                Intent intent = new Intent(MainActivity.this, UserMainActivity.class);
                startActivity(intent);
            }
        });
    }

        private void post () {

        }

        private void initMyAPI (String url){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            myAPI = retrofit.create(MyAPI.class);


        }
    }
