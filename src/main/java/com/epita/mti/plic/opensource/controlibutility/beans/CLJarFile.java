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
  private String fileName; // Include the .jar

  public CLJarFile(HashMap<String, Object> map)
  {
    super(map);
    Object mapFile = map.get("file");
    if (mapFile != null)
      this.file = mapFile.toString();
    else
      this.file = "";
    Object mapFileName = map.get("fileName");
    if (mapFileName != null)
      this.file = mapFileName.toString();
    else
      this.file = "";
  }

  public CLJarFile()
  {
    this.type = "jarFile";
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

}
