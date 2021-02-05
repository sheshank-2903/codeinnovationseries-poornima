package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class Scan extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView zxv;
    ImageView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        zxv=findViewById(R.id.zxscan);
        tv=findViewById(R.id.txt_result);
        Dexter.withActivity(Scan.this).withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        zxv.setResultHandler(Scan.this);
                        zxv.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(Scan.this, "Enable the permission from App Setting", Toast.LENGTH_LONG).show();
                        Intent go_to_main=new Intent(Scan.this,MainActivity.class);
                        startActivity(go_to_main);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        Toast.makeText(Scan.this, "Acccept please!!", Toast.LENGTH_LONG).show();

                    }
                }).check();
    }
    public void handleResult(Result rawResult) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(400);
        //tv.setText(rawResult.toString());
        tv.setImageResource(R.drawable.done_gif);
        Intent go_to_Main=new Intent(Scan.this,MainActivity.class);
        startActivity(go_to_Main);
        //onResume();
    }

    @Override
    protected void onDestroy() {
        zxv.stopCamera();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zxv.setResultHandler(this);
        zxv.startCamera();
    }
}
