package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This class will be used to serialize data coming from
 * a pressure on the device's screen.
 * It contains coordinates of the pressure.
 */
public class CLPressure extends CLSerializable
{

  /**
   * X axis value on the device's screen
   */
  protected Integer x;

  /**
   * Y axis value on the device's screen
   */
  protected Integer y;

  /**
   * Constructor
   */
  public CLPressure ()
  {
    this.type = "pressure";
  }

  /**
   * Get the value of x
   *
   * @return the value of x
   */
  public Integer getX()
  {
    return x;
  }

  /**
   * Set the value of x
   *
   * @param x new value of x
   */
  public void setX(Integer x)
  {
    this.x = x;
  }

  /**
   * Get the value of y
   *
   * @return the value of y
   */
  public Integer getY()
  {
    return y;
  }

  /**
   * Set the value of y
   *
   * @param y new value of y
   */
  public void setY(Integer y)
  {
    this.y = y;
  }
}
