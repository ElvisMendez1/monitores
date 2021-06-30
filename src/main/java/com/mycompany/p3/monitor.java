/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
/**
 *
 * @author ronny
 */
public class monitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int seg;
        String ip = "localhost";
        String id;
        String loadavg;
        
         ip = JOptionPane.showInputDialog("Ingrese la IP");
         
          try {
           
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            objetoCoordinador mCoordinador = (objetoCoordinador) registry.lookup("mCoordinador");

            BufferedReader br2 = new BufferedReader(new FileReader(new File("/etc/hostname")));
            id = br2.readLine();
            JOptionPane.showMessageDialog(null,"Monitor: " + id);

            seg = mCoordinador.iniMonitor(id);
            
            while (true) {
                BufferedReader br = new BufferedReader(new FileReader(new File("/proc/loadavg")));
                loadavg = br.readLine();

                mCoordinador.loadMonitor(id + ": " + loadavg);
                
                Thread.sleep(seg * 1000);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }

    }
    
}
