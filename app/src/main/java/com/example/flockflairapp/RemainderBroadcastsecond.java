package com.example.flockflairapp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class RemainderBroadcastsecond extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        intent = new Intent(context, QuestionOfTheDay.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "TheBotanistnew")
                .setSmallIcon(R.drawable.thebotanist)
                .setContentTitle("Random Questions of Std12!")
                .setContentText("Hey Students ! Can you solve this questions?")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(2, builder.build());

    }
}
