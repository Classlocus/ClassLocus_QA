package com.example.classlocus.test;

import com.example.classlocus.data.Building;

import android.test.AndroidTestCase;
//import junit.framework.TestCase;

public class BuildingTest extends AndroidTestCase {

	Building b;
	
	protected void setUp() throws Exception {
		super.setUp();
		b = new Building();
		assertNotNull(b);
	}
	
	public void testId(){
		long id = 32;
		b.setId(id);
		assertEquals(id, b.getId());
	}
	
	public void testBuildingName(){
		String name = "Kelley Engineering Center";
		b.setName(name);
		assertEquals(name, b.getName());
	}
	
	public void testBuildingAbbreviation(){
		String abbrv = "KEC";
		b.setAbbreviation(abbrv);
		assertEquals(abbrv, b.getAbbreviation());
	}
	
	public void testBuildingLngLat(){
		double latitude = 44.5672164;
		double longitude = -123.2785964;
		double[] latlng = {latitude, longitude};
		
		b.setLatLng(latitude, longitude);
		assertEquals(latlng[0], b.getLatLng()[0]);
		assertEquals(latlng[1], b.getLatLng()[1]);
	}
	
	public void testBuildingId(){
		long buildingId = 14;
		b.setBuildingId(buildingId);
		
		assertEquals(buildingId, b.getBuildingId());
	}
	
	public void testParentId(){
		long parentId = 342;
		b.setParentId(parentId);
		
		assertEquals(parentId, b.getParentId());
	}
	
	public void testAcessible(){
		boolean accessible = true;
		b.setAccessible(accessible);
		
		assertEquals(accessible, b.getAccessible());
	}
	
	public void testToString(){
		String name = "Kelley Engineering Center";
		b.setName(name);
		
		assertEquals(name, b.toString());
	}
}
