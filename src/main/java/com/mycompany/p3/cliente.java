/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p3;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class cliente {

    public static void main(String[] args) {

        int segundos, i = 1;
        String ip = "localhost";

       
        
        ip = JOptionPane.showInputDialog("IP del server");

        try {
            
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            objetoCoordinador mCoordinador = (objetoCoordinador) registry.lookup("mCoordinador");

            
            JOptionPane.showMessageDialog(null,"Monitores funcionando: " + mCoordinador.iniClient());

            if (mCoordinador.iniClient() > 0) {

                
                
                segundos = Integer.parseInt(JOptionPane.showInputDialog("segundos"));

                while (true) {
                    
                    
                    JOptionPane.showMessageDialog(null,i + ": " + mCoordinador.getLoadAvg());
                    i++;

                    
                    Thread.sleep(segundos * 1000);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Saliendo...");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }

    }
}
