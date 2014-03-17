package com.example.classlocus.test;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import android.database.sqlite.SQLiteDatabase;

import com.example.classlocus.data.DatabaseHelper;

public class DatabaseHelperTest extends AndroidTestCase {

	private DatabaseHelper dbHelper;
	
	public DatabaseHelperTest() {
	}
	
	public void setUp() throws Exception {
		super.setUp();
		RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		dbHelper = DatabaseHelper.getInstance(context);
	}
	
	public void tearDown() throws Exception {
		dbHelper.close();
		super.tearDown();
	}

	public void testPreConditions() {
		assertNotNull(dbHelper);
	}

	public void testDatabaseIntegrity() {
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		assertTrue(database.isDatabaseIntegrityOk());
	}
	
}