package com.example.classlocus.test;
import java.util.ArrayList;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import android.content.Intent;

import com.example.classlocus.BuildingDetail;
import com.example.classlocus.R;
import com.example.classlocus.data.Building;
import com.example.classlocus.data.BuildingsRepository;
import com.example.classlocus.data.DatabaseHelper;

public class BuildingDetailsTest extends ActivityInstrumentationTestCase2<BuildingDetail> {

	BuildingDetail activity;
	private BuildingsRepository repository;
	private Building building;
	
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
	
	public void testBuildingPopulate() {
		repository = new BuildingsRepository(activity);
		building = new Building();
		Intent search = new Intent();
		long bid;
		List<Building> bdlist = new ArrayList<Building>();
		
		building.setName("Kelley Center");
		building.setAbbreviation("KEC");
		building.setLatLng(23.45, 34.56);
		
		repository.saveBuilding(building);
		bdlist.add(repository.searchBuilding("Kelley").get(0));
		bid = bdlist.get(0).getId();
		search.putExtra("buildingID", bid);
		bdlist.add(activity.populate(search, repository));
		
	}

}
