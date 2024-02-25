package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;



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
        Monitor example1 = new Monitor("Juan","3203481270",new Date(313123123),"Calle 38 N 31 - 130", "juanCortez@gmail.com");

        try {
            monitorDAO.addMonitor(example1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
