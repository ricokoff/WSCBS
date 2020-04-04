/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.codejava;

public interface Calculator extends java.rmi.Remote {
    public int add(int arg0, int arg1) throws java.rmi.RemoteException;
    public int sub(int arg0, int arg1) throws java.rmi.RemoteException;
    public int div(int arg0, int arg1) throws java.rmi.RemoteException;
    public int mul(int arg0, int arg1) throws java.rmi.RemoteException;
}
