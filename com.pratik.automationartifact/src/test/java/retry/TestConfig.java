package retry;

import utilities.ConfigReader;

public class TestConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		  ConfigReader cr = new ConfigReader();
		  
		  System.out.println("Browser : " + cr.getBrowser());
		  
		  System.out.println(cr.getURL()); System.out.println(cr.getUsername());
		  System.out.println(cr.getPassword()); System.out.println(cr.getTimeout());
		  
		  
		  
		 
		
		
	}

}
