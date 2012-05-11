/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;
import java.util.HashMap;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 */
public class CLJarFile extends CLSerializable
{
  private String file;

  public CLJarFile(HashMap<String, Object> map)
  {
    super(map);
    Object mapStr = map.get("file");
    if (mapStr != null)
      this.file = mapStr.toString();
    else
      this.file = "";
  }

  public CLJarFile()
  {
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }
}
