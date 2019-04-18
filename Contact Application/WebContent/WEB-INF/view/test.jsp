<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
  <s:url var="test" value="/static/js/jquery-3.3.1.min.js"></s:url>
  <script type="text/javascript" src="${test}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing jQuery</title>

<script type="text/javascript">

  $(document).ready(function(){
	  
	//  alert('jquery is ready to use')
    $("#get_server_time").click(function()
    		{
    	
    	  $.ajax(
    			  {
    				  
    				  url:'get_time',
    				  success:function(data)
    				  
    				  {
    					  $("#id_time").html(data)
    				  }
    			  
    				  
    			  }
    			  
    	  
    	  );
    	
    		})
	
  })

</script>
</head>
<body>

   <h1> Ajax test page</h1>
   <button id="get_server_time">
   get Server Time
   </button>
   <p id="id_time"></p>



</body>
</html>