package com.jsfcourse.calc;

public class interestName extends CalcBB {
	
		private final String interestName, intrestValue;
		
		public interestName(String interestName, String intrestValue) {
		this.interestName= interestName;
		this.intrestValue= intrestValue;
		}
		public String getInterestName() 
		{
			return(interestName);
		}
		public String getInterestValue() 
		{
			return(intrestValue);
		}
		
}
