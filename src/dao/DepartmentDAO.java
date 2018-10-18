package dao;

import model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements DAO<Department, Long> {
    @Override
    public Boolean save(Department department) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO department SET " +
                            "field = ?, " +
                            "description = ?, " +
                            "id_campus = ?, " +
                            "id_institute = ?, " +
                            "id_professor = ?"
            );
            Query.setStatementValues(
                    statement,
                    department.getField(),
                    department.getDescription(),
                    department.getIdCampus(),
                    department.getIdInstitute(),
                    department.getIdProfessor()
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
    public Department findOne(Long key) {
        String sql = String.format("SELECT * FROM department WHERE id_department = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Department> findAll() {
        return search("SELECT * FROM department");
    }

    @Override
    public Boolean update(Department department) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE department SET " +
                            "field = ?, " +
                            "description = ?, " +
                            "id_campus = ?, " +
                            "id_institute = ?, " +
                            "id_professor = ? " +
                            "WHERE id_department = ?"
            );
            Query.setStatementValues(
                    statement,
                    department.getField(),
                    department.getDescription(),
                    department.getIdCampus(),
                    department.getIdInstitute(),
                    department.getIdProfessor(),
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
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM department WHERE id_department = ?"
            );
            statement.setLong(1, key);
            statement.execute();
            Database.closeConnection(connection, statement);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return false;
    }

    private Department fromResultSet(ResultSet result) throws SQLException {
        return new Department()
                .setIdDepartment(result.getLong("id_department"))
                .setField(result.getString("field"))
                .setDescription(result.getString("description"))
                .setCampus(null)
                .setIdCampus(result.getLong("id_campus"))
                .setInstitute(null)
                .setIdInstitute(result.getLong("id_institute"))
                .setProfessor(null)
                .setIdProfessor(result.getLong("id_professor"));
    }

    private List<Department> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Department> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) list.add(fromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return list;
    }
}
