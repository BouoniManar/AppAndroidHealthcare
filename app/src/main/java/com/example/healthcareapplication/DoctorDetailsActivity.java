package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

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

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Abdelmajid Mselmi", "Hospital Address : Sousse Tunisia", "Exp : 5yrs", "Mobile No:364321498", "600"},
                    {"Doctor Name : Nadia Mezzi ", "Hospital Address : Centre Urbain Nord Tunisia", "Exp : 7yrs", "Mobile No:236521498", "900"},
                    {"Doctor Name : Selim Ben Jaafer", "Hospital Address : Belverdere Tunis Tunisia", "Exp : 10yrs", "Mobile No:9546987123", "500"},
                    {"Doctor Name : Soumaya Mechergui", "Hospital Address : Nabeul Tunisia", "Exp : 4yrs", "Mobile No:45987628", "800"}


            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Zineb Bennani", "Hospital Address : Sousse Tunisia", "Exp : 5yrs", "Mobile No:364321498", "600"},
                    {"Doctor Name : Iyed Hannachi ", "Hospital Address : Centre Urbain Nord Tunisia", "Exp : 7yrs", "Mobile No:236521498", "900"},
                    {"Doctor Name : Maha smaoui", "Hospital Address : Belverdere Tunis Tunisia", "Exp : 10yrs", "Mobile No:9546987123", "500"},
                    {"Doctor Name : Khouloud ben ahmed", "Hospital Address : Nabeul Tunisia", "Exp : 4yrs", "Mobile No:45987628", "800"}


            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Nour ben youssef", "Hospital Address : Sousse Tunisia", "Exp : 5yrs", "Mobile No:364321498", "600"},
                    {"Doctor Name : Wassim mahjoub", "Hospital Address : Centre Urbain Nord Tunisia", "Exp : 7yrs", "Mobile No:236521498", "900"},
                    {"Doctor Name : Manel bouabid", "Hospital Address : Belverdere Tunis Tunisia", "Exp : 10yrs", "Mobile No:9546987123", "500"},
                    {"Doctor Name : Mounir ben chatouh", "Hospital Address : Nabeul Tunisia", "Exp : 4yrs", "Mobile No:45987628", "800"}


            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Souha haddad", "Hospital Address : Sousse Tunisia", "Exp : 5yrs", "Mobile No:364321498", "600"},
                    {"Doctor Name : Raja hedda ", "Hospital Address : Centre Urbain Nord Tunisia", "Exp : 7yrs", "Mobile No:236521498", "900"},
                    {"Doctor Name : Amine bouker", "Hospital Address : Belverdere Tunis Tunisia", "Exp : 10yrs", "Mobile No:9546987123", "500"},
                    {"Doctor Name : Feriel ben smida", "Hospital Address : Nabeul Tunisia", "Exp : 4yrs", "Mobile No:45987628", "800"}


            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Kais Kaabachi", "Hospital Address : Sousse Tunisia", "Exp : 5yrs", "Mobile No:364321498", "600"},
                    {"Doctor Name : Achref khabou", "Hospital Address : Centre Urbain Nord Tunisia", "Exp : 7yrs", "Mobile No:236521498", "900"},
                    {"Doctor Name : Jabil Hachicha", "Hospital Address : Belverdere Tunis Tunisia", "Exp : 10yrs", "Mobile No:9546987123", "500"},
                    {"Doctor Name : Slim dammak", "Hospital Address : Nabeul Tunisia", "Exp : 4yrs", "Mobile No:45987628", "800"}


            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);


            }
        });
    };


    }
