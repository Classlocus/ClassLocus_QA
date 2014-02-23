package com.example.classlocus.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.classlocus.data.BuildingDatabaseHelper;

import android.database.sqlite.SQLiteDatabase;
import android.test.mock.MockContext;

public class BuildingDatabaseHelperTest {

	MockContext context;
	private SQLiteDatabase database;
	private BuildingDatabaseHelper dbHelper;
	
	public BuildingDatabaseHelperTest() {
		context = new MockContext();
	}

	@Before
	public void setUp() throws Exception {
		dbHelper.onCreate(database);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testBuildingDatabaseHelper() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testOnCreateSQLiteDatabase() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testOnUpgradeSQLiteDatabaseIntInt() {
		fail("Not yet implemented"); // TODO
	}

}
