package lyit.oscar.insurance.test;

import static org.junit.Assert.*;
import lyit.oscar.insurance.Run;

import org.junit.Test;

public class RunTest {

	@Test
	public void displaytest() {
		System.out.println("Admin Display");
		Run.displayAdminMenu();
		
		System.out.println("User Display");
		Run.displayClientMenu();
	}
	
	@Test
	public void testStrInput(){
		String str = Run.getStrResponse("Please type the letter a then hit enter");
		assert(str.equalsIgnoreCase("a"));
	}
	
	@Test
	public void testNumInput(){
		int anInt = Run.getNumResponse("Please select 7 then hit enter", 0, 10);
		assertEquals(7, anInt);
	}
	
	@Test
	public void testCreateUser(){
		//TODO: Create user test
		fail("Not generated");
	}
	
	@Test 
	public void testRun(){
		//TODO: Create Run Test
		fail("Not generated");
	}

}
