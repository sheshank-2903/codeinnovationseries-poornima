package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login_first extends AppCompatActivity {
        Button main;
        TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_first);
        main=findViewById(R.id.main);
        login=findViewById(R.id.login);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_main=new Intent(login_first.this,MainActivity.class);
                startActivity(go_to_main);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login=new Intent(login_first.this,login_second.class);
                startActivity(go_to_login);
            }
        });
    }
}
