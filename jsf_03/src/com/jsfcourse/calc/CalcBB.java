package com.jsfcourse.calc;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean
public class CalcBB {
	private String x;
	private String y;
	private Double result;

	// Resource injected by the server (notice the defined resource name in faces-config)
	// (locale is set automatically based on the use context of the bean - view)
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	public void setTxtCalcErr(ResourceBundle txtCalcErr) {
		this.txtCalcErr = txtCalcErr;
	}

	private ResourceBundle txtCalcErrManual;

	// Resource loaded "manually"
	// (here after initialization in @PostConstruct method)
	// (locale explicitly given - here based on the view )
	@PostConstruct
	public void postConstruct() {
		// loading resource (notice the full "file" name)
		FacesContext context = FacesContext.getCurrentInstance();
		txtCalcErrManual = ResourceBundle.getBundle("resources.textCalcErr",
				context.getViewRoot().getLocale());
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public String calc() {
		FacesContext ctx = FacesContext.getCurrentInstance();

		try {
			double x = Double.parseDouble(this.x);
			double y = Double.parseDouble(this.y);

			result = x + y;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					txtCalcErr.getString("calcComputationOkInfo"), null));
			return "showresult";
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					txtCalcErrManual.getString("calcWrongParams"), null));
			return null;
		}

	}

	public String info() {
		return "info";
	}
}
