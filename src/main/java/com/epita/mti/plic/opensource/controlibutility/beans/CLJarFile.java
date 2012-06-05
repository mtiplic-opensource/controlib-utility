/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import net.iharder.Base64;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This class is use to send the plugin definition of the one used
 * by the client to the server
 */
public class CLJarFile extends CLSerializable
{
  /*
   * Content of the jar file
   */
  private String file;

  /*
   * The name of the jar file
   */
  private String fileName; // Include the .jar


  /**
   * Constructor used by the receiver
   */
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

  /**
   * Constructor
   */
  public CLJarFile()
  {
    this.type = "jarFile";
  }

  public String getFile()
  {
    return file;
  }

  public void setFile(InputStream filestream)
  {
    try
    {
      ByteArrayOutputStream buff = new ByteArrayOutputStream();
      BufferedInputStream bis = new BufferedInputStream(filestream);
      int c;

      while ((c = bis.read()) != -1)
      {
        buff.write(c);
      }
      filestream.close();
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
