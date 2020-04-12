package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    private TextView textView;
    private TextView phoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        textView = findViewById(R.id.text);
        phoneNo = findViewById(R.id.phone);
        Bundle extra = getIntent().getExtras();
        if(extra != null ) {
            String name = extra.getString("name");
            String phone = extra.getString("phone");

            textView.setText(name);
            phoneNo.setText(phone);

        }
    }
}
