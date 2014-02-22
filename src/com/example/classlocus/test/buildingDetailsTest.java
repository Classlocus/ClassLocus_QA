package com.example.classlocus.test;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.classlocus.BuildingDetail;
import com.example.classlocus.R;
import com.google.android.gms.maps.model.LatLng;

public class buildingDetailsTest extends ActivityInstrumentationTestCase2<BuildingDetail> {

	BuildingDetail activity;
	
	public buildingDetailsTest() {
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
	
	public final void testDistanceClose(){
		//Distance from the intersection near weatherford to that same location
		String testString = activity.buildingDistance(new LatLng(Double.parseDouble("44.564591"), 
				Double.parseDouble("-123.279995")), 
				new LatLng(Double.parseDouble("44.564591"), 
						Double.parseDouble("-123.279995")));
		assertEquals(testString, testString, "0.0m");
	}

	public final void testDistanceFar(){
		//distance between the intersection near weatherford and the intersection near Kerr
		//1.5hrs and counting! starting again at 1:17PM
		String testString = activity.buildingDistance(
				new LatLng(Double.parseDouble("44.564591"), Double.parseDouble("-123.279995")),
				new LatLng(Double.parseDouble("44.564576"), Double.parseDouble("-123.274029")));
		testString = testString.substring(0, testString.indexOf('.'));
		assertEquals(testString, String.valueOf(testString.charAt(0)), "4");
	}
	
}
