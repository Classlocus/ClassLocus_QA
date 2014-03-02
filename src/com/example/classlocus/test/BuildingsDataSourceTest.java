package com.example.classlocus.test;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;
import com.example.classlocus.data.*;

public class BuildingsDataSourceTest extends AndroidTestCase {

	BuildingsDataSource database;
	
	public BuildingsDataSourceTest() {
	}

	@Before
	public void setUp() throws Exception {
		database = new BuildingsDataSource(mContext);
	}

	@After
	public void tearDown() throws Exception {
		mContext.deleteDatabase(BuildingDatabaseHelper.DATABASE_NAME);
	}

	@Test
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

	@Test
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

	@Test
	public void testGetBuildingEmpty() {
		assertNull(database.getBuilding(4));
	}
	
	@Test
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
	
	@Test
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

	@Test
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

}
