package br.com.caelum.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.dao.ContactDao;
import br.com.caelum.jdbc.dao.DaoException;
import br.com.caelum.jdbc.model.Contact;

public class InsertionConnectionTest {
  public static void main(String[] args) {
    Connection connection = new ConnectionFactory().getConnection();

    try {
      Contact contact = new Contact();
      contact.setName("My Name");
      contact.setEmail("my@email.com");
      contact.setAddress("My Street");
      contact.setBornDate(new GregorianCalendar(1981, 12, 19));

      ContactDao contactDao = new ContactDao();
      contactDao.insert(contact);
      System.out.println("Insertion done.");
    }
    catch (DaoException e) {
      System.out.println("Erro ao Executar o DAO: " + e);
    }
    finally {
      try {
        connection.close();
      }
      catch (SQLException e) {
        System.out.println("Erro ao fechar conecção: " + e);
      }
    }
  }
}
