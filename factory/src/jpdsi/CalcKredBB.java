package jpdsi;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.lang.Math;

@ManagedBean
// @RequestScoped // default value
// @SessionScoped
public class CalcKredBB {
	private String lata;
	private String kwota;
	private String oprocentowanie;
	private Double result;

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public String getLata() {
		return lata;
	}

	public void setLata(String lata) {
		this.lata = lata;
	}

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(String oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public String calc() {
		FacesContext ctx = FacesContext.getCurrentInstance();

		try {
			int lata = Integer.parseInt(this.lata);
			double kwota = Double.parseDouble(this.kwota);
			double oprocentowanie = Double.parseDouble(this.oprocentowanie);
			oprocentowanie = oprocentowanie / 100;
			double q = (1 + (oprocentowanie / lata * 12));
			double n = 12 * lata;
			double result = kwota * Math.pow(q, n) * ((q - 1) / (Math.pow(q, n) - 1));
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie " + result, null));
			return "Dupa";
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return null;
		}

	}

	public String info() {
		return "info";
	}

}
