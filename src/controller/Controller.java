package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import model.Connection.ConnectionSQL;
import model.DAO.InstructorDAO;
import model.DAO.InstructorDAOImpl;
import model.persona.Instructor;

public class Controller {
    
    private Connection connection;     
    private InstructorDAO instructorDAO;
    
    public Controller(){
        try {
            connection = ConnectionSQL.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instructorDAO = new InstructorDAOImpl(connection);



        Instructor ejemplo1 = new Instructor("Pedro","3203481270",new Date(313123123),"Calle 38 N 31 - 130", "pedroAlcantara@gmail.com");

        try {
            instructorDAO.addInstructor(ejemplo1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
