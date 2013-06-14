package jp.mixi.practice.network.networkpractice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
public class MyPostAsyncTask extends AsyncTask<Void, Void, Void> {
	private StringBuffer src = new StringBuffer();
	private Context mApplicationContext;

	public MyPostAsyncTask(Context applicationContext) {
		super();
		mApplicationContext = applicationContext;
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
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    /**
     * 非同期処理の本体
     * 引数は非同期処理内容に渡すためのパラメータ配列。
     * @return 
     */
    @Override
    protected Void doInBackground(Void... params) {
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
    	          connection.setRequestMethod("POST");
    	          connection.setDoOutput(true);

    	          String postData = "hoge=fuga&piyo=test";
    	          OutputStream os = connection.getOutputStream();
    	          os.write(postData.getBytes());
    	          os.flush();
    	          os.close();

    	          InputStream is = connection.getInputStream();

    	          BufferedReader br = new BufferedReader(new InputStreamReader(is, "euc-jp"));
    	             while (true) {
    	            	 String line = br.readLine();
    	            	 if(line == null) break;

    	            	 src.append(line);
    	                 Log.v("sss", "pos "+ line);
    	             }
    	    
    	      } catch (IOException e) {
    	          e.printStackTrace();
    	      } finally{
    	          connection.disconnect();
    	      }
    	
        return null;
    }

    /**
     * 非同期処理の実行後に、UI スレッドで実行する処理。
     * 引数は {@link AsyncTask#execute(Object...)} の返り値。
     */
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        Toast.makeText(mApplicationContext, "post", Toast.LENGTH_SHORT).show();
    }
}
