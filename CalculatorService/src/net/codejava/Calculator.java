package net.codejava;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public class Calculator {
	
	@WebMethod
	public double add(double n1, double n2) {
		return n1 + n2;
	}
	
	@WebMethod
	public double mul(double n1, double n2) {
		return n1*n2;
	}
	
	@WebMethod
	public double sub(double n1, double n2) {
		return n1-n2;
	}
	
	@WebMethod
	public double div(double n1, double n2) {
		return n1/n2;
	}
	
}
