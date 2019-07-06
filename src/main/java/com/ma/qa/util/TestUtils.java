package com.ma.qa.util;

import com.ma.qa.base.TestBase;

public class TestUtils extends TestBase {
	
	public static long page_load_timeout=20;
	public static long implicit_wait=20;
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

}
