package lyit.oscar.insurance.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import lyit.oscar.insurance.Pricing;
import lyit.oscar.insurance.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PricingTest {
	
	static private User rnd;
	static private Pricing price;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LocalDate bDay = LocalDate.of(1992, 4, 17);
		rnd = new User("Mrs.", "Melissa", "Melaugh", bDay, "18009998888", "female", "L00131543@student.lyit.ie", "Fake address");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		price = new Pricing(rnd);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		price.generatePolicyNum();
		int num = Integer.parseInt(rnd.getPolicyNo());
		assert(num <= 999999999 && num >= 100000000);
	}

}
