package model.DAO;

import java.sql.SQLException;
import java.util.List;
import model.persona.Monitor;

public interface MonitorDAO {
    
    void addMonitor(Monitor monitor) throws SQLException;
    Monitor getMonitor(int id) throws SQLException;
    List<Monitor> getAllMonitors() throws SQLException;
    void updateMonitor(Monitor updatedMonitor) throws SQLException;
    void deleteMonitor(int id) throws SQLException;

}