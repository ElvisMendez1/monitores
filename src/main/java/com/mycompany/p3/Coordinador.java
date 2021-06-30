/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ronny
 */
public class Coordinador {

    public static int t;
        
         public static ArrayList<String> lMonitor = new ArrayList<String>();
         
    public static void main(String[] args) {
       
       try{
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("mCoordinador", new ClassCoordinador());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            System.exit(0);
        }
       
       t = Integer.parseInt(JOptionPane.showInputDialog("Intervalo de tiempo"));
        JOptionPane.showMessageDialog(null,"Servidor en ejecucion...");  
    }
    
}
