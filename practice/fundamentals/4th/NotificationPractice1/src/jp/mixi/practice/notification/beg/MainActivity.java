
package jp.mixi.practice.notification.beg;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO ここで通知を表示する
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        Notification notification = builder
                // 通知の日時
        //        .setWhen(System.currentTimeMillis())
                // 通知のタイトル
         //       .setContentTitle("通知だヨ！")
                // 通知の詳細メッセージ
          //      .setContentText("通知の詳しい内容をここに書きます。")
                // 通知を表示した瞬間、通知バーに表示するショートメッセージ
           //     .setTicker("通知だヨ！")
                // 通知をタップした時に使う PendingIntent
   //             .setContentIntent(pendingIntent)
                // この通知が未だ表示されていない時だけ、音やバイブレーション、ショートメッセージの表示を行う
           //     .setOnlyAlertOnce(true)
                // タップしたら消えるようにする
            //    .setAutoCancel(true)
  //              .build();
        /*
                // 直接インスタンス化せず、Context を経由してインスタンスを取得する
                NotificationManager manager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
                // 通知の種類に応じて id を割当てることが出来る。
                // id の異なる通知は違うものとして扱われる。
                manager.notify(0, notification);
                :*/
    }
}