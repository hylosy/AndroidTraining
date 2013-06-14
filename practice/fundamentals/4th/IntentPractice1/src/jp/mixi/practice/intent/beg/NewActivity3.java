package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewActivity3 extends Activity {

	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	      

	        // テキストビューを生成
	        TextView text = new TextView(this);
	        text.setText("new Activity3!");
	         
	        LinearLayout layout = new LinearLayout(this);
	        // レイアウトにテキストビューを追加
	        layout.addView(text);
	        setContentView(layout);
	        
	        setContentView(layout);
	    }
	
	
}
