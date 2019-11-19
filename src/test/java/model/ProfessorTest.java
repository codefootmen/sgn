package model;

import org.junit.Assert;
import org.junit.Test;

public class ProfessorTest {

    @Test
    public void isValidEmail_001() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("testeteste.com");

        Assert.assertFalse(test);
    }

    @Test
    public void isValidEmail__002() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("teste@teste");

        Assert.assertFalse(test);
    }

    @Test
    public void isValidEmail__003() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("tes#te@teste.com");

        Assert.assertFalse(test);
    }

    @Test
    public void isValidEmail__004() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("t!este@teste.com");

        Assert.assertFalse(test);
    }
    @Test
    public void isValidEmail__005() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("tes\"te@teste.com");

        Assert.assertFalse(test);
    }
    @Test
    public void isValidEmail__006() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("test;e@teste.com");

        Assert.assertFalse(test);
    }
    @Test
    public void isValidEmail__007() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("teste@teste.comteste@teste.comteste@teste.comteste@teste.comteste@teste.com" +
                "teste@teste.comteste@teste.comteste@teste.comteste@teste.comteste@teste.comteste@teste.comteste@teste." +
                "comteste@teste.comteste@teste.comteste@teste.comteste@teste.comteste@teste.coma");

        Assert.assertFalse(test);
    }
    @Test
    public void isValidEmail__008() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("a@a.com");

        Assert.assertFalse(test);
    }
    @Test
    public void isValidEmail__009() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("teste@teste.cm");

        Assert.assertFalse(test);
    }
    @Test
    public void isValidEmail__010() {
        Professor p = new Professor();
        boolean test = p.isValidEmail("teste@teste.com");

        Assert.assertTrue(test);
    }
}