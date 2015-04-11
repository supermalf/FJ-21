package br.com.caelum.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class ConnectionTest {
  public static void main(String[] args) throws SQLException {
    Connection connection = new ConnectionFactory().getConnection();
    System.out.println("Connection opened.");
    connection.close();
  }
}
