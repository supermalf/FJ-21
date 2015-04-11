<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp" />

<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContactDao"/>

<table border="1">
  <tr bgcolor = "#B0F">
    <th>Name</th> 
    <th>Email</th>
    <th>Address</th>
    <th>Born Date</th>
  </tr>
  <c:forEach var="contact" items="${dao.list}" varStatus="loopStatus">
    <tr bgcolor="${loopStatus.index % 2 == 0 ? '#CCC' : '#FFF'}">
      <td>${contact.name}</td>
      <td>
        <c:if test="${not empty contact.email}"><a href="mailto:${contact.email}">${contact.email}</a></c:if>
        <c:if test="${empty contact.email}">E-mail not informed</c:if>      
      </td>
      <td>${contact.address}</td>
      <td><fmt:formatDate pattern="dd/MM/yyyy" value="${contact.bornDate.time}"/></td>
    </tr>
  </c:forEach>
</table>

<c:import url="footer.jsp" />