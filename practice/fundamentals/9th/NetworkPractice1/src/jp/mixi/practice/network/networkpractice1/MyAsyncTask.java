package jp.mixi.practice.network.networkpractice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void, String, String> {
	private StringBuffer src = new StringBuffer();
	private TextView textview = null;
	public MyAsyncTask(TextView tv) {
		super();
		textview = tv;
	}

    /**
     * 非同期処理を実行する前に UI スレッドで実行する処理を書く
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * 非同期処理の進捗を受け取るコールバック。
     */
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textview.setText(values[0]);
    }

    /**
     * 非同期処理の本体
     * 引数は非同期処理内容に渡すためのパラメータ配列。
     * @return 
     */
    @Override
    protected String doInBackground(Void... params) {
    	 URL url = null;
    	 StringBuilder src = new StringBuilder();
		try {
			url = new URL("http://mixi.jp");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         HttpURLConnection connection = null;
         try {
             connection = (HttpURLConnection) url.openConnection();
             connection.connect();
             InputStream is = connection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is, "euc-jp"));
             while (true) {
            	 String line = br.readLine();
            	 if(line == null) break;

            	 src.append(line);
                 Log.v("sss", "jello "+ line);
             }
             /*            
             while (true) {
                 byte[] line = new byte[1024];
                 int size = is.read(line);
                 if (size <= 0)
                     break;
                 src.append(new String(line, "utf-8"));
//                 Log.v("sss", "jello "+ line);

             }
             */
         } catch (IOException e) {
             e.printStackTrace();
         } finally{
             connection.disconnect();
         }
    	publishProgress(src.toString());
        return src.toString();
    }

    /**
     * 非同期処理の実行後に、UI スレッドで実行する処理。
     * 引数は {@link AsyncTask#execute(Object...)} の返り値。
     */
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        result = src.toString();
        
        
      //  Toast.makeText(mApplicationContext, src.toString(), Toast.LENGTH_SHORT).show();
    }
    
    
}