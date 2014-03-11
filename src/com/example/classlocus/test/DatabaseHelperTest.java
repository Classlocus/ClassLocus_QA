package com.example.classlocus.test;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import android.database.Cursor;

import com.example.classlocus.data.DatabaseHelper;

public class DatabaseHelperTest extends AndroidTestCase {

	private DatabaseHelper dbHelper;

	public DatabaseHelperTest() {
	}
	
	public void setUp() throws Exception {
		super.setUp();
		RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		dbHelper = DatabaseHelper.getInstance(context);
		dbHelper.wipe();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPreConditions() {
		assertNotNull(dbHelper);
	}

	public void testInsert() {
		double[] latLng = {10.101010, -20.202020};
		long id = dbHelper.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		assertTrue(id > 0);
	}
	
	public void testRead() {
		double[] latLng = {10.101010, -20.202020};
		long id = dbHelper.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		
		Cursor cursor = dbHelper.read(id);
		assertEquals(1, cursor.getCount());
	}
	
	public void testRemove() {
		double[] latLng = {10.101010, -20.202020};
		long id = dbHelper.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		
		dbHelper.remove(id);
		Cursor cursor = dbHelper.read(id);
		assertEquals(0, cursor.getCount());
	}
	
	public void testSearch() {
		double[] latLng = {10.101010, -20.202020};
		dbHelper.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		dbHelper.insert("Brandenburg Center", "BRC", latLng, 10, false);
		
		Cursor cursorA = dbHelper.search("Waldorf");
		assertEquals(1, cursorA.getCount());
		
		Cursor cursorB = dbHelper.search("Grand");
		assertEquals(0, cursorB.getCount());
	}
	
	public void testUniqueNames() {
		double[] latLng = {10.101010, -20.202020};
		dbHelper.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		dbHelper.insert("Waldorf Astoria Building", "WAL", latLng, 10, false);
		
		Cursor cursor = dbHelper.search("Waldorf");
		assertEquals(1, cursor.getCount());
	}
}