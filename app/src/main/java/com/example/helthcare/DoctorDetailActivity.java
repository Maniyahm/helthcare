package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    private String[][] doctor_detail1=
            {
                    {"Doctor name : ajit donbhal", "Hospital address : vareli", "Exp : 10yrs", "Mobile no=8976543456"},
                    {"Doctor name : manoj gundaliya", "Hospital address = mumbai", "Exp = 15yrs", "Mobile no=7463543456"},
                    {"Doctor name : parbat ajit", "Hospital address = france", "Exp = 15yrs", "Mobile no=7846543456"},
                    {"Doctor name : mayur rana", "Hospital address = dubai", "Exp = 13yrs", "Mobile no=8746343456"},
                    {"Doctor name : surya rana", "Hospital address = punjab", "Exp = 53yrs", "Mobile no=8976836333"}
            };
    private String[][] doctor_detail2 =
            {
                    {"Doctor name: kinjal donbhal", "Hospital address: vareli", "Exp: 10yrs", "Mobile no: 8976543456","400"},
                    {"Doctor name: hemali gundaliya", "Hospital address: mumbai", "Exp: 15yrs", "Mobile no: 7463543456","500"},
                    {"Doctor name: parbat pratap", "Hospital address: france", "Exp: 15yrs", "Mobile no: 7846543456","600"},
                    {"Doctor name: mayur kumar singh", "Hospital address: dubai", "Exp: 13yrs", "Mobile no: 8746343456","695"},
                    {"Doctor name: surya morya", "Hospital address: punjab", "Exp: 53yrs", "Mobile no: 8976836333","800"}
            };
    private String[][] doctor_detail3 =
            {
                    {"Doctor name: a k", "Hospital address: vareli", "Exp: 10yrs", "Mobile no: 8976543456","900"},
                    {"Doctor name: manoj sharma", "Hospital address: mumbai", "Exp: 15yrs", "Mobile no: 7463543456","758"},
                    {"Doctor name: pankaj patel", "Hospital address: france", "Exp: 15yrs", "Mobile no: 7846543456","600"},
                    {"Doctor name: mayur maniya", "Hospital address: dubai", "Exp: 13yrs", "Mobile no: 8746343456","543"},
                    {"Doctor name: shilesh dhola", "Hospital address: punjab", "Exp: 53yrs", "Mobile no: 8976836333","455"}
            };
    private String[][] doctor_detail4 =
            {
                    {"Doctor name: jareewala nainal", "Hospital address: vareli", "Exp: 10yrs", "Mobile no: 8976543456","544"},
                    {"Doctor name: maya patel", "Hospital address: mumbai", "Exp: 15yrs", "Mobile no: 7463543456","455"},
                    {"Doctor name: pardeep ajit", "Hospital address: france", "Exp: 15yrs", "Mobile no: 7846543456","544"},
                    {"Doctor name: sanjay r rana", "Hospital address: dubai", "Exp: 13yrs", "Mobile no: 8746343456","1100"},
                    {"Doctor name: salman khan", "Hospital address: punjab", "Exp: 53yrs", "Mobile no: 8976836333","233"}
            };
    private String[][] doctor_detail5 =
            {
                    {"Doctor name: ankur bhimani", "Hospital address: vareli", "Exp: 10yrs", "Mobile no: 8976543456","489"},
                    {"Doctor name: pardeep singh dillo", "Hospital address: mumbai", "Exp: 15yrs", "Mobile no: 7463543456","433"},
                    {"Doctor name: maya ahir", "Hospital address: france", "Exp: 15yrs", "Mobile no: 7846543456","2000"},
                    {"Doctor name: mayur patel", "Hospital address: dubai", "Exp: 13yrs", "Mobile no: 8746343456","433"},
                    {"Doctor name: sandeep maheshwwri", "Hospital address: punjab", "Exp: 53yrs", "Mobile no: 8976836333","7560"}
            };
    TextView tv;
    Button btn;
    String [][] getdoctor_detail ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewCartPackagename);
        btn = findViewById(R.id.ButtonGoBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        String[][] doctor_detail;



        if(title.compareTo("family_phaysician")==0)
            doctor_detail= doctor_detail1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_detail= doctor_detail2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_detail= doctor_detail3;
        else
        if(title.compareTo("Surgon")==0)
            doctor_detail= doctor_detail4;
        else
            doctor_detail= doctor_detail5;




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailActivity.this, FinddoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_detail.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",doctor_detail[i][0]);
            item.put("line2",doctor_detail[i][1]);
            item.put("line3",doctor_detail[i][2]);
            item.put("line4",doctor_detail[i][3]);
            item.put("line5","cons Fees"+  doctor_detail[i][4]+"/-");
            list.add(item);



        }
        sa =new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.listviewcart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailActivity.this,BookAppoitmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);




            }
        });


    }
}
