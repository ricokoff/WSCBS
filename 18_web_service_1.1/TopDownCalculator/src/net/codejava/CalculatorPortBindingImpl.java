/**
 * CalculatorPortBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.codejava;

public class CalculatorPortBindingImpl implements net.codejava.Calculator{
    public double add(double arg0, double arg1) throws java.rmi.RemoteException {
        return arg0+arg1;
    }

    public double sub(double arg0, double arg1) throws java.rmi.RemoteException {
        return arg0-arg1;
    }

    public double div(double arg0, double arg1) throws java.rmi.RemoteException {
        return arg0/arg1;
    }

    public double mul(double arg0, double arg1) throws java.rmi.RemoteException {
        return arg0*arg1;
    }

}
