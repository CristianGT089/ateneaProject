package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import model.persona.Instructor;

public class InstructorDAOImpl implements InstructorDAO{
    private Connection connection;

    public InstructorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addInstructor(Instructor instructor) throws SQLException {
        String query = "INSERT INTO instructor (name, phoneNumber, bornDate, address, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, instructor.getName());
            statement.setString(2, instructor.getPhoneNumber());
            statement.setDate(3, new java.sql.Date(instructor.getBornDate().getTime()));
            statement.setString(4, instructor.getAddress());
            statement.setString(5, instructor.getEmail());
            statement.executeUpdate();
        }
    }

    @Override
    public Instructor getInstructor(int id) throws SQLException {
        Instructor instructor = new Instructor();
    
        String query = "SELECT * FROM instructor WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) { // Comprueba si hay un resultado antes de acceder a él
                    instructor.setId(resultSet.getInt("id"));
                    instructor.setName(resultSet.getString("name"));
                    instructor.setPhoneNumber(resultSet.getString("phoneNumber"));
                    instructor.setBornDate(new Date(resultSet.getDate("bornDate").getTime()));
                    instructor.setAddress(resultSet.getString("address"));
                    instructor.setEmail(resultSet.getString("email"));
                }else{
                    instructor = null;
                }
            }
        }
        return instructor;
    }   

    @Override
    public List<Instructor> getAllInstructors() throws SQLException {
        List<Instructor> instructors = new ArrayList<>();
        String query = "SELECT * FROM instructor";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Instructor instructor = new Instructor();
                    instructor.setId(resultSet.getInt("id"));
                    instructor.setName(resultSet.getString("name"));
                    instructor.setPhoneNumber(resultSet.getString("phoneNumber"));
                    instructor.setBornDate(new Date(resultSet.getDate("bornDate").getTime()));
                    instructor.setAddress(resultSet.getString("address"));
                    instructor.setEmail(resultSet.getString("email"));
                    instructors.add(instructor);
                }
            }
        }
        return instructors;
    }

    @Override
    public void updateInstructor(Instructor updatedInstructor) throws SQLException {
        String query = "UPDATE instructor SET name=?, phoneNumber=?, bornDate=?, address=?, email=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, updatedInstructor.getName());
            statement.setString(2, updatedInstructor.getPhoneNumber());
            statement.setDate(3, new java.sql.Date(updatedInstructor.getBornDate().getTime()));
            statement.setString(4, updatedInstructor.getAddress());
            statement.setString(5, updatedInstructor.getEmail());
            statement.setInt(6, updatedInstructor.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteInstructor(int id) throws SQLException {
        String query = "DELETE FROM instructor WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    
}
