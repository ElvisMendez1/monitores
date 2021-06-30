/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author ronny
 */
public class ClassMonitor extends UnicastRemoteObject implements objetoMonitor {

    public ClassMonitor() throws RemoteException {
        super();
    }

    @Override
    public void pingMonitor() throws RemoteException {
     
    }
}
