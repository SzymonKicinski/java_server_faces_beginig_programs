package jpdsi;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OpOptions {
	private String[] opValues = {"1","2","3","4","5"};

	

public String[] getOpValues() {
		return opValues;
	}



	public void setOpValues(String[] opValues) {
		this.opValues = opValues;
	}



public OpOptions() {
	for(int i=0; i<opValues.length; i++) {
		String opValue = opValues[i];
	}
}

}

