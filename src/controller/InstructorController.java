/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.VistaInstructor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DAO.InstructorDAO;
import model.persona.Instructor;

/**
 *
 */
public class InstructorController implements ActionListener{
    
    private Instructor instructor;
    private InstructorDAO instructorDAO;
    private VistaInstructor viewInstructor;
    
    public InstructorController(InstructorDAO instructorDAO, VistaInstructor viewInstructor){
    
        this.instructor= new Instructor();
        this.instructorDAO=instructorDAO;
        this.viewInstructor=viewInstructor;
        this.viewInstructor.btnSearch.addActionListener(this);//Buscar
        this.viewInstructor.btnSave.addActionListener(this);//Guardar
        this.viewInstructor.btnUpdate.addActionListener(this);//Actualizar
        this.viewInstructor.btnDelete.addActionListener(this);//Borrar
        
    }
    
    public void iniciar(){
        viewInstructor.setTitle("Monitor");
        viewInstructor.setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Guardar
        if(e.getSource()==viewInstructor.btnSave){
            
            instructor.setAddress(viewInstructor.tfAddress.getText());
            instructor.setName(viewInstructor.tfName.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            instructor.setEmail(viewInstructor.tfEmail.getText());
            instructor.setPhoneNumber(viewInstructor.tfPhone.getText());
        }
        
        
        //Actualizar
        if(e.getSource()==viewInstructor.btnUpdate){
            instructor.setAddress(viewInstructor.tfAddress.getText());
            instructor.setName(viewInstructor.tfName.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            instructor.setEmail(viewInstructor.tfEmail.getText());
            instructor.setPhoneNumber(viewInstructor.tfPhone.getText());
        }
        
        
        //Borrar
        if(e.getSource()==viewInstructor.btnDelete){
            instructor.setAddress(viewInstructor.tfAddress.getText());
            instructor.setName(viewInstructor.tfName.getText());
            //monitor.setBornDate(vMonitor.jTextField5.getText());
            instructor.setEmail(viewInstructor.tfEmail.getText());
            instructor.setPhoneNumber(viewInstructor.tfPhone.getText());
        }
             
        
        //Buscar
        if(e.getSource()==viewInstructor.btnSearch){
            try {
                instructor = instructorDAO.getInstructor(Integer.parseInt(viewInstructor.tfId.getText()));
                viewInstructor.tfName.setText(instructor.getName());
                viewInstructor.tfPhone.setText(instructor.getPhoneNumber());
                viewInstructor.tfAddress.setText(instructor.getAddress());
                viewInstructor.tfEmail.setText(instructor.getEmail());
                viewInstructor.tfBornDate.setText(String.valueOf(instructor.getBornDate()));
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró registro");
        }        
        
    }
    
    
}
