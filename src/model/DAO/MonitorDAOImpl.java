package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import model.persona.Monitor;

public class MonitorDAOImpl implements MonitorDAO {
    
    private Connection connection;

    public MonitorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addMonitor(Monitor monitor) throws SQLException {
        String query = "INSERT INTO monitor (name, phoneNumber, bornDate, address, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, monitor.getName());
            statement.setString(2, monitor.getPhoneNumber());
            statement.setDate(3, new java.sql.Date(monitor.getBornDate().getTime()));
            statement.setString(4, monitor.getAddress());
            statement.setString(5, monitor.getEmail());
            statement.executeUpdate();

        }
    }
    
    @Override
    public Monitor getMonitor(int id) throws SQLException {
        Monitor monitor = new Monitor();
    
        String query = "SELECT * FROM monitor WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) { // Comprueba si hay un resultado antes de acceder a él
                    monitor.setId(resultSet.getInt("id"));
                    monitor.setName(resultSet.getString("name"));
                    monitor.setPhoneNumber(resultSet.getString("phoneNumber"));
                    monitor.setBornDate(new Date(resultSet.getDate("bornDate").getTime()));
                    monitor.setAddress(resultSet.getString("address"));
                    monitor.setEmail(resultSet.getString("email"));
                }else{
                    monitor = null;
                }
            }
        }
        return monitor;
    }   

    @Override
    public List<Monitor> getAllMonitors() throws SQLException {
        List<Monitor> monitors = new ArrayList<>();
        String query = "SELECT * FROM monitor";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Monitor monitor = new Monitor();
                    monitor.setId(resultSet.getInt("id"));
                    monitor.setName(resultSet.getString("name"));
                    monitor.setPhoneNumber(resultSet.getString("phoneNumber"));
                    monitor.setBornDate(new Date(resultSet.getDate("bornDate").getTime()));
                    monitor.setAddress(resultSet.getString("address"));
                    monitor.setEmail(resultSet.getString("email"));
                    monitors.add(monitor);
                }
            }
        }
        return monitors;
    }

    @Override
    public void updateMonitor(Monitor updatedMonitor) throws SQLException {
        String query = "UPDATE monitor SET name=?, phoneNumber=?, bornDate=?, address=?, email=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, updatedMonitor.getName());
            statement.setString(2, updatedMonitor.getPhoneNumber());
            statement.setDate(3, new java.sql.Date(updatedMonitor.getBornDate().getTime()));
            statement.setString(4, updatedMonitor.getAddress());
            statement.setString(5, updatedMonitor.getEmail());
            statement.setInt(6, updatedMonitor.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteMonitor(int id) throws SQLException {
        String query = "DELETE FROM monitor WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


}