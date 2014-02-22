package com.example.classlocus.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;

import com.example.classlocus.MainActivity;
import com.example.classlocus.R;

import android.app.Fragment;
import android.app.FragmentManager;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	private FragmentManager mFragment;
	private Fragment googleMap;
	
	public MainActivityTest() {
	      super(MainActivity.class);
	    }
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		//mFragment = mActivity.getFragmentManager();
		//googleMap = (Fragment) mFragment.findFragmentById(com.example.classlocus.R.id.map);
		//while (menu.findItem(R.id.action_search).getActionView() == null);
		//sv = (SearchView) menu.findItem(R.id.action_search).getActionView();
	}
	
	public void testPreconditions() {
		assertNotNull(mActivity);
		assertNotNull(googleMap);
	}
	
	public void testMapAppears(){
		View map = mActivity.findViewById(R.id.map);
		assertNotNull(map);
	}
	
	public void testJunkSearch(){
		//search_function("Not a room");
		//TODO find out what exactly is supposed to happen when I make a search.
		fail("Where to recieve search results?");
	}
	
	public void testRealSearch(){
		//Search_function("KEC 3065");
		//TODO find out what exactly is supposed to happen when I make a search.
		fail("Where to recieve search results?");
	}
}
