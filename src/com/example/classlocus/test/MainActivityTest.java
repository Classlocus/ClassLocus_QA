package com.example.classlocus.test;

import android.test.ActivityInstrumentationTestCase2;
import com.example.classlocus.MainActivity;
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
	
}
