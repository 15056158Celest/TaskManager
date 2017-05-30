package sg.edu.rp.c346.taskmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TaskManagerReciever extends BroadcastReceiver {
    int reqCode = 12345;


    @Override
    public void onReceive(Context context, Intent intent) {
        String id = intent.getStringExtra("ID");
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");


        Intent i = new Intent (context,MainActivity.class);




        PendingIntent pIntent = PendingIntent.getActivity(context,reqCode,i, PendingIntent.FLAG_CANCEL_CURRENT);



        //Build Notification
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(name);
        builder.setContentText(desc);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        // This 1 is, when the user clicks on the notification
        builder.setContentIntent(pIntent);
        //To cancel
        builder.setAutoCancel(true);


        Notification n = builder.build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(123,n);
    }


}
