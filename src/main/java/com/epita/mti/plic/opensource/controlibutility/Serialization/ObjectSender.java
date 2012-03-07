package com.epita.mti.plic.opensource.controlibutility.Serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien "Roulyo" Fraisse
 */
public class ObjectSender
{

  private ObjectOutputStream objectOutputStream;

  public void setOutputStream(OutputStream outputStream)
  {
    try
    {
      this.objectOutputStream.flush();
      this.objectOutputStream.close();
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot close ObjectOutputStream", ex);
    }
    
    try
    {
      this.objectOutputStream = new ObjectOutputStream(outputStream);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot instantiate ObjectOutputStream", ex);
    }
  }

  public ObjectSender(OutputStream outputStream)
  {
    try
    {
      this.objectOutputStream = new ObjectOutputStream(outputStream);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot instantiate ObjectOutputStream", ex);
    }
  }

  public void send(CLSerializable bean)
  {
    try
    {
      objectOutputStream.writeObject(bean);
      objectOutputStream.flush();
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot write into socket", ex);
    }
  }
}
