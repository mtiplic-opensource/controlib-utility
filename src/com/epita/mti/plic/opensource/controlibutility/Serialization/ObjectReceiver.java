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
 * The ObjectReceiver class is part of a Observable/Observer pattern.
 * It listens the socket in a thread and notifies its observers when an object
 * is received and deserialized.
 * A list of the user's observers is necessary while instantiating that class in
 * order to notify them.
 * 
 * @author Julien "Roulyo" Fraisse
 */
public class ObjectReceiver extends Observable implements Runnable
{
  private ObjectInputStream objectInputStream = null;

  /**
   * Ctor instantiate the ObjectInputStream used by the ObjectReceiver to
   * deserialize data from a socket's input stream.
   * 
   * @param inputStream Socket's input stream.
   * @param observersList List of user's observers.
   */
  public ObjectReceiver(InputStream inputStream,
                        List<Observer> observersList)
  {
    this.objectInputStreamInit(inputStream);
    
    for (Observer observer : observersList)
      addObserver(observer);
  }
 
  /**
   * Ctor alternate version with only one observer.
   * 
   * @param inputStream Socket's input stream.
   * @param observer User's observer.
   */
  public ObjectReceiver(InputStream inputStream,
                        Observer observer)
  {
    this.objectInputStreamInit(inputStream);

    addObserver(observer);
    System.out.println("echo");
  }
  
  /**
   * Set a new ObjectInputStream from another socket's input stream.
   * Close the one used previously.
   * 
   * @param inputStream 
   */
  public void setInputStream(InputStream inputStream)
  {
    try
    {
      this.objectInputStream.close();
      System.out.println("OK");
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
    this.read();
  }
  
  /**
   * This method deserialize data from the socket while it is openned, and
   * notifies its observers when a CLSerializable can be restitute.
   */
  private synchronized void read()
  {
    CLSerializable bean = null;
    
    try
    {
      while ((bean = (CLSerializable) this.objectInputStream.readObject()) != null)
      {
        setChanged();
        notifyObservers(bean);
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

  private synchronized void objectInputStreamInit(InputStream inputStream)
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
}
