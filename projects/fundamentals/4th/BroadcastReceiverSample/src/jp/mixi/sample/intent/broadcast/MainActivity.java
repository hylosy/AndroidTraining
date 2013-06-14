
package jp.mixi.sample.intent.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    // 迢ｬ閾ｪ縺ｫ螳夂ｾｩ縺励◆縲！ntent 縺ｮ Action
    public static final String ACTION_HOGEHOGE = "jp.mixi.sample.android.intent.action.HOGEHOGE";

    private BroadcastReceiver mMyReceiver = new MyDynamicBroadcastReceiver();
    private BroadcastReceiver mMyReceiver2 = new MyNestedDynamicBroadcastReceiver();
    private BroadcastReceiver mMyReceiver3 = new MyNestedDynamicBroadcastReceiver2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 縺薙� Activity 縺ｮ Context 縺ｫ BroadacstReceiver 縺ｮ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧貞虚逧�↓逋ｻ骭ｲ縺吶ｋ
        registerReceiver(mMyReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));

        // 縺薙� Activity 繧呈戟縺､ Application 縺ｮ Context 縺ｫ BroadcastReceiver 縺ｮ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧貞虚逧�↓逋ｻ骭ｲ縺吶ｋ
        getApplicationContext().registerReceiver(mMyReceiver2, new IntentFilter(Intent.ACTION_HEADSET_PLUG));

        registerReceiver(mMyReceiver3, new IntentFilter(ACTION_HOGEHOGE));
    }

    @Override
    protected void onStop() {
        super.onStop();

        // 縺薙� Activity 縺ｮ Context 縺ｫ逋ｻ骭ｲ縺励◆ BroadcastReceiver 縺ｮ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧定ｧ｣髯､縺吶ｋ
        // 縺薙ｌ繧定｡後ｏ縺ｪ縺�→縲、ctivity 縺梧ｭｻ繧薙□縺ゅ→繧�BroadcastReceiver 縺檎函縺阪◆縺ｾ縺ｾ縺ｫ縺ｪ繧翫�繝｡繝｢繝ｪ繝ｪ繝ｼ繧ｯ縺ｨ縺ｪ繧九′縲√す繧ｹ繝�Β縺後Μ繝ｼ繧ｯ繧呈､懃衍縺励※蠑ｷ蛻ｶ隗｣髯､縺吶ｋ
        unregisterReceiver(mMyReceiver);

        // 縺薙� Activity 繧呈戟縺､ Application 縺ｮ Context 縺ｫ逋ｻ骭ｲ縺励◆ BroadcastReceiver 縺ｮ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧定ｧ｣髯､縺吶ｋ
        // 縺薙ｌ繧定｡後ｏ縺ｪ縺�→縲、ctivity 縺梧ｭｻ繧薙□縺ゅ→繧�BroadcastReceiver 縺檎函縺阪◆縺ｾ縺ｾ縺ｫ縺ｪ繧翫�繝｡繝｢繝ｪ繝ｪ繝ｼ繧ｯ縺ｨ縺ｪ繧�        // 繧ｷ繧ｹ繝�Β縺ｯ閾ｪ蜍輔〒逋ｻ骭ｲ繧定ｧ｣髯､縺励↑縺��縺ｧ縲�←蛻�↑繧ｿ繧､繝溘Φ繧ｰ縺ｧ遒ｺ螳溘↓隗｣髯､縺吶ｋ縺薙→繧定ｦ∵ｱゅ＆繧後ｋ
        getApplicationContext().unregisterReceiver(mMyReceiver2);

        unregisterReceiver(mMyReceiver3);
    }

    public void onClick(View v) {
        // Intent 縺ｮ繝悶Ο繝ｼ繝峨く繝｣繧ｹ繝�        
    	Intent intent = new Intent();
        intent.setAction(ACTION_HOGEHOGE);
        sendBroadcast(intent);
    }

    public class MyNestedDynamicBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v(TAG, "broadcast received in nested receiver.");
        }
    }

    public class MyNestedDynamicBroadcastReceiver2 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v(TAG, "broadcast received in nested receiver 2.");
        }
    }
}