package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Instructor> getAllInstructors() throws SQLException {
        List<Instructor> instructors = new ArrayList<>();
        String query = "SELECT * FROM instructor";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Instructor instructor = new Instructor();
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
    
}
