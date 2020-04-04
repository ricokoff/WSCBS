/**
 * CalculatorPortBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.codejava;

public class CalculatorPortBindingImpl implements net.codejava.Calculator{
    public int add(int arg0, int arg1) throws java.rmi.RemoteException {
        return arg0+arg1;
    }

    public int sub(int arg0, int arg1) throws java.rmi.RemoteException {
        return arg0-arg1;
    }

    public int div(int arg0, int arg1) throws java.rmi.RemoteException {
        return arg0/arg1;
    }

    public int mul(int arg0, int arg1) throws java.rmi.RemoteException {
        return arg0*arg1;
    }

}
