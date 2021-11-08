package com.example.freemeal2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListviewFav extends AppCompatActivity {

    private Button listview_delete_button;
    TextView TextView_get;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_custom_mypage);


        Intent intent=getIntent();

        String key =intent.getStringExtra("key");

        TextView_get=findViewById(R.id.text_name);



//        Intent secondIntent = getIntent();
//        secondIntent.getStringExtra("급식소 이름");

    }

}


