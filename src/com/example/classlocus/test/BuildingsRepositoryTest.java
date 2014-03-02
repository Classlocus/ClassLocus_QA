package com.example.classlocus.test;

import java.util.List;

import android.test.AndroidTestCase;

import com.example.classlocus.data.Building;
import com.example.classlocus.data.DatabaseHelper;
import com.example.classlocus.data.BuildingsDataSource;

public class BuildingsRepositoryTest extends AndroidTestCase {

	BuildingsDataSource database;
	
	public BuildingsRepositoryTest() {
	}

	protected void setUp() throws Exception {
		super.setUp();
		database = new BuildingsDataSource(mContext);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		mContext.deleteDatabase(DatabaseHelper.DATABASE_NAME);
	}
	
	public void testInsertBuilding() {
		Building b = new Building();
		b.setId(34);
		b.setName("Kelley Engineering Center");
		b.setAbbreviation("KEC");
		b.setLatLng(44.5679076, -123.2783046);
		b.setParentId(10);
		b.setAccessible(true);
		
		assertTrue(database.insertBuilding(b));
	}

	public void testRemoveBuilding() {
		Building b = new Building();
		b.setId(34);
		b.setName("Kelley Engineering Center");
		b.setAbbreviation("KEC");
		b.setLatLng(44.5679076, -123.2783046);
		b.setParentId(10);
		b.setAccessible(true);
		database.insertBuilding(b);
		
		assertTrue(database.removeBuilding(b.getId()));
	}

	public void testGetBuildingEmpty() {
		assertNull(database.getBuilding(4));
	}
	
	public void testGetBuildingOne() {
		Building b = new Building();
		b.setId(34);
		b.setName("Kelley Engineering Center");
		b.setAbbreviation("KEC");
		b.setLatLng(44.5679076, -123.2783046);
		b.setParentId(10);
		b.setAccessible(true);
		database.insertBuilding(b);
		
		Building c = database.getBuilding(b.getId());
	
		assertEquals(b, c);
	}
	
	public void testGetBuildingMany() {
		Building a = new Building();
		a.setId(21);
		a.setName("The Valley Library");
		a.setAbbreviation("VLib");
		a.setLatLng(44.5651985, -123.2759504);
		a.setParentId(10);
		a.setAccessible(true);
		
		Building b = new Building();
		b.setId(34);
		b.setName("Kelley Engineering Center");
		b.setAbbreviation("KEC");
		b.setLatLng(44.5679076, -123.2783046);
		b.setParentId(10);
		b.setAccessible(true);
		
		Building c = new Building();
		c.setId(56);
		c.setName("Memorial Union Building");
		c.setAbbreviation("MU");
		c.setLatLng(44.5647739, -123.2788814);
		c.setParentId(10);
		c.setAccessible(true);
		
		database.insertBuilding(a);
		database.insertBuilding(b);
		database.insertBuilding(c);
		
		Building d = database.getBuilding(a.getId());
		assertEquals(a, d);
		
		Building e = database.getBuilding(b.getId());
		assertEquals(b, e);
		
		Building f = database.getBuilding(c.getId());
		assertEquals(c, f);
	}

	public void testGetAllBuildings() {
		Building a = new Building();
		a.setId(21);
		a.setName("The Valley Library");
		a.setAbbreviation("VLib");
		a.setLatLng(44.5651985, -123.2759504);
		a.setParentId(10);
		a.setAccessible(true);
		
		Building b = new Building();
		b.setId(34);
		b.setName("Kelley Engineering Center");
		b.setAbbreviation("KEC");
		b.setLatLng(44.5679076, -123.2783046);
		b.setParentId(10);
		b.setAccessible(true);
		
		Building c = new Building();
		c.setId(56);
		c.setName("Memorial Union Building");
		c.setAbbreviation("MU");
		c.setLatLng(44.5647739, -123.2788814);
		c.setParentId(10);
		c.setAccessible(true);
		
		database.insertBuilding(a);
		database.insertBuilding(b);
		database.insertBuilding(c);
		
		List<Building> buildings = database.getAllBuildings();
		assertEquals(3, buildings.size());
		
		assert(buildings.contains(a));
		assert(buildings.contains(b));
		assert(buildings.contains(c));
	}
	
	public void testSelectAll() {
		Building a = new Building();
		a.setId(21);
		a.setName("The Valley Library");
		a.setAbbreviation("VLib");
		a.setLatLng(44.5651985, -123.2759504);
		a.setParentId(10);
		a.setAccessible(true);
		
		Building b = new Building();
		b.setId(34);
		b.setName("Kelley Engineering Center");
		b.setAbbreviation("KEC");
		b.setLatLng(44.5679076, -123.2783046);
		b.setParentId(10);
		b.setAccessible(true);
		
		database.insertBuilding(a);
		database.insertBuilding(b);
		
		assertEquals(2, database.selectAll());
	}
	
	public void testGetMatchedBuildingsOne() {
		Building a = new Building();
		a.setId(21);
		a.setName("The Valley Library");
		a.setAbbreviation("VLib");
		a.setLatLng(44.5651985, -123.2759504);
		a.setParentId(10);
		a.setAccessible(true);
		
		Building b = new Building();
		b.setId(34);
		b.setName("Kelley Engineering Center");
		b.setAbbreviation("KEC");
		b.setLatLng(44.5679076, -123.2783046);
		b.setParentId(10);
		b.setAccessible(true);
		
		database.insertBuilding(a);
		database.insertBuilding(b);
		
		List<Building> buildings = database.getMatchedBuildings("Library");
		assertEquals(1, buildings.size());
		
		assert(buildings.contains(a));
	}

}
