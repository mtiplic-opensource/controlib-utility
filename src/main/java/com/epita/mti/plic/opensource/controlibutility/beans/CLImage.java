package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This class will be used to serialize data corresponding
 * to an image.
 */
public class CLImage extends CLSerializable
{
  /**
   * image represented in base 64
   */
  protected byte[] image;

  /**
   * Constructor
   */
  public CLImage()
  {
    this.type = "image";
  }

  public byte[] getImage()
  {
    return image;
  }

  public void setImage(byte[] image)
  {
    this.image = image;
  }
}
