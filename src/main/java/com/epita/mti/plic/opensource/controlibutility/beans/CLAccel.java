/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 */
public class CLAccel extends CLSerializable {

  protected Integer x;
  protected Integer y;
  protected Integer z;

  public CLAccel()
  {
    this.type = "accel";
  }

  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  public Integer getZ() {
    return z;
  }

  public void setZ(Integer z) {
    this.z = z;
  }
}
