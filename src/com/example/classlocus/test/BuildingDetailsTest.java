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
		bdlist.add(0, repository.searchBuilding("Kelley").get(0));
		bid = bdlist.get(0).getId();
		search.putExtra("buildingID", bid);
		bdlist.add(1, activity.populate(search, repository));
		assertTrue(bdlist.get(0).equals(bdlist.get(1)));
	}
}
