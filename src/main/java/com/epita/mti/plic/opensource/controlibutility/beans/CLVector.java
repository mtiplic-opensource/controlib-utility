package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;
import java.util.HashMap;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This class is used to represent a vector,
 * a difference between two points.
 * This can be used for a trackpad for example.
 */
public class CLVector extends CLSerializable
{
  /**
   * X axis value in space
   */
  protected float x;
  /**
   * Y axis value in space
   */
  protected float y;

  /**
   * Constructor
   */
  public CLVector()
  {
    this.type = "vector";
  }

  /**
   * Constructor used by the receiver.
   * @param map
   */
  public CLVector(HashMap<String, Object> map)
  {
    super(map);
    Object mapx = map.get("x");
    Object mapy = map.get("y");
    if (mapx != null)
      this.x = Float.parseFloat(mapx.toString());
    else
      this.x = 0;
    if (mapy != null)
      this.y = Float.parseFloat(mapy.toString());
    else
      this.y = 0;
  }

  public float getX()
  {
    return x;
  }

  public void setX(float x)
  {
    this.x = x;
  }

  public float getY()
  {
    return y;
  }

  public void setY(float y)
  {
    this.y = y;
  }
}
