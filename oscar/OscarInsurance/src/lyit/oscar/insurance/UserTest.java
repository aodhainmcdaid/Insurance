/**
 * 
 */
package lyit.oscar.insurance.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import lyit.oscar.insurance.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ryan651
 *
 */
public class UserTest {
	private static User aUser;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LocalDate bday = LocalDate.of(1992, 4, 17);
		aUser = new User("SolarLunix", "Melissa", "Melaugh", bday, "FakePass123".hashCode(), false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogIn() {
		assertTrue(aUser.logIn("FakePass123".hashCode()));
	}
	
	@Test
	public void testSetPolicyNum(){
		aUser.setPolicyNum(123);
		assertEquals(123, aUser.getPolicyNum());
	}
	
	@Test
	public void testGetAge(){
		assertEquals(24, aUser.getAge());
	}

}
