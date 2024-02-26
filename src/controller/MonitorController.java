/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.VistaMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public Monitor chargeMonitor() throws ParseException{
        Monitor newMonitor = new Monitor();

        newMonitor = new Monitor();
        newMonitor.setId(Integer.parseInt(viewMonitor.tfId.getText()));
        newMonitor.setName(viewMonitor.tfName.getText());
        newMonitor.setPhoneNumber(viewMonitor.tfPhone.getText());
        newMonitor.setAddress(viewMonitor.tfAddress.getText());
        newMonitor.setEmail(viewMonitor.tfEmail.getText());
        
        String dateString = viewMonitor.tfBornDate.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = dateFormat.parse(dateString); // Parsea la fecha en formato string a java.util.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Convierte java.util.Date a java.sql.Date
        newMonitor.setBornDate(sqlDate);
        return newMonitor;
    }

    public void clearTextFields(){
        viewMonitor.tfId.setText("");
        viewMonitor.tfName.setText("");
        viewMonitor.tfPhone.setText("");
        viewMonitor.tfAddress.setText("");
        viewMonitor.tfEmail.setText("");
        viewMonitor.tfBornDate.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Guardar
        if(e.getSource()==viewMonitor.btnSave){
            try {
                
                monitor = chargeMonitor();

                monitorDAO.addMonitor(monitor);

                clearTextFields();
                
                JOptionPane.showMessageDialog(null, "¡El monitor fue registrado satisfactoriamente!");

            } catch (ParseException ex) {
                // Mostrar un mensaje de error si la fecha no es válida
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utilice el formato dd/MM/yyyy");
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al conectar la BD");
            }
        }

        
        //Actualizar
        if(e.getSource()==viewMonitor.btnUpdate){
            try {
                monitor = chargeMonitor();

                monitorDAO.updateMonitor(monitor);

                clearTextFields();

                JOptionPane.showMessageDialog(null, "¡El monitor fue actualizado satisfactoriamente!");

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utilice el formato dd/MM/yyyy");
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al conectar la BD");
            }
        }

        //Borrar
        if(e.getSource()==viewMonitor.btnDelete){
            try {
                monitorDAO.deleteMonitor(Integer.parseInt(viewMonitor.tfId.getText()));

                clearTextFields();

                JOptionPane.showMessageDialog(null, "¡El monitor fue eliminado satisfactoriamente!");

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al conectar la BD");
            }
        }

        //Buscar
        if(e.getSource()==viewMonitor.btnSearch){
            try {
                monitor = monitorDAO.getMonitor(Integer.parseInt(viewMonitor.tfId.getText()));

                viewMonitor.tfName.setText(monitor.getName());
                viewMonitor.tfPhone.setText(monitor.getPhoneNumber());
                viewMonitor.tfAddress.setText(monitor.getAddress());
                viewMonitor.tfEmail.setText(monitor.getEmail());
                // Convertir la fecha de tipo Date a String con el formato adecuado
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = dateFormat.format(monitor.getBornDate());
                
                // Establecer la fecha formateada en el JFormattedTextField
                viewMonitor.tfBornDate.setText(formattedDate);

                JOptionPane.showMessageDialog(null, "¡El monitor fue encontrado satisfactoriamente!");

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
