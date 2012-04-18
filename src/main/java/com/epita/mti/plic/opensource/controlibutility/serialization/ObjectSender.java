package com.epita.mti.plic.opensource.controlibutility.serialization;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * The ObjectSender class is the one which send data over the socket.
 * It takes its output stream in order to create the object output stream.
 *
 * @author Julien "Roulyo" Fraisse
 */
public class ObjectSender
{

  /**
   * The stream used to serialize objects for the socket communication.
   */
  private OutputStream outputStream;

  /**
   * Ctor instantiate the ObjectOutputStream used by the ObjectSender to
   * serialize data from a socket's output stream.
   *
   * @param outputStream Socket's output stream.
   */
  public ObjectSender(OutputStream outputStream)
  {
    this.outputStream = outputStream;
  }

  /**
   * Set a new ObjectOutputStream from another socket's output stream.
   * Flush and close the one used previously.
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
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot close ObjectOutputStream", ex);
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
    try
    {
      ObjectMapper mapper = new ObjectMapper();
      mapper.writeValue(outputStream, bean);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot write into socket", ex);
    }
  }
}
