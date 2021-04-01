package com.atmecs.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeExample {
	
	@Test(description="Test Case description")
	public void testCase1() {
		System.out.println("In testcase 1");
		Assert.assertEquals("Harshitha", "Harshitha");
	}
	
	@Test(dependsOnMethods="testCase1")
	public void testCase2() {
		System.out.println("In testcase 2");
	}
	
	@Test(priority=1)
	public void testCasePriority1() {
		System.out.println("In test case with Priority 1");
	}
	
	@Test(priority=2)
	public void testCasePriority2() {
		System.out.println("In test case2 with Priority 2");
	}
	
	@Test(enabled=false)
	public void testCase3() {
		System.out.println("In test case3");
	}
	
	@Test(enabled=true)
	public void testCase4() {
		System.out.println("In test case3 enabled true");
	}
}
