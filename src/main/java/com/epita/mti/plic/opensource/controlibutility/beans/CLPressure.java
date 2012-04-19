package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;
import java.util.HashMap;

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

  public CLPressure(HashMap<String, Object> map)
  {
    super(map);
    Object mapx = map.get("x");
    Object mapy = map.get("y");
    if (mapx != null)
      x = Integer.parseInt(mapx.toString());
    else
      x = 0;
    if (mapy != null)
      y = Integer.parseInt(mapy.toString());
    else
      y = 0;
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
