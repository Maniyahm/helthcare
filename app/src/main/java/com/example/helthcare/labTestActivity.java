package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class labTestActivity extends AppCompatActivity {

    private String[][] Package =
            {
                    {"Package 1: Full Body Checkup", "", "", "", "999"},
                    {"Package 2: Blood Glucose Fasting", "", "", "", "299"},
                    {"Package 3: Covid 19 Antibody", "", "", "", "899"},
                    {"Package 4: Thyroid Check", "", "", "", "499"},
                    {"Package 5: Immunity", "", "", "", "699"},
            };
    private String[] package_detail = {
            "Blood Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbAlc\n" +
                    "Iron Studies\n" +
                    "Kidney Function\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function\n" +
                    "Liver Function Test\n",
            "Blood Glucose Fasting",
            "COVID-19 Antibody - IgG",
            "Thyroid profile-Total (T3, T4 & Tsh Ultra-sensitive)",
            "Complete Hemogram\n" +
                    "CRP (C Reactive protein) Quantitative, serum\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Lipid Profile"
    };
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttondetail);
        btnBack = findViewById(R.id.ButtonGoBack);
        listView = findViewById(R.id.listviewcart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(labTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < Package.length; i++) {
            item = new HashMap<>();
            item.put("line1", Package[i][0]);
            item.put("line2", Package[i][1]);
            item.put("line3", Package[i][2]);
            item.put("line4", Package[i][3]);
            item.put("line5", "total cost: " + Package[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(getApplicationContext(), list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(labTestActivity.this, labTestDetailActivity.class);
                it.putExtra("text1", Package[i][0]);
                it.putExtra("text2", package_detail[i]);
                it.putExtra("text3", Package[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(labTestActivity.this, cartlabActivity.class));
            }
        });
    }
}
