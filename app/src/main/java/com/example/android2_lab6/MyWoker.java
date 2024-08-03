package com.example.android2_lab6;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWoker extends Worker {

    public MyWoker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Handler handler=new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // sau 1s sẽ toast lên
                Toast.makeText(getApplicationContext(), "Đang sạc", Toast.LENGTH_SHORT).show();
            }
        },1000);



        return Result.success();
    }
}
