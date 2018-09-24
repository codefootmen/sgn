package dao;

import model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RequestDAO implements DAO<Request, Long> {
    @Override
    public Boolean save(Request request) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(request));
            Query.setStatementValues(
                    statement,
                    request.getIdRequest(),
                    request.getMotive(),
                    request.getDescription(),
                    request.getPriority().toString(),
                    request.getRoom().getIdRoom()
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
    public Request find(Long key) {
        return null;
    }

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public Boolean update(Request request) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(request));
            Query.setStatementValues(
                    statement,
                    request.getMotive(),
                    request.getDescription(),
                    request.getPriority().toString(),
                    request.getRoom().getIdRoom(),
                    request.getIdRequest()
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
