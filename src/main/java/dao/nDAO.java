package dao;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.swing.text.html.Option;
import java.util.Optional;

public class nDAO {

    public Optional save(Object entity) {
        SessionFactory factory = this.getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.save(entity);

        t.commit();
        factory.close();
        session.close();

        return Optional.empty();
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

    private SessionFactory getSessionFactory() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        return meta.getSessionFactoryBuilder().build();
    }

}
