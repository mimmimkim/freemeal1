package com.example.freemeal2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class VolunteerDetailPopup extends AppCompatActivity {

    private Button btn_vol_popupclose;
    private Button btn_apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_volunteerdetail);


        btn_vol_popupclose = findViewById(R.id.btn_vol_popupclose);
        btn_vol_popupclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //닫기
                Intent intent = new Intent(VolunteerDetailPopup.this, VolunteerResisterActivity.class);
                startActivity(intent);
            }
        });

        //신청 버튼 클릭하면 메뉴의 신청 리스트뷰에 뜨게하기.
        btn_apply=findViewById(R.id.btn_apply);
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name="";
                Bundle extras = getIntent().getExtras();
                name = extras.getString("title");

                Intent intent =new Intent(getApplicationContext(), UserMenuActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });



        //위치, 인원 등 내용 채워넣기
        String title="";
        String address="";
        String date="";
        String person="";

        Bundle extras = getIntent().getExtras();

        if(extras==null){
            title="error";
            address="error";
        }
        else{
            title=extras.getString("title");
            address=extras.getString("address");
            date=extras.getString("date");
            person=extras.getString("person");
        }


        //봉사지 이름
        TextView textView1 = (TextView)findViewById(R.id.text_volunteer_name);

        String str=title +'\n';
        textView1.setText(str);


        //봉사지 위치
        TextView textView2=(TextView)findViewById(R.id.volunteer_lacation);
        String adr=address;
        textView2.setText(adr);


        //봉사지 날짜
        TextView textView3=(TextView)findViewById(R.id.volunteer_date);
        String dat=date;
        textView3.setText(dat);


        //봉사지 인원
        TextView textView4=(TextView)findViewById(R.id.volunteer_person);
        String per=person;
        textView4.setText(per);


    }
}
