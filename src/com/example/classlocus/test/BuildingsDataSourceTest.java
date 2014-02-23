package com.example.classlocus.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.example.classlocus.data.Building;
import com.example.classlocus.data.BuildingDatabaseHelper;
import com.example.classlocus.data.BuildingsDataSource;

public class BuildingsDataSourceTest extends AndroidTestCase {

	BuildingDatabaseHelper dbhelper;
	
	@Before
	public void setUp() throws Exception {
			super.setUp();
			if (dbhelper == null){
				dbhelper = new BuildingDatabaseHelper(mContext);
			}
			dbhelper.getWritableDatabase(); //Creates the db
	}

	@After
	public void tearDown() throws Exception {
		mContext.deleteDatabase(BuildingDatabaseHelper.DATABASE_NAME);
	}
	
	@Test
	public void testCreateAndInsertBuilding(){
		BuildingsDataSource bds = new BuildingsDataSource(mContext);
		assertNotNull(bds);
		Building b = bds.createBuilding("Kelly Engineering Center", "KEC");
		assertEquals(b.getName(), "Kelly Engineering Center");
		assertEquals(b.getAbbreviation(), "KEC");
	}

}
