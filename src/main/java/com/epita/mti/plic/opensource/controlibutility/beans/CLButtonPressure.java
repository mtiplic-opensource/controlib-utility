package com.epita.mti.plic.opensource.controlibutility.beans;

import com.epita.mti.plic.opensource.controlibutility.serialization.CLSerializable;
import java.util.HashMap;

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

  /**
   * Constructor used by the receiver.
   * @param map
   */
  public CLButtonPressure(HashMap<String, Object> map)
  {
    super(map);
    Object mapButtonId = map.get("buttonId");
    if (mapButtonId != null)
      buttonId = Integer.parseInt(mapButtonId.toString());
    else
      buttonId = 0;
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
