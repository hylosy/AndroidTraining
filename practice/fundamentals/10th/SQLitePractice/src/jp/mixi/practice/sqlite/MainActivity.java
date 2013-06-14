
package jp.mixi.practice.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Insert).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        findViewById(R.id.Delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        findViewById(R.id.Update).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        findViewById(R.id.Query).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });

    }

    private void insert() {
        // TODO:ここにinsert処理を実装してください
    	BookOpenHelper bookopenhelper = new BookOpenHelper(this.getApplicationContext()); 
    	SQLiteDatabase sqlitedatabase = bookopenhelper.getWritableDatabase();
    	Book book = new Book("title_hoge", "huga publisher", 1000);
    	ContentValues values = new ContentValues(); 
    	values.put(Book.COLUMN_NAME_BOOK_TITLE, book.getTitle());
    	values.put(Book.COLUMN_NAME_BOOK_PUBLISHER, book.getPublisher());
    	values.put(Book.COLUMN_NAME_BOOK_PRICE, book.getPrice());
    
    	long rowId = sqlitedatabase.insert(Book.BOOK_TABLE_NAME, null, values);
    	Log.v("insert", "insert book");

    }

    private void delete() {
        // TODO:ここにdelete処理を実装してください
    	BookOpenHelper bookopenhelper = new BookOpenHelper(this.getApplicationContext()); 
    	SQLiteDatabase sqlitedatabase = bookopenhelper.getWritableDatabase();
    	
    	String selection = Book.COLUMN_NAME_BOOK_PRICE + "= ?";
    	String[] selectionArgs = { "1000" };
    	int deletedCount = sqlitedatabase.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);
    	Log.v("delete", "delete");
    }

    private void update() {
        // TODO:ここにupdate処理を実装してください
      	BookOpenHelper bookopenhelper = new BookOpenHelper(this.getApplicationContext()); 
    	SQLiteDatabase sqlitedatabase = bookopenhelper.getWritableDatabase();

    	ContentValues values = new ContentValues();
    	values.put(Book.COLUMN_NAME_BOOK_TITLE, "NEW TITLE");
    	
       	String selection = Book.COLUMN_NAME_BOOK_TITLE + " LIKE ?";
    	String[] selectionArgs = { "TITLE%" };
    	
    	int updatedCounte = sqlitedatabase.update(Book.BOOK_TABLE_NAME, values, selection, selectionArgs);
    	Log.v("update", "update title");
    }

    private void query() {
        // TODO:ここにquery処理を実装してください
     	BookOpenHelper bookopenhelper = new BookOpenHelper(this.getApplicationContext()); 
    	SQLiteDatabase sqlitedatabase = bookopenhelper.getWritableDatabase();
    	
    	String[] projection = {
    			Book._ID,
    			Book.COLUMN_NAME_BOOK_TITLE,
    			Book.COLUMN_NAME_BOOK_PUBLISHER,
    			Book.COLUMN_NAME_BOOK_PRICE
    	};
    
    	
    	String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
    	String[] selectionArgs = {
    			"1000"
    	};
    	
    	Cursor cursor = sqlitedatabase.query(Book.BOOK_TABLE_NAME, projection, selection, selectionArgs, null, null, null);;
    	boolean moveToFirst = cursor.moveToFirst();
    	long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(Book._ID));
    	Log.v("query", "read");
    	cursor.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
