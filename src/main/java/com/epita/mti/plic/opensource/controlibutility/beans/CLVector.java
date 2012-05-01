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
  protected Double x;
  /**
   * Y axis value in space
   */
  protected Double y;

  /**
   * Constructor
   */
  public CLVector()
  {
    this.type = "vector";
  }

  public CLVector(HashMap<String, Object> map)
  {
    super(map);
    Object mapx = map.get("x");
    Object mapy = map.get("y");
    if (mapx != null)
      this.x = Double.parseDouble(mapx.toString());
    else
      this.x = 0.0;
    if (mapy != null)
      this.y = Double.parseDouble(mapy.toString());
    else
      this.y = 0.0;
  }

  public Double getX()
  {
    return x;
  }

  public void setX(Double x)
  {
    this.x = x;
  }

  public Double getY()
  {
    return y;
  }

  public void setY(Double y)
  {
    this.y = y;
  }
}
