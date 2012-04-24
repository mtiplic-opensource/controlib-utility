package com.epita.mti.plic.opensource.controlibutility.beans;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 */
public class CLAccelTest extends TestCase {

  public CLAccelTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite(CLAccelTest.class);
    return suite;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test of getType method, of class CLAccel.
   */
  public void testGetType() {
    CLAccel instance = new CLAccel();
    String expResult = "accel";
    String result = instance.getType();
    assertEquals(expResult, result);
  }

  /**
   * Test of getX method, of class CLAccel.
   */
  public void testGetX() {
    CLAccel instance = new CLAccel();
    Double expResult = 3.0;
    instance.x = 3.0;
    Double result = instance.getX();
    assertEquals(expResult, result);
  }

  /**
   * Test of setX method, of class CLAccel.
   */
  public void testSetX() {
    Double x = 3.0;
    CLAccel instance = new CLAccel();
    instance.setX(x);
    assertEquals(instance.x, x);
  }

  /**
   * Test of getY method, of class CLAccel.
   */
  public void testGetY() {
    CLAccel instance = new CLAccel();
    Double expResult = 3.0;
    instance.y = 3.0;
    Double result = instance.getY();
    assertEquals(expResult, result);
  }

  /**
   * Test of setY method, of class CLAccel.
   */
  public void testSetY() {
    Double y = 3.0;
    CLAccel instance = new CLAccel();
    instance.setY(y);
    assertEquals(instance.y, y);
  }

  /**
   * Test of getZ method, of class CLAccel.
   */
  public void testGetZ() {
    CLAccel instance = new CLAccel();
    Double expResult = 3.0;
    instance.z = 3.0;
    Double result = instance.getZ();
    assertEquals(expResult, result);
  }

  /**
   * Test of setZ method, of class CLAccel.
   */
  public void testSetZ() {
    Double z = 3.0;
    CLAccel instance = new CLAccel();
    instance.setZ(z);
    assertEquals(instance.z, z);
  }
}
