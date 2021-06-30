/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p3;

/**
 *
 * @author ronny
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

public class ClassCoordinador extends UnicastRemoteObject implements objetoCoordinador {

    String loadavg = "loadavg"; 
   

    public ClassCoordinador() throws RemoteException {
        super(); //CONSTRUCTOR
    }

    @Override
    public int iniMonitor(String id) throws RemoteException {
        
       
        Coordinador.lMonitor.add(id);
        JOptionPane.showMessageDialog(null,"Monitor: " + id + " ha sido agregado");

        
        return Coordinador.t;
    }

    @Override
    public void loadMonitor(String loadavg) throws RemoteException {

        this.loadavg = loadavg; 
    }

    @Override
    public int iniClient() throws RemoteException {
      
       
        return Coordinador.lMonitor.size();
    }

    @Override
    public String getLoadAvg() throws RemoteException {

        return loadavg; 
    }

}
