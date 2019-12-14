package coreservlets;

import java.util.*;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Test {
  private List<String> options = Arrays.asList("foo", "bar", "baz");
  private List<Object> selections;
  
  public List<Object> getSelections() {
    return (selections);
  }
  public void setSelections(List<Object> selections) {
    this.selections = selections;
    System.out.println("Setting selections to " + selections);
  }
  public List<String> getOptions() {
    return (options);
  }

  public String blah() {
    return(null);
  }
}
