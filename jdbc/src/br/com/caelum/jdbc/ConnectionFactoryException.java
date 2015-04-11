package br.com.caelum.jdbc;

/**
 * Exceção criada para sinalizar que uma exceção ocorreu dentro do
 * ConnectionFactory.
 */
public class ConnectionFactoryException extends RuntimeException {

  public ConnectionFactoryException(String message) {
    super(message);
  }
}
