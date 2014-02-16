package com.example.classlocus.test;

import com.example.classlocus.Building;

import junit.framework.TestCase;

public class DataTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testCreateBuilding(){
		Building b = new Building();
		assertNotNull(b);
	}
}
