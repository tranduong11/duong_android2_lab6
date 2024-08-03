package com.example.android2_lab6;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

public class ConfigNotification extends Application {

    public static final String CHANNEL_ID="LAB6_ANDROID2";
    public static final String CHANNEL_ID_BAI2="LAB6_BAI2";

    @Override
    public void onCreate() {
        super.onCreate();
        config();
    }
    public void config(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            //ten can dang ki
            CharSequence name=getString(R.string.channel_name);
            // mo ta
            String description=getString(R.string.description);
            //do uu tien
            int importance=NotificationManager.IMPORTANCE_DEFAULT;
            Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

            AudioAttributes attributes=new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,name,importance);
            channel.setDescription(description);
            channel.setSound(uri,attributes);
            // dang ki voi he thong
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            CharSequence name2=getString(R.string.channel_name_2);
            // mo ta
            String description2=getString(R.string.description_2);
            //do uu tien
            int importance2=NotificationManager.IMPORTANCE_DEFAULT;
            Uri uri2= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

            AudioAttributes attributes2=new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            NotificationChannel channel2=new NotificationChannel(CHANNEL_ID_BAI2,name2,importance2);
            channel.setDescription(description2);
            channel.setSound(uri2,attributes2);
            // dang ki voi he thong
            NotificationManager notificationManager2=getSystemService(NotificationManager.class);
            notificationManager2.createNotificationChannel(channel2);
        }
    }
}
