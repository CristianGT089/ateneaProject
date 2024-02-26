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
    private VistaMonitor viewMonitor;
    
    public MonitorController(MonitorDAO monitorDAO, VistaMonitor viewMonitor){
        this.monitor = new Monitor();
        this.monitorDAO = monitorDAO;
        this.viewMonitor = viewMonitor;
        this.viewMonitor.btnSearch.addActionListener(this);//Buscar
        this.viewMonitor.btnSave.addActionListener(this);//Guardar
        this.viewMonitor.btnUpdate.addActionListener(this);//Actualizar
        this.viewMonitor.btnDelete.addActionListener(this);//Borrar

    }
    
    public void iniciar(){
        viewMonitor.setTitle("Monitor");
        viewMonitor.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Guardar
        if(e.getSource()==viewMonitor.btnSave){
            monitor.setAddress(viewMonitor.jTextField3.getText());
            monitor.setName(viewMonitor.jTextField1.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(viewMonitor.jTextField4.getText());
            monitor.setPhoneNumber(viewMonitor.jTextField2.getText());
        }

        
        //Actualizar
        if(e.getSource()==viewMonitor.btnUpdate){
            monitor.setAddress(viewMonitor.jTextField3.getText());
            monitor.setName(viewMonitor.jTextField1.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(viewMonitor.jTextField4.getText());
            monitor.setPhoneNumber(viewMonitor.jTextField2.getText());
        }

        //Borrar
        if(e.getSource()==viewMonitor.btnDelete){
            monitor.setAddress(viewMonitor.jTextField3.getText());
            monitor.setName(viewMonitor.jTextField1.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(viewMonitor.jTextField4.getText());
            monitor.setPhoneNumber(viewMonitor.jTextField2.getText());
        }

        
        //Buscar
        if(e.getSource()==viewMonitor.btnSearch){
            viewMonitor.jTextField1.setText(monitor.getName());
            viewMonitor.jTextField2.setText(monitor.getPhoneNumber());
            viewMonitor.jTextField3.setText(monitor.getAddress());
            viewMonitor.jTextField4.setText(monitor.getEmail());
            viewMonitor.jTextField5.setText(String.valueOf(monitor.getBornDate()));
            
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró registro");
        }        
        
        
    }
    
    
}
