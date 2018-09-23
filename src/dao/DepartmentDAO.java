package dao;

import model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDAO implements DAO<Department, Long> {
    @Override
    public Boolean save(Department department) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getInsertSQLString(department));
            Query.setStatementValues(
                    statement,
                    department.getIdDepartment(),
                    department.getField(),
                    department.getDescription(),
                    department.getProfessor().getIdProfessor()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return false;
    }

    @Override
    public Department find(Long key) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Boolean update(Department department) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(department));
            Query.setStatementValues(
                    statement,
                    department.getField(),
                    department.getDescription(),
                    department.getProfessor().getIdProfessor()
                    department.getIdDepartment()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return false;
    }

    @Override
    public Boolean delete(Long key) {
        return null;
    }
}
