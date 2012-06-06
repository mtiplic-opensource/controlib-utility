package com.epita.mti.plic.opensource.controlibutility.plugins;

import com.epita.mti.plic.opensource.controlibutility.serialization.ObjectSender;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This is the interface that all plugins that uses a sender have to implements
 */
public interface CLObserverSend extends Observer
{
  public void update(Observable o, Object arg);
  public void setObjectSender(ObjectSender sender);
}
