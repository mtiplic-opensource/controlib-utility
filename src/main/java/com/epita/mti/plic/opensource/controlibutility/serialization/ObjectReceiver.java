package com.epita.mti.plic.opensource.controlibutility.serialization;

import com.epita.mti.plic.opensource.controlibutility.beans.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

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
  public static HashMap<String, Class<?>> beansMap;
  private ObjectMapper mapper = new ObjectMapper();

  /**
   * Ctor instantiate the ObjectInputStream used by the ObjectReceiver to
   * deserialize data from a socket's input stream.
   *
   * @param inputStream Socket's input stream.
   * @param observersList List of user's observers.
   */
  public ObjectReceiver(Socket socket,
                        List<Observer> observersList)
  {
    try
    {
      this.objectInputStreamInit(socket.getInputStream());
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot open input stream from socket", ex);
    }
    for (Observer observer : observersList)
      addObserver(observer);
    initMap();
  }

  /**
   * Ctor alternate version with only one observer.
   *
   * @param inputStream Socket's input stream.
   * @param observer User's observer.
   */
  public ObjectReceiver(Socket socket,
                        Observer observer)
  {
    try
    {
     this.objectInputStreamInit(socket.getInputStream());
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot open input stream from socket", ex);
    }

    addObserver(observer);
    initMap();
  }

  /**
   * Initialize the map with defaults value;
   */
  private static void initMap()
  {
    beansMap = new HashMap<String, Class<?>>();
    beansMap.put("accel", CLAccel.class);
    beansMap.put("button-pressure", CLButtonPressure.class);
    beansMap.put("image", CLButtonPressure.class);
    beansMap.put("pressure", CLPressure.class);
  }

  /**
   * This method allows users to close the stream properly.
   */
  public void disposeStream()
  {
    try
    {
      this.objectInputStream.close();
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot close ObjectInputStream", ex);
    }
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
    try
    {
       this.read();
    }
    catch (NoSuchMethodException ex) {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (IllegalArgumentException ex) {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (InvocationTargetException ex) {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex) {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex) {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * This method deserialize data from the socket while it is openned, and
   * notifies its observers when a CLSerializable can be restitute.
   */
  public synchronized void read() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException
  {
    CLSerializable bean;
    Map<String, Object> map;
    try
    {
      while ((map = mapper.readValue(objectInputStream,
                                     new TypeReference<Map<String, Object>>() {})) != null)
      {
        Object mapType = map.get("type");
        Class<?> beanClass;
        if (mapType != null)
           beanClass = beansMap.get(mapType.toString());
        else
        {
          map = null;
          continue;
        }
        Constructor<?> constructor = beanClass.getConstructor(HashMap.class);
        bean = (CLSerializable) constructor.newInstance(map);
        setChanged();
        notifyObservers(bean);
      }
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectReceiver.class.getName()).log(Level.SEVERE, "Cannot read the ObjectInputStream", ex);
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
