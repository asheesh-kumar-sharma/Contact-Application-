		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		    pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
		    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
		    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Login </title>
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
		<h3>User Login</h3>
		<c:if test="${param.act eq 'lo'}">
		<p class="success">logout successfully ! ,thanks for using Contact Application </p>
		</c:if>
		<c:if test="${param.act eq 'reg'}">
		<p class="success">registration successfully ! ,please login </p>
		</c:if>
		<c:if test="${err!=null}">
		<p class="error">${err}</p>
		</c:if>
		<s:url var="url_login" value="/login"/>
		<f:form action="${url_login}" modelAttribute="command">
		<table border="1">
		<tr>
		<td>User Name</td>
		<td><f:input path="loginName"/></td>
		</tr>
		<tr>
		<td>user password</td>
		<td><f:password path="password"/></td>
		</tr>
		<tr>
		<td colspan="2" align="right"><button  >login</button>
		<br>
		<s:url var="url_reg_from" value="/reg_form"/>
  
		<a href="${url_reg_from}">New User Register</a>
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