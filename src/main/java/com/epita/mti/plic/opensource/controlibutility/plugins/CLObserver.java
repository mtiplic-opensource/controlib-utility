package com.epita.mti.plic.opensource.controlibutility.plugins;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This is the interface the all plugins that don't use a sender have to implements
 */
public interface CLObserver extends Observer
{
  public void update(Observable o, Object arg);
  public String getVersion();
}
