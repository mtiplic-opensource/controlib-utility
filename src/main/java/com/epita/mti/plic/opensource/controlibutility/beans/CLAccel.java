package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This class will be used to serialize data coming from
 * the accelerometer.
 */
public class CLAccel extends CLSerializable
{

  /**
   * X axis value in space
   */
  protected Integer x;

  /**
   * Y axis value in space
   */
  protected Integer y;

  /**
   * Z axis value in space
   */
  protected Integer z;

  /**
   * Constructor
   */
  public CLAccel()
  {
    this.type = "accel";
  }

  public Integer getX()
  {
    return x;
  }

  public void setX(Integer x)
  {
    this.x = x;
  }

  public Integer getY()
  {
    return y;
  }

  public void setY(Integer y)
  {
    this.y = y;
  }

  public Integer getZ()
  {
    return z;
  }

  public void setZ(Integer z)
  {
    this.z = z;
  }
}
