package com.epita.mti.plic.opensource.controlibutility.beans;

import junit.framework.TestCase;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 */
public class CLImageTest extends TestCase {

  public CLImageTest(String testName) {
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
   * Test of getType method, of class CLImage.
   */
  public void testGetType() {
    CLImage instance = new CLImage();
    String expResult = "image";
    String result = instance.getType();
    assertEquals(expResult, result);
  }

  /**
   * Test of getImage method, of class CLImage.
   */
  public void testGetImage() {
    CLImage instance = new CLImage();
    byte[] expResult = new byte[] {1, 2, 3};
    instance.image = new byte[] {1, 2, 3};
    byte[] result = instance.getImage();
    assertEquals(expResult.length, result.length);
    for (int i = 0; i < expResult.length; ++i)
    {
      assertEquals(expResult[i], result[i]);
    }
  }

  /**
   * Test of setImage method, of class CLImage.
   */
  public void testSetImage() {
    byte[] image = new byte[] {1, 2, 3};
    byte[] expResult = new byte[] {1, 2, 3};
    CLImage instance = new CLImage();
    instance.setImage(image);
    assertEquals(expResult.length, instance.image.length);
    for (int i = 0; i < expResult.length; ++i)
    {
      assertEquals(expResult[i], instance.image[i]);
    }
  }
}
