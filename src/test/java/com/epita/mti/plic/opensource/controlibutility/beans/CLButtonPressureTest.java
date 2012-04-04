/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epita.mti.plic.opensource.controlibutility.beans;

import junit.framework.TestCase;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 */
public class CLButtonPressureTest extends TestCase {

  public CLButtonPressureTest(String testName) {
    super(testName);
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
   * Test of getButtonId method, of class CLButtonPressure.
   */
  public void testGetButtonId() {
    CLButtonPressure instance = new CLButtonPressure();
    Integer expResult = 3;
    instance.buttonId = 3;
    Integer result = instance.getButtonId();
    assertEquals(expResult, result);
  }

  /**
   * Test of setButtonId method, of class CLButtonPressure.
   */
  public void testSetButtonId() {
    Integer buttonId = 3;
    CLButtonPressure instance = new CLButtonPressure();
    instance.setButtonId(buttonId);
    assertEquals(instance.buttonId, buttonId);
  }
}
