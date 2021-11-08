package com.example.freemeal2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostDialog extends Dialog {
    private static final String URL = "http://18.190.33.132:8081/location/add/";

    private Context mContext;
    private static PostDialog postDialog;

    private MyAPI myAPI;

    private EditText etLan;
    private EditText etLat;
    private EditText etAdd;
    private EditText etNum;
    private EditText etDate;
    private EditText etTime;
    private EditText etUid;

    private Button btnOk;
    private Button btnNo;

    public PostDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_input);

        initMyAPI(URL);

        etLan = (EditText) findViewById(R.id.etLan);
        etLat = (EditText) findViewById(R.id.etLat);
        etAdd = (EditText) findViewById(R.id.etAdd);
        etNum = (EditText) findViewById(R.id.etNum);
        etDate = (EditText) findViewById(R.id.etDate);
        etTime = (EditText)findViewById(R.id.etTime);
        etUid = (EditText) findViewById(R.id.etUid);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnNo = (Button)findViewById(R.id.btnNo);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lan = Double.parseDouble(etLan.getText().toString());
                double lat = Double.parseDouble(etLat.getText().toString());
                String add = etAdd.getText().toString();
                String dt = etDate.getText().toString() + " " + etTime.getText().toString();
                int num = Integer.parseInt(etNum.getText().toString());
                int uid = Integer.parseInt(etUid.getText().toString());
                Log.d("정보", lan + ", " + lat + "\t" + dt + "\t");
                LocationItem locItem = new LocationItem(lan, lat, add, dt, num, uid);
                myAPI.postLocation(locItem).enqueue(new Callback<LocationItem>() {
                    @Override
                    public void onResponse(Call<LocationItem> call, Response<LocationItem> response) {
                        if(response.isSuccessful()) {
                            Log.d("보내기", "성공");
                            dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<LocationItem> call, Throwable t) {
                        Log.d("보내기", "실패");
                        Toast.makeText(mContext, "실패하였습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
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
