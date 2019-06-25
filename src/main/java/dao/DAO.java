package dao;

import model.User;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.text.html.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAO {

    public Optional save(Object entity) {
        SessionFactory factory = this.getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.save(entity);

        t.commit();
        factory.close();
        session.close();

        return Optional.of(entity);
    }

    public Optional update(Object entity) {
        SessionFactory factory = this.getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.update(entity);

        t.commit();
        factory.close();
        session.close();

        return Optional.empty();
    }

    public Object findOne(Long key, Class c){
        SessionFactory factory = this.getSessionFactory();
        Session session = factory.openSession();

        IdentifierLoadAccess identifier = session.byId(c);

        Object entity = identifier.load(key);

        factory.close();
        session.close();

        return entity;
    }

    public List<Object> findAll(Class c){
        SessionFactory factory = this.getSessionFactory();
        Session session = factory.openSession();

        List<Object> result = session.createCriteria(c).list();

        factory.close();
        session.close();

        return result;
    }

    public void delete(Object entity){
        SessionFactory factory = this.getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.delete(entity);

        t.commit();
        factory.close();
        session.close();

    }

    private SessionFactory getSessionFactory() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        return meta.getSessionFactoryBuilder().build();
    }



    public User authenticate(String login, String password) {

        String sql = String.format("SELECT * FROM user WHERE login = '%s' AND password = '%s'", login.trim(), password.trim());
        return search(sql).get(0);
    }

    private User fromResultSet(ResultSet result) throws SQLException {
        return new User()
                .setIdUser(result.getLong("id_user"))
                .setLogin(result.getString("login"))
                .setAccessLevel(result.getString("access_level"));
    }

    private List<User> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<User> list = new ArrayList<>();
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
