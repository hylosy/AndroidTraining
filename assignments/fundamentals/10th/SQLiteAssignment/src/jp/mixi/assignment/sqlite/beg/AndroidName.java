package jp.mixi.assignment.sqlite.beg;

import android.provider.BaseColumns;

public class AndroidName implements BaseColumns {


	public static final String ANDROID_TABLE_NAME ="practice";

	public static final String COLUMN_NAME_ANDROID_CODE = "name";	
	public static final String COLUMN_NAME_CODE_VERSION = "version";
	
	private String mCode;
	private int mVersion;
	
	public AndroidName(String code, int version){
		super();
		mCode = code;
		mVersion = version;
	}

	public String getCode(){
		return mCode;
	}
	
	public int getVersion(){
		return mVersion;
	}

}
