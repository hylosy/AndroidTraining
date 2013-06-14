package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewActivity1 extends Activity{
	  public static final int REQUEST_CODE_HOGE = 1;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        // テキストビューを生成
	        TextView text = new TextView(this);
	        text.setText("new Activity1");
	         
	        LinearLayout layout = new LinearLayout(this);
	        // レイアウトにテキストビューを追加
	        layout.addView(text);
	        setContentView(layout);
	    }
}
