package com.example.freemeal2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freemeal2.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserMenuActivity extends AppCompatActivity {

    ArrayList<String> sampledata = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayList<SampleDataFav> samplelist = new ArrayList<SampleDataFav>();
    ListView fav_listView;

    private Button btn_support_info;
    private Button btn_volunteer_resister;

    private ListView fav_meal_listView;
    private TextView soup_kitchen_name;
    private Button delete_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermenu);

        soup_kitchen_name = (TextView) findViewById(R.id.soup_kitchen_name);
        fav_meal_listView = (ListView) findViewById(R.id.fav_meal_listView);


/////////////////////////////////////////////////////////////////////////////
        //후원 정보 버튼
        btn_support_info = findViewById(R.id.btn_support_info);
        btn_support_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserMenuActivity.this, SupportInfoActivity.class);
                startActivity(intent);
            }
        });

        //봉사 신청 버튼
        btn_volunteer_resister = findViewById(R.id.btn_volunteer_resister);
        btn_volunteer_resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserMenuActivity.this, VolunteerResisterActivity.class);
                startActivity(intent);
            }
        });
    }

        //즐겨찾기한 급식소 리스트뷰

        public void setListView () {
//            fav_listView = (ListView) findViewById(R.id.fav_meal_listView);
//
//            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sampledata);
//            fav_listView.setAdapter(adapter);
//
//            data.add(new ListViewApply("ddd"));
//
//            fav_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = new Intent(UserMenuActivity.this, SupportDetailPopup.class);
////                    SampleDataFav sam = samplelist.get(position);
//                    intent.putExtra("samplelist", sampledata);
//                    startActivity(intent);
//
//                }
//            });



        //신청한 봉사정보 리스트뷰
        //데이터 준비



            ArrayList<ListViewApply> data = new ArrayList<>();


            Intent intent =getIntent();
            intent.getParcelableArrayExtra("name");
//           data.add(new ListViewApply("ddd"));

            //어댑터
            ApplyAdapter adapter = new ApplyAdapter(data);
            //뷰
            ListView listView = findViewById(R.id.listView_volunteer_apply);
            listView.setAdapter(adapter);


            //클릭
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(UserMenuActivity.this, VolunteerDetailPopup.class);
                    startActivity(intent);
                }
            });


    }
}




//        final FavAdapter FavAdapter = new FavAdapter(this, soup_kitchen_DataList);
//
//        listView.setAdapter(FavAdapter);
//        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView parent, View v, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        FavAdapter.getItem(position).getSoup_kitchen_name(),
//                        Toast.LENGTH_LONG).show();
//
//
//            }
//        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ListView listView=(ListView)adapterView;
//                @Override
//                        public void onClick(DialogInterface dialog, int which){
//
//                }
//            }
//        });

///////////////////////////////////////////////////////////////////////////////////////////
//
//        ListView listView2 = (ListView) findViewById(R.id.listView_volunteer_info_check);
//        final FavAdapter FavAdapter2 = new FavAdapter(this, soup_kitchen_DataList);
//
//        listView2.setAdapter(FavAdapter2);
//
//        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView parent, View v, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        FavAdapter2.getItem(position).getSoup_kitchen_name(),
//                        Toast.LENGTH_LONG).show();
//            }
//        });

//    }
//
//
//    public void InitializeSoupData()
//
//    {
//        soup_kitchen_DataList = new ArrayList<SampleDataFav>();
//
//        soup_kitchen_DataList.add(new SampleDataFav("서울 1 급식소"));
//        soup_kitchen_DataList.add(new SampleDataFav("경기 1 급식소"));
//        soup_kitchen_DataList.add(new SampleDataFav("서울 2 급식소"));
//        }









