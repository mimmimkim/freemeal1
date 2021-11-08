package com.example.freemeal2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class SupportDetailPopup extends AppCompatActivity {

    private Button btn_popupclose;
    private TextView text_name;
    RelativeLayout RelativeLayout_click1;

   // ArrayList<String> sampledata= new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayList<SampleDataFav> sampledata=new ArrayList<SampleDataFav>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_supportdetail);

        //닫기 클릭시 창 닫기
        btn_popupclose = findViewById(R.id.btn_popupclose);
        btn_popupclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupportDetailPopup.this, SupportInfoActivity.class);
                startActivity(intent);
        }
        });




        String title="";
//        String address="";

        Bundle extras = getIntent().getExtras();

        if(extras==null){
            title="error";
        }
        else{
            title=extras.getString("title");
//            address=extras.getString("address");
        }

        TextView textView = (TextView)findViewById(R.id.text_support_name);

        String str=title +'\n';
        textView.setText(str);

    }
}
