package com.example.classlocus.test;

import java.util.List;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.example.classlocus.data.Building;
import com.example.classlocus.data.BuildingsRepository;

public class BuildingsRepositoryTest extends AndroidTestCase {

	private BuildingsRepository repository;
	private Building building;
	
	public BuildingsRepositoryTest() {
		building = new Building();
		
		building.setId(0);
		building.setName("Malcolm Building");
		building.setAbbreviation("MAB");
		building.setLatLng(10.1010, -141.1414);
		building.setParentId(10);
		building.setAccessible(true);
	}

	protected void setUp() throws Exception {
		super.setUp();
		RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		repository = new BuildingsRepository(context);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSaveBuilding() {
		long id = repository.saveBuilding(building);
		assert(id > 0);
	}

	public void testDeleteBuilding() {
		repository.saveBuilding(building);
		assertTrue(repository.deleteBuilding(building));
	}

	public void testSearchBuildingsEmpty() {
		List<Building> buildings = repository.searchBuilding("Kerney"); 
		assertEquals(0, buildings.size());
	}
	
	public void testSearchBuildingsOne() {
		long id = repository.saveBuilding(building);
		List<Building> buildings = repository.searchBuilding(id);
		assertEquals(1, buildings.size());
		assertEquals(building, buildings.get(0));
	}
	
	public void testGetBuildingMany() {
		Building a = new Building();
		a.setId(21);
		a.setName("The Valley Library Center");
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
		c.setName("Memorial Union Center");
		c.setAbbreviation("MU");
		c.setLatLng(44.5647739, -123.2788814);
		c.setParentId(10);
		c.setAccessible(true);
		
		repository.saveBuilding(a);
		repository.saveBuilding(b);
		repository.saveBuilding(c);
		
		List<Building> buildings = repository.searchBuilding("Center");
		assertEquals(3, buildings.size());
		
		assert(buildings.contains(a));
		assert(buildings.contains(b));
		assert(buildings.contains(c));
	}

}
