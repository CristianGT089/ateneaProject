package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.Connection.ConnectionSQL;
import model.DAO.InstructorDAO;
import model.DAO.InstructorDAOImpl;
import model.DAO.MonitorDAO;
import model.DAO.MonitorDAOImpl;
import model.persona.*;

public class Model {
    private Connection connection;     
    private InstructorDAO instructorDAO;
    private MonitorDAO monitorDAO;
    
    public Model(){
        try {
            connection = ConnectionSQL.getConnection();
            instructorDAO = new InstructorDAOImpl(connection);
            monitorDAO = new MonitorDAOImpl(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addExample(){
        try {
            List<Monitor> monitors = monitorDAO.getAllMonitors();

            for (Monitor monitor : monitors) {
                System.out.println("ID: " + monitor.getId());
                System.out.println("Nombre: " + monitor.getName());
                System.out.println("Número de teléfono: " + monitor.getPhoneNumber());
                System.out.println("Fecha de nacimiento: " + monitor.getBornDate());
                System.out.println("Dirección: " + monitor.getAddress());
                System.out.println("Correo electrónico: " + monitor.getEmail());
                System.out.println(); // Espacio en blanco entre cada monitor
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public InstructorDAO getInstructorDAO() {
        return instructorDAO;
    }

    public void setInstructorDAO(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    public MonitorDAO getMonitorDAO() {
        return monitorDAO;
    }

    public void setMonitorDAO(MonitorDAO monitorDAO) {
        this.monitorDAO = monitorDAO;
    }
}
