/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
   * Test of getX method, of class CLAccel.
   */
  public void testGetX() {
    CLAccel instance = new CLAccel();
    Integer expResult = 3;
    instance.x = 3;
    Integer result = instance.getX();
    assertEquals(expResult, result);
  }

  /**
   * Test of setX method, of class CLAccel.
   */
  public void testSetX() {
    Integer x = 3;
    CLAccel instance = new CLAccel();
    instance.setX(x);
    assertEquals(instance.x, x);
  }

  /**
   * Test of getY method, of class CLAccel.
   */
  public void testGetY() {
    CLAccel instance = new CLAccel();
    Integer expResult = 3;
    instance.y = 3;
    Integer result = instance.getY();
    assertEquals(expResult, result);
  }

  /**
   * Test of setY method, of class CLAccel.
   */
  public void testSetY() {
    Integer y = 3;
    CLAccel instance = new CLAccel();
    instance.setY(y);
    assertEquals(instance.y, y);
  }

  /**
   * Test of getZ method, of class CLAccel.
   */
  public void testGetZ() {
    CLAccel instance = new CLAccel();
    Integer expResult = 3;
    instance.z = 3;
    Integer result = instance.getZ();
    assertEquals(expResult, result);
  }

  /**
   * Test of setZ method, of class CLAccel.
   */
  public void testSetZ() {
    Integer z = 3;
    CLAccel instance = new CLAccel();
    instance.setZ(z);
    assertEquals(instance.z, z);
  }
}
