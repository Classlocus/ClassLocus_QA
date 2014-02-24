package com.example.classlocus.test;

import static org.junit.Assert.*;

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
	public void testCreateBuilding() {
		Building b = database.createBuilding("Kelley Engineering Center", "KEC");
		assertNotNull(b);
	}

	@Test
	public void testDeleteBuilding() {
		Building b = database.createBuilding("Kelley Engineering Center", "KEC");
		long id = b.getId();
		database.deleteBuilding(b);
		assertNull(database.getBuilding(id));
	}

	@Test
	public void testGetBuildingEmpty() {
		assertNull(database.getBuilding(4));
	}
	
	@Test
	public void testGetBuildingOne() {
		Building b = database.createBuilding("Kelley Engineering Center", "KEC");
		Building c = database.getBuilding(b.getId());
		
		assertNull(database.getBuilding(b.getId()));
		
		//assertEquals(b, c);
	}
	
	@Test
	public void testGetBuildingMany() {
		Building a = database.createBuilding("Valley Library", "VLib");
		Building b = database.createBuilding("Kelley Engineering Center", "KEC");
		Building c = database.createBuilding("Memorial Union", "MU");
		
		Building d = database.getBuilding(b.getId());
		assertEquals(b, d);
	}

	@Test
	public void testGetAllBuildings() {
		Building a = database.createBuilding("Valley Library", "VLib");
		Building b = database.createBuilding("Kelley Engineering Center", "KEC");
		Building c = database.createBuilding("Memorial Union", "MU");
		
		List<Building> buildings = database.getAllBuildings();
		assertEquals(3, buildings.size());
		
		Building x = database.getBuilding(a.getId());
		Building y = buildings.get(0);
		
		if (x.equals(y)) {
			fail("x and y are the same");
		}
		
		assert(buildings.contains(a));
		assert(buildings.contains(b));
		assert(buildings.contains(c));
	}

}
