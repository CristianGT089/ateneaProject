package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Monitor> getAllMonitors() throws SQLException {
        List<Monitor> monitors = new ArrayList<>();
        String query = "SELECT * FROM monitor";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Monitor monitor = new Monitor();
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

    

    // Otros métodos de DAO como updateMonitor(), deleteMonitor(), etc.
}