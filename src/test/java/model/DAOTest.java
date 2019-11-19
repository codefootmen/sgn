package model;

import dao.DAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class DAOTest {

    @Test
    public void saveTest(){
        Institute i = new Institute();

        i.setName("Test");
        i.setSite("www.teste.com");

        DAO dao = new DAO();
        Optional o = dao.save(i);

        Assert.assertFalse(o.isEmpty());
    }

    @Test
    public void updateTest(){
        Institute i = new Institute();
        i.setIdInstitute(Long.valueOf(1));
        i.setName("New Name");
        i.setSite("www.newsite.com");

        DAO dao = new DAO();
        Optional o = dao.update(i);

        Assert.assertFalse(o.isEmpty());
    }

    @Test
    public void findOneTest(){
        DAO dao = new DAO();
        Object i = dao.findOne(Long.valueOf(1), Institute.class);

        Assert.assertTrue(i != null);
    }

    @Test
    public void findAllTest(){
        DAO dao = new DAO();
        List<Object> li = dao.findAll(Institute.class);

        Assert.assertTrue(li.size() > 0);
    }

    @Test
    public void deleteTest(){
        DAO dao = new DAO();
        Institute i = new Institute();
        i.setIdInstitute(Long.valueOf(1));
        dao.delete(i);
        Assert.assertTrue(true);
    }
}
