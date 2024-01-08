package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class cartlabActivity extends AppCompatActivity {

    HashMap<String,String> item;
    SimpleAdapter sa;
    TextView tvTotal;
    ListView lst;
    private DatePickerDialog datePickerDialog; // Renamed the variable
    private Button dateButton, timeButton, btnCheckout, btnBack;
    private String dbData;
    private String[][] packages ={};
    private ArrayList list;
    private java.util.List<? extends Map<String,?>> List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartlab);
        dateButton = findViewById(R.id.buttoncartdatepicker);
        btnCheckout = findViewById(R.id.buttoncheckout);
        btnBack = findViewById(R.id.buttonback);
        lst = findViewById(R.id.listviewcart);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username"," ").toString();


        Database db =new Database(getApplicationContext(),"helthcare",null,1);

        float totalAmount =0;
        ArrayList dbdata =db.getCartdata(username,"lab");
        Toast.makeText(getApplicationContext(),""+dbData,Toast.LENGTH_LONG).show();


        packages = new String[dbData.length()][];
        for (int i=0;i< packages.length;i++){
            packages[i]=new String[5];
        }
        for (int i = 0;i<dbData.length();i++){
            String arrData = dbData.split(String.valueOf(i)).toString();
            String[] strDate = arrData.split(Pattern.quote("s"));
            packages[i][0]=strDate[0];
            packages[i][4]="Cost:"+strDate[1]+"/-";
            totalAmount = totalAmount +Float.parseFloat(strDate[1]);

        }
        tvTotal.setText("text cost:"+totalAmount);
        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]);
            list.add(item);


        }
        sa=new SimpleAdapter(this, List,
              R.layout.multi_lines,
              new String[] {"line1","line2","line3","line4","line 5"},
              new int[] {R.id.line_a, R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cartlabActivity.this, labTestActivity.class));
            }
        });

        initDatepicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show(); // Using the class-level variable
            }
        });
    }

    private void initDatepicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2 + "/" + i1 + "/" + i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day); // Assign to the class-level variable
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }
}
