package com.example.freemeal2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GetActivity extends AppCompatActivity {
    private final String URL = "http://18.190.33.132:8081/location/";

    private MyAPI myAPI;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        textView = (TextView)findViewById(R.id.textView);
        initMyAPI(URL);

        Call<List<LocationItem>> getLocation = myAPI.getLocation();
        getLocation.enqueue(new Callback<List<LocationItem>>() {
            @Override
            public void onResponse(Call<List<LocationItem>> call, Response<List<LocationItem>> response) {
                if(response.isSuccessful()) {
                    List<LocationItem> mList = response.body();
                    String result = "";

                    for(LocationItem item : mList) {
                        result +=
                                " _lid: " + item.get_lid() + "\n_uid: " + item.get_uid()
                                        + "\nlat: " + item.getLat() + "\nlan: " + item.getLan() + "\nnum: " + item.getNum()
                                        + "\naddress: " + item.getAddress() + "\ndatetime: " + item.getDt() + "\n\n";
                        textView.setText(result);
                    }
                }
                else
                    textView.setText("status Code: " + response.code());
            }

            @Override
            public void onFailure(Call<List<LocationItem>> call, Throwable t) {
                Log.d("Activity", "Fail msg " + t.getMessage());
            }
        });
    }

    private void initMyAPI(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPI = retrofit.create(MyAPI.class);
    }
}
