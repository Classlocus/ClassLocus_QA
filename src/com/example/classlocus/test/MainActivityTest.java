package com.example.classlocus.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

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
		mFragment = mActivity.getFragmentManager();
		googleMap = (Fragment) mFragment.findFragmentById(com.example.classlocus.R.id.map);
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
		assertTrue(true);
	}
	
	public void testRealSearch(){
		assertTrue(true);
	}
}
