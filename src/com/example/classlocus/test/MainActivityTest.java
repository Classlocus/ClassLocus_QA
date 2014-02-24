package com.example.classlocus.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;

import com.example.classlocus.MainActivity;
import com.example.classlocus.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.Instrumentation;
import android.app.SearchManager;
import android.content.Context;

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
		mFragment = mActivity.getFragmentManager();
		googleMap = (Fragment) mFragment
				.findFragmentById(com.example.classlocus.R.id.map);
	}

	public void testPreconditions() throws Exception {
		assertNotNull(mActivity);
		assertNotNull(googleMap);
	}

	public void testMapAppears() {
		
		View map = mActivity.findViewById(R.id.map);
		assertNotNull(map);
	}
	
	public void testSearchBarAppears() {
		
		SearchView searchBar = (SearchView) mActivity.findViewById(R.id.action_search);
		assertNotNull(searchBar);
	}
	
	/*
	 * USE IN TEST FOR SEARCH RESULTS?
	 * 
	public void testSearchBar() {
		
		SearchView searchBar = (SearchView) mActivity.findViewById(R.id.action_search);
		searchBar.setQuery("KEC", true);
	}
	*/

}
