		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		    pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		    
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
		 <s:url var="test" value="/static/js/jquery-3.3.1.min.js"></s:url>
        <script type="text/javascript" src="${test}"></script>
		<script>
		function changestatus(uid , lstatus)
		{
			
			//alert(userId+", "+loginStatus);
		   $.ajax(
				   {
		      
					   url:'change_status',
					   //bind the data
					   data:{userId:uid,loginStatus:lstatus},
					   success: function(data)
					   {
						   alert(data);
					   }
					   
				   }
	     )	
		}
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User List-ContactApp </title>
		<s:url var="url_css" value="/static/css/style.css"/>
		
		<link rel="stylesheet"   type="text/css" href="${url_css}"/>
		</head>
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
		<h3>UserList</h3>
		 <table border="1">
		 <tr>
			 <th>SR</th>
	         <th>User Id</th>
	         <th>Name</th>
	         <th>Phone</th>
	         <th>Email</th>
	         <th>Address</th>
	         <th>UserName</th>
	         <th>Status</th>
	         
        </tr>
        
        <c:forEach var="u" items="${userList}" varStatus="st">
         <tr>
			 <td>${st.count}</td>
	         <td>${u.userId}</td>
	         <td>${u.name}</td>
	         <td>${u.phone}</td>
	         <td>${u.email}</td>
	         <td>${u.address}</td>
	         <td>${u.loginName}</td>
	         <td>
	         <select id="id_${u.userId}" onchange="changestatus(${u.userId},$(this).val())">
	         <option value="1">Active</option>
	         <option value="2">Block</option>
	         </select>
	         <script>
	         $('#id_${u.userId}').val(${u.loginStatus});
	        </script>
	        </tr>
        
        </c:forEach>
		 
		 
		 </table>
		 
		
		
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