package br.com.caelum.jdbc;

/**
 * Exce��o criada para sinalizar que uma exce��o ocorreu dentro do
 * ConnectionFactory.
 */
public class ConnectionFactoryException extends RuntimeException {

  public ConnectionFactoryException(String message) {
    super(message);
  }
}
