package com.example.classlocus.test;

import java.util.List;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.example.classlocus.data.Building;
import com.example.classlocus.data.BuildingsRepository;

public class BuildingsRepositoryTest extends AndroidTestCase {

	private BuildingsRepository repository;
	private Building bld_a;
	private Building bld_b;
	private Building bld_c;
	private Building bld_d;
	
	public BuildingsRepositoryTest() {
		bld_a = new Building();
		bld_a.setId(0);
		bld_a.setName("Malcolm Building");
		bld_a.setAbbreviation("MAB");
		bld_a.setLatLng(10.1010, -141.1414);
		bld_a.setParentId(10);
		bld_a.setAccessible(true);
		
		bld_b = new Building();
		bld_b.setId(0);
		bld_b.setName("The Valley Library");
		bld_b.setAbbreviation("VLib");
		bld_b.setLatLng(44.5651985, -123.2759504);
		bld_b.setParentId(10);
		bld_b.setAccessible(true);
		
		bld_c = new Building();
		bld_c.setId(0);
		bld_c.setName("Kelley Engineering Center");
		bld_c.setAbbreviation("KEC");
		bld_c.setLatLng(44.5679076, -123.2783046);
		bld_c.setParentId(10);
		bld_c.setAccessible(true);
		
		bld_d = new Building();
		bld_d.setId(0);
		bld_d.setName("Memorial Union Building");
		bld_d.setAbbreviation("MU");
		bld_d.setLatLng(44.5647739, -123.2788814);
		bld_d.setParentId(10);
		bld_d.setAccessible(true);
	}

	protected void setUp() throws Exception {
		super.setUp();
		RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		repository = new BuildingsRepository(context);
		repository.cleanBuilding();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSaveBuilding() {
		long id = repository.saveBuilding(bld_a);
		assertTrue(id > 0);
	}

	public void testDeleteBuilding() {
		long id = repository.saveBuilding(bld_a);
		bld_a.setId(id);
		assertTrue(repository.deleteBuilding(bld_a));
	}

	public void testSearchBuildingsEmptyResult() {
		repository.saveBuilding(bld_a);
		repository.saveBuilding(bld_b);
		repository.saveBuilding(bld_c);
		repository.saveBuilding(bld_d);
		
		List<Building> buildings = repository.searchBuilding("Kerney"); 
		assertEquals(0, buildings.size());
	}
	
	public void testSearchBuildingsByName() {
		repository.saveBuilding(bld_a);
		repository.saveBuilding(bld_b);
		repository.saveBuilding(bld_c);
		repository.saveBuilding(bld_d);
		
		List<Building> buildings = repository.searchBuilding("Building");
		assertEquals(2, buildings.size());
		assertFalse(buildings.contains(bld_c));
	}
	
	public void testSearchBuildingsByAbbreviation() {
		repository.saveBuilding(bld_a);
		repository.saveBuilding(bld_b);
		repository.saveBuilding(bld_c);
		repository.saveBuilding(bld_d);
		
		List<Building> buildings = repository.searchBuilding("KEC");
		assertEquals(1, buildings.size());
		assertTrue(buildings.contains(bld_c));
	}

}
