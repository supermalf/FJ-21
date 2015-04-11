package br.com.caelum.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.dao.ContactDao;
import br.com.caelum.jdbc.model.Contact;

public class ListTest {
  public static void main(String[] args) throws SQLException {
    Connection connection = new ConnectionFactory().getConnection();
    ContactDao contactDao = new ContactDao();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    List<Contact> contacts = contactDao.getList();
    for (Contact contact : contacts) {
      System.out.println("Name:      " + contact.getName());
      System.out.println("Email:     " + contact.getEmail());
      System.out.println("Address:   " + contact.getAddress());
      System.out.println("Born Date: "
        + dateFormat.format(contact.getBornDate().getTime()) + "\n");
    }
  }
}
