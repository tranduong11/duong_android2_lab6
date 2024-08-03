package com.example.android2_lab6;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class FouregroundService extends Service {


    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Có thể sử dun intent hoặc bundle để nhận dữ liệu từ service
        Toast.makeText(this, "Service đang chạy ", Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,
                ConfigNotification.CHANNEL_ID_BAI2)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Service đang chạy")
                .setContentText("Bạn không thể tắt bằng cách trượt ngang ")
                .setColor(Color.RED);
        //tạo notification và truyền nos vào startFouregroundService
        Notification notification=(Notification) builder.build();
        startForeground(1,notification);
        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy service", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
