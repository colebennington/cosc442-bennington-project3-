/**
 * 
 */
package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineTest.
 *
 * @author Cole
 */
public class VendingMachineTest {

	/** The vend machine. */
	VendingMachine vendMachine;

	/**
	 * Sets up the vending machine that we are testing.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		vendMachine = new VendingMachine();
	}

	/**
	 * Test for adding an item to a slot that is not occupied.
	 */
	@Test
	public void testAddItem_not_occupied() {
		VendingMachineItem test = new VendingMachineItem("test", 10.0);
		vendMachine.addItem(test, "A");
		assertEquals(test, vendMachine.getItem("A"));
	}

	/**
	 * Test for adding an item to a slot that is already occupied.
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItem_already_occupied() {
		VendingMachineItem test = new VendingMachineItem("test", 10.0);
		vendMachine.addItem(test, "A");
		VendingMachineItem test2 = new VendingMachineItem("test", 10.0);
		vendMachine.addItem(test2, "A");

	}

	/**
	 * Test for adding an item to a slot with an invalid code.
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItem_invalid_code() {
		VendingMachineItem test = new VendingMachineItem("test", 10.0);
		vendMachine.addItem(test, "F");
	}

	/**
	 * Test for removing an item from a slot with an invalid code.
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItem_invalid_code() {
		vendMachine.removeItem("F");
	}

	/**
	 * Test for removing an item from an empty slot.
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItem_empty_slot() {
		vendMachine.removeItem("D");
	}

	/**
	 * Test for removing an item.
	 */
	@Test
	public void testRemoveItem() {
		VendingMachineItem test = new VendingMachineItem("test", 10.0);
		vendMachine.addItem(test, "B");
		assertEquals(test, vendMachine.removeItem("B"));
	}

	/**
	 * Test for inserting money.
	 */
	@Test
	public void testInsertMoney() {
		vendMachine.insertMoney(10.0);
		assertEquals(10.0, vendMachine.getBalance(), 0.001);
	}

	/**
	 * Test for inserting an invalid amount of money.
	 */
	@Test(expected = VendingMachineException.class)
	public void testInsertMoney_invalid_amount() {
		vendMachine.insertMoney(-10.0);
	}

	/**
	 * Test for making a purchase with enough money.
	 */
	@Test
	public void testMakePurchase_enough_money() {
		VendingMachineItem test = new VendingMachineItem("test", 10.0);
		vendMachine.addItem(test, "A");
		vendMachine.addItem(test, "C");
		vendMachine.insertMoney(10.0);
		assertEquals(true, vendMachine.makePurchase("A"));
	}

	/**
	 * Test for making a purchase with not enough money.
	 */
	@Test
	public void testMakePurchase_not_enough_money() {
		assertEquals(false, vendMachine.makePurchase("A"));
	}

	/**
	 * Test for making a purchase from an empty slot.
	 */
	@Test
	public void testMakePurchase_empty_slot() {
		assertEquals(false, vendMachine.makePurchase("D"));
	}

	/**
	 * Test for returning change.
	 */
	@Test
	public void testReturnChange() {
		vendMachine.insertMoney(5.0);
		assertEquals(5.0, vendMachine.returnChange(), 0.001);
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		vendMachine = null;
	}

}
