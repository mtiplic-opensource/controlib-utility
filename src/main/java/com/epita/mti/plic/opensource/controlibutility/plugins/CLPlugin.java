package com.epita.mti.plic.opensource.controlibutility.plugins;

import com.epita.mti.plic.opensource.controlibserver.jarloader.JarClassLoader;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This is the interface the all plugins have to implements
 */
public interface CLPlugin extends Observer
{
  public void update(Observable o, Object arg);
  public void setClassLoader(JarClassLoader classLoader);
}
