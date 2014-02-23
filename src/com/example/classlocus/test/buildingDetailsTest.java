package com.example.classlocus.test;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.classlocus.BuildingDetail;
import com.example.classlocus.R;

public class BuildingDetailsTest extends ActivityInstrumentationTestCase2<BuildingDetail> {

	BuildingDetail activity;
	
	public BuildingDetailsTest() {
		super(BuildingDetail.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent i = new Intent(getInstrumentation().getTargetContext(),
				BuildingDetail.class);
		activity = getActivity();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testViewsAppear(){
		assertNotNull(activity.findViewById(R.id.detail_building_name));
		assertNotNull(activity.findViewById(R.id.detail_building_value));
	}
	
	public final void testBuildingDetails() {
		fail("There is not any procedure to input data into the page yet");
		//put data into the views.
		TextView bName = (TextView) activity.findViewById(R.id.detail_building_name);
		TextView bDetails = (TextView) activity.findViewById(R.id.detail_building_value);
		assertNotNull(bName);
		assertNotNull(bDetails);
		//TODO Fill these to match dummy data.
		assertEquals(bName.getText(), "KEC");
		assertEquals(bDetails.getText(), "KEC");
	}

}
