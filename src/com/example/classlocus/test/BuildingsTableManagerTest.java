package com.example.classlocus.test;

import android.test.AndroidTestCase;
import android.database.Cursor;
import android.test.RenamingDelegatingContext;

import com.example.classlocus.data.BuildingsTableManager;

public class BuildingsTableManagerTest extends AndroidTestCase {

	private BuildingsTableManager manager;
	
	public BuildingsTableManagerTest() {
	}

	protected void setUp() throws Exception {
		super.setUp();
		RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		manager = new BuildingsTableManager(context);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsert() {
		double[] latLng = {10.101010, -20.202020};
		long id = manager.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		assertTrue(id > 0);
	}

	public void testRemove() {
		double[] latLng = {10.101010, -20.202020};
		long id = manager.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		
		manager.remove(id);
		Cursor cursor = manager.read(id);
		assertEquals(0, cursor.getCount());
	}

	public void testRead() {
		double[] latLng = {10.101010, -20.202020};
		manager.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		
		Cursor cursor = manager.search("Waldorf");
		assertEquals(1, cursor.getCount());
	}

	public void testSearch() {
		double[] latLng = {10.101010, -20.202020};
		manager.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		manager.insert("Brandenburg Center", "BRC", latLng, 10, false);
		
		Cursor cursorA = manager.search("Waldorf");
		assertEquals(1, cursorA.getCount());
		
		Cursor cursorB = manager.search("Grand");
		assertEquals(0, cursorB.getCount());
	}
	
	public void testUniqueNames() {
		double[] latLng = {10.101010, -20.202020};
		manager.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		manager.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		
		Cursor cursor = manager.search("Waldorf");
		assertEquals(1, cursor.getCount());
	}

}
