		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		    pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
		    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
		    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
		 <s:url var="test" value="/static/js/jquery-3.3.1.min.js"></s:url>
        <script type="text/javascript" src="${test}"></script>
        <script>
        
        $(document).ready(function(){
        	
        	$("#id_check_avail").click(function(){
        		
        		$.ajax({
        			
        			ur:'check_avail',
        			data: {username:$("#id_username").val()} ,
        			success: function(data){
        			
        				$("#id_res_div").html(data);
      
        			}
        		})
        	})
        	
        });
        </script>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Registration </title>
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
		<h3>User Registration</h3>
		<c:if test="${err!=null}">
		<p class="error">${err}</p>
		</c:if>
		<s:url var="url_reg" value="/register"/>
		<f:form action="${url_reg}" modelAttribute="command">
		<table border="1">
		<tr>
		<td>Name</td>
		<td><f:input path="user.name"/></td>
		</tr>
		<tr>
		<td>Phone</td>
		<td><f:input path="user.phone"/></td>
		</tr>
		<tr>
		<td>Email</td>
		<td><f:input path="user.email"/></td>
		</tr>
		<tr>
		<td>Address</td>
		<td><f:textarea path="user.address"/></td>
		</tr>
		<tr>
		<td>User name</td>
		<td><f:input id="id_username" path="user.loginName"/>
		<!--  
		<button type="button" id="id_check_avail">Check Availablity</button>
	
		<div id="id_res_div"  class="error">
		</div>
		-->
			</td>
		</tr>
		<tr>
		<tr>
		<td>password</td>
		<td><f:password path="user.password"/></td>
		</tr>
		
		
		<tr>
		<td colspan="2" align="right"><button >submit</button>
		<br>
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