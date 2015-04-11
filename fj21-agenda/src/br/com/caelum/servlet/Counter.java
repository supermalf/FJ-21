package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Counter extends HttpServlet {
  private int contador = 0; //variavel de inst�ncia

  @Override
  protected void service(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    contador++; // a cada requisi��o a mesma vari�vel � incrementada

    // recebe o writer
    PrintWriter out = response.getWriter();

    // escreve o texto
    out.println("<html>");
    out.println("<body>");
    out.println("Contador agora �: " + contador);
    out.println("</body>");
    out.println("</html>");
  }
}