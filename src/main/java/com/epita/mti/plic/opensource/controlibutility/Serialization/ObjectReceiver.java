package com.epita.mti.plic.opensource.controlibutility.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien "Roulyo" Fraisse
 */
public class ObjectReceiver extends Observable implements Runnable
{
  private ObjectInputStream objectInputStream = null;

  public ObjectReceiver(InputStream inputStream,
                        List<Observer> observersList)
  {
    try
    {
      this.objectInputStream = new ObjectInputStream(inputStream);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot instantiate ObjectInputStream", ex);
    }
    
    for (Observer observer : observersList)
      addObserver(observer);
  }
 
  public ObjectReceiver(InputStream inputStream,
                        Observer observer)
  {
    try
    {
      this.objectInputStream = new ObjectInputStream(inputStream);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot instantiate ObjectInputStream", ex);
    }
    
    addObserver(observer);
  }
  
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

  @Override
  public void run()
  {
    read();
  }
  
  private void read()
  {
    CLSerializable object = null;
    
    try
    {
      while ((object = (CLSerializable) objectInputStream.readObject()) != null)
      {
        notifyObservers(object);
      }
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot read the ObjectInputStream", ex);
    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Class CLSerializable not found", ex);
    }
  }

}
