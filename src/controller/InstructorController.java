/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.VistaInstructor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DAO.InstructorDAOImpl;
import model.persona.Instructor;

/**
 *
 */
public class InstructorController implements ActionListener{
    
    private Instructor monitor;
    private InstructorDAOImpl monitorC;
    private VistaInstructor vMonitor;
    
    public InstructorController(Instructor monitor, InstructorDAOImpl monitorC, VistaInstructor vMonitor){
    
        this.monitor=monitor;
        this.monitorC=monitorC;
        this.vMonitor=vMonitor;
        this.vMonitor.btnSearch.addActionListener(this);//Buscar
        this.vMonitor.btnSave.addActionListener(this);//Guardar
        this.vMonitor.btnUpdate.addActionListener(this);//Actualizar
        this.vMonitor.btnDelete.addActionListener(this);//Borrar
        
        
        
    }
    
    public void iniciar(){
        vMonitor.setTitle("Monitor");
        vMonitor.setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Guadar
        if(e.getSource()==vMonitor.btnSave){
            monitor.setAddress(vMonitor.tfAddress.getText());
            monitor.setName(vMonitor.tfName.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(vMonitor.tfEmail.getText());
            monitor.setPhoneNumber(vMonitor.tfPhoneNumber.getText());
        }
        
        
        //Actualizar
        if(e.getSource()==vMonitor.btnUpdate){
            monitor.setAddress(vMonitor.tfAddress.getText());
            monitor.setName(vMonitor.tfName.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(vMonitor.tfEmail.getText());
            monitor.setPhoneNumber(vMonitor.tfPhoneNumber.getText());
        }
        
        
        //Borrar
        if(e.getSource()==vMonitor.btnDelete){
            monitor.setAddress(vMonitor.tfAddress.getText());
            monitor.setName(vMonitor.tfName.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            monitor.setEmail(vMonitor.tfEmail.getText());
            monitor.setPhoneNumber(vMonitor.tfPhoneNumber.getText());
        }
             
        
        //Buscar
        if(e.getSource()==vMonitor.btnSearch){
            vMonitor.tfName.setText(monitor.getName());
            vMonitor.tfPhoneNumber.setText(monitor.getPhoneNumber());
            vMonitor.tfAddress.setText(monitor.getAddress());
            vMonitor.tfEmail.setText(monitor.getEmail());
            vMonitor.tfBornDate.setText(String.valueOf(monitor.getBornDate()));
            
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró registro");
        }        
        
        
    }
    
    
}
