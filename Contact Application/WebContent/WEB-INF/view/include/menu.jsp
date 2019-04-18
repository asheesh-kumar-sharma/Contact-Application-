<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:url var="url_logout" value="/logout"/>
  <c:if test="${sessionScope.userId==null}">
  <%-- user guest menu no one is logged in --%>
  <s:url var="url_reg_from" value="/reg_form"/>
  <s:url var="url_login_from" value="/index"/>
  
  <a href="${url_login_from}">Home</a> |<a href="${url_login_from}">Login</a>| <a href="${url_reg_from}">Register</a> |<a href="#">About</a>
  </c:if>
   <c:if test="${sessionScope.userId!=null&&sessionScope.role==1}">
   <!-- loggedUser is admin: admin menu-->
   <a href="${url_login_from}">Home</a> |<a href="<s:url value="/admin/users"/>">UserList</a>| <a href="${url_logout}">Logout</a> 
   </c:if>
   <c:if test="${sessionScope.userId!=null&&sessionScope.role==2}">
   <!-- loggedUser is General user :user menu-->
    <s:url var="url_uhome" value="/user/dashboard"/>
    <s:url var="url_cform" value="/user/contact_form"/>
   
   <s:url var="url_clist" value="/user/clist"/>
   
   <a href="${url_uhome}">Home</a> |<a href="${url_cform}">AddContact</a>|<a href="${url_clist}">ContactList</a> |<a href="${url_logout}">Logout</a> 
   </c:if>