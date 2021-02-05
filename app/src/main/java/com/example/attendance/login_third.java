package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class login_third extends AppCompatActivity {
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_third);
        next=findViewById(R.id.next);
        final DisplayMetrics signup_display=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(signup_display);
        int width=signup_display.widthPixels;
        int height=signup_display.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_MainActivity=new Intent(login_third.this,login_fourth.class);
                startActivity(go_to_MainActivity);
            }
        });
    }
}
