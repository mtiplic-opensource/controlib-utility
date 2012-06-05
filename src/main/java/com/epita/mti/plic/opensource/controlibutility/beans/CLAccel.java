package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;
import java.util.HashMap;

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
  protected Double x;
  /**
   * Y axis value in space
   */
  protected Double y;

  /**
   * Z axis value in space
   */
  protected Double z;

  /**
   * Constructor
   */
  public CLAccel()
  {
    this.type = "accel";
  }

  /**
   * Constructor use by the receiver
   */
  public CLAccel(HashMap<String, Object> map)
  {
    super(map);
    Object mapx = map.get("x");
    Object mapy = map.get("y");
    Object mapz = map.get("z");
    if (mapx != null)
      this.x = Double.parseDouble(mapx.toString());
    else
      this.x = 0.0;
    if (mapy != null)
      this.y = Double.parseDouble(mapy.toString());
    else
      this.y = 0.0;
    if (mapz != null)
      this.z = Double.parseDouble(mapz.toString());
    else
      this.z = 0.0;
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

  public Double getZ()
  {
    return z;
  }

  public void setZ(Double z)
  {
    this.z = z;
  }
}
