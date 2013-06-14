package jp.mixi.assignment.sqlite.beg;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AndroidNameOpenHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME ="plactice.db";
	
	private static final String ANDROID_TABLE_CREATE = 
			"CREATE TABLE " + AndroidName.ANDROID_TABLE_NAME + " (" +
			AndroidName._ID + "INTEGER PRIMARY KEY," +
			AndroidName.COLUMN_NAME_ANDROID_CODE + "TEXT NOT NULL, " + 
			AndroidName.COLUMN_NAME_CODE_VERSION + "TEXT);";
	
	

	private static final String ANDROID_TABLE_DELETE = 
				"DROP TABLE IF EXISTS " + AndroidName.ANDROID_TABLE_NAME;
	
	public AndroidNameOpenHelper(Context context) {
		super(context,DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(ANDROID_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(ANDROID_TABLE_DELETE);
		
	}

}
