package com.epita.mti.plic.opensource.controlibutility.serialization;

import com.epita.mti.plic.opensource.controlibutility.beans.CLAccel;
import com.epita.mti.plic.opensource.controlibutility.beans.CLButtonPressure;
import com.epita.mti.plic.opensource.controlibutility.beans.CLPressure;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.*;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * The ObjectReceiver class is part of a Observable/Observer pattern. It listens
 * the socket in a thread and notifies its observers when an object is received
 * and deserialized. A list of the user's observers is necessary while
 * instantiating that class in order to notify them.
 *
 * @author Julien "Roulyo" Fraisse
 */
public class ObjectReceiver extends Observable implements Runnable
{

  private InputStream inputStream = null;
  public static HashMap<String, Class<?>> beansMap;
  private ObjectMapper mapper = null;

  /**
   * Ctor instantiate the IntputStream used by the ObjectReceiver to deserialize
   * data from a socket's input stream.
   *
   * @param inputStream Socket's input stream.
   * @param observersList List of user's observers.
   */
  public ObjectReceiver(Socket socket,
                        List<Observer> observersList) throws IOException
  {
    this.inputStream = socket.getInputStream();
    for (Observer observer : observersList)
    {
      addObserver(observer);
    }
    mapper = new ObjectMapper().configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
    initMap();
  }

  /**
   * Ctor alternate version with only one observer.
   *
   * @param inputStream Socket's input stream.
   * @param observer User's observer.
   */
  public ObjectReceiver(Socket socket,
                        Observer observer) throws IOException
  {
    this.inputStream = socket.getInputStream();
    addObserver(observer);
    mapper = new ObjectMapper().configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
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
      this.inputStream.close();
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }

  /**
   * Set a new IntputStream from another socket's input stream. Close the one
   * used previously.
   *
   * @param inputStream
   */
  public void setInputStream(InputStream inputStream)
  {
    try
    {
      this.inputStream.close();
      System.out.println("OK");
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }

    this.inputStream = inputStream;
  }

  @Override
  public void run()
  {
    try
    {
      this.read();
    }
    catch (NoSuchMethodException ex)
    {
      ex.printStackTrace();
    }
    catch (IllegalArgumentException ex)
    {
      ex.printStackTrace();
    }
    catch (InvocationTargetException ex)
    {
      ex.printStackTrace();
    }
    catch (InstantiationException ex)
    {
      ex.printStackTrace();
    }
    catch (IllegalAccessException ex)
    {
      ex.printStackTrace();
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
      while ((map = mapper.readValue(inputStream, new TypeReference<Map<String, Object>>()
      {
      })) != null)
      {
        Object mapType = map.get("type");
        Class<?> beanClass;
        if (mapType != null)
        {
          beanClass = beansMap.get(mapType.toString());
          Constructor<?> constructor = beanClass.getConstructor(HashMap.class);
          bean = (CLSerializable) constructor.newInstance(map);
          setChanged();
          notifyObservers(bean);
        }
        else
        {
          map = null;
        }
      }
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
}
