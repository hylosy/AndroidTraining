package jp.mixi.practice.network.networkpractice1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textview = null;	

	@Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder()
                    .detectNetwork()
                    .penaltyDeath()
                    .build());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View buttonGet = findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // http getの処理を書く
            	// 非同期処理の開始
            	textview = (TextView)findViewById(R.id.responce);
                 new MyAsyncTask(textview).execute();
                
            }
        });
        View buttonPost = findViewById(R.id.buttonPost);
        buttonPost.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // http postの処理を書く
            	
        //    	new MyPostAsyncTask(getApplicationContext(textview)).execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
