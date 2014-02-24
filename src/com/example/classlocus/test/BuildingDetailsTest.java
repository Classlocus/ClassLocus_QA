package com.example.classlocus.test;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.mock.MockContext;
import android.util.Log;
import android.widget.TextView;

import com.example.classlocus.BuildingDetail;
import com.example.classlocus.data.*;
import com.example.classlocus.R;

public class BuildingDetailsTest extends ActivityInstrumentationTestCase2<BuildingDetail> {

	BuildingDetail activity;
	
	public BuildingDetailsTest() {
		super(BuildingDetail.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
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
		BuildingsDataSource bds = new BuildingsDataSource(activity);
		assertNotNull(bds);
		Building kelley = bds.createBuilding("Kelley Engineering Center", "KEC"); //Null pointer exception here!
		//Intent i = new Intent(activity, BuildingDetail.class);
		//i.putExtra("buildingID", 7);
		//activity.populate(i);
		//put data into the views.
		/*TextView bName = (TextView) activity.findViewById(R.id.detail_building_name);
		TextView bDetails = (TextView) activity.findViewById(R.id.detail_building_value);
		assertNotNull(bName);
		assertNotNull(bDetails);
		//TODO Fill these to match dummy data.
		assertEquals(bName.getText(), "KEC");
		assertEquals(bDetails.getText(), "KEC");*/
		bds.deleteBuilding(kelley);
	}

}
