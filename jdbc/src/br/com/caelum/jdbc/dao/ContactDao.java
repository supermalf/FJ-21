package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.model.Contact;

/**
 * DAO - Data Access Object
 */
public class ContactDao {
  private Connection connection;

  public ContactDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void insert(Contact contact) {
    try {
      String sql =
        "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, contact.getName());
      stmt.setString(2, contact.getEmail());
      stmt.setString(3, contact.getAddress());
      stmt.setDate(4, new Date(contact.getBornDate().getTimeInMillis()));
      stmt.execute();
      stmt.close();
    }
    catch (SQLException e) {
      throw new DaoException(e.toString());
    }
  }

  public void remove(Contact contact) {
    try {
      PreparedStatement stmt =
        connection.prepareStatement("delete from contatos where id=?");
      stmt.setLong(1, contact.getId());
      stmt.execute();
      stmt.close();
    }
    catch (SQLException e) {
      throw new DaoException(e.toString());
    }
  }

  public void update(Contact contact) {
    try {
      String sql =
        "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, contact.getName());
      stmt.setString(2, contact.getEmail());
      stmt.setString(3, contact.getAddress());
      stmt.setDate(4, new Date(contact.getBornDate().getTimeInMillis()));
      stmt.setLong(5, contact.getId());

      stmt.execute();
      stmt.close();
    }
    catch (SQLException e) {
      throw new DaoException(e.toString());
    }
  }

  public List<Contact> getList() {
    try {
      List<Contact> contacts = new ArrayList<Contact>();
      PreparedStatement stmt =
        this.connection.prepareStatement("SELECT * FROM contatos");
      ResultSet resultSet = stmt.executeQuery();

      while (resultSet.next()) {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setName(resultSet.getString("nome"));
        contact.setEmail(resultSet.getString("email"));
        contact.setAddress(resultSet.getString("endereco"));

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(resultSet.getDate("dataNascimento"));
        contact.setBornDate(calendar);

        contacts.add(contact);
      }
      resultSet.close();
      stmt.close();

      return contacts;
    }
    catch (SQLException e) {
      throw new DaoException(e.toString());
    }
  }
}
