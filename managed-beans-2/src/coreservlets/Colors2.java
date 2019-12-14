package coreservlets;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="myBean")
public class Colors2 extends Colors1 {
  @Override
  public String showColors() {
    return("show-colors-2");
  }
}
