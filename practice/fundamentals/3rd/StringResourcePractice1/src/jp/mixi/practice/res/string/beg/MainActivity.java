
package jp.mixi.practice.res.string.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    StringBuffer sentence = new StringBuffer(getString(R.string.my_format, 1, 2));  
//        TextView tv = new TextView(this);
   //     TextView tv = (TextView) this.findViewById(R.layout.pluraltext);
   //     tv.setText(sentence);
   //     setContentView(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
