<%@page import="br.com.caelum.jdbc.model.Contact"%>
<%@page import="br.com.caelum.jdbc.dao.ContactDao"%>
<%@page import="
        java.util.*,
        java.text.DateFormat,
        java.text.SimpleDateFormat"%>

<html>
  <body>
    <table>
      <%
      ContactDao dao = new ContactDao();
      List<Contact> contatos = dao.getList();
      %>
      <tr>
        <td>Name</td> 
        <td>Email</td>
        <td>Address</td>
        <td>Born Date</td>
      </tr>
    
    <%for (Contact contact : contatos ) {%>
        <tr>
          <td><%=contact.getName() %></td> 
          <td><%=contact.getEmail() %></td>
          <td><%=contact.getAddress() %></td>
              <% Date date = contact.getBornDate().getTime();
                 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");%>
          <td><%=dateFormat.format(date) %></td>
        </tr>
      <%
      }
      %>
    </table>
  </body>
</html>