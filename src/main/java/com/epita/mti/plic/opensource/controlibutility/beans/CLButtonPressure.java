package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;

/**
 *
 * @author Benoit "KIDdAe" Vasseur
 * This class will be used to serialize data coming from
 * a pressure on a button of the device's screen.
 * It contains id of the button.
 */
public class CLButtonPressure extends CLSerializable
{
  /**
   * id of the pressed button
   */
  protected Integer buttonId;

  /**
   * Constructor
   */
  public CLButtonPressure()
  {
     this.type = "button-pressure";
  }

  public Integer getButtonId()
  {
    return buttonId;
  }

  public void setButtonId(Integer buttonId)
  {
    this.buttonId = buttonId;
  }
}
