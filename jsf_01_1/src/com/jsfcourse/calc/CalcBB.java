package com.jsfcourse.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
//@RequestScoped // default value
@SessionScoped
public class CalcBB {
	private String amount; // wartoœæ kredytu    X
	private String interest;  //oprocentowanie   Y
	private String period; // Iloœæ lat Z
	private Double installment; //rata - result 
	private String[] interestNames = { "0.5", "1.0","1.5","2.0","2.5","3.0","3.5","4.0"};

	private Map<String,String> interestMap = new LinkedHashMap<>();
	
	private List<String> interestValues =Arrays.asList("0.5", "1.0","1.5","2.0","2.5","3.0","3.5","4.0");
	private List<CalcBB> interestList = new ArrayList<>();
	
	
	public  CalcBB()  //konstruktor 
	{
		for ( int i =0; i<interestNames.length;i++)
		{
			String interestName = interestNames[i];
			String intrestValue= interestValues.get(i);
			interestMap.put(interestName, intrestValue);
			interestList.add(new interestName(interestName, intrestValue));
			
		}
			
	}
	
	
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period= period;
	}

	public Double getInstallment() {
		return installment;
	}

	public void setInstallment(Double installment) {
		this.installment= installment;
	}
	

	public String calc() {
		FacesContext ctx = FacesContext.getCurrentInstance();		
		try {
			double amount = Double.parseDouble(this.amount);
			double interest = Double.parseDouble(this.interest);
			double period = Double.parseDouble(this.period);
			
			installment = amount * (( interest + 100) / 100/(period*12));
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dane wprowadzone poprawnie", null));
			return "showresult";
		
		}  catch (Exception e) {
			ctx.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR,"B³êdne dane.", null));
			return null;			
		}
				
	}

	public String info() {
		return "info"; 
	}
}
