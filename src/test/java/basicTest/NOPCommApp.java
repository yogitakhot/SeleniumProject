package basicTest;

import org.junit.Test;

import utility.ReadConfig;

public class NOPCommApp {
	
	
	
	
	@Test
	public void verifyLogin() throws Exception {
		
		
		
		ReadConfig conf = new ReadConfig();
		
		
		System.out.println("launching app: " + conf.getApp());
		System.out.println("userName: " + conf.getUserName());
		
		
		System.out.println("password: " + conf.getPassword());
		
		
		
	}

}
