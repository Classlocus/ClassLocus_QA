package com.example.classlocus.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.classlocus.Help;
import com.example.classlocus.R;

public class HelpTest extends ActivityInstrumentationTestCase2<Help> {

	Help mActivity;

	public HelpTest() {
		super(Help.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPreconditions() throws Exception {
		assertNotNull(mActivity);
	}

	public final void testViewsAppear() {
		// test whether layout views appear
		assertNotNull(mActivity.findViewById(R.id.button1));
		assertNotNull(mActivity.findViewById(R.id.projectMembersList));
		assertNotNull(mActivity.findViewById(R.id.projectDescription));
	}
	
}
