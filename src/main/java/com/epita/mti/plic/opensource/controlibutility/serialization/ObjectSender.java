package com.epita.mti.plic.opensource.controlibutility.serialization;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
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
  private ObjectOutputStream objectOutputStream;

  /**
   * Ctor instantiate the ObjectOutputStream used by the ObjectSender to
   * serialize data from a socket's output stream.
   *
   * @param outputStream Socket's output stream.
   */
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

  /**
   * This method send a serialized bean of data via the socket.
   *
   * @param bean The bean represents data about pressures, accelerometric
   * values, and so on.
   */
  public void send(CLSerializable bean) throws InvocationTargetException, IllegalAccessException, IntrospectionException
  {
    try
    {
      ObjectMapper mapper = new ObjectMapper();
      mapper.writeValue(new File("test"), bean);
    }
    catch (IOException ex)
    {
      Logger.getLogger(ObjectSender.class.getName()).log(Level.SEVERE, "Cannot write into socket", ex);
    }
  }
}
