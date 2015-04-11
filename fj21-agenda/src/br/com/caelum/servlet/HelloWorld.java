package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<body>");
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    out.println("Hora: " + dateFormat.format(date));
    out.println("<br>");
    out.println("Hora2: " + date);
    out.println("</body>");
    out.println("</html>");
  }
}
