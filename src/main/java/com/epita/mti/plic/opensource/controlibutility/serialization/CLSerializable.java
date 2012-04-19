package com.epita.mti.plic.opensource.controlibutility.serialization;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Julien "Roulyo" Fraisse
 */
public abstract class CLSerializable implements Serializable
{
  protected String type;

  public CLSerializable()
  {

  }

  public CLSerializable(HashMap<String, Object> map)
  {
    Object mapType = map.get("type");
    if (mapType != null)
      type = mapType.toString();
    else
      type = null;
  }

  public String getType()
  {
    return type;
  }
}
