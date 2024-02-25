/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.VistaMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DAO.MonitorDAO;
import model.persona.Monitor;

/**
 *
 */
public class MonitorController implements ActionListener{
    
    private Monitor monitor;
    private MonitorDAO monitorDAO;
    private VistaMonitor vMonitor;
    
    public MonitorController(MonitorDAO monitorDAO, VistaMonitor vMonitor){
    
        this.monitorDAO=monitorDAO;
        this.vMonitor=vMonitor;
        this.vMonitor.jButton1.addActionListener(this);//Buscar
        this.vMonitor.jButton2.addActionListener(this);//Guardar
        this.vMonitor.jButton3.addActionListener(this);//Actualizar
        this.vMonitor.jButton4.addActionListener(this);//Borrar

    }
    
    public void iniciar(){
        vMonitor.setTitle("Monitor");
        vMonitor.setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Guadar
        if(e.getSource()==vMonitor.jButton2){
            monitor.setAddress(vMonitor.jTextField3.getText());
            monitor.setName(vMonitor.jTextField1.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(vMonitor.jTextField4.getText());
            monitor.setPhoneNumber(vMonitor.jTextField2.getText());
        }

        
        //Actualizar
        if(e.getSource()==vMonitor.jButton3){
            monitor.setAddress(vMonitor.jTextField3.getText());
            monitor.setName(vMonitor.jTextField1.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(vMonitor.jTextField4.getText());
            monitor.setPhoneNumber(vMonitor.jTextField2.getText());
        }

        //Borrar
        if(e.getSource()==vMonitor.jButton4){
            monitor.setAddress(vMonitor.jTextField3.getText());
            monitor.setName(vMonitor.jTextField1.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(vMonitor.jTextField4.getText());
            monitor.setPhoneNumber(vMonitor.jTextField2.getText());
        }

        
        //Buscar
        if(e.getSource()==vMonitor.jButton1){
            vMonitor.jTextField1.setText(monitor.getName());
            vMonitor.jTextField2.setText(monitor.getPhoneNumber());
            vMonitor.jTextField3.setText(monitor.getAddress());
            vMonitor.jTextField4.setText(monitor.getEmail());
            vMonitor.jTextField5.setText(String.valueOf(monitor.getBornDate()));
            
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró registro");
        }        
        
        
    }
    
    
}
