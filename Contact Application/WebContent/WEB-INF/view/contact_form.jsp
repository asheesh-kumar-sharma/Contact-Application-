		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		    pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
		    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
		    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>contact form </title>
		<s:url var="url_css" value="/static/css/style.css"/>
		<link rel="stylesheet"   type="text/css" href="${url_css}"/></head>
		<s:url var="url_bg" value="/static/image/phonebook.jpg"/>
		<body background="${url_bg}">
		   <table align="center" border="1" width="80%">
		   <tr>
		<td height="100px"><!-- header -->
		<jsp:include page="include/header.jsp"/>
		
		</td>
		</tr>
		<tr>
		<td height="25px"><!-- main menu --> 
		
		<jsp:include page="include/menu.jsp"/>
		</td>
		</tr>
		<tr>
		<td height="350px" valign="top"><!-- main content --> 
		<h3>Contact form</h3>
		<c:if test="${err!=null}">
		<p class="error" >${err}</p>
		</c:if>
		<s:url var="url_csave" value="/user/save_contact"/>
		<f:form action="${url_csave}" modelAttribute="command">
		<table border="1">
		<tr>
		<td>Name</td>
		<td><f:input path="name"/></td>
		</tr>
		<tr>
		<td>Phone</td>
		<td><f:input path="phone"/></td>
		</tr>
		<tr>
		<td>Email</td>
		<td><f:input path="email"/></td>
		</tr>
		<tr>
		<td>Address</td>
		<td><f:textarea path="address"/></td>
		</tr>
		
		<tr>
		<td>Remark</td>
		<td><f:input path="remark"/></td>
		</tr>
		
		
		<tr>
		<td colspan="2" align="right"><button  >save</button>
		
		</td>
		</tr>
	   </table>
	   </f:form>
		
		</td>
		</tr>
		<tr>
		<td height="25px">
		<!-- footer page  -->
	    <jsp:include page="include/footer.jsp"/>
		 </td>
		</tr>
		
		</table>
		</body>
		</html>