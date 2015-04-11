<html>
  <body>
    <%-- comentário em JSP aqui: nossa primeira página JSP --%>
    
    <%
    String mensagem = "Welcome to FJ-21 Agenda.";
    %>
    <% out.println(mensagem); %><br />
    
    <%
    String desenvolvido = "Developed by MALF";
    %>        
    <%= desenvolvido %><br />
    
    <%
      System.out.println("Tudo foi executado!");
    %>
  </body>
</html>