package model.DAO;

import java.sql.SQLException;
import java.util.List;
import model.persona.Monitor;

public interface MonitorDAO {
    
    void addMonitor(Monitor monitor) throws SQLException;
    List<Monitor> getAllMonitors() throws SQLException;
    // Otros métodos de DAO como updateMonitor(), deleteMonitor(), etc.
}