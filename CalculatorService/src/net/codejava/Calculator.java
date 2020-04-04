package net.codejava;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public class Calculator {
	
	@WebMethod
	public int add(int n1, int n2) {
		return n1 + n2;
	}
	
	@WebMethod
	public int mul(int n1, int n2) {
		return n1*n2;
	}
	
	@WebMethod
	public int sub(int n1, int n2) {
		return n1-n2;
	}
	
	@WebMethod
	public int div(int n1, int n2) {
		return n1/n2;
	}
	
}
