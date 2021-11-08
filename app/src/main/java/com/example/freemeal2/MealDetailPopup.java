package com.example.freemeal2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MealDetailPopup extends AppCompatActivity {

    private Button btn_popupclose;
    private TextView text_name;

    Button checkbox_star;
    boolean i =true;

    ArrayAdapter<String> adapter;
    ArrayList<SampleDataFav> sampledata=new ArrayList<SampleDataFav>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_mealdetail);


        btn_popupclose = findViewById(R.id.btn_popupclose);
        btn_popupclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MealDetailPopup.this, UserMainActivity.class);
                startActivity(intent);
            }
        });

        //즐겨찾기 별 클릭시 즐겨찾기 기능
        checkbox_star=findViewById(R.id.checkbox_star);
        text_name=findViewById(R.id.text_name);

        checkbox_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==true){

                }
                Toast.makeText(getApplicationContext(), "즐겨찾기 되었습니다.", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(MealDetailPopup.this, ListviewFav.class);
//                intent.putExtra("key", "무슨 급식소");
//                startActivity(intent);
            }
        });


//        Intent myIntent=new Intent(this, ListView.class);
//        myIntent.putExtra("급식소 이름", "무료 급식소");
//
//
        //제목 설정
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

        TextView textView = (TextView)findViewById(R.id.text_name);

        String str=title +'\n';
        textView.setText(str);


    }




}
