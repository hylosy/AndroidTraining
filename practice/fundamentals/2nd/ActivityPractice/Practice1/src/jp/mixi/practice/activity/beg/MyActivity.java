package jp.mixi.practice.activity.beg;

import android.app.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class MyActivity extends FragmentActivity{

	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_my);
	        FragmentManager manager = getSupportFragmentManager();
	        // レイアウトから Fragment を見つけ出してインスタンスを得る
	        Fragment fragment = manager.findFragmentById(R.id.MyFragment);
	        
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	
}
