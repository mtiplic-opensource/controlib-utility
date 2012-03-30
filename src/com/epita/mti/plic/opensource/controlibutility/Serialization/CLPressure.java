package com.epita.mti.plic.opensource.controlibutility.Serialization;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 */
public class CLPressure extends CLSerializable {

  protected Integer x;
  protected Integer y;

  public CLPressure ()
  {
    this.type = "pressure";
  }

  /**
   * Get the value of x
   *
   * @return the value of x
   */
  public Integer getX() {
    return x;
  }

  /**
   * Set the value of x
   *
   * @param x new value of x
   */
  public void setX(Integer x) {
    this.x = x;
  }

  /**
   * Get the value of y
   *
   * @return the value of y
   */
  public Integer getY() {
    return y;
  }

  /**
   * Set the value of y
   *
   * @param y new value of y
   */
  public void setY(Integer y) {
    this.y = y;
  }
}
