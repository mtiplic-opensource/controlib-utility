package com.epita.mti.plic.opensource.controlibutility.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien "Roulyo" Fraisse
 */
public class ObjectReceiver
{
  private CLDispatcher dispatcher = null;
  private ObjectInputStream objectInputStream = null;

  public void setInputStream(InputStream inputStream)
  {
 try
    {
      this.objectInputStream.close();
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot close ObjectInputStream", ex);
    }
    
    try
    {
      this.objectInputStream = new ObjectInputStream(inputStream);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot instantiate ObjectInputStream", ex);
    }
  }

  public ObjectReceiver(InputStream inputStream)
  {
    try
    {
      this.objectInputStream = new ObjectInputStream(inputStream);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot instantiate ObjectInputStream", ex);
    }
  }

  public void read()
  {
    CLSerializable object = null;
    
    try
    {
      while ((object = (CLSerializable) objectInputStream.readObject()) != null)
      {
        // MAGICAL STUFF HERE
      }
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
