/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface objetoCoordinador extends Remote {

    
    int iniMonitor(String id) throws RemoteException; 
    
    void loadMonitor(String loadavg) throws RemoteException; 
    
    int iniClient() throws RemoteException; 
    
    String getLoadAvg() throws RemoteException; 
}

