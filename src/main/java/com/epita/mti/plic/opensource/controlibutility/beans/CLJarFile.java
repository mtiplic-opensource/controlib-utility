/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import net.iharder.Base64;

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
    {
      this.file = mapFile.toString();
    }
    else
    {
      this.file = "";
    }
    Object mapFileName = map.get("fileName");
    if (mapFileName != null)
    {
      this.fileName = mapFileName.toString();
    }
    else
    {
      this.fileName = "";
    }
  }

  public CLJarFile()
  {
    this.type = "jarFile";
  }

  public String getFile()
  {
    return file;
  }

  public void setFile(String filepath)
  {
    try
    {
      ByteArrayOutputStream buff = new ByteArrayOutputStream();
      FileInputStream fis = new FileInputStream(filepath);
      BufferedInputStream bis = new BufferedInputStream(fis);
      
      int c;
      
      while ((c = bis.read()) != -1)
      {
        buff.write(c);
      }
      bis.close();
      buff.flush();
      
      this.file = Base64.encodeBytes(buff.toByteArray());
    }
    catch (Exception e)
    {
      System.out.println(e.toString());
    }
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
}
