package com.example.android2_lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;

public class Bai2Activity extends AppCompatActivity {

    private Button btnStart,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnStart=findViewById(R.id.btnStart_b2);
        btnStop=findViewById(R.id.btnStop_b2);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Bai2Activity.this, FouregroundService.class);
                startService(intent);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Bai2Activity.this, FouregroundService.class);
                stopService(intent);
            }
        });
        Constraints constraints=new Constraints.Builder()
                .setRequiresCharging(true).build();
        WorkRequest myWorkRequest=new OneTimeWorkRequest.Builder(MyWoker.class)
                .setConstraints(constraints).build();
        // gửi workRequest đến hệ thống
        WorkManager.getInstance(Bai2Activity.this).enqueue(myWorkRequest);
    }
}