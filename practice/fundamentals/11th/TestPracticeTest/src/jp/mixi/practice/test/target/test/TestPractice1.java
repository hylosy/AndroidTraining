package jp.mixi.practice.test.target.test;

import jp.mixi.practice.test.target.SubActivity;
import jp.mixi.practice.test.target.TestTarget1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;

public class TestPractice1 extends AndroidTestCase {
	protected void setup() throws Exception
	{
		super.setUp();
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void teststartSubActivity(){
		TestTarget1 target = new TestTarget1();
		target.startSubActivity(new TestTarget1Context(getContext()), "hogehoge");
	}

	private static class TestTarget1Context extends MockContext{
		private Context mContext;
		
		public TestTarget1Context(Context baseContext){
			mContext = baseContext;
		}
		public String getPackageName(){
			return mContext.getPackageName();
		}
		
		public void startActivity(Intent intent){
			ComponentName component = intent.getComponent();
			assertEquals(SubActivity.class.getCanonicalName(), component.getClassName());
			assertTrue(intent.hasExtra(Intent.EXTRA_SUBJECT));
			assertEquals("hogehoge", intent.getStringExtra(Intent.EXTRA_SUBJECT));
			assertEquals(intent.getFlags(), Intent.FLAG_ACTIVITY_FORWARD_RESULT | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			assertEquals(intent.getData(), Uri.parse("http://mixi.jp"));
		}
		
	}
	
	public void testisValidIntent(Intent intent){
		TestTarget1 target = new TestTarget1();
		target.isValidIntent(intent);
		
	}

}
