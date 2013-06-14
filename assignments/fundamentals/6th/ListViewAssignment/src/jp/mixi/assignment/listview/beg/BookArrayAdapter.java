package jp.mixi.assignment.listview.beg;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class BookArrayAdapter extends BaseAdapter {

	private Context context;
	private List<Book> books;
	
	public BookArrayAdapter(Activity mActivity, ArrayList<Book> list) {
		this.context = mActivity;
		this.books = list;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return books.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return books.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
