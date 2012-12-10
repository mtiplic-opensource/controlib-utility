package com.epita.mti.plic.opensource.controlibutility.serialization;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.locks.ReentrantLock;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * The ObjectSender class is the one which send data over the socket. It takes
 * its output stream in order to create the object output stream.
 *
 * @author Julien "Roulyo" Fraisse
 */
public class ObjectSender
{

  /**
   * The stream used to serialize objects for the socket communication.
   */
  private OutputStream outputStream = null;
  /**
   * The mapper used to serialize in JSON.
   */
  private ObjectMapper mapper = null;
  /**
   * The mutex used to ensure that there is only one sender writing on the
   * socket.
   */
  private ReentrantLock mutex = null;
  
  /**
   * Ctor instantiate the ObjectOutputStream used by the ObjectSender to
   * serialize data from a socket's output stream.
   *
   * @param outputStream Socket's output stream.
   */
  public ObjectSender(OutputStream outputStream)
  {
    this.outputStream = outputStream;
    this.mapper = new ObjectMapper().configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
    this.mutex = new ReentrantLock(true);
  }

  /**
   * Set a new ObjectOutputStream from another socket's output stream. Flush and
   * close the one used previously.
   *
   * @param outputStream Socket's output stream.
   */
  public void setOutputStream(OutputStream outputStream)
  {
    try
    {
      this.outputStream.flush();
      this.outputStream.close();
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
    this.outputStream = outputStream;
  }

  /**
   * This method send a serialized bean of data via the socket.
   *
   * @param bean The bean represents data about pressures, accelerometric
   * values, and so on.
   */
  public void send(CLSerializable bean) throws InvocationTargetException, IllegalAccessException
  {
    mutex.lock();
    try
    {
      mapper.writeValue(outputStream, bean);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      mutex.unlock();
    }
  }
}
