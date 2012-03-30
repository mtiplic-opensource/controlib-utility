package com.epita.mti.plic.opensource.controlibutility.serialization;

import java.io.Serializable;

/**
 *
 * @author Julien "Roulyo" Fraisse
 */
public abstract class CLSerializable implements Serializable
{
  protected String type;

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }


}
