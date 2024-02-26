/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.VistaInstructor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        viewInstructor.setTitle("instructor");
        viewInstructor.setLocationRelativeTo(null);
        
    }

    
    public Instructor chargeInstructor() throws ParseException{
        Instructor newInstructor = new Instructor();

        newInstructor = new Instructor();
        newInstructor.setId(Integer.parseInt(viewInstructor.tfId.getText()));
        newInstructor.setName(viewInstructor.tfName.getText());
        newInstructor.setPhoneNumber(viewInstructor.tfPhone.getText());
        newInstructor.setAddress(viewInstructor.tfAddress.getText());
        newInstructor.setEmail(viewInstructor.tfEmail.getText());
        
        String dateString = viewInstructor.tfBornDate.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = dateFormat.parse(dateString); // Parsea la fecha en formato string a java.util.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Convierte java.util.Date a java.sql.Date
        newInstructor.setBornDate(sqlDate);
        return newInstructor;
    }

    public void clearTextFields(){
        viewInstructor.tfId.setText("");
        viewInstructor.tfName.setText("");
        viewInstructor.tfPhone.setText("");
        viewInstructor.tfAddress.setText("");
        viewInstructor.tfEmail.setText("");
        viewInstructor.tfBornDate.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Guardar
        if(e.getSource()==viewInstructor.btnSave){
            try {
                
                instructor = chargeInstructor();

                instructorDAO.addInstructor(instructor);

                clearTextFields();
                
                JOptionPane.showMessageDialog(null, "¡El instructor fue registrado satisfactoriamente!");

            } catch (ParseException ex) {
                // Mostrar un mensaje de error si la fecha no es válida
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utilice el formato dd/MM/yyyy");
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al conectar la BD");
            }
        }
        
        
        //Actualizar
        if(e.getSource()==viewInstructor.btnUpdate){
            try {
                instructor = chargeInstructor();

                instructorDAO.updateInstructor(instructor);

                clearTextFields();

                JOptionPane.showMessageDialog(null, "¡El instructor fue actualizado satisfactoriamente!");

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utilice el formato dd/MM/yyyy");
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al conectar la BD");
            }
        }
        
        
        //Borrar
        if(e.getSource()==viewInstructor.btnDelete){
            try {
                instructorDAO.deleteInstructor(Integer.parseInt(viewInstructor.tfId.getText()));

                clearTextFields();

                JOptionPane.showMessageDialog(null, "¡El instructor fue eliminado satisfactoriamente!");

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al conectar la BD");
            }
        }
             
        
        //Buscar
        if(e.getSource()==viewInstructor.btnSearch){
            try {
                instructor = instructorDAO.getInstructor(Integer.parseInt(viewInstructor.tfId.getText()));

                viewInstructor.tfName.setText(instructor.getName());
                viewInstructor.tfPhone.setText(instructor.getPhoneNumber());
                viewInstructor.tfAddress.setText(instructor.getAddress());
                viewInstructor.tfEmail.setText(instructor.getEmail());
                // Convertir la fecha de tipo Date a String con el formato adecuado
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = dateFormat.format(instructor.getBornDate());
                
                // Establecer la fecha formateada en el JFormattedTextField
                viewInstructor.tfBornDate.setText(formattedDate);

                JOptionPane.showMessageDialog(null, "¡El instructor fue encontrado satisfactoriamente!");

            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Por favor digite un número");
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
            } catch (NullPointerException e1){
                JOptionPane.showMessageDialog(null, "No se encontró registro");
            }
        }         
        
    }
    
}
