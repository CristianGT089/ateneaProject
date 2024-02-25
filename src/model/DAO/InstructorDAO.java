package model.DAO;

import java.sql.SQLException;
import java.util.List;
import model.persona.Instructor;

public interface InstructorDAO {
    void addInstructor(Instructor instructor) throws SQLException;
    List<Instructor> getAllInstructors() throws SQLException;
    // Otros métodos de DAO como updateInstructor(), deleteInstructor(), etc.
}
