/**
 * 
 */
package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Cole
 *
 */
public class VendingMachineItemTest {

	VendingMachineItem vendItem1;

	/**
	 * Sets up the vending machine item to be tested
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vendItem1 = new VendingMachineItem("test1", 10.0);
	}

	@Test
	public void testPositivePriceConstructor() {
		assertEquals(10.0, vendItem1.getPrice(), 0.001);
	}

	@Test(expected = VendingMachineException.class)
	public void testNegativePriceConstructor() {
		VendingMachineItem test = new VendingMachineItem("test2", -10.0);
	}

	@Test
	public void testGetName() {
		assertEquals("test1", vendItem1.getName());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
