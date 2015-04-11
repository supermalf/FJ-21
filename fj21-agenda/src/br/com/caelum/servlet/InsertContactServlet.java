package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContactDao;
import br.com.caelum.jdbc.model.Contact;

public class InsertContactServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request,
    HttpServletResponse response) throws IOException, ServletException {

    PrintWriter out = response.getWriter();

    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String email = request.getParameter("email");
    String dateTxt = request.getParameter("bornDate");
    Calendar bornDate = null;

    try {
      Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateTxt);
      bornDate = Calendar.getInstance();
      bornDate.setTime(date);
    }
    catch (ParseException e) {
      out.println("Erro de convers�o da data");
      return;
    }

    Contact contact = new Contact();
    contact.setName(name);
    contact.setAddress(address);
    contact.setEmail(email);
    contact.setBornDate(bornDate);

    ContactDao dao = new ContactDao();
    dao.insert(contact);

    out.println("<html>");
    out.println("<body>");
    out.println("Contato " + contact.getName() + " adicionado com sucesso");
    out.println("</body>");
    out.println("</html>");
  }
}