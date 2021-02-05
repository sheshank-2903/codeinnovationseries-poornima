package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab1_sad;
    private PopupWindow window;
    String TAG = "MainActivity";
    CoordinatorLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main=findViewById(R.id.main_Activity);
        fab1_sad = (FloatingActionButton)findViewById(R.id.fab_sad);
        fab1_sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, " open popup window touch");
                main.setAlpha(0.5f);
                ShowPopupWindow();
                //fab1_sad.onWindowFocusChanged(true);
            }
        });
//        main.setAlpha(1.0f);

    }
    private void ShowPopupWindow(){
        try {
            ImageView lab_data,btncamera, settings,logout;

            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popupwindow, null);
            window = new PopupWindow(layout, 310, 1000, true);

            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setOutsideTouchable(true);
            window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    main.setAlpha(1.0f);
                }
            });
            //window.showAtLocation(layout, Gravity.CENTER, 0, 0);
              window.showAtLocation(layout,Gravity.BOTTOM | Gravity.END, 180, 180);
            lab_data = (ImageView) layout.findViewById(R.id.lab_record);
            btncamera = (ImageView) layout.findViewById(R.id.btncamera);
            settings = (ImageView) layout.findViewById(R.id.settings);
            logout = (ImageView) layout.findViewById(R.id.logout);
            lab_data.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, " button call press ");
                    window.dismiss();
                }
            });
            btncamera.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent go_to_scan=new Intent(MainActivity.this,Scan.class);
                    startActivity(go_to_scan);
                }
            });
            settings.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.e(TAG, " video select  touch");
                    window.dismiss();
                }
            });
            logout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.e(TAG, " button close  touch");
                    window.dismiss();
                }
            });
        }catch (Exception e){ }
    }
}
