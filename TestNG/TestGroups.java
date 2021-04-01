package com.atmecs.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGroups {

	@Test(groups = { "smoke" })
	public void testCase1() {
		System.out.println("Smoke Test Case 1");
		Assert.assertEquals("Test","test");
	}

	@Test(groups = { "smoke" }, dependsOnMethods= {"testCase1"})
	public void testCase2() {
		System.out.println("Smoke Test Case 2");
	}
	
	@Test(groups = { "smoke" })
	public void testCase3() {
		System.out.println("Smoke Test Case 3");
	}

	@Test(groups = { "regression" })
	public void testCase4() {
		System.out.println("Regression Test Case 1");
	}

	@Test(groups = { "smoke" })
	public void testCase5() {
		System.out.println("Smoke Test Case 3");
	}

	@Test(groups = { "regression" })
	public void testCase6() {
		System.out.println("Regression Test Case 2");
	}
}
