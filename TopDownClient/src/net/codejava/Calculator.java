/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.codejava;

public interface Calculator extends java.rmi.Remote {
    public double add(double arg0, double arg1) throws java.rmi.RemoteException;
    public double sub(double arg0, double arg1) throws java.rmi.RemoteException;
    public double div(double arg0, double arg1) throws java.rmi.RemoteException;
    public double mul(double arg0, double arg1) throws java.rmi.RemoteException;
}
