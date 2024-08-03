package com.example.android2_lab6;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackgroundService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service bắt đầu chạy", Toast.LENGTH_SHORT).show();
        try{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(BackgroundService.this, "Đang chuyển", Toast.LENGTH_SHORT).show();
                    Intent webIntent=new Intent(Intent.ACTION_VIEW);
                    webIntent.setData(Uri.parse("https://caodang.fpt.edu.vn/"));
                    webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(webIntent);
                    //thực hiện xong thì đóng service
                    stopSelf();

                }
            },5000);

        }catch (Exception ex){
            Toast.makeText(this, "Lỗi chuyển qua web", Toast.LENGTH_SHORT).show();
            stopSelf();
        }
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy service", Toast.LENGTH_SHORT).show();
    }
}
