package model;

import java.sql.Connection;
import java.sql.SQLException;
import model.Connection.ConnectionSQL;
import model.DAO.InstructorDAO;
import model.DAO.InstructorDAOImpl;
import model.DAO.MonitorDAO;
import model.DAO.MonitorDAOImpl;

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
