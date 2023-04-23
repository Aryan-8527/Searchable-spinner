package com.example.searchablespinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textviews;
    ArrayList<String> arrayList;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviews=findViewById(R.id.testView);
        arrayList=new ArrayList<>();

        arrayList.add("Arya Sharma");
        arrayList.add("Dev Saxena");
        arrayList.add("Sagar Mittal");
        arrayList.add("Vijay Sharma");
        arrayList.add("Aakash Sharma");
        arrayList.add("Rajat goyal");
        arrayList.add("Riyaz Ahmad");
        arrayList.add("Sagar Verma");
        arrayList.add("Ajay Sharma");
        arrayList.add("Vijay Saxena");
        arrayList.add("Shivam Mittal");
        arrayList.add("Kartik Sharma");
        arrayList.add("Ashu Sharma");
        arrayList.add("Raju");
        arrayList.add("Faisu");
        arrayList.add("Samsung");

        textviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog=new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.searchable_spinner);

                dialog.getWindow().setLayout(650,800);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

                EditText editTexts = dialog.findViewById(R.id.edit_text);
                ListView listViews = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this , android.R.layout.simple_list_item_1,arrayList);

                listViews.setAdapter(adapter);
                editTexts.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        textviews.setText(adapter.getItem(position));
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}