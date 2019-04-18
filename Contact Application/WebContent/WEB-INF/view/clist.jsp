		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		    pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		    
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contact list-ContactApp </title>
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
		<h3>Contact list</h3>
		
		
		<c:if test="${param.act eq 'sv'}">
		<p class="success">contact saved successfully</p>
		</c:if>
		<c:if test="${param.act eq 'del'}">
		<p class="success">contact deleted successfully</p>
		</c:if>
		
		<form action="<s:url  value="/user/contact_search"/>">
		<input type="text" name="freeText" value="${param.freeText}" placeholder="Enter Text To search">
		<button>find</button>
		<br/>
		<br/>
		<form action="<s:url value="/user/bulk_cdelete"/>" >
		<button>delete selected records</button>
		<br/>
		<br/>
		<table border="1" cellpadding="3">
		<tr>
		    <th>Select</th>
	        <th>CID</th>
	        
			
	        <th>Name</th>
	        <th>PHONE</th>
			
	        <th>EMAIL</th>
			<th>ADDRESS</th>
			<th>REMARK</th>
			<th>ACTION</th>
			
		</tr>
		<c:if test="${empty contactList}">
		 <tr>
		 <td align="center" colspan="8" class="error">
		  No Record Present
		 </td>
		 </tr>
		</c:if>
		
		
		<c:forEach var="c" items="${contactList}" varStatus="st">
		<tr>
		    <td align="center"><input type="checkbox"  name="cid" value="${c.contactId}" ></td>
	        <td>${c.contactId}</td>
			
	        <td>${c.name}</td>
	        <td>${c.phone}</td>
			
	        <td>${c.email}</td>
			<td>${c.address}</td>
			<td>${c.remark}</td>
			<s:url var="url_del" value="/user/del_contact">
			<s:param name="cid" value="${c.contactId}"/>
			</s:url>
			<s:url var="url_edit" value="/user/edit_contact">
			<s:param name="cid" value="${c.contactId}"/>
			</s:url>
			<td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
			
		</tr>
		
		</c:forEach>
		</table>
		</form>
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