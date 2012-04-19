package com.epita.mti.plic.opensource.controlibutility.beans;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 */
public class CLPressureTest extends TestCase {

  public CLPressureTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite(CLPressureTest.class);
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
   * Test of getType method, of class CLPressure.
   */
  public void testGetType() {
    CLPressure instance = new CLPressure();
    String expResult = "pressure";
    String result = instance.getType();
    assertEquals(expResult, result);
  }

  /**
   * Test of getX method, of class CLPressure.
   */
  public void testGetX() {
    CLPressure instance = new CLPressure();
    Integer expResult = 3;
    instance.x = expResult;
    Integer result = instance.getX();
    assertEquals(expResult, result);
  }

  /**
   * Test of setX method, of class CLPressure.
   */
  public void testSetX() {
    Integer x = 3;
    CLPressure instance = new CLPressure();
    instance.setX(x);
    assertEquals(instance.x, x);
  }

  /**
   * Test of getY method, of class CLPressure.
   */
  public void testGetY() {
    CLPressure instance = new CLPressure();
    Integer expResult = 3;
    instance.y = expResult;
    Integer result = instance.getY();
    assertEquals(expResult, result);
  }

  /**
   * Test of setY method, of class CLPressure.
   */
  public void testSetY() {
    Integer y = 3;
    CLPressure instance = new CLPressure();
    instance.setY(y);
    assertEquals(instance.y, y);
  }
}
