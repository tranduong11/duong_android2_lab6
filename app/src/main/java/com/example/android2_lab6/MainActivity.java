package com.example.android2_lab6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSend=findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.lofo_fpt);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,
                        ConfigNotification.CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setLargeIcon(bitmap)
                        .setColor(Color.RED)
                        .setAutoCancel(true)
                        .setContentTitle("Chào mừng đến với FPT Polytechnic")
                        .setContentText("Android 2")
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(bitmap).bigLargeIcon((Bitmap) null));
                NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.
                        from(MainActivity.this);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS)==
                         PackageManager.PERMISSION_GRANTED){
                    //nếu đã có quyền ta thực hiện push notification
                    //mỗi thông báo có mooitj id riêng
                    notificationManagerCompat.notify((int) new Date().getTime(),builder.build());
                }
                else{
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.POST_NOTIFICATIONS},900);
                }
            }
        });
    }
}