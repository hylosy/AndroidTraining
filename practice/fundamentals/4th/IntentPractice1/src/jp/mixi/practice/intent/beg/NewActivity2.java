package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewActivity2 extends Activity {
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        setContentView(R.layout.activity_main);

	        Intent received = getIntent();
	        String stringExtra = received.getStringExtra("toast_message"); // 文字列の Extra を取り出す

	        // テキストビューを生成
	        TextView text = new TextView(this);
	        text.setText(new String("new Activity2!   " + stringExtra));
	         
	        LinearLayout layout = new LinearLayout(this);
	        // レイアウトにテキストビューを追加
	        layout.addView(text);
	        setContentView(layout);
	        setContentView(layout);
	        
	    }
}
